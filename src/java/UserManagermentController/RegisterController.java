/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package UserManagermentController;

import UserManagementController.Google.OTP_Email;
import Dal.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author LEGION
 */
public class RegisterController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public boolean validUserName(String name) {
        return name.matches("^[a-zA-Z0-9]+$");
    }

    public boolean validPassword(String password) {
        return password.matches("^(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,}$");
    }

    public boolean validEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public boolean validName(String name) {
        return name.matches("^[a-z]+$");
    }

    public String capitalizeFirstLetter(String name) {

        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
    private void sendMail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        OTP_Email OTP = new OTP_Email();
        String email = (String) session.getAttribute("email");
        String otp = OTP.sendOtpMail(email);
        if (otp != null) {
            Cookie otpCookie = new Cookie("otp", otp);
            otpCookie.setMaxAge(60 * 5);
            response.addCookie(otpCookie);
            //  session.setAttribute("otp", otp);
            request.setAttribute("messSendOTP", "OTP is sending to your email now");

        } else {
            request.setAttribute("messSendOTP", "OTP sending failed");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String resendOTP = request.getParameter("resendOTP");
        if (resendOTP != null) {
            sendMail(request, response);
        } else {
            try {
                String otp = request.getParameter("otp").trim();

                String username = (String) session.getAttribute("username");
                String firstname = (String) session.getAttribute("firstname");
                String lastname = (String) session.getAttribute("lastname");
                String email = (String) session.getAttribute("email");
                String password = (String) session.getAttribute("password");
                if (otp.isBlank()) {
                    request.setAttribute("errorOTP", "Please enter OTP sent your email");
                } else {
                    Cookie[] CookieArr = request.getCookies();
                    Cookie cookie = null;
                    String otpCookie = "";
                    if (CookieArr != null) {
                        for (Cookie c : CookieArr) {
                            if (c.getName().equals("otp")) {
                                otpCookie = c.getValue();

                            }
                        }
                    }

                    if (otpCookie.equals(otp)) {
                        if (cookie != null) {
                            cookie.setMaxAge(0);
                        }
                        UserDAO dao = new UserDAO();
                        int n = dao.register(username, password, firstname, lastname, email);
                        if (n == 0) {
                            request.setAttribute("registerError", "Registration failed");
                        } else {
                            request.setAttribute("registerSuccess", "Registration success");
                        }
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                        return;

                    } else {
                        request.setAttribute("errorOTP", "OTP is incorrect");

                    }

                }
            } catch (NullPointerException e) {
                sendMail(request, response);
            }
        }
        request.setAttribute("controller", "register");
        request.getRequestDispatcher("OTP.jsp").forward(request, response);

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
        String username = request.getParameter("username").trim().toLowerCase();
        String firstname = request.getParameter("firstname").trim().toLowerCase();
        String lastname = request.getParameter("lastname").trim().toLowerCase();
        String email = request.getParameter("email").trim().toLowerCase();
        String password = request.getParameter("password").trim();
        String repassword = request.getParameter("repassword").trim();
        boolean check = true;
        if (username.isBlank() || email.isBlank() || password.isBlank() || repassword.isBlank() || firstname.isBlank() || lastname.isBlank()) {
            request.setAttribute("errorMessage", "Please enter complete information!!!!");
            check = false;
        } else {

            UserDAO dao = new UserDAO();

            if (!validUserName(username)) {
                request.setAttribute("errorUserName", "Username is invalid!!!");
                check = false;
            } else if (dao.checkUserNameExisted(username)) {
                request.setAttribute("errorUserName", "Username has been existed!!!");
                check = false;
            }

            if (!validEmail(email)) {
                request.setAttribute("errorEmail", "Email is invalid!!!");
                check = false;
            } else if (dao.checkEmailExisted(email)) {
                request.setAttribute("errorEmail", "Email has been existed!!!");
                check = false;
            }

            if (!validPassword(password)) {
                request.setAttribute("errorPassword", "Password must contain at least 8 characters, at least 1 number and both lower and uppercase letters and special characters");
                check = false;
            } else if (!password.equals(repassword)) {
                request.setAttribute("errorRePassword", "Passwords do not match!!!");
                check = false;
            }
        }
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        session.setAttribute("firstname", firstname);
        session.setAttribute("lastname", lastname);
        session.setAttribute("email", email);
        session.setAttribute("password", password);
        session.setAttribute("repassword", repassword);

        if (check) {
            response.sendRedirect("register");
        } else {
            request.setAttribute("username", username);
            request.setAttribute("firstname", firstname);
            request.setAttribute("lastname", lastname);
            request.setAttribute("email", email);
            request.setAttribute("password", password);
            request.setAttribute("repassword", repassword);
            request.getRequestDispatcher("signup.jsp").forward(request, response);
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
}
