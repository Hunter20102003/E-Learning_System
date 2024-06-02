/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package UserManagermentController;

import Dal.UserDAO;

import java.io.IOException;

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
public class LoginController extends HttpServlet {

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
        UserDAO dao = new UserDAO();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        username = username.toLowerCase().trim();
        password = password.trim();
        UserDBO user = dao.LoginCheck(username, password);
        HttpSession session=request.getSession();
        if (user == null) {

            request.setAttribute("mess", "Wrong user or password!!!");
        } else {
            if (dao.checkLockedUser(user.getId())) {
                request.setAttribute("mess", "Your account has been looked!!!");

            } else {
                HttpSession s=request.getSession();
                s.setAttribute("user",user);
                Cookie name = new Cookie("username", username);
                Cookie pass = new Cookie("password", password);
                Cookie rem = new Cookie("remember", "selected");
                if (remember == null) {
                    name.setMaxAge(0);
                    pass.setMaxAge(0);
                    rem.setMaxAge(0);

                } else {
                    int n =30* 24 * 60 * 60;
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
       
        request.getRequestDispatcher("login.jsp").forward(request, response);

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
