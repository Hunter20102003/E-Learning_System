/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
<<<<<<< HEAD
package AdminManagementController;

import Dal.DashboardDAO;
import Model.DashBoardPaymentDBO;
import Model.IncomeManagerDBO;
import Model.UserDBO;
=======

package AdminManagementController;

>>>>>>> origin/payment
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
<<<<<<< HEAD
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
=======
>>>>>>> origin/payment

/**
 *
 * @author buiqu
 */
public class DisplayIncomeDashboard extends HttpServlet {
<<<<<<< HEAD

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
=======
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
>>>>>>> origin/payment
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
<<<<<<< HEAD
            throws ServletException, IOException {
=======
    throws ServletException, IOException {
>>>>>>> origin/payment
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
<<<<<<< HEAD
            out.println("<title>Servlet DisplayIncomeDashboard</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DisplayIncomeDashboard at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public Double TotalPriceYear(String year, String userid) {
        DashboardDAO db = new DashboardDAO();
        List<DashBoardPaymentDBO> pay_list = db.getAllIncomeManager(year, userid);
        double total = 0.0;
        for (DashBoardPaymentDBO payment : pay_list) {
            total += payment.getAmount();
        }
        return total;
    }
       public Double TotalPriceMonthYear(String year,String month ,String userid) {
        DashboardDAO db = new DashboardDAO();
        List<DashBoardPaymentDBO> pay_list = db.getAllIncomeManager(year,month, userid);
        double total = 0.0;
        for (DashBoardPaymentDBO payment : pay_list) {
            total += payment.getAmount();
        }
        return total;
    }

    public Double TotalPrice(String year) {
        DashboardDAO db = new DashboardDAO();
        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByYear(year);
        double total = 0.0;
        for (DashBoardPaymentDBO payment : pay_list) {
            total += payment.getAmount();
        }
        return total;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Dal.DashboardDAO db = new DashboardDAO();
        String year = "2024";
        year = request.getParameter("year");
        if (year == null) {
            year = "2024";
        }

        double total = TotalPrice(year);
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("#,###", symbols); // Định dạng số với phân tách nhóm là dấu chấm
        String formattedNumber = df.format(total);
        request.setAttribute("total", formattedNumber);
       String Manager_total ;
        List<UserDBO> Manager = db.getAllUser();
        double[] amount = new double[12];
        List<IncomeManagerDBO> Manager_payment = new ArrayList<>();
     for (UserDBO manager : Manager) {
    List<Double> amountList = new ArrayList<>();
    for (int i = 0; i < 12; i++) {
        amountList.add(TotalPriceMonthYear(year, String.valueOf(i + 1), manager.getId() + "")/1000000); // Chia cho 1000 nếu cần
    }
    String managerTotal = df.format(TotalPriceYear(year, manager.getId() + ""));
    Manager_payment.add(new IncomeManagerDBO(manager.getId() + "", manager.getUsername(), manager.getEmail(), amountList, managerTotal));
}
        
        request.setAttribute("year", year);
        request.setAttribute("manager_list", Manager_payment);
        request.getRequestDispatcher("dashboard3.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String year = request.getParameter("year");

        // Kiểm tra giá trị year
     
        try {
            // Chuyển tiếp yêu cầu với tham số year
            response.sendRedirect("income_dashboard?year=" + year);
        } catch (Exception e) {
            // Ghi log và xử lý ngoại lệ
            
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

=======
            out.println("<title>Servlet DisplayIncomeDashboard</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DisplayIncomeDashboard at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

  
>>>>>>> origin/payment
}
