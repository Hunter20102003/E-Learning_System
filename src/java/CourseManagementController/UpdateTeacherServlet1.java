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
import java.util.List;

@WebServlet("/updateTeacher1")
public class UpdateTeacherServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        CourseDAO courseDAO = new CourseDAO();
        // Lấy danh sách giáo viên (role_id = 2 là giáo viên)
        List<UserDBO> teachers = (List<UserDBO>) userDAO.getUsersByRole(2);
List<CourseDBO> course = courseDAO.getAllCourses();
        request.setAttribute("teachers", teachers); // Đặt danh sách giáo viên vào thuộc tính của request
request.setAttribute("course", course);
        // Forward đến trang chooseTeacher.jsp để chọn giáo viên
        request.getRequestDispatcher("chooseTeacher1.jsp").forward(request, response);
    }

  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy thông tin từ request
        String action = request.getParameter("action");
        String courseIdStr = request.getParameter("courseId");
        String teacherIdStr = request.getParameter("teacherId");

        // Kiểm tra nếu thiếu thông tin
        if (courseIdStr == null || teacherIdStr == null || courseIdStr.isEmpty() || teacherIdStr.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Course ID or Teacher ID missing");
            return;
        }

        int courseId = Integer.parseInt(courseIdStr);
        int teacherId = Integer.parseInt(teacherIdStr);
        int userId = 1; // Thay thế bằng ID người dùng thực tế hoặc lấy từ session

        if ("delete".equals(action)) {
            // Xóa giáo viên
            CourseDAO courseDAO = new CourseDAO();
            boolean deleteSuccess = courseDAO.deleteTeacherById(teacherId);

            if (deleteSuccess) {
                response.sendRedirect("manage-courses"); // Chuyển hướng về trang quản lý khóa học sau khi xóa thành công
            } else {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().write("Failed to delete teacher");
            }
        } else {
            // Cập nhật giáo viên cho khóa học
            CourseDAO courseDAO = new CourseDAO();
            boolean updateSuccess = courseDAO.updateCourseTeacher(courseId, teacherId, userId);

            if (updateSuccess) {
                // Chuyển hướng về trang manage-courses.jsp sau khi cập nhật thành công
                response.sendRedirect("manage-courses");
            } else {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().write("Failed to update course teacher");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Update Teacher Servlet";
    }
}
