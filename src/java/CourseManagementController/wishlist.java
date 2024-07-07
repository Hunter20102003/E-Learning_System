package CourseManagementController;

import Dal.CourseDAO;
import Dal.UserDAO;
import Model.CourseDBO;
import Model.UserDBO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/wish-list")
public class wishlist extends HttpServlet {

    private List<CourseDBO> CoursePaggingList(String page, List<CourseDBO> listCourse) {
        int pageSize = 10; // Number of courses per page
        int currentPage = (page != null) ? Integer.parseInt(page) : 1;
        int startItem = (currentPage - 1) * pageSize;
        int endItem = Math.min(startItem + pageSize, listCourse.size());

        return listCourse.subList(startItem, endItem);
    }

    private int pageCounting(int totalItems) {
        int pageSize = 10; // Number of courses per page
        return (int) Math.ceil((double) totalItems / pageSize);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        CourseDAO courseDAO = new CourseDAO();
        UserDAO userDAO = new UserDAO();

        String action = request.getParameter("action");
        String search = request.getParameter("search");
        String page = request.getParameter("page");

        List<CourseDBO> wishlistCourses = new ArrayList<>();

        HttpSession session = request.getSession();
        UserDBO user = (UserDBO) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            if ("remove".equals(action)) {
                int courseId = Integer.parseInt(request.getParameter("courseId"));
                boolean removed = courseDAO.removeCourseFromWishlist(user.getId(), courseId);
                if (removed) {
                    response.getWriter().write("success");
                    return;
                } else {
                    response.getWriter().write("error");
                    return;
                }
            }

            if ("search".equals(action)) {
                if (search != null && !search.isEmpty()) {
                    wishlistCourses = courseDAO.searchWishlistCourses(user.getId(), search);
                } else {
                    wishlistCourses = courseDAO.getWishlistCourses(user.getId());
                }
            } else {
                wishlistCourses = courseDAO.getWishlistCourses(user.getId());
            }

            if (wishlistCourses.isEmpty()) {
                request.setAttribute("emptyCourse", "There are no courses in your wishlist");
            } else {
                List<CourseDBO> coursePaggingList = CoursePaggingList(page, wishlistCourses);
                request.setAttribute("pageCounting", pageCounting(wishlistCourses.size()));
                request.setAttribute("wishlistCourses", coursePaggingList);
            }

            request.setAttribute("search", (search != null && !search.isBlank()) ? search : "");
            request.setAttribute("page", (page != null) ? page : "1");

        } catch (NumberFormatException | NullPointerException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("wish-list.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}




