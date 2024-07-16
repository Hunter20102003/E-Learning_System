package AdminManagementController;

import Dal.AdminDAO;
import Model.AccountManagerExcelDBO;
import Model.AccountMentorExcelDBO;
import Model.UserDBO;
import UserManagementController.Google.OTP_Email;
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

public class GetAllAccountMentorByExcel extends HttpServlet {

    public AccountMentorExcelDBO getmanageraccount(String id) throws IOException {

        ArrayList<AccountMentorExcelDBO> accounts = parseJSONToAccounts(getJSONFromURL("https://script.google.com/macros/s/AKfycbyNTfntPC7qU3V37WBFREgIXRqcvd2ExvrtmFpjla9Udi_EQb8_1jPa4VS4fguvnWAQYg/exec"));

        for (AccountMentorExcelDBO
                
                
                
                account : accounts) {
            if (account.getIdcheck().equals(id)) {
                return account;
            }
        }

        return null;

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
        String url = "https://script.google.com/macros/s/AKfycbyNTfntPC7qU3V37WBFREgIXRqcvd2ExvrtmFpjla9Udi_EQb8_1jPa4VS4fguvnWAQYg/exec";
        String jsonResponse = getJSONFromURL(url);
        ArrayList<AccountMentorExcelDBO> accounts = parseJSONToAccounts(jsonResponse);
        Dal.AdminDAO db = new AdminDAO();
        OTP_Email otp_email = new OTP_Email();

        try {
          
            String check = request.getParameter("check");
            if (check != null || !check.isEmpty()) {
                for (AccountMentorExcelDBO account : accounts) {
                    String name = account.getName();
                    String password = account.getPassword();
                    String email = account.getEmail();
                    String fname = account.getFirst_name();
                    String lname = account.getLast_name();
                    String gmail_manager = account.getGmail_Manager();
                    UserDBO user = new UserDBO();
                    user = db.getUserByGmail(gmail_manager);
                    int id_Manager = user.getId();
                    
                    boolean check1 = true;
                    if (!validUserName(name)) {
                        check1 = false;
                      
                    } else if (db.checkUserNameExisted(name)) {
                        check1 = false;
                           break;
                    }

                    if (!validEmail(email)) {
                        check1 = false;
                    } else if (db.checkEmailExisted(email)) {
                        check1 = false;
                           break;
                    }

                    if (!validPassword(password)) {
                        check1 = false;
                           break;
                    }

                    if (!validName(fname)) {

                        check1 = false;
                           break;
                    }

                    if (!validName(lname)) {

                        check1 = false;
                           break;
                    }
                    if(!validEmail(gmail_manager)){
                        check1 = false;
                        break;
                    }
                    if (check1) {
                        updateGoogleSheet(account.getIdcheck(), name,password, email, fname, lname, "1",gmail_manager );
                        int id_Mentor = db.addAccount(name,password, email, fname, lname, "2");
                        db.addMentorByManager(id_Mentor+"", id_Manager+"");

                        otp_email.sendMessageMail(email, "YOU ACCOUNT " + "\n" + "USER NAME:" + name + "\n" + "PASSWORD: " + password + "\n" + "FIRST NAME:" + fname + "\n" + "LAST NAME:" + lname+"\n"+"Management By Manager with email:" + gmail_manager);

                    }

                }
                String messi = "1";
               
               
                response.sendRedirect("all_mentor_accounts?mesall=" + messi);

            }
        } catch (Exception e) {
                   String add = request.getParameter("add");
        String messi = request.getParameter("mes");
        String messiall = request.getParameter("mesall");
        if (add == null || add.isEmpty()) {
            request.setAttribute("messi_all", messiall);
            request.setAttribute("messi", messi);
            request.setAttribute("accounts", accounts);
            request.getRequestDispatcher("/all-accounts-excel_1.jsp").forward(request, response);
        } else {
            AccountMentorExcelDBO account = getmanageraccount(add);
            request.setAttribute("account", account);
            request.getRequestDispatcher("/add-mentor-accounts.jsp").forward(request, response);
        }
        }

 
    }

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dal.AdminDAO db = new AdminDAO();
        OTP_Email otp_email = new OTP_Email();

        String username = request.getParameter("name");
        String password = request.getParameter("pas");
        String email = request.getParameter("email");
        String f_name = request.getParameter("fname");
        String l_name = request.getParameter("lname");
        String gmail_manager = request.getParameter("gmail_manager");
        
        
boolean check = true;
        String idCheck = request.getParameter("idCheck");  // Added to get idCheck
         UserDBO user = new UserDBO();
         int id_Manager =0;
                    user = db.getUserByGmail(gmail_manager);
                    if(user == null ){
                        request.setAttribute("errorGmail_Manager", "Account manager is not exist!");
                        check =false;
                    }else{
                      id_Manager = user.getId();
                    }
                   
        

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
            if(!validEmail(gmail_manager)){
              request.setAttribute("errorGmail_Manager", "Email is invalid!");
                check = false;
            }
        }

        if (check) {

            updateGoogleSheet(idCheck, username, password, email, f_name, l_name, "1",gmail_manager);
           int id_Mentor = db.addAccount(username, password, email, f_name, l_name, "2");
           db.addMentorByManager(id_Mentor+"", id_Manager+"");
 
            otp_email.sendMessageMail(email, "YOU ACCOUNT " + "\n" + "USER NAME:" + username + "\n" + "PASSWORD: " + password + "\n" + "FIRST NAME:" + f_name + "\n" + "LAST NAME:" + l_name +"\n"+"Management By Manager with email:" + gmail_manager);

            response.sendRedirect("all_mentor_accounts?mes=" + username);
        } else {
            request.setAttribute("account", new AccountMentorExcelDBO(username, password, email, f_name, l_name, idCheck,gmail_manager));
            request.getRequestDispatcher("/add-mentor-accounts.jsp").forward(request, response);
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

    private ArrayList<AccountMentorExcelDBO> parseJSONToAccounts(String jsonResponse) {
        ArrayList<AccountMentorExcelDBO> accounts = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONArray dataArray = jsonObject.getJSONArray("data");

        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject obj = dataArray.getJSONObject(i);
            String username = obj.getString("username");
            String password = obj.getString("password");
            String email = obj.getString("email");
            String first_name = obj.getString("first_name");
            String last_name = obj.getString("last_name");

            String idcheck = obj.getString("idCheck");
            String gamil_Manager = obj.getString("manager");

            AccountMentorExcelDBO account = new AccountMentorExcelDBO(
                    username, password, email, first_name, last_name, idcheck, gamil_Manager);

            accounts.add(account);
        }
        return accounts;
    }

    private void updateGoogleSheet(String idCheck, String username, String password, String email, String first_name, String last_name, String status, String manager) throws IOException {
        String urlString = "https://script.google.com/macros/s/AKfycbyNTfntPC7qU3V37WBFREgIXRqcvd2ExvrtmFpjla9Udi_EQb8_1jPa4VS4fguvnWAQYg/exec";

        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);

        String postData = "idCheck=" + idCheck + "&username=" + username + "&password=" + password + "&email=" + email + "&first_name=" + first_name + "&last_name=" + last_name + "&status=" + status +"&manager=" + manager;
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = postData.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        int responseCode = conn.getResponseCode();
        conn.disconnect();
    }
}
