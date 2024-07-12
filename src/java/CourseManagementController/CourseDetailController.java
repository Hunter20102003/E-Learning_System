/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package CourseManagementController;

import Dal.CourseDAO;
import Dal.PaymentDAO;
import Dal.UserDAO;
import Model.CourseDBO;
import Model.Payment;
<<<<<<< HEAD
import Model.ReviewDBO;
=======
>>>>>>> origin/AdminManager
import Model.UserDBO;
import YoutobeDataAPI.YouTubeDuration;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author LEGION
 */
public class CourseDetailController extends HttpServlet {

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
            out.println("<title>Servlet CourseDetailController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CourseDetailController at " + request.getContextPath() + "</h1>");
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
        String courseId = request.getParameter("course_id");
        CourseDAO courseDAO = new CourseDAO();
        UserDAO userDAO = new UserDAO();
        YouTubeDuration youTubeDuration = new YouTubeDuration();
        HttpSession session = request.getSession();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

        UserDBO user = (UserDBO) session.getAttribute("user");
<<<<<<< HEAD
<<<<<<< HEAD
        String enrollCourse = request.getParameter("enrollCourse");
        if (courseId == null) {
            return;
        }

        if (enrollCourse != null && user != null) {

            int n = courseDAO.enrollCourse(user.getId(), Integer.parseInt(courseId));
            if (n > 0) {

                response.sendRedirect(request.getContextPath() + "/course/learning");
                return;
            }

        }

