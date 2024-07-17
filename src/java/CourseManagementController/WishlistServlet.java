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
public class WishlistServlet extends HttpServlet {



    private List<CourseDBO> paginateCourses(String page, List<CourseDBO> listCourse) {
        int pageSize = 10; // Number of courses per page
        int currentPage = (page != null) ? Integer.parseInt(page) : 1;
        int startItem = (currentPage - 1) * pageSize;
        int endItem = Math.min(startItem + pageSize, listCourse.size());

        return listCourse.subList(startItem, endItem);
    }

    private int calculatePageCount(int totalItems) {
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
            try {
                int courseId = Integer.parseInt(request.getParameter("courseId"));
                boolean removed = courseDAO.removeCourseFromWishlist(user.getId(), courseId);
                if (removed) {
                    // Cập nhật lại danh sách wishlist
                    if (search != null && !search.isEmpty()) {
                        wishlistCourses = courseDAO.searchWishlistCourses(user.getId(), search);
                    } else {
                        wishlistCourses = courseDAO.getWishlistCourses(user.getId());
                    }

                    if (wishlistCourses.isEmpty()) {
                        request.setAttribute("emptyCourse", "There are no courses in your wishlist");
                    } else {
                        List<CourseDBO> coursePaggingList = paginateCourses(page, wishlistCourses);
                        request.setAttribute("pageCounting", calculatePageCount(wishlistCourses.size()));
                        request.setAttribute("wishlistCourses", coursePaggingList);
                    }

                    request.setAttribute("search", (search != null && !search.isBlank()) ? search : "");
                    request.setAttribute("page", (page != null) ? page : "1");

                    // Forward lại trang để hiển thị kết quả mới
                    request.getRequestDispatcher("wish-list.jsp").forward(request, response);
                } else {
                    response.getWriter().write("error");
                }
            } catch (NumberFormatException | NullPointerException e) {
                response.getWriter().write("error");
            }
            return;
        }

        // Xử lý lấy danh sách wishlist khi không phải action remove
        if (search != null && !search.isEmpty()) {
            wishlistCourses = courseDAO.searchWishlistCourses(user.getId(), search);
        } else {
            wishlistCourses = courseDAO.getWishlistCourses(user.getId());
        }

        if (wishlistCourses.isEmpty()) {
            request.setAttribute("emptyCourse", "There are no courses in your wishlist");
        } else {
            List<CourseDBO> coursePaggingList = paginateCourses(page, wishlistCourses);
            request.setAttribute("pageCounting", calculatePageCount(wishlistCourses.size()));
            request.setAttribute("wishlistCourses", coursePaggingList);
        }

        request.setAttribute("search", (search != null && !search.isBlank()) ? search : "");
        request.setAttribute("page", (page != null) ? page : "1");

        // Forward lại trang để hiển thị danh sách wishlist
        request.getRequestDispatcher("wish-list.jsp").forward(request, response);

    } catch (NumberFormatException | NullPointerException e) {
        // Xử lý ngoại lệ nếu có
    }
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
        return "Servlet for managing wishlist";
    }
}
