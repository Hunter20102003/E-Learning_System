package CourseManagementController;

import Dal.CourseDAO;
import Model.CourseDBO;
import Model.UserDBO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "wishlist", urlPatterns = {"/wish-list"})
public class wishlist extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Retrieve userId from session
    HttpSession session = request.getSession();

    // Retrieve user information from session
    UserDBO user = (UserDBO) session.getAttribute("user");

    // Create CourseDAO instance
    CourseDAO wishlistDAO = new CourseDAO();

    // Retrieve wishlist courses for the userId
    List<CourseDBO> wishlistCourses = wishlistDAO.getWishlistCourses(user);

    // Set wishlistCourses as request attribute
    request.setAttribute("wishlistCourses", wishlistCourses);

    // Forward request to wish-list.jsp for rendering
    request.getRequestDispatcher("/wish-list.jsp").forward(request, response);
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
