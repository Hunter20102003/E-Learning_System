/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package CourseManagementController;

import Dal.CourseDAO;
import Model.LessonDBO;
import Model.SubLessonDBO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author LEGION
 */
public class LessonController extends HttpServlet {

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
            out.println("<title>Servlet LessonController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LessonController at " + request.getContextPath() + "</h1>");
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
//        String courseId = request.getParameter("courseId");
//        String action = request.getParameter("action");
//        CourseDAO courseDao = new CourseDAO();
//        request.setAttribute("course", courseDao.getCourseByID(courseId));
//        request.setAttribute("courseId", courseId);
//        request.setAttribute("action", action);
//        request.getRequestDispatcher("create-lesson.jsp").forward(request, response);

        CourseDAO courseDao = new CourseDAO();
        String courseId = request.getParameter("courseId");
        String action = request.getParameter("action");
        String requestDispatcher = ""; // Khởi tạo mặc định
        if (courseId != null) {
            request.setAttribute("course", courseDao.getCourseByID(Integer.parseInt(courseId)));
        }
        request.setAttribute("courseId", courseId);
        request.setAttribute("action", action);
        String lessonId = "";
        String lessonName = "";
        try {
            if (action != null) {
                switch (action) {
                    case "addLesson":
                        requestDispatcher = "create-lesson.jsp";
                        lessonName = request.getParameter("lessonName");
                        if (lessonName == null) {
                            requestDispatcher = "create-lesson.jsp";
                        } else if (lessonName.isBlank()) {

                            request.setAttribute("errorMess", "Please enter lesson name");
                        } else {
                            String active = request.getParameter("active");
                            int atv = Integer.parseInt(active);

                            int checkAdd = courseDao.addLesson(lessonName, Integer.parseInt(courseId), atv);
                            if (checkAdd > 0) {
                                request.setAttribute("successMess", "Lesson added successfully!!!");
                                requestDispatcher = "CourseContentManagement";
                            } else {
                                request.setAttribute("errorMess", "Lesson added failure");
                            }
                        }

                        request.setAttribute("course", courseDao.getCourseByID(Integer.parseInt(courseId)));
                        request.setAttribute("courseId", courseId);
                        request.setAttribute("action", action);
                        break;
                    case "removeLesson":
                        lessonId = request.getParameter("lessonId");
                        if (lessonId != null) {
                            int check = courseDao.removeLesson(Integer.parseInt(lessonId));
                            if (check > 0) {
                                requestDispatcher = "CourseContentManagement";
                            }
                        }
                        break;
                    default:
                        requestDispatcher = "edit-lesson.jsp";
                        lessonName = request.getParameter("lessonName");
                        lessonId = request.getParameter("lessonId");
                        request.setAttribute("course", courseDao.getCourseByLessonID(lessonId));
                        if (lessonName == null) {
                            requestDispatcher = "edit-lesson.jsp";
                        } else if (lessonName.isBlank()) {
                            requestDispatcher = "edit-lesson.jsp";
                            request.setAttribute("errorMess", "Please enter lesson name");
                        } else {
                            String active = request.getParameter("active");
                            int atv = Integer.parseInt(active);

                            int check = courseDao.editLesson(Integer.parseInt(lessonId), lessonName, atv);
                            if (check > 0) {
                                request.setAttribute("successMess", "Lesson edited successfully!!!");
                                requestDispatcher = "CourseContentManagement";
                            } else {
                                request.setAttribute("errorMess", "Lesson edited failure");
                            }
                        }
                        LessonDBO lesson = courseDao.getLessonByID(lessonId);
                        request.setAttribute("lessonName", lesson.getTitle());
                        request.setAttribute("active", lesson.isIs_locked() == true ? 1 : 0);

                        request.setAttribute("lessonId", lessonId);
                        request.setAttribute("action", action);
                        break;

                }
            }
        } catch (NullPointerException e) {
            request.setAttribute("errorMess", "Invalid input detected. Please try again.");
        }

        request.getRequestDispatcher(requestDispatcher).forward(request, response);

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
