/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package CourseManagementController;

import Dal.CourseDAO;
import Model.LessonDBO;
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

        String action = request.getParameter("action");
        if (action == null) {
            return;
        }
        request.setAttribute("action", action);

        try {

            switch (action) {
                case "addLesson":
                    addLesson(request, response);
                    break;
                case "removeLesson":
                    remvoveLesson(request, response);
                    break;
                default:
                    editLesson(request, response);
            }

        } catch (NullPointerException e) {
            request.setAttribute("errorMess", "Invalid input detected. Please try again.");
        }

        //request.getRequestDispatcher(requestDispatcher).forward(request, response);
    }

    private void addLesson(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CourseDAO courseDao = new CourseDAO();
        HttpSession session = request.getSession();
        String courseId = (String) session.getAttribute("course_id_MT");
        if (courseId == null) {
            return;
        }
        String lessonName = request.getParameter("lessonName");
        String active = request.getParameter("active");

        try {
            if (lessonName.isBlank()) {
                request.setAttribute("errorMess", "Please enter lesson name");
            } else {
                int atv = Integer.parseInt(active);
                int checkAdd = courseDao.addLesson(lessonName, Integer.parseInt(courseId), atv);
                String mess = "";
                if (checkAdd > 0) {
                    mess = "Lesson added successfully!!!";
                } else {
                    mess = "Lesson added failure";
                }
                response.sendRedirect("CourseContentEdit?mess=" + mess);
                return;
            }
        } catch (NullPointerException e) {
        }
        request.setAttribute("lessonName", lessonName);
        request.setAttribute("active", active == null ? "0" : active);
        request.setAttribute("course", courseDao.getCourseByID(Integer.parseInt(courseId)));
        request.getRequestDispatcher("create-lesson.jsp").forward(request, response);

    }

    private void editLesson(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String courseId = (String) session.getAttribute("course_id_MT");
        if (courseId == null) {
            return;
        }
        CourseDAO courseDao = new CourseDAO();
        String lessonId = request.getParameter("lessonId");
        if (lessonId == null) {
            return;
        }
        request.setAttribute("lessonId", lessonId);

        String lessonName = request.getParameter("lessonName");
        String active = request.getParameter("active");

        try {
            if (lessonName.isBlank()) {
                request.setAttribute("errorMess", "Please enter lesson name");
            } else {
                int atv = Integer.parseInt(active);
                int check = courseDao.editLesson(Integer.parseInt(lessonId), lessonName, atv);
                String mess = "";
                if (check > 0) {
                    mess = "Lesson updated successfully!!!";
                } else {
                    mess = "Lesson updated failure";
                }
                response.sendRedirect("CourseContentEdit?course_id=" + courseId + "&mess=" + mess);
                return;
            }
        } catch (NullPointerException e) {
        }
        LessonDBO lesson = courseDao.getLessonByID(lessonId);
        request.setAttribute("lessonName", lesson.getTitle());
        request.setAttribute("active", lesson.isIs_locked() == true ? 1 : 0);

        request.setAttribute("course", courseDao.getCourseByID(Integer.parseInt(courseId)));
        request.getRequestDispatcher("edit-lesson.jsp").forward(request, response);
    }

    private void remvoveLesson(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CourseDAO courseDao = new CourseDAO();
//        String courseId = request.getParameter("course_id");
//        if (courseId == null) {
//            return;
//        }
        String lessonId = request.getParameter("lessonId");
        if (lessonId != null) {
            int check = courseDao.removeLesson(Integer.parseInt(lessonId));
            String mess = "";
            if (check > 0) {
                mess = "Removed lesson successfully";
            } else {
                mess = "Removed lesson failed";

            }
            response.sendRedirect("CourseContentEdit?mess=" + mess);
        }

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

        String action = request.getParameter("action");

        try {
            if (action != null) {
                request.setAttribute("action", action);

                switch (action) {
                    case "addLesson":
                        addLesson(request, response);
                        break;
                    case "editLesson":
                        editLesson(request, response);
                        break;

                }
            }
        } catch (NullPointerException e) {
            request.setAttribute("errorMess", "Invalid input detected. Please try again.");
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
