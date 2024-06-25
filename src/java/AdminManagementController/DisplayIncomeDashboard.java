/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package AdminManagementController;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author buiqu
 */
public class DisplayIncomeDashboard extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DisplayIncomeDashboard</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DisplayIncomeDashboard at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
  //       public Double TotalPrice1(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//                       public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
             
//       public Double TotalPrice1(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//                       public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
             
//       public Double TotalPrice1(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//                       public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
             
//       public Double TotalPrice1(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//                       public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
             
  //       public Double TotalPrice1(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//                       public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
             
//       public Double TotalPrice1(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//                       public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
             
//       public Double TotalPrice1(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//                       public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
             
//       public Double TotalPrice1(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//                       public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
             
  //       public Double TotalPrice1(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//                       public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
             
//       public Double TotalPrice1(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//                       public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
             
//       public Double TotalPrice1(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//                       public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
             
//       public Double TotalPrice1(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//                       public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
             

}
