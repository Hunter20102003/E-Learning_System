/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package CourseManagementController;

import Dal.CourseDAO;
import Model.CourseDBO;
import Model.UserCourseProgressDBO;
import Model.UserDBO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public class MyLearningServlert extends HttpServlet {

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
        HttpSession session = request.getSession();

    UserDBO user = (UserDBO) session.getAttribute("user");

    if (user != null) {
        int userId = user.getId();
        CourseDAO courseDAO = new CourseDAO();

        // Handle user enrollment
        String enrollAction = request.getParameter("enroll");
        if (enrollAction != null) {
            int courseId = Integer.parseInt(request.getParameter("courseId"));
            courseDAO.enrollUserInCourse(userId, courseId);
            request.setAttribute("enrollSuccess", "You have been successfully enrolled in the course.");
        }

        // Retrieve in-progress and completed courses
        List<UserCourseProgressDBO> listProgress = courseDAO.getInProgressCourses(userId);
        request.setAttribute("listP", listProgress);

        List<CourseDBO> listCompleted = courseDAO.getCompletedCourses(userId);
        request.setAttribute("listCP", listCompleted);

        // Check for existing reviews
        Map<Integer, Boolean> reviewExistsMap = new HashMap<>();
        for (CourseDBO course : listCompleted) {
            boolean reviewExists = courseDAO.checkFeedBackExisted(userId, course.getId());
            reviewExistsMap.put(course.getId(), reviewExists);
        }
        request.setAttribute("reviewExistsMap", reviewExistsMap);
    }

    request.getRequestDispatcher("my-learning.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * * @throws ServletException if a servlet-specific error occurs
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
    
//  Map<Integer, Boolean> reviewExistsMap = new HashMap<>();
//            for (CourseDBO course : listCompleted) {
//                boolean reviewExists = courseDAO.checkFeedBackExisted(userId, course.getId());
//                reviewExistsMap.put(course.getId(), reviewExists);
//            }
}