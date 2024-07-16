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
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/updateTeacher1")
public class UpdateTeacherServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        CourseDAO courseDAO = new CourseDAO();
HttpSession session = request.getSession();
        // Lấy tham số tìm kiếm và phân trang từ request
        String searchQuery = request.getParameter("txtSearch");
        String pageStr = request.getParameter("page");
        String courseIdStr = request.getParameter("courseId");
        int page = (pageStr != null) ? Integer.parseInt(pageStr) : 1;
       UserDBO user = (UserDBO) session.getAttribute("user");
        // Nếu thanh tìm kiếm trống, đặt giá trị mặc định là chuỗi rỗng
        if (searchQuery == null) {
            searchQuery = "";
        }

        // Lấy danh sách giáo viên theo tìm kiếm và phân trang
        List<UserDBO> teachers = userDAO.searchTeachers(searchQuery, page,user.getId());
        int totalTeachers = userDAO.countTeachers(searchQuery);

        // Tính toán số trang
        int totalPages = (int) Math.ceil((double) totalTeachers / 10);

        // Lấy danh sách khóa học
        List<CourseDBO> courses = courseDAO.getAllCourses();

        // Lấy teacherId của khóa học hiện tại
        int courseId = (courseIdStr != null) ? Integer.parseInt(courseIdStr) : 0;
        int currentTeacherId = courseDAO.getTeacherIdByCourseId(courseId);

        // Đặt các thuộc tính vào request
        request.setAttribute("teachers", teachers);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("searchQuery", searchQuery);
        request.setAttribute("courses", courses);
        request.setAttribute("currentTeacherId", currentTeacherId);
        request.setAttribute("courseId", courseId);

        // Forward đến trang chooseTeacher1.jsp để chọn giáo viên
        request.getRequestDispatcher("chooseTeacher1.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        // Lấy thông tin từ request
        String action = request.getParameter("action");
        String courseIdStr = request.getParameter("courseId");
        String teacherIdStr = request.getParameter("teacherId");
        UserDBO user = (UserDBO) session.getAttribute("user");

        // Kiểm tra nếu thiếu thông tin
        if (courseIdStr == null || teacherIdStr == null || courseIdStr.isEmpty() || teacherIdStr.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Course ID or Teacher ID missing");
            return;
        }

        int courseId = Integer.parseInt(courseIdStr);
        int teacherId = Integer.parseInt(teacherIdStr);

        CourseDAO courseDAO = new CourseDAO();
        UserDAO userDAO = new UserDAO();
        CourseDBO course = courseDAO.getCourseByID(courseId);
        UserDBO teacher = userDAO.getUserByID(teacherId); // Sử dụng hàm DAO mới

        if ("delete".equals(action)) {
            // Xóa giáo viên khỏi khóa học cụ thể
            boolean deleteSuccess = courseDAO.removeTeacherFromCourse(courseId, teacherId);

            if (deleteSuccess) {
                EmailSender.sendLeaveCourseEmail(teacher.getEmail(), course.getName());
                response.sendRedirect("manage-courses"); // Chuyển hướng về trang quản lý khóa học sau khi xóa thành công
            } else {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().write("Failed to remove teacher from course");
            }
        } else {
            // Cập nhật giáo viên cho khóa học
            boolean updateSuccess = courseDAO.updateCourseTeacher(courseId, teacherId);

            if (updateSuccess) {
                EmailSender.sendJoinCourseEmail(teacher.getEmail(), course.getName());
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
