/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package AdminManagementController;

import Dal.AdminDAO;
import Dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author buiqu
 */
public class Add_Account extends HttpServlet {

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
            out.println("<title>Servlet Add_Account</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Add_Account at " + request.getContextPath() + "</h1>");
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
        doPost(request, response);
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
        Dal.AdminDAO db = new AdminDAO();

        String name = request.getParameter("name");
        String password = request.getParameter("pas");
        String email = request.getParameter("email");
        String frit_name = request.getParameter("fname");
        String last_name = request.getParameter("lname");
        String role_id = request.getParameter("role");
        boolean check = true;
       if (name.isBlank() || email.isBlank() || password.isBlank() || frit_name.isBlank() || last_name.isBlank()) {
            request.setAttribute("errorMessage", "Please enter complete information!!!!");
            check = false;
        } else {

            UserDAO dao = new UserDAO();

            if (!validUserName(name)) {
                request.setAttribute("errorUserName", "Username is invalid!!!");
                check = false;
            } else if (dao.checkUserNameExisted(name)) {
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
            } 
        }
        HttpSession session = request.getSession();
        session.setAttribute("username", name);
        session.setAttribute("firstname", frit_name);
        session.setAttribute("lastname", last_name);
        session.setAttribute("email", email);
        session.setAttribute("password", password);
        session.setAttribute("role", role_id);
   

        if (check) {
            db.addAccount(name, password, email, frit_name, last_name, role_id);
           request.getRequestDispatcher("add-account.jsp").forward(request, response);
        } else {
            request.setAttribute("username", name);
            request.setAttribute("firstname", frit_name);
            request.setAttribute("lastname", last_name);
            request.setAttribute("email", email);
            request.setAttribute("password", password);
            session.setAttribute("role", role_id);
          
            request.getRequestDispatcher("add-account.jsp").forward(request, response);
        }
    }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
