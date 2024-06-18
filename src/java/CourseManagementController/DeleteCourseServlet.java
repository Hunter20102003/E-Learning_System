package CourseManagementController;

import Dal.CourseDAO;
import Dal.UserDAO;
import Model.CourseDBO;
import Model.UserDBO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/delete-course")
public class DeleteCourseServlet extends HttpServlet {

    private CourseDAO courseDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        courseDAO = new CourseDAO(); // Khởi tạo DAO trong phương thức init()
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseId = request.getParameter("id");

        try {
            // Thực hiện câu truy vấn để cập nhật trạng thái của khóa học
            boolean isUpdated = courseDAO.deleteCourse(Integer.parseInt(courseId));

            if (isUpdated) {
                // Phản hồi về client là đã cập nhật thành công
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().write("Cập nhật thành công"); // Gửi thông báo thành công
            } else {
                // Nếu không thành công, phản hồi lỗi
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().write("Không thể cập nhật"); // Gửi thông báo không thành công
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Lỗi SQL: " + e.getMessage()); // Gửi thông báo lỗi SQL
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        CourseDAO courseDAO = new CourseDAO();
        // Lấy danh sách giáo viên (role_id = 2 là giáo viên)
        List<UserDBO> teachers = userDAO.getUsersByRole(2);
        List<CourseDBO> course = courseDAO.getAllCourses();
        request.setAttribute("teachers", teachers); // Đặt danh sách giáo viên vào thuộc tính của request
        request.setAttribute("course", course);
        // Forward đến trang chooseTeacher.jsp để chọn giáo viên
        request.getRequestDispatcher("deletedcourse.jsp").forward(request, response);
    }

}
