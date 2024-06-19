/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
package UserManagermentController;

import Dal.CourseDAO;
import Dal.UserDAO;
import Model.CourseDBO;
=======
package UserManagermentController;

import Dal.UserDAO;
>>>>>>> origin/profile

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
<<<<<<< HEAD
=======
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
>>>>>>> origin/Authentication
=======
package UserManagermentController;
<<<<<<<< HEAD:src/java/UserManagermentController/ChangePasswordController.java

import Dal.UserDAO;
import Model.UserDBO;
========

import Dal.UserDAO;

>>>>>>>> origin/front-end:src/java/UserManagermentController/LoginController.java
import java.io.IOException;

import jakarta.servlet.ServletException;
>>>>>>> origin/front-end
=======
>>>>>>> origin/profile
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

import Model.UserDBO;
=======
<<<<<<<< HEAD:src/java/CourseManagementController/CourseContentManagementController.java
import java.util.ArrayList;
========

import Model.UserDBO;
>>>>>>>> origin/Authentication:src/java/UserManagermentController/LoginController.java
>>>>>>> origin/Authentication
=======
<<<<<<<< HEAD:src/java/UserManagermentController/ChangePasswordController.java
========

import Model.UserDBO;
>>>>>>>> origin/front-end:src/java/UserManagermentController/LoginController.java
>>>>>>> origin/front-end
=======

import Model.UserDBO;
>>>>>>> origin/profile

/**
 *
 * @author LEGION
 */
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
public class LoginController extends HttpServlet {
=======
public class CourseContentManagementController extends HttpServlet {
>>>>>>> origin/Authentication
=======
public class ChangePasswordController extends HttpServlet {
>>>>>>> origin/front-end
=======
public class LoginController extends HttpServlet {
>>>>>>> origin/profile

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
<<<<<<< HEAD
<<<<<<< HEAD
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
<<<<<<< HEAD
=======
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
>>>>>>> origin/Authentication
=======
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
>>>>>>> origin/front-end
=======
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
>>>>>>> origin/profile
        UserDAO dao = new UserDAO();
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        String action = request.getParameter("action");
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        if (action != null) {
            session.setAttribute("action", action);
        }

=======
  
>>>>>>> origin/Authentication
=======
  
>>>>>>> origin/front-end
=======
  
>>>>>>> origin/profile
        try {
            username = username.toLowerCase().trim();
            password = password.trim();
            UserDBO user = dao.LoginCheck(username, password);

            if (user == null) {

                request.setAttribute("mess", "Wrong user or password!!!");
            } else {
                if (dao.checkLockedUser(user.getId())) {
                    request.setAttribute("mess", "Your account has been looked!!!");
<<<<<<< HEAD
<<<<<<< HEAD

                } else {
<<<<<<< HEAD
                    session.setAttribute("user", user);
=======
                    HttpSession s = request.getSession();
                    s.setAttribute("user", user);
>>>>>>> origin/Authentication
=======
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
>>>>>>> origin/front-end
=======

                } else {
                    HttpSession s = request.getSession();
                    s.setAttribute("user", user);
>>>>>>> origin/profile
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                    String act = (String) session.getAttribute("action");
                    if (act != null) {
                        CourseDAO courseDao = new CourseDAO();
                        CourseDBO course = (CourseDBO) session.getAttribute("course");
                        if (course != null) {
                            boolean check = courseDao.userEnrolledCheck(user.getId(), course.getId());
                            if (check) {
                                response.sendRedirect(request.getContextPath() + "/course/learning");
                            } else {
                                if (course.getPrice() > 0) {
                                    response.sendRedirect(request.getContextPath() + "/course_learing");

                                } else {
                                    int n = courseDao.enrollCourse(user.getId(), course.getId());
                                    if (n > 0) {
                                        response.sendRedirect(request.getContextPath() + "/course/learning");

                                    } else {

                                    }

                                }
                            }

                        }
                        if (action != null) {
                            session.removeAttribute("action");
                        }
                        return;

                    } else {
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
=======
                    request.getRequestDispatcher("index.jsp").forward(request, response);
>>>>>>> origin/Authentication
=======
                    request.getRequestDispatcher("index.jsp").forward(request, response);
>>>>>>> origin/front-end
=======
                    request.getRequestDispatcher("index.jsp").forward(request, response);
>>>>>>> origin/profile
                    return;

                }

            }
        } catch (NullPointerException e) {

        }

        request.getRequestDispatcher("login.jsp").forward(request, response);

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>>> origin/Authentication:src/java/UserManagermentController/LoginController.java
>>>>>>> origin/Authentication
=======
>>>>>>>> origin/front-end:src/java/UserManagermentController/LoginController.java
>>>>>>> origin/front-end
=======
>>>>>>> origin/profile
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        processRequest(request, response);
=======
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

>>>>>>> origin/Authentication
=======
        processRequest(request, response);
>>>>>>> origin/front-end
=======
        processRequest(request, response);
>>>>>>> origin/profile
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        processRequest(request, response);
=======

>>>>>>> origin/Authentication
=======
        processRequest(request, response);
>>>>>>> origin/front-end
=======
        processRequest(request, response);
>>>>>>> origin/profile
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