        CourseDBO course = courseDAO.getCourseByID(Integer.parseInt(courseId));
        ArrayList<ReviewDBO> listReviews = (ArrayList<ReviewDBO>) courseDAO.getAllReviewByCourseID(course.getId());
=======
        if (courseId == null) {

            CourseDBO c = (CourseDBO) session.getAttribute("course");
            // response.getWriter().print(c.getName());

=======
        UserDBO user = (UserDBO) session.getAttribute("user");
        if (courseId == null) {

            CourseDBO c = (CourseDBO) session.getAttribute("course");
            // response.getWriter().print(c.getName());

>>>>>>> origin/crudlesson,sublesson
            String enrollCourse = request.getParameter("enrollCourse");
            if (c != null && enrollCourse != null && user != null) {
                int n = courseDAO.enrollCourse(user.getId(), c.getId());
                if (n > 0) {

                    response.sendRedirect(request.getContextPath() + "/course/learning");
                }

            }

=======
=======
        UserDBO user = (UserDBO) session.getAttribute("user");
>>>>>>> origin/AdminManager
        if (courseId == null) {

            CourseDBO c = (CourseDBO) session.getAttribute("course");
            // response.getWriter().print(c.getName());

            String enrollCourse = request.getParameter("enrollCourse");
            if (c != null && enrollCourse != null && user != null) {
                int n = courseDAO.enrollCourse(user.getId(), c.getId());
                if (n > 0) {

                    response.sendRedirect(request.getContextPath() + "/course/learning");
                }

            }

<<<<<<< HEAD
>>>>>>> origin/develop
=======
>>>>>>> origin/AdminManager
        } else {
            CourseDBO course = courseDAO.getCourseByID(Integer.parseInt(courseId));

            long durationCourse = courseDAO.getDurationOfCourse(Integer.parseInt(courseId));
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> origin/DashBoard

        long durationCourse = courseDAO.getDurationOfCourse(Integer.parseInt(courseId));

        ArrayList<CourseDBO> listRelatedCourse = (ArrayList<CourseDBO>) courseDAO.getCourseByCourseType(String.valueOf(course.getCourse_type().getId()));

        if (!listRelatedCourse.isEmpty()) {
            for (int i = 0; i < listRelatedCourse.size(); i++) {
                if (listRelatedCourse.get(i).getId() == course.getId()) {
                    listRelatedCourse.remove(i);
                }
=======
=======
>>>>>>> origin/develop
=======
>>>>>>> origin/AdminManager

            ArrayList<CourseDBO> listRelatedCourse = (ArrayList<CourseDBO>) courseDAO.getCourseByCourseType(courseId);

            if (!listRelatedCourse.isEmpty()) {
                for (int i = 0; i < listRelatedCourse.size(); i++) {
                    if (listRelatedCourse.get(i).getId() == course.getId()) {
                        listRelatedCourse.remove(i);
                    }
                }

                if (listRelatedCourse.size() > 4) {
                    listRelatedCourse = new ArrayList<>(listRelatedCourse.subList(0, 4));
                }
                request.setAttribute("listRelatedCourse", listRelatedCourse);
<<<<<<< HEAD
>>>>>>> origin/crudlesson,sublesson
            }
<<<<<<< HEAD

            if (listRelatedCourse.size() > 4) {
                listRelatedCourse = new ArrayList<>(listRelatedCourse.subList(0, 4));
            }
            request.setAttribute("listRelatedCourse", listRelatedCourse);
=======
=======
            }
>>>>>>> origin/AdminManager
            session.setAttribute("course", course);
            if (user != null) {
                request.setAttribute("enrolledCheck", courseDAO.userEnrolledCheck(user.getId(), course.getId()));
            }
            request.setAttribute("durationCourse", youTubeDuration.convertToHoursAndMinutes(durationCourse));
            request.setAttribute("listLesson", courseDAO.getListLessonByCourseID(courseId));
            request.setAttribute("teacher", userDAO.getUserByID("" + course.getTeacher_id()));
            request.getRequestDispatcher("/detailCourse.jsp").forward(request, response);
<<<<<<< HEAD
>>>>>>> origin/DashBoard
        }
=======

        UserDBO user = (UserDBO) session.getAttribute("user");
        String enrollCourse = request.getParameter("enrollCourse");
        if (courseId == null) {
            return;
        }

        if (enrollCourse != null && user != null) {

            int n = courseDAO.enrollCourse(user.getId(), Integer.parseInt(courseId));
            if (n > 0) {

                response.sendRedirect(request.getContextPath() + "/course/learning");
                return;
            }

        }

        CourseDBO course = courseDAO.getCourseByID(Integer.parseInt(courseId));
        ArrayList<ReviewDBO> listReviews = (ArrayList<ReviewDBO>) courseDAO.getAllReviewByCourseID(course.getId());

        long durationCourse = courseDAO.getDurationOfCourse(Integer.parseInt(courseId));

        ArrayList<CourseDBO> listRelatedCourse = (ArrayList<CourseDBO>) courseDAO.getCourseByCourseType(String.valueOf(course.getCourse_type().getId()));

        if (!listRelatedCourse.isEmpty()) {
            for (int i = 0; i < listRelatedCourse.size(); i++) {
                if (listRelatedCourse.get(i).getId() == course.getId()) {
                    listRelatedCourse.remove(i);
                }
            }

            if (listRelatedCourse.size() > 4) {
                listRelatedCourse = new ArrayList<>(listRelatedCourse.subList(0, 4));
            }
            request.setAttribute("listRelatedCourse", listRelatedCourse);
        }
>>>>>>> origin/crud_quiz
        session.setAttribute("course", course);
        request.setAttribute("enrolledCheck", courseDAO.userEnrolledCheck(user.getId(), course.getId()));
        request.setAttribute("listReviews", listReviews);


        request.setAttribute("userDAO", userDAO);
        request.setAttribute("durationCourse", youTubeDuration.convertToHoursAndMinutes(durationCourse));
        request.setAttribute("listLesson", courseDAO.getListLessonByCourseID(courseId));
        request.setAttribute("teacher", userDAO.getUserByID("" + course.getTeacher_id()));

        request.getRequestDispatcher("/detail-course1.jsp").forward(request, response);

=======
        }
>>>>>>> origin/AdminManager
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
