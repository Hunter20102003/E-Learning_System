/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package UserManagermentController;

import UserManagementController.Google.OTP_Email;
import Dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Model.UserDBO;

/**
 *
 * @author LEGION
 */
public class ForgotPasswordController extends HttpServlet {

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
            out.println("<title>Servlet ForgotPasswordController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ForgotPasswordController at " + request.getContextPath() + "</h1>");
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
    private void sendMail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        OTP_Email OTP = new OTP_Email();
        String email = (String) session.getAttribute("email");
        String otp = OTP.sendMail(email);
        if (otp != null) {
            Cookie otpCookie = new Cookie("otp", otp);
            otpCookie.setMaxAge(60 * 5);
            response.addCookie(otpCookie);

            //session.setAttribute("otp", otp);
            request.setAttribute("messSendOTP", "OTP is sending to your email now");

        } else {
            request.setAttribute("messSendOTP", "OTP sending failed");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        UserDAO dao = new UserDAO();
        String resendOTP = request.getParameter("resendOTP");
        if (resendOTP != null) {
            sendMail(request, response);
        } else {
            try {
                String otp = request.getParameter("otp").trim();

                if (otp.isBlank()) {
                    request.setAttribute("errorOTP", "Please enter OTP sent your email");
                } else {
                    String otpCookie = "";
                    Cookie[] cookieArr = request.getCookies();
                    Cookie cookie = null;
                    if (cookieArr != null) {
                        for (Cookie c : cookieArr) {
                            if (c.getName().equals("otp")) {
                                otpCookie = c.getValue();
                                cookie = c;
                            }
                        }
                    }

                    if (otpCookie.equals(otp)) {
                        if (cookie != null) {
                            cookie.setMaxAge(0);
                        }

                        String email = (String) session.getAttribute("email");
                        System.out.println(email);
                        System.out.println(email);
                        UserDBO user = dao.getUserByEmail(email);
                       response.getWriter().print(user); 
                        session.setAttribute("user", user);
                        System.out.println(user);
                        request.getRequestDispatcher("resetPassword.jsp").forward(request, response);

                    } else {
                        request.setAttribute("errorOTP", "OTP is incorrect");

                    }
                }

            } catch (NullPointerException e) {
                sendMail(request, response);
            }
        }
       
        session.setAttribute("controller", "forgot-password");
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
    public boolean validEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email").trim().toLowerCase();
        if (email.isBlank()) {
            request.setAttribute("errorMess", "Please enter your email address");
        } else {
            if (validEmail(email)) {
                UserDAO dao = new UserDAO();
                if (dao.checkEmailExisted(email)) {
                    UserDBO user = dao.getUserByEmail(email);
                    if (user.getUsername() != null) {
                        session.setAttribute("email", email);
                      
                        response.sendRedirect("forgot-password");
                        return;
                    }
                    else{
                        request.setAttribute("errorMess", "Your email address hasn't been registed");
                    }

                } else {
                    request.setAttribute("errorMess", "Your email address hasn't been registed");

                }

            } else {
                request.setAttribute("errorMess", "Invalid email address");

            }
        }
        request.setAttribute("email",email);
       if (session.getAttribute(email)!=null){
           session.removeAttribute("email");
       }
        request.getRequestDispatcher("forgot-password.jsp").forward(request, response);

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
