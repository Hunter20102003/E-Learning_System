package CourseManagementController;

import Dal.CourseDAO;
import Model.CourseDBO;
import Model.UserWithEnrollment;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Studnet_in_Course", urlPatterns = {"/student-in-course"})
public class Studnet_in_Course extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CourseDAO courseDAO = new CourseDAO();
        String courseIdParam = request.getParameter("courseId");
        int courseId = 0;

        if (courseIdParam != null && !courseIdParam.isEmpty()) {
            try {
                courseId = Integer.parseInt(courseIdParam);
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid course ID");
                return;
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Course ID is required");
            return;
        }

        // Get course name
       CourseDBO course1 = courseDAO.getCourseByID(courseId);
        String courseName = (course1 != null) ? course1.getName(): null;

        // Pagination variables
        int page = 1;
        int pageSize = 10; // Number of users per page
        String pageParam = request.getParameter("page");

        if (pageParam != null && !pageParam.isEmpty()) {
            try {
                page = Integer.parseInt(pageParam);
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid page number");
                return;
            }
        }

        // Search variable
        String search = request.getParameter("search");

        List<UserWithEnrollment> enrolledUsers;

        if (search != null && !search.isEmpty()) {
            // Perform search if search parameter is provided
            enrolledUsers = courseDAO.searchEnrolledUsers(courseId, search, page, pageSize);
        } else {
            // Fetch enrolled users for the given course and pagination parameters
            enrolledUsers = courseDAO.getEnrolledUsers(courseId, page, pageSize);
        }

        // Set enrolled users and pagination variables in request scope
        request.setAttribute("enrolledUsers", enrolledUsers);
        request.setAttribute("page", page);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("courseId", courseId);
        request.setAttribute("search", search);
        request.setAttribute("courseName", courseName); // Set course name

        // Calculate total users
        int totalUsers = courseDAO.countEnrolledUsers(courseId, search);
        request.setAttribute("totalUsers", totalUsers);

        // Calculate total pages
        int pageCount = (int) Math.ceil((double) totalUsers / pageSize);
        request.setAttribute("pageCount", pageCount);

        // Forward to the JSP page
        request.getRequestDispatcher("/student-in-course.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle POST request for search
        String action = request.getParameter("action");
        if (action != null && action.equals("search")) {
            String search = request.getParameter("search");
            String courseIdParam = request.getParameter("courseId");
            int courseId = 0;

            if (courseIdParam != null && !courseIdParam.isEmpty()) {
                try {
                    courseId = Integer.parseInt(courseIdParam);
                } catch (NumberFormatException e) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid course ID");
                    return;
                }
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Course ID is required");
                return;
            }

            // Redirect to doGet for handling search with updated parameters
            response.sendRedirect(request.getContextPath() + "/student-in-course?courseId=" + courseId + "&search=" + search);
        } else {
            // Handle any other POST requests (if any)
            processRequest(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet to handle displaying enrolled students in a course";
    }
}
