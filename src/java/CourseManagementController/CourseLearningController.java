/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package CourseManagementController;

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/front-end
import Dal.CommentDAO;
import Dal.CourseDAO;
import Model.CommentDBO;
import Model.CourseDBO;
import Model.LessonDBO;
import Model.SubLessonDBO;
import Model.UserDBO;
import YoutobeDataAPI.YouTubeDuration;
<<<<<<< HEAD
=======
import Dal.CourseDAO;
import Model.CourseDBO;
import Model.LessonDBO;
import Model.SubLessonDBO;
>>>>>>> origin/Authentication
=======
>>>>>>> origin/front-end
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
public class CourseLearningController extends HttpServlet {

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
            out.println("<title>Servlet CourseLearnController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CourseLearnController at " + request.getContextPath() + "</h1>");
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
<<<<<<< HEAD
<<<<<<< HEAD
        HttpSession session = request.getSession(false);
=======
        HttpSession session = request.getSession();
>>>>>>> origin/front-end
        CourseDBO course = (CourseDBO) session.getAttribute("course");
        String sub_lesson_id = request.getParameter("sub_lesson_id");
        CourseDAO courseDAO = new CourseDAO();
        CommentDAO commentDAO = new CommentDAO();

        YouTubeDuration youtobeDuration = new YouTubeDuration();
        ArrayList<LessonDBO> listLesson = courseDAO.getListLessonByCourseID("" + course.getId());
        SubLessonDBO subLesson = null;
<<<<<<< HEAD
        ArrayList<CommentDBO> listComment = new ArrayList<>();
        try {
            if (sub_lesson_id == null) {
                if (!listLesson.isEmpty() && listLesson.get(0) != null && listLesson.get(0).getSub_lesson_list() != null && !listLesson.get(0).getSub_lesson_list().isEmpty()) {
                    subLesson = listLesson.get(0).getSub_lesson_list().get(0);
                    sub_lesson_id = String.valueOf(subLesson.getId());
                }
=======
        HttpSession session = request.getSession();
        CourseDBO course = (CourseDBO) session.getAttribute("course");
        String sub_lesson_id = request.getParameter("sub_lesson_id");
        CourseDAO courseDAO = new CourseDAO();

        ArrayList<LessonDBO> listLesson = courseDAO.getListLessonByCourseID("" + course.getId());
        SubLessonDBO subLesson = null;
        try {

            if (sub_lesson_id == null) {
                if (listLesson.get(0).getSub_lesson_list().get(0) != null) {
                    subLesson = listLesson.get(0).getSub_lesson_list().get(0);
                }

>>>>>>> origin/Authentication
=======
        
        try {

            if (sub_lesson_id == null) {
                if (!listLesson.isEmpty() && listLesson.get(0) != null && listLesson.get(0).getSub_lesson_list() != null && !listLesson.get(0).getSub_lesson_list().isEmpty()) {
                    subLesson = listLesson.get(0).getSub_lesson_list().get(0);
                    sub_lesson_id=""+subLesson.getId();

                }
>>>>>>> origin/front-end
            } else {
                subLesson = courseDAO.getSubLessonByID(Integer.parseInt(sub_lesson_id));
            }

<<<<<<< HEAD
<<<<<<< HEAD
            if (sub_lesson_id != null) {
                listComment = commentDAO.getCommentsFromDatabase(Integer.parseInt(sub_lesson_id));
            }
        } catch (NumberFormatException e) {

        }
        request.setAttribute("comment", listComment);

        request.setAttribute("youtobeDuration", youtobeDuration);
=======
        } catch (NumberFormatException e) {

        }
>>>>>>> origin/Authentication
=======
        } catch (NumberFormatException e) {

        }
        ArrayList<CommentDBO> listComment = commentDAO.getCommentsFromDatabase(Integer.parseInt(sub_lesson_id));
        request.setAttribute("comment", listComment);

        request.setAttribute("youtobeDuration", youtobeDuration);
>>>>>>> origin/front-end
        request.setAttribute("subLesson", subLesson);
        request.setAttribute("listLesson", listLesson);
        request.getRequestDispatcher("/videoLearn.jsp").forward(request, response);

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
=======
>>>>>>> origin/front-end
        HttpSession session = request.getSession();
        CourseDBO course = (CourseDBO) session.getAttribute("course");
        String sub_lesson_id = request.getParameter("sub_lesson_id");
        String content = request.getParameter("content");
        String comment_id = request.getParameter("comment_id");
        String comment = request.getParameter("comment");
        CourseDAO courseDAO = new CourseDAO();
        CommentDAO commentDAO = new CommentDAO();

        UserDBO user = (UserDBO) session.getAttribute("user");
        ArrayList<LessonDBO> listLesson = courseDAO.getListLessonByCourseID("" + course.getId());
        SubLessonDBO subLesson = courseDAO.getSubLessonByID(Integer.parseInt(sub_lesson_id));
        try {
            // comment 0 là insert comment cha 
            if (Integer.parseInt(comment) == 0) {
                if (!content.isEmpty()) {
                    commentDAO.InsertComment(null, Integer.parseInt(sub_lesson_id), user.getId(), content);
                    ArrayList<CommentDBO> listComment = commentDAO.getCommentsFromDatabase(Integer.parseInt(sub_lesson_id));

                    request.setAttribute("subLesson", subLesson);
                    request.setAttribute("comment", listComment);
                } else {

                    ArrayList<CommentDBO> listComment = commentDAO.getCommentsFromDatabase(Integer.parseInt(sub_lesson_id));

                    request.setAttribute("subLesson", subLesson);
                    request.setAttribute("comment", listComment);

                }
            } else if (Integer.parseInt(comment) == 1) {   // comment 1 là insert comment replies
                if (!content.isEmpty()) {
                    commentDAO.InsertComment(comment_id, Integer.parseInt(sub_lesson_id), user.getId(), content);
                    ArrayList<CommentDBO> listComment = commentDAO.getCommentsFromDatabase(Integer.parseInt(sub_lesson_id));

                    request.setAttribute("subLesson", subLesson);
                    request.setAttribute("comment", listComment);
                } else {
                    ArrayList<CommentDBO> listComment = commentDAO.getCommentsFromDatabase(Integer.parseInt(sub_lesson_id));

                    request.setAttribute("subLesson", subLesson);
                    request.setAttribute("comment", listComment);
                }
            }

        } catch (Exception e) {

        }
        request.setAttribute("listLesson", listLesson);
        request.getRequestDispatcher("/videoLearn.jsp").forward(request, response);

<<<<<<< HEAD
=======
        processRequest(request, response);
>>>>>>> origin/Authentication
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
