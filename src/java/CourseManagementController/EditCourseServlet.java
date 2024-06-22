package CourseManagementController;

import Dal.CourseDAO;
import Model.CourseDBO;
import Model.UserDBO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import java.util.List;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 12)
@WebServlet("/edit-course")
public class EditCourseServlet extends HttpServlet {
    private static final int TARGET_WIDTH = 350;
    private static final int TARGET_HEIGHT = 188;
    private static final String UPLOAD_DIRECTORY = "E:\\SWP\\E-Learning_System\\web\\img";

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin user từ session
        UserDBO user = (UserDBO) request.getSession().getAttribute("user");

        // Kiểm tra xem user đã đăng nhập chưa
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Lấy thông tin courseID từ request parameter
        int courseId = Integer.parseInt(request.getParameter("courseId"));

        // Lưu courseId vào session
        HttpSession session = request.getSession();
        session.setAttribute("courseId", courseId);

        // Lấy thông tin khóa học từ DAO
        CourseDAO courseDAO = new CourseDAO();
        CourseDBO course = courseDAO.getCourseByID(courseId);

        // Lấy danh sách loại khóa học
        List<String> courseTypeNames = courseDAO.getAllCourseTypeNames();

        // Đưa dữ liệu của khóa học và loại khóa học vào request attribute
        request.setAttribute("course", course);
        request.setAttribute("courseTypeNames", courseTypeNames);

        // Forward request và response tới trang JSP để hiển thị thông tin
        request.getRequestDispatcher("/edit-course.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Extract form parameters
        String courseIdStr = request.getParameter("courseId");
        int courseId = 0; // Giá trị mặc định khi courseId không hợp lệ
        if (courseIdStr != null && !courseIdStr.isEmpty()) {
            try {
                courseId = Integer.parseInt(courseIdStr);
            } catch (NumberFormatException e) {
                // Xử lý khi courseId không phải số nguyên
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Course ID format");
                return;
            }
        } else {
            // Xử lý khi courseId không được cung cấp
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Course ID is missing");
            return;
        }

        String name = request.getParameter("name");
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        double price = 0; // Giá trị mặc định khi price không hợp lệ
        String priceStr = request.getParameter("price");
        if (priceStr != null && !priceStr.isEmpty()) {
            try {
                price = Double.parseDouble(priceStr);
            } catch (NumberFormatException e) {
                // Xử lý khi price không phải số thực
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Price format");
                return;
            }
        } else {
            // Xử lý khi price không được cung cấp
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Price is missing");
            return;
        }

        // Xử lý file upload
        Part filePart = request.getPart("courseImage"); // Tên trường trong form là courseImage
        String fileName = getFileName(filePart);

        // Đường dẫn lưu file
        String filePath = UPLOAD_DIRECTORY + File.separator + fileName;
        File file = new File(filePath);

        // Lưu file tạm thời
        try (InputStream fileContent = filePart.getInputStream()) {
            BufferedImage originalImage = ImageIO.read(fileContent);
            BufferedImage resizedImage = resizeImage(originalImage, TARGET_WIDTH, TARGET_HEIGHT);
            ImageIO.write(resizedImage, "jpg", file);
        }

        boolean isLocked = request.getParameter("isLocked") != null;
        String courseTypeName = request.getParameter("courseTypeName");

        HttpSession session = request.getSession();
        UserDBO user = (UserDBO) session.getAttribute("user");

        // Log the received data for debugging
        System.out.println("Received data from form:");
        System.out.println("Course ID: " + courseId);
        System.out.println("Name: " + name);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Price: " + price);
        System.out.println("Course Image Link: " + filePath);
        System.out.println("Is Locked: " + isLocked);
        System.out.println("Course Type Name: " + courseTypeName);
        System.out.println("User ID: " + user.getId());

        // Create a CourseDAO object and update the course
        CourseDAO courseDAO = new CourseDAO();
        boolean isSuccess = courseDAO.updateCourse(courseId, name, title, description, price, filePath, isLocked, courseTypeName);

        // Respond to the client
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Course Update</title>");
            out.println("</head>");
            out.println("<body>");
            if (isSuccess) {
                out.println("<h1>Course updated successfully with ID: " + courseId + "</h1>");
            } else {
                out.println("<h1>Failed to update course.</h1>");
            }
            out.println("<a href=\"edit-course.jsp\">Back to course editing</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // Utility method to get file name from Part
    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] items = contentDisposition.split(";");
        for (String item : items) {
            if (item.trim().startsWith("filename")) {
                return item.substring(item.indexOf("=") + 2, item.length() - 1);
            }
        }
        return "";
    }

    // Utility method to resize image
    private BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        g.dispose();
        return resizedImage;
    }
}