//package CourseManagementController;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import Dal.CourseDAO;
//import Model.CourseDBO;
//import Model.CourseTypeDBO;
//
///**
// * Servlet implementation class CreateCourse
// */
//@WebServlet(name = "CreateCourse", urlPatterns = {"/create-course"})
//public class CreateCourse extends HttpServlet {
//
//    private static final long serialVersionUID = 1L;
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            // Dummy response for processRequest
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet CreateCourse</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet CreateCourse at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        // Extract form parameters
//        String name = request.getParameter("name");
//        String title = request.getParameter("title");
//        String description = request.getParameter("description");
//        double price = Double.parseDouble(request.getParameter("price"));
//        String courseImageLink = request.getParameter("courseImageLink");
//        boolean isLocked = request.getParameter("isLocked") != null;
//        String course_type = request.getParameter("courseTypeName");
//
//        // Create a Course object and save it to the database
//        CourseDBO course = new CourseDBO(0, name, title, description, price, courseImageLink, 0, 0, isLocked, null, course_type);
//        CourseDAO courseDAO = new CourseDAO();
//        boolean isCreated = courseDAO.createCourse(course);
//
//        // Respond to the client
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Course Created</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            if (isCreated) {
//                out.println("<h1>Course Created Successfully</h1>");
//                out.println("<p>Course Name: " + name + "</p>");
//                out.println("<p>Course Title: " + title + "</p>");
//                out.println("<p>Description: " + description + "</p>");
//                out.println("<p>Price: " + price + "</p>");
//                out.println("<p>Course Image Link: " + courseImageLink + "</p>");
//                out.println("<p>Is Locked: " + isLocked + "</p>");
//                out.println("<p>Course Type: " + courseTypeName + "</p>");
//            } else {
//                out.println("<h1>Failed to Create Course</h1>");
//            }
//            out.println("</body>");
//            out.println("</html>");
//        }
//
//        // Forward to JSP page
//        request.getRequestDispatcher("create-course.jsp").forward(request, response); 
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Servlet for creating courses";
//    }// </editor-fold>
//}
