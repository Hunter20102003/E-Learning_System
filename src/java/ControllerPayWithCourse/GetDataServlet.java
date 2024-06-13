/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package ControllerPayWithCourse;

import Model.UserDBO;
import Model.CourseDBO;
import Model.Transaction;
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
        HttpSession session = request.getSession();
        UserDBO user = (UserDBO)session.getAttribute("user");
        int UserID =0;
        if(user!= null){
            UserID = user.getId();
        }
        Double Amount= 0.0;
        String Date = "";
        String transaction_code = "";
        String CourseID = request.getParameter("id");

           ArrayList<Transaction> transactions = parseJSONToTransactions(jsonResponse);
        CourseDAO db = new CourseDAO();
       
        String random = request.getParameter("random");
        CourseDBO list = db.getCourseByID(request.getParameter("id"));
        String check = "Chưa thấy bạn thanh toán hoặc chưa thấy có thông tin thanh toán của bạn, bạn lên xem lại hoặc liên hệ lại với chúng tôi!";
        int flax = 0;
     
        for (Transaction transaction : transactions) {
            if (transaction.getGiaTri() == list.getPrice() && transaction.getMoTa().contains(random)) {
                Amount = transaction.getGiaTri();  
                Date = transaction.getNgayDienRa();
                transaction_code = transaction.getMaGD();
                flax = 1;
                break;
            }
        }
        if(flax ==1){
            
            dp.AddPayment(UserID + "", CourseID, Amount, Date ,transaction_code);
         request.getRequestDispatcher("course/learning").forward(request, response);
    }
        else{
                   request.setAttribute("check", check);
        request.getRequestDispatcher("payqrcourse").forward(request, response);

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

            transactions.add(new Transaction(moTa, moTa, giaTri, ngayDienRa, soTaiKhoan));
        }
        return transactions;
    }
    
}
