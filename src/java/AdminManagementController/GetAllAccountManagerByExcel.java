package AdminManagementController;

import Dal.AdminDAO;
import Model.AccountManagerExcelDBO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class GetAllAccountManagerByExcel extends HttpServlet {

    public AccountManagerExcelDBO getmanageraccount(String username) throws IOException {
        ArrayList<AccountManagerExcelDBO> accounts = parseJSONToAccounts(getJSONFromURL("https://script.google.com/macros/s/AKfycbyqWz-Ia9Uh-F4n38RfOgSCtWRCRuyNN9dHEysxgfeWKoBA3RzA0MA6J2Gmwj-0PdXrNg/exec"));

        for (AccountManagerExcelDBO account : accounts) {
            if (account.getName().equals(username)) {
                return account;
            }
        }

        return null; // Trả về null nếu không tìm thấy tài khoản với username tương ứng
    }

    private boolean validUserName(String name) {
        return name.matches("^[a-zA-Z0-9]+$");
    }

    private boolean validPassword(String password) {
        return password.matches("^(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,}$");
    }

    private boolean validEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
   private boolean validName(String name) {
        return name.matches("^[a-zA-Z]+$");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "https://script.google.com/macros/s/AKfycbyqWz-Ia9Uh-F4n38RfOgSCtWRCRuyNN9dHEysxgfeWKoBA3RzA0MA6J2Gmwj-0PdXrNg/exec";
        String jsonResponse = getJSONFromURL(url);

        ArrayList<AccountManagerExcelDBO> accounts = parseJSONToAccounts(jsonResponse);
        String name = request.getParameter("add");
        String messi = request.getParameter("mes");
        if (name == null || name.isEmpty()) {
            request.setAttribute("messi", messi);
            request.setAttribute("accounts", accounts);
            request.getRequestDispatcher("/all-accounts-excel.jsp").forward(request, response);
        } else {
            AccountManagerExcelDBO account = getmanageraccount(name);
            request.setAttribute("account", account);
            request.getRequestDispatcher("/add-manager-accounts.jsp").forward(request, response);
        }
    }

    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dal.AdminDAO db = new AdminDAO();
        
        String username = request.getParameter("name");
        String password = request.getParameter("pas");
        String email = request.getParameter("email");
        String f_name = request.getParameter("fname");
        String l_name = request.getParameter("lname");
        
        boolean check = true;

        if (username.isBlank() || email.isBlank() || password.isBlank() || f_name.isBlank() || l_name.isBlank()) {
            request.setAttribute("errorMessage", "Please enter complete information!");
            check = false;
        } else {
            if (!validUserName(username)) {
                request.setAttribute("errorUserName", "Username is invalid!");
                check = false;
            } else if (db.checkUserNameExisted(username)) {
                request.setAttribute("errorUserName", "Username has been existed!");
                check = false;
            }

            if (!validEmail(email)) {
                request.setAttribute("errorEmail", "Email is invalid!");
                check = false;
            } else if (db.checkEmailExisted(email)) {
                request.setAttribute("errorEmail", "Email has been existed!");
                check = false;
            }

            if (!validPassword(password)) {
                request.setAttribute("errorPassword", "Password must contain at least 8 characters, including 1 number and both lower and uppercase letters and special characters");
                check = false;
            }
            
            if (!validName(f_name)) {
                request.setAttribute("errorFirstName", "First name is invalid!");
                check = false;
            }
            
            if (!validName(l_name)) {
                request.setAttribute("errorLastName", "Last name is invalid!");
                check = false;
            }
        }

        if (check) {
            updateGoogleSheet(username, "1");
            db.addAccount(username, password, email, f_name, l_name, "4");
            response.sendRedirect("all_manager_accounts?mes=" + username);
        } else {
            request.setAttribute("account", new AccountManagerExcelDBO(username, password, email, f_name, l_name));
            request.getRequestDispatcher("/add-manager-accounts.jsp").forward(request, response);
        }
    }
    private String getJSONFromURL(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        conn.disconnect();
        return content.toString();
    }

    private ArrayList<AccountManagerExcelDBO> parseJSONToAccounts(String jsonResponse) {
        ArrayList<AccountManagerExcelDBO> accounts = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONArray dataArray = jsonObject.getJSONArray("data");

        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject obj = dataArray.getJSONObject(i);
            String username = obj.getString("username");
            String password = obj.getString("password");
            String email = obj.getString("email");
            String first_name = obj.getString("first_name");
            String last_name = obj.getString("last_name");

            AccountManagerExcelDBO account = new AccountManagerExcelDBO(
                    username, password, email, first_name, last_name);

            accounts.add(account);
        }
        return accounts;
    }

    private void updateGoogleSheet(String username, String status) throws IOException {
        String urlString = "https://script.google.com/macros/s/AKfycbz2dDAnBrhfcAAOrvWI9LrA50zxVSDskHVdKbtxjSBYhniYgTcXC5Y1PlbghZJxyQ3esg/exec"; // Thay bằng URL mới của bạn
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        String postData = "username=" + username + "&status=" + status;
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = postData.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        int responseCode = conn.getResponseCode();
        conn.disconnect();
    }
}
