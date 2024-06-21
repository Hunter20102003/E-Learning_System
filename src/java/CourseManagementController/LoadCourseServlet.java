package CourseManagementController;

import Dal.CourseDAO;
import Model.CourseDBO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/load-course")
public class LoadCourseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu của khóa học có courseID = 1 từ DAO
        int courseId = 1; // Course ID cần load, có thể truyền từ request parameter nếu cần
        CourseDAO courseDAO = new CourseDAO();
        CourseDBO course = courseDAO.getCourseByID(courseId);

        // Đưa dữ liệu của khóa học vào request attribute
        request.setAttribute("course", course);

        // Chuyển tiếp request và response tới trang JSP
        request.getRequestDispatcher("/newjsp.jsp").forward(request, response);
    }
}
