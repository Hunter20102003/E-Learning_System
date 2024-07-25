package CourseManagementController;

import Dal.CourseDAO;
import Model.CourseDBO;
import Model.UserWithEnrollment;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import Model.CourseTypeDBO;
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
    private static final String UPLOAD_DIRECTORY = "E:\\SWP\\E-Learning_System\\web\\img";
    private static final String DEFAULT_IMAGE = "img/images.jpg";
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        CourseDAO courseDAO = new CourseDAO();
        CourseDBO course = courseDAO.getCourseByID(courseId);

        // Retrieve all course types from DAO
        List<CourseTypeDBO> courseTypes = courseDAO.getAllCourseType();

        request.setAttribute("course", course);
        request.setAttribute("courseTypes", courseTypes);
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
        int courseTypeId = Integer.parseInt(request.getParameter("courseTypeId"));

        CourseDAO courseDAO = new CourseDAO();
        CourseDBO course = courseDAO.getCourseByID(courseId);

        String img = course.getImg(); // Keep current image
        if (filePart != null && filePart.getSize() > 0) {
            String fileName = extractFileName(filePart);
            File uploads = new File(UPLOAD_DIRECTORY);
            if (!uploads.exists()) {
                uploads.mkdirs();
            }
            File uploadDir = new File(UPLOAD_DIRECTORY);
            File file = new File(uploads, fileName);

            // Save image to temporary directory
            File tempFile = new File(uploadDir, "temp_" + fileName);
            filePart.write(tempFile.getAbsolutePath());

            // Resize and save image
            BufferedImage originalImage = ImageIO.read(tempFile);
            BufferedImage resizedImage = resizeImage(originalImage, TARGET_WIDTH, TARGET_HEIGHT);
            ImageIO.write(resizedImage, "jpg", file);
            img = "img/" + fileName;
            tempFile.delete(); // Delete temporary file
        }

        if (img == null || img.isEmpty()) {
            img = DEFAULT_IMAGE; // Use default image if no current image
        }

        boolean success = courseDAO.updateCourse(courseId, name, title, description, price, img, isLocked, courseTypeId);

        if (success && isLocked) {
            System.out.println("Course is locked, sending emails...");
            List<UserWithEnrollment> enrolledUsers = courseDAO.getEnrolledUsers(courseId);
            for (UserWithEnrollment user : enrolledUsers) {
                EmailSender1.sendLockCourseEmail(user.getUser().getEmail(), name);
            }
        }

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
