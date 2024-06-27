/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package CourseManagementController;

import Dal.CourseDAO;
import Model.CourseDBO;
import Model.UserDBO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
public class ReviewCourseController extends HttpServlet {

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
            out.println("<title>Servlet ReviewCourseController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReviewCourseController at " + request.getContextPath() + "</h1>");
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

        int courseID = Integer.parseInt(request.getParameter("course_id"));

        CourseDAO dao = new CourseDAO();
        CourseDBO course = dao.getCourseByID(courseID);
        request.setAttribute("course", course);

        request.getRequestDispatcher("reviewCourse.jsp").forward(request, response);

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

        String reviewText = request.getParameter("review-text");
        String ratings = request.getParameter("rating");
        Double rating = Double.parseDouble(ratings);
        String course_id = request.getParameter("course_id");
        int courseID = Integer.parseInt(course_id);

        HttpSession session = request.getSession();
        UserDBO user = (UserDBO) session.getAttribute("user");

        CourseDAO dao = new CourseDAO();
        try {
            if (course_id != null) {
            int id = Integer.parseInt(course_id);
            dao.insertReview(user.getId(), courseID, rating, reviewText);
            response.sendRedirect("reviewCourse.jsp?course_id=" + courseID);
        }
        } catch (Exception e) {
        }
        

//        if (rating == null) {
//            request.setAttribute("error", "You must provide a rating.");
//            request.getRequestDispatcher("review?course_id=" + courseID).forward(request, response);
//        } else{
//            dao.insertReview(user.getId(), courseID, rating, reviewText);
//            request.getRequestDispatcher("review?course_id=" + courseID).forward(request, response);
//        }
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
