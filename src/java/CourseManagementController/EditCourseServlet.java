package CourseManagementController;

import Dal.CourseDAO;
import Model.CourseDBO;
<<<<<<< HEAD
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
=======
import Model.UserDBO;
import Dal.UserDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
>>>>>>> origin/payment
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
<<<<<<< HEAD
import jakarta.servlet.http.Part;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 12)
@WebServlet("/edit-course")
public class EditCourseServlet extends HttpServlet {

    private static final int TARGET_WIDTH = 350;
    private static final int TARGET_HEIGHT = 188;
<<<<<<< HEAD
    private static final String UPLOAD_DIRECTORY = "E:\\1107project\\E-Learning_System-crud_quiz\\E-Learning_System-crud_quiz\\web\\img";
=======
    private static final String UPLOAD_DIRECTORY = "E:\\downloads\\E-Learning_System\\web\\img";
>>>>>>> origin/front-end
    private static final String DEFAULT_IMAGE = "https://i.ytimg.com/vi/py7-61U5IQU/hqdefault.jpg?sqp=-oaymwEXCNACELwBSFryq4qpAwkIARUAAIhCGAE=&rs=AOn4CLCrxhh83ZY1vQQBLrShPkJ7jz-RfQ";

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        CourseDAO courseDAO = new CourseDAO();
        CourseDBO course = courseDAO.getCourseByID(courseId);
        List<String> courseTypeNames = courseDAO.getAllCourseTypeNames();

        request.setAttribute("course", course);
        request.setAttribute("courseTypeNames", courseTypeNames);
        request.getRequestDispatcher("edit-course.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        String name = request.getParameter("name");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        Part filePart = request.getPart("courseImage");
        boolean isLocked = request.getParameter("isLocked") != null;
        String courseTypeName = request.getParameter("courseTypeName");

        CourseDAO courseDAO = new CourseDAO();
        CourseDBO course = courseDAO.getCourseByID(courseId);

        String img = course.getImg(); // Giữ nguyên ảnh hiện tại
        if (filePart != null && filePart.getSize() > 0) {
            String fileName = extractFileName(filePart);
            File uploads = new File(UPLOAD_DIRECTORY);
            if (!uploads.exists()) {
                uploads.mkdirs();
            }
              File uploadDir = new File(UPLOAD_DIRECTORY);
            File file = new File(uploads, fileName);

            // Lưu hình ảnh vào thư mục tạm thời
            File tempFile = new File(uploadDir, "temp_" + fileName);
            filePart.write(tempFile.getAbsolutePath());

            // Thay đổi kích thước ảnh và lưu vào thư mục
            BufferedImage originalImage = ImageIO.read(tempFile);
            BufferedImage resizedImage = resizeImage(originalImage, TARGET_WIDTH, TARGET_HEIGHT);

            // Lưu hình ảnh đã thay đổi kích thước
            ImageIO.write(resizedImage, "jpg", file);
            img = "img/" + fileName;

            // Xóa tệp tạm thời
            tempFile.delete();
        }

        if (img == null || img.isEmpty()) {
            img = DEFAULT_IMAGE; // Sử dụng ảnh mặc định nếu không có ảnh hiện tại
        }

        boolean success = courseDAO.updateCourse(courseId, name, title, description, price, img, isLocked, courseTypeName);

        if (success) {
            request.setAttribute("successMessage", "Course updated successfully.");
            doGet(request, response);
        } else {
            request.setAttribute("errorMessage", "Failed to update course.");
            doGet(request, response);
        }
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length() - 1);
            }
        }
        return "";
    }

    private BufferedImage resizeImage(BufferedImage originalImage, int width, int height) {
        Image tmp = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
}
=======
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/edit-course")
public class EditCourseServlet extends HttpServlet {

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

    // Đưa dữ liệu của khóa học vào request attribute
    request.setAttribute("course", course);

    // Forward request và response tới trang JSP để hiển thị thông tin
    request.getRequestDispatcher("/edit-course.jsp").forward(request, response);
}

   private static final String SAVE_DIR = "E:\\SWP\\New folder (3)\\E-Learning_System\\web\\img";

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

    double price = 0.0; // Giá trị mặc định khi price không hợp lệ
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

    String courseImageLink = request.getParameter("courseImage"); // Tên trường trong form là courseImage

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
    System.out.println("Course Image Link: " + courseImageLink);
    System.out.println("Is Locked: " + isLocked);
    System.out.println("Course Type Name: " + courseTypeName);
    System.out.println("User ID: " + user.getId());

    // Create a CourseDAO object and update the course
    CourseDAO courseDAO = new CourseDAO();
    boolean isSuccess = courseDAO.updateCourse(courseId, name, title, description, price, courseImageLink, isLocked, courseTypeName);

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


}
>>>>>>> origin/payment
