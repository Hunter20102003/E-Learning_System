/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dal.UserDAO;
import Model.UserDBO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author LEGION
 */
public class ChangePasswordController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public boolean validPassword(String password) {
        return password.matches("^(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,}$");

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String oPassword = request.getParameter("oldPassword").trim();
        String nPassword = request.getParameter("newPassword").trim();
        String renPassword = request.getParameter("reNewPassword").trim();
        if (oPassword.isBlank() || nPassword.isBlank() || renPassword.isBlank()) {
            request.setAttribute("errorMessage", "Please enter complete information!!!!");
        } else {
            HttpSession session = request.getSession();
            UserDBO user = (UserDBO) session.getAttribute("user");

            if (user != null && user.getPassword().equals(oPassword)) {
                if (validPassword(nPassword)) {
                    if (nPassword.equals(oPassword)) {
                        request.setAttribute("errorMessage", "Please enter a new password, this password is the previous password");

                    } else {
                        if (nPassword.equals(renPassword)) {
                            UserDAO dao=new UserDAO();
                            dao.resetPassword(user.getId(), nPassword);
                            request.setAttribute("message", "Change password successfully!!!");

                        } else {
                            request.setAttribute("errorNewPassword", "Passwords do not match!!!");

                        }

                    }
                } else {
                    request.setAttribute("errorNewPassword", "Password must contain at least 8 characters, at least 1 number and both lower and uppercase letters and special characters");

                }
            } else {
                request.setAttribute("errorOldPassword", "Your old password is incorrect");

            }
        }
        request.getRequestDispatcher("change-password.jsp").forward(request, response);
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
