/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package UserManagermentController;
<<<<<<<< HEAD:src/java/UserManagermentController/ChangePasswordController.java

import Dal.UserDAO;
import Model.UserDBO;
========

import Dal.UserDAO;

>>>>>>>> origin/front-end:src/java/UserManagermentController/LoginController.java
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
<<<<<<<< HEAD:src/java/UserManagermentController/ChangePasswordController.java
========

import Model.UserDBO;
>>>>>>>> origin/front-end:src/java/UserManagermentController/LoginController.java

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
<<<<<<<< HEAD:src/java/UserManagermentController/ChangePasswordController.java

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
========
        UserDAO dao = new UserDAO();
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        String action = request.getParameter("action");
  
        try {
            username = username.toLowerCase().trim();
            password = password.trim();
            UserDBO user = dao.LoginCheck(username, password);

            if (user == null) {

                request.setAttribute("mess", "Wrong user or password!!!");
            } else {
                if (dao.checkLockedUser(user.getId())) {
                    request.setAttribute("mess", "Your account has been looked!!!");
>>>>>>>> origin/front-end:src/java/UserManagermentController/LoginController.java

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
<<<<<<<< HEAD:src/java/UserManagermentController/ChangePasswordController.java
                    request.setAttribute("errorNewPassword", "Password must contain at least 8 characters, at least 1 number and both lower and uppercase letters and special characters");

                }
            } else {
                request.setAttribute("errorOldPassword", "Your old password is incorrect");

            }
        }
        request.getRequestDispatcher("change-password.jsp").forward(request, response);
========
                    HttpSession s = request.getSession();
                    s.setAttribute("user", user);
                    Cookie name = new Cookie("username", username);
                    Cookie pass = new Cookie("password", password);
                    Cookie rem = new Cookie("remember", "selected");
                    if (remember == null) {
                        name.setMaxAge(0);
                        pass.setMaxAge(0);
                        rem.setMaxAge(0);

                    } else {
                        int n = 30 * 24 * 60 * 60;
                        name.setMaxAge(n);
                        pass.setMaxAge(n);
                        rem.setMaxAge(n);
                    }
                    response.addCookie(name);
                    response.addCookie(pass);
                    response.addCookie(rem);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    return;

                }

            }
        } catch (NullPointerException e) {

        }

        request.getRequestDispatcher("login.jsp").forward(request, response);

>>>>>>>> origin/front-end:src/java/UserManagermentController/LoginController.java
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
