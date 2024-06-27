package AdminManagementController;

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "https://script.google.com/macros/s/AKfycbyqWz-Ia9Uh-F4n38RfOgSCtWRCRuyNN9dHEysxgfeWKoBA3RzA0MA6J2Gmwj-0PdXrNg/exec";
        String jsonResponse = getJSONFromURL(url);

        ArrayList<AccountManagerExcelDBO> accounts = parseJSONToAccounts(jsonResponse);
        request.setAttribute("accounts", accounts);
        request.getRequestDispatcher("/accounts.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String status = request.getParameter("status");

        updateGoogleSheet(username, status);

        response.sendRedirect("all_manager_accounts");
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
