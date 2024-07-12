/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package AdminManagementController;

<<<<<<< HEAD
<<<<<<< HEAD
import Dal.AdminDAO;
import Dal.DashboardDAO;
import Model.Payment;
=======
>>>>>>> origin/AdminManager
=======
import Dal.AdminDAO;
import Dal.DashboardDAO;
import Model.Payment;
>>>>>>> origin/create-course1
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/create-course1
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.List;
<<<<<<< HEAD
=======
>>>>>>> origin/AdminManager
=======
>>>>>>> origin/create-course1

/**
 *
 * @author buiqu
 */
public class DisplayAccountRateDashboard extends HttpServlet {
   
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
            out.println("<title>Servlet DisplayAccountRateDashboard</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DisplayAccountRateDashboard at " + request.getContextPath () + "</h1>");
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/create-course1
    
    public  double getTotalIncome(){
        Dal.DashboardDAO db = new DashboardDAO();
        List<Payment> pays = db.getAllPayment();
        double total = 0.0;
       for(Payment pay : pays){
           total += pay.getAmount();
           
       }
       return total;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Dal.DashboardDAO db = new DashboardDAO();
        List<Payment> pays = db.getAllPayment();
         DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("#,###", symbols); // Định dạng số với phân tách nhóm là dấu chấm
        String formattedNumber = df.format(getTotalIncome());
        request.setAttribute("total", formattedNumber);
        request.setAttribute("size", pays.size());
        
       
        double number_all = (double)(db.getAllUser_ALL().size());
        double number_before_10day = (double)(db.getAllUserBefore10Day().size());
         double persen  = ((number_all-number_before_10day)/number_before_10day)*100;
         request.setAttribute("persen", persen);
         request.setAttribute("number_all",  (int)number_all);
         request.setAttribute("number_10", (int)number_before_10day);
        
        
<<<<<<< HEAD
=======
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
>>>>>>> origin/AdminManager
=======
>>>>>>> origin/create-course1
        request.getRequestDispatcher("dashboard1.jsp").forward(request, response);
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

}
