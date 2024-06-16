/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package CourseManagementController;

import Dal.CourseDAO;

import Model.CourseDBO;
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
import java.util.List;

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

        String txtSearch = request.getParameter("txtSearch");
        String[] cbxTypesOfCourse = request.getParameterValues("cbxTypesOfCourse");
        String[] cbxPrices = request.getParameterValues("cbxPrices");
        String[] cbxDurations = request.getParameterValues("cbxDurations");
        String rating = request.getParameter("rating");
        String sort = request.getParameter("sort");
        String page = request.getParameter("page");
        YouTubeDuration youTubeDuration = new YouTubeDuration();

        List<CourseDBO> listCourse = new ArrayList<>();

// Trong servlet của trang course
//        HttpSession session = request.getSession();
//        Integer userID = (Integer) session.getAttribute("userID");
//        if (userID == null) {
//            response.sendRedirect("login.jsp"); // Chuyển hướng đến trang đăng nhập nếu session không có thông tin người dùng
//            return;
//        }
// Tiếp tục xử lý khi người dùng đã đăng nhập

        if (sort == null) {
            sort = "mostRelevant";
        }
        try {
            listCourse = courseDAO.searchAndFilterData(txtSearch, cbxTypesOfCourse, cbxPrices, cbxDurations, rating, sort);

            if (listCourse.isEmpty()) {
                request.setAttribute("emptyCourse", "There are no courses");
            } else {
//                List<CourseDBO> coursePaggingList = CoursePaggingList(page, listCourse);
//                request.setAttribute("pageCounting", pageCounting(listCourse.size()));
//                request.setAttribute("listCourse", coursePaggingList);
            }
            request.setAttribute("cbxDurations", (cbxDurations != null) ? Arrays.asList(cbxDurations) : "");

            request.setAttribute("txtSearch", (txtSearch != null && !txtSearch.isBlank()) ? txtSearch : "");
            request.setAttribute("cbxTypesOfCourse", (cbxTypesOfCourse != null) ? Arrays.asList(cbxTypesOfCourse) : "");
            request.setAttribute("cbxPrices", (cbxPrices != null) ? Arrays.asList(cbxPrices) : "");
            request.setAttribute("rating", (rating != null) ? rating : "");
            request.setAttribute("page", (page != null) ? page : "1");

        } catch (NullPointerException | NumberFormatException e) {
            e.printStackTrace();
        }
        request.setAttribute("youTubeDuration", youTubeDuration);
//        request.setAttribute("pageCounting", pageCounting(listCourse.size()));
        request.setAttribute("sort", sort);
        request.setAttribute("courseDao", courseDAO);
        request.setAttribute("results", listCourse.size());
        request.setAttribute("course", courseDAO.getAllCourseByUserId(29));
        request.getRequestDispatcher("manage-courses.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
