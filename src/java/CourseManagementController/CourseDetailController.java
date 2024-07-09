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
import Model.UserDBO;
import Model.WishlistItem;
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
import java.util.List;
<<<<<<< Updated upstream
=======
import Model.WishlistItem;
>>>>>>> Stashed changes

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
        CourseDBO course = courseDAO.getCourseByID(courseId);
        YouTubeDuration youTubeDuration = new YouTubeDuration();
        HttpSession session = request.getSession();
<<<<<<< Updated upstream
        UserDBO user = (UserDBO) session.getAttribute("user");
        int userID = (user != null) ? user.getId() : 0;
=======
        CourseDBO course1 = courseDAO.getCourseByID(courseId);
        UserDBO user = (UserDBO) session.getAttribute("user");
        String enrollCourse = request.getParameter("enrollCourse");
        int userID = (user != null) ? user.getId() : 0;
        if (courseId == null) {
            return;
        }
>>>>>>> Stashed changes

        PaymentDAO paymentDAO = new PaymentDAO();
        ArrayList<Payment> listPayment = paymentDAO.FindPaymentByUserID(String.valueOf(userID));

        int check = 0;
        int idc = Integer.parseInt(courseId);
        for (Payment payment : listPayment) {
            if (payment.getCourse_id() == idc) {
                check = 1;
                break;
            }
        }

        if (course == null) {
            response.sendRedirect("course");
        } else {
            UserDAO userDAO = new UserDAO();
            long durationCourse = courseDAO.getDurationOfCourse(Integer.parseInt(courseId));

            // Kiểm tra xem khóa học có trong Wishlist của người dùng không
            boolean isInWishlist = courseDAO.isCourseInWishlist(userID, Integer.parseInt(courseId));

<<<<<<< Updated upstream
            ArrayList<CourseDBO> listRelatedCourse = (ArrayList<CourseDBO>) courseDAO.getCourseByCourseType(courseId);

            if (!listRelatedCourse.isEmpty()) {
                for (int i = 0; i < listRelatedCourse.size(); i++) {
                    if (listRelatedCourse.get(i).getId() == course.getId()) {
                        listRelatedCourse.remove(i);
                    }
=======
        ArrayList<CourseDBO> listRelatedCourse = (ArrayList<CourseDBO>) courseDAO.getCourseByCourseType(String.valueOf(course.getCourse_type().getId()));
        // Kiểm tra xem khóa học có trong Wishlist của người dùng không
        boolean isInWishlist = courseDAO.isCourseInWishlist(userID, Integer.parseInt(courseId));
        if (!listRelatedCourse.isEmpty()) {
            for (int i = 0; i < listRelatedCourse.size(); i++) {
                if (listRelatedCourse.get(i).getId() == course.getId()) {
                    listRelatedCourse.remove(i);
>>>>>>> Stashed changes
                }

                if (listRelatedCourse.size() > 4) {
                    listRelatedCourse = new ArrayList<>(listRelatedCourse.subList(0, 4));
                }
                request.setAttribute("listRelatedCourse", listRelatedCourse);
            }

            session.setAttribute("course", course);
            request.setAttribute("durationCourse", youTubeDuration.convertToHoursAndMinutes(durationCourse));
            request.setAttribute("listLesson", courseDAO.getListLessonByCourseID(courseId));
            request.setAttribute("teacher", userDAO.getUserByID("" + course.getTeacher_id()));
            request.setAttribute("isInWishlist", isInWishlist); // Truyền thông tin isInWishlist vào JSP
            request.getRequestDispatcher("/detail-course.jsp").forward(request, response);
        }
<<<<<<< Updated upstream
    }


@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String courseId = request.getParameter("courseId");
    CourseDAO courseDAO = new CourseDAO();
    HttpSession session = request.getSession();
    UserDBO user = (UserDBO) session.getAttribute("user");
    int userID = 0;
    if (user != null) {
        userID = user.getId();
=======
        session.setAttribute("course", course);
        request.setAttribute("enrolledCheck", courseDAO.userEnrolledCheck(user.getId(), course.getId()));
        request.setAttribute("listReviews", listReviews);

        request.setAttribute("userDAO", userDAO);
        request.setAttribute("durationCourse", youTubeDuration.convertToHoursAndMinutes(durationCourse));
        request.setAttribute("listLesson", courseDAO.getListLessonByCourseID(courseId));
        request.setAttribute("teacher", userDAO.getUserByID("" + course.getTeacher_id()));
        request.setAttribute("isInWishlist", isInWishlist); // Truyền thông tin isInWishlist vào JSP
        request.getRequestDispatcher("/detail-course_1.jsp").forward(request, response);

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
        String courseId = request.getParameter("courseId");
        CourseDAO courseDAO = new CourseDAO();
        HttpSession session = request.getSession();
        UserDBO user = (UserDBO) session.getAttribute("user");
        int userID = 0;
        if (user != null) {
            userID = user.getId();
        }

        // Toggle Wishlist
        String toggleResult = courseDAO.toggleWishlist(userID, Integer.parseInt(courseId));

        // Load danh sách Wishlist của người dùng sau khi thay đổi
        List<CourseDBO> wishlistCourses = courseDAO.getWishlistCourses(userID);
        session.setAttribute("wishlistCourses", wishlistCourses);

        // Trả về kết quả là added hoặc removed
        response.getWriter().write(toggleResult);
>>>>>>> Stashed changes
    }

    // Toggle Wishlist
    String toggleResult = courseDAO.toggleWishlist(userID, Integer.parseInt(courseId));

    // Load danh sách Wishlist của người dùng sau khi thay đổi
    List<CourseDBO> wishlistCourses = courseDAO.getWishlistCourses(userID);
    session.setAttribute("wishlistCourses", wishlistCourses);

    // Trả về kết quả là added hoặc removed
    response.getWriter().write(toggleResult);
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
