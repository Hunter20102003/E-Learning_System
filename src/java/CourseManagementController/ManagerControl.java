/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package CourseManagementController;

import Dal.CourseDAO;
import Dal.UserDAO;

import Model.CourseDBO;
import Model.UserDBO;
import YoutobeDataAPI.YouTubeDuration;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Hi Ryo
 */
@WebServlet("/manage-courses")
public class ManagerControl extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        request.getRequestDispatcher("ManagerProduct.jsp").forward(request, response);
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

    CourseDAO courseDAO = new CourseDAO();
    YouTubeDuration youTubeDuration = new YouTubeDuration();

    String txtSearch = request.getParameter("txtSearch");
    String[] cbxTypesOfCourse = request.getParameterValues("cbxTypesOfCourse");
    String[] cbxPrices = request.getParameterValues("cbxPrices");
    String[] cbxDurations = request.getParameterValues("cbxDurations");
    String rating = request.getParameter("rating");
    String sort = request.getParameter("sort");
    String page = request.getParameter("page");

    List<CourseDBO> listCourse = new ArrayList<>();

    HttpSession session = request.getSession();
    UserDBO user = (UserDBO) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    if (sort == null) {
        sort = "mostRelevant";
    }

    try {
        listCourse = courseDAO.searchAndFilterData(txtSearch, cbxTypesOfCourse, cbxPrices, cbxDurations, rating, sort);

        if (listCourse.isEmpty()) {
            request.setAttribute("emptyCourse", "There are no courses");
        }

        // Fetch users and create a map of teacher_id to teacher name
        // Pass the list of teachers
        UserDAO userDAO = new UserDAO();
        List<UserDBO> users = userDAO.getAllUsers();
        Map<Integer, String> teacherMap = new HashMap<>();
        for (UserDBO u : users) {
            teacherMap.put(u.getId(), u.getFirstName() + " " + u.getLastName());
        }

        // Fetch teachers separately if needed
        List<UserDBO> teachers = userDAO.getUsersByRole(2);

        request.setAttribute("teacherMap", teacherMap);
        request.setAttribute("cbxDurations", (cbxDurations != null) ? Arrays.asList(cbxDurations) : "");
        request.setAttribute("txtSearch", (txtSearch != null && !txtSearch.isBlank()) ? txtSearch : "");
        request.setAttribute("cbxTypesOfCourse", (cbxTypesOfCourse != null) ? Arrays.asList(cbxTypesOfCourse) : "");
        request.setAttribute("cbxPrices", (cbxPrices != null) ? Arrays.asList(cbxPrices) : "");
        request.setAttribute("rating", (rating != null) ? rating : "");
        request.setAttribute("page", (page != null) ? page : "1");
        request.setAttribute("teachers", teachers);
    } catch (NullPointerException | NumberFormatException e) {
        e.printStackTrace();
    }

    request.setAttribute("youTubeDuration", youTubeDuration);
    request.setAttribute("sort", sort);
    request.setAttribute("courseDao", courseDAO);
    request.setAttribute("results", listCourse.size());
    request.setAttribute("course", courseDAO.getAllCourseByUserId(user.getId()));
    request.getRequestDispatcher("manage-courses.jsp").forward(request, response);
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
