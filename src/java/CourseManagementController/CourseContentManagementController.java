/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
<<<<<<<< HEAD:src/java/CourseManagementController/CourseContentManagementController.java
package CourseManagementController;

import Dal.CourseDAO;
import Model.CourseDBO;
import Model.UserDBO;
========
package UserManagermentController;

import Dal.UserDAO;

>>>>>>>> origin/Authentication:src/java/UserManagermentController/LoginController.java
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
<<<<<<<< HEAD:src/java/CourseManagementController/CourseContentManagementController.java
import java.util.ArrayList;
========

import Model.UserDBO;
>>>>>>>> origin/Authentication:src/java/UserManagermentController/LoginController.java

/**
 *
 * @author LEGION
 */
public class CourseContentManagementController extends HttpServlet {

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
<<<<<<<< HEAD:src/java/CourseManagementController/CourseContentManagementController.java
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CourseContentManagementController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CourseContentManagementController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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

                } else {
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

>>>>>>>> origin/Authentication:src/java/UserManagermentController/LoginController.java
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
        HttpSession session = request.getSession();
        UserDBO user = (UserDBO) session.getAttribute("user");

        CourseDAO courseDao = new CourseDAO();
        if (user == null) {
            return;
        }
        if (user.getRole().getId() == 2) {
            ArrayList<CourseDBO> listCourse = courseDao.getCourseByMentorId(user.getId());

            request.setAttribute("listCourse", listCourse);

        }

        request.setAttribute("courseDao", courseDao);
        request.getRequestDispatcher("course_content_management.jsp").forward(request, response);

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