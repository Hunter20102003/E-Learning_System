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
import java.util.ArrayList;
import java.util.List;

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
    private int pageCounting(int n) {
        if (n == 0) {
            return 1;
        }
        return (n + 5) / 6;
    }
    
    private List<CourseDBO> CoursePaggingList(int page, List<CourseDBO> listCourse) {
        int pageSize = 6;
        
        int fromIndex = (page - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, listCourse.size());
        return listCourse.subList(fromIndex, toIndex);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDBO user = (UserDBO) session.getAttribute("user");
        String search = request.getParameter("search");
        String pageStr = request.getParameter("page");
        int page = 1;
        ArrayList<CourseDBO> listCourse = new ArrayList<>();
        CourseDAO courseDao = new CourseDAO();
        if (user == null) {
            return;
        }
        if (user.getRole().getId() == 2) {
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
        request.setAttribute("page", page);
        request.setAttribute("pageCounting", pageCounting(listCourse.size()));
        request.setAttribute("listCourse", CoursePaggingList(page, listCourse));
        request.setAttribute("courseDao", courseDao);
        request.getRequestDispatcher("course_content_management.jsp").forward(request, response);
        
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
