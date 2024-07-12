/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ControllerPayWithCourse;

import Model.UserDBO;
import Model.CourseDBO;
import Model.Transaction;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import Dal.CourseDAO;
import Dal.PaymentDAO;
import Model.CourseDBO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import Model.Transaction;
import Model.UserDBO;
import UserManagementController.Google.OTP_Email;
import jakarta.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author buiqu
 */
@WebServlet("/GetDataServlet")
public class GetDataServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "https://script.google.com/macros/s/AKfycbx5bY8oot0v5vpzRTDpMvLqVlavP2EDj4AoRLKdb7sRFpasPy9G7YCdUqPrgiP2uEFDHw/exec";
        String jsonResponse = getJSONFromURL(url);
        Dal.PaymentDAO dp = new PaymentDAO();
        OTP_Email otp_email = new OTP_Email();
        HttpSession session = request.getSession();
        UserDBO user = (UserDBO) session.getAttribute("user");
        int UserID = 0;
         String mail = "";
        if (user != null) {
            UserID = user.getId();
            mail = user.getEmail().trim();
        }
        Double Amount = 0.0;
        String Date = "";
       int transaction_code = 0;
       
       
        String CourseID = request.getParameter("id");
        String price = "";
        ArrayList<Transaction> transactions = parseJSONToTransactions(jsonResponse);
        CourseDAO db = new CourseDAO();

        String random = request.getParameter("random");
        CourseDBO list = db.getCourseByID(Integer.parseInt(request.getParameter("id")));
        String check = "Haven't seen your payment or don't see your payment information, you should review or contact us again!";
        int flax = 0;

         if(mail != null || !mail.isEmpty() ){
             for (Transaction transaction : transactions) {
            if (transaction.getGiaTri() == list.getPrice() && transaction.getMoTa().contains(random)) {
                Amount = transaction.getGiaTri();
                price = transaction.getGiaTri() + "";
                Date = transaction.getNgayDienRa();
                transaction_code = transaction.getMaGD();
                flax = 1;
                break;
            }
        }
        }
         
       
        if (flax == 1) {
             otp_email.sendMessageMail(mail, "YOU ARE DONE PAYMENT " + "\n" + "TRANSACTION CODE:" + transaction_code + "\n" +"PRICE: "+price + "\n" + "description:" + random);
            
            dp.AddEnrollMent(UserID + "", CourseID);
            dp.AddPayment(UserID + "", CourseID, Amount, Date, transaction_code +"");
<<<<<<< HEAD
            request.getRequestDispatcher("course/learning").forward(request, response);
        } else {
           
            request.setAttribute("check", check);
            request.getRequestDispatcher("course_learing").forward(request, response);
=======
            request.getRequestDispatcher("course/learning?course_id="+CourseID).forward(request, response);
        } else {
           
            request.setAttribute("check", check);
            request.getRequestDispatcher("course_learing?course_id="+CourseID).forward(request, response);
>>>>>>> origin/create-course1

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

    private ArrayList<Transaction> parseJSONToTransactions(String jsonResponse) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONArray dataArray = jsonObject.getJSONArray("data");

        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject obj = dataArray.getJSONObject(i);
            int maGD = obj.getInt("Ma GD");
            String moTa = obj.getString("Mo ta");
            double giaTri = obj.getDouble("Gia tri");
            String ngayDienRa = obj.getString("date");
            String soTaiKhoan = obj.getString("Stk");

            transactions.add(new Transaction(maGD, moTa, giaTri, ngayDienRa, soTaiKhoan));
        }
        return transactions;
    }
    

}
