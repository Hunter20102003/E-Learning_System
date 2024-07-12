/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package CourseManagementController;

import Dal.CourseDAO;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import Dal.QuizDAO;
=======
>>>>>>> origin/DashBoard
=======
>>>>>>> origin/develop
=======
import Dal.QuizDAO;
>>>>>>> origin/crud_quiz
=======
>>>>>>> origin/AdminManager
=======
>>>>>>> origin/comment
=======
import Dal.QuizDAO;
>>>>>>> origin/create-course1
=======
import Dal.QuizDAO;
>>>>>>> origin/front-end
import Model.CourseDBO;
import Model.UserDBO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> origin/DashBoard
=======
import java.util.List;
>>>>>>> origin/crudlesson,sublesson
=======
>>>>>>> origin/develop
=======
>>>>>>> origin/AdminManager
=======
>>>>>>> origin/comment
=======
import java.util.List;
>>>>>>> origin/create-course1
=======
import java.util.List;
>>>>>>> origin/front-end

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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/crudlesson,sublesson
=======
>>>>>>> origin/create-course1
=======
>>>>>>> origin/front-end
    private int pageCounting(int n) {
        if (n == 0) {
            return 1;
        }
        return (n + 5) / 6;
    }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/create-course1
=======
>>>>>>> origin/front-end

    private List<CourseDBO> CoursePaggingList(int page, List<CourseDBO> listCourse) {
        int pageSize = 6;

<<<<<<< HEAD
<<<<<<< HEAD
=======
    
    private List<CourseDBO> CoursePaggingList(int page, List<CourseDBO> listCourse) {
        int pageSize = 6;
        
>>>>>>> origin/crudlesson,sublesson
=======

    private List<CourseDBO> CoursePaggingList(int page, List<CourseDBO> listCourse) {
        int pageSize = 6;

>>>>>>> origin/crud_quiz
=======
>>>>>>> origin/create-course1
=======
>>>>>>> origin/front-end
        int fromIndex = (page - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, listCourse.size());
        return listCourse.subList(fromIndex, toIndex);
    }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> origin/DashBoard
=======
    
>>>>>>> origin/crudlesson,sublesson
=======
>>>>>>> origin/develop
=======

>>>>>>> origin/crud_quiz
=======
>>>>>>> origin/AdminManager
=======
>>>>>>> origin/comment
=======

>>>>>>> origin/create-course1
=======

>>>>>>> origin/front-end
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDBO user = (UserDBO) session.getAttribute("user");
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/create-course1
=======
>>>>>>> origin/front-end
        String search = request.getParameter("search");
        String pageStr = request.getParameter("page");
        String mess = request.getParameter("mess");
        int page = 1;
        ArrayList<CourseDBO> listCourse = new ArrayList<>();
        QuizDAO quizDao = new QuizDAO();
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> origin/DashBoard
=======
        String search = request.getParameter("search");
        String pageStr = request.getParameter("page");
        String mess = request.getParameter("mess");
        int page = 1;
        ArrayList<CourseDBO> listCourse = new ArrayList<>();
<<<<<<< HEAD
>>>>>>> origin/crudlesson,sublesson
=======

>>>>>>> origin/develop
=======
        QuizDAO quizDao = new QuizDAO();
>>>>>>> origin/crud_quiz
=======

>>>>>>> origin/AdminManager
=======

>>>>>>> origin/comment
=======
>>>>>>> origin/create-course1
=======
>>>>>>> origin/front-end
        CourseDAO courseDao = new CourseDAO();
        if (user == null) {
            return;
        }
        if (user.getRole().getId() == 2) {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/create-course1
=======
>>>>>>> origin/front-end
            if (search != null && !search.isBlank()) {
                listCourse = courseDao.searchCourseBelongMentor(search, user.getId());
                request.setAttribute("search", search);

            } else {
                listCourse = courseDao.getCourseByMentorId(user.getId());

            }

        }
        if (pageStr != null) {
            try {
                page = Integer.parseInt(pageStr);
            } catch (NumberFormatException ex) {

            }
        }
        if (mess != null) {
            request.setAttribute("mess", mess);
        }
        request.setAttribute("page", page);
        request.setAttribute("pageCounting", pageCounting(listCourse.size()));
        request.setAttribute("listCourse", CoursePaggingList(page, listCourse));
        request.setAttribute("courseDao", courseDao);
        request.setAttribute("quizDao", quizDao);

<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> origin/develop
=======
>>>>>>> origin/AdminManager
=======
>>>>>>> origin/comment
            ArrayList<CourseDBO> listCourse = courseDao.getCourseByMentorId(user.getId());

            request.setAttribute("listCourse", listCourse);

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
            if (search != null && !search.isBlank()) {
                listCourse = courseDao.searchCourseBelongMentor(search, user.getId());
                request.setAttribute("search", search);

            } else {
                listCourse = courseDao.getCourseByMentorId(user.getId());

            }
<<<<<<< HEAD
            
>>>>>>> origin/crudlesson,sublesson
=======

>>>>>>> origin/crud_quiz
        }
        if (pageStr != null) {
            try {
                page = Integer.parseInt(pageStr);
            } catch (NumberFormatException ex) {

            }
        }
        if (mess != null) {
            request.setAttribute("mess", mess);
        }
        request.setAttribute("page", page);
        request.setAttribute("pageCounting", pageCounting(listCourse.size()));
        request.setAttribute("listCourse", CoursePaggingList(page, listCourse));
        request.setAttribute("courseDao", courseDao);
<<<<<<< HEAD
>>>>>>> origin/DashBoard
        request.getRequestDispatcher("course_content_management.jsp").forward(request, response);
        
=======
=======
>>>>>>> origin/AdminManager
=======
>>>>>>> origin/comment
        }

        request.setAttribute("courseDao", courseDao);
        request.getRequestDispatcher("course_content_management.jsp").forward(request, response);

<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> origin/develop
=======
        request.setAttribute("quizDao", quizDao);

        request.getRequestDispatcher("course_content_management.jsp").forward(request, response);

>>>>>>> origin/crud_quiz
=======
>>>>>>> origin/AdminManager
=======
>>>>>>> origin/comment
=======
        request.getRequestDispatcher("course_content_management.jsp").forward(request, response);

>>>>>>> origin/create-course1
=======
        request.getRequestDispatcher("course_content_management.jsp").forward(request, response);

>>>>>>> origin/front-end
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        
=======

>>>>>>> origin/develop
=======

>>>>>>> origin/crud_quiz
=======

>>>>>>> origin/AdminManager
=======

>>>>>>> origin/comment
=======

>>>>>>> origin/create-course1
=======

>>>>>>> origin/front-end
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
