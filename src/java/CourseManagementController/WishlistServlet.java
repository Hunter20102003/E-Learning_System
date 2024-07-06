package CourseManagementController;

import Dal.CourseDAO;
import Model.CourseDBO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "wishlist", urlPatterns = {"/wishlist", "/wishlist/toggle"})
public class WishlistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userId");
        CourseDAO courseDAO = new CourseDAO();
        List<CourseDBO> wishlistCourses = courseDAO.getWishlistCourses(userId);

        request.setAttribute("wishlistCourses", wishlistCourses);
        request.getRequestDispatcher("/wish-list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userId");
        int courseId = Integer.parseInt(request.getParameter("courseId"));

        CourseDAO courseDAO = new CourseDAO();
        String result = courseDAO.toggleWishlist(userId, courseId);

        // Set response content type and write result
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(result);
    }

    @Override
    public String getServletInfo() {
        return "Wishlist servlet to handle course wishlist operations";
    }
}
