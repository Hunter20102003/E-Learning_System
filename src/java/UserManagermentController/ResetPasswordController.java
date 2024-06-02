/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package UserManagermentController;

import Dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Model.UserDBO;

/**
 *
 * @author LEGION
 */
public class ResetPasswordController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
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
            out.println("<title>Servlet ResetPasswordController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResetPasswordController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public boolean validPassword(String password) {
        return password.matches("^(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,}$");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pw = request.getParameter("newpassword");
        String rpw = request.getParameter("confirmnewpassword");
        HttpSession session = request.getSession();
        UserDAO dao = new UserDAO();
        UserDBO user = (UserDBO) session.getAttribute("user");
        if (user == null) {
            session.removeAttribute("email");
            request.setAttribute("resetPasswordError", "Reset password not successfully!!!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;

        }
        try {
            pw = pw.trim();
            rpw = rpw.trim();
            if (pw.isBlank() || rpw.isBlank()) {
                request.setAttribute("mess", "Please enter your new password");

            } else {
                if (validPassword(pw)) {
                    if (!pw.equals(rpw)) {
                        request.setAttribute("mess", "Passwords do not match!!!");
                    } else {
                        if (pw.equals(user.getPassword())) {
                            request.setAttribute("mess", "Please enter a new password, this password is the previous password");
                        } else {
                            int n = dao.resetPassword(user.getId(), pw);
                            if (n > 0) {
                                session.removeAttribute("email");
                                session.removeAttribute("user");
                                request.setAttribute("resetPasswordSuccess", "Reset password successfully!!!");
                                request.getRequestDispatcher("login.jsp").forward(request, response);
                                return;

                            }
                        }

                    }
                } else {
                    request.setAttribute("mess", "Password must contain at least 8 characters, at least 1 number and both lower and uppercase letters and special characters");

                }
            }

        } catch (NullPointerException e) {
        }
        request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
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

}
