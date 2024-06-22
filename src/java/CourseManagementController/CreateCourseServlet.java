package CourseManagementController;

import Dal.CourseDAO;
import Model.UserDBO;
import Model.CourseDBO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 12)
@WebServlet("/createCourse")
public class CreateCourseServlet extends HttpServlet {

    private static final int TARGET_WIDTH = 350;
    private static final int TARGET_HEIGHT = 188;
    private static final String UPLOAD_DIRECTORY = "E:\\SWP\\E-Learning_System\\web\\img";
    private static final String DEFAULT_IMAGE = "https://i.ytimg.com/vi/py7-61U5IQU/hqdefault.jpg?sqp=-oaymwEXCNACELwBSFryq4qpAwkIARUAAIhCGAE=&rs=AOn4CLCrxhh83ZY1vQQBLrShPkJ7jz-RfQ"; // Đường dẫn tới ảnh mặc định

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Extract form parameters
        String name = request.getParameter("name");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        boolean isLocked = request.getParameter("isLocked") != null;
        String courseTypeName = request.getParameter("courseTypeName");
        HttpSession session = request.getSession();

        // Retrieve user information from session
        UserDBO user = (UserDBO) session.getAttribute("user");
        if (user == null) {
            // Redirect to login page or handle unauthorized access
            response.sendRedirect("login.jsp");
            return;
        }
        CourseDBO course =(CourseDBO) session.getAttribute("course");

        // Check if the name field is empty
        if (name == null || name.trim().isEmpty()) {

            String message = "Course name cannot be empty.";
            session.setAttribute("message", message);
            response.sendRedirect("createCourse");
            return;
  
        }
//        if(!name.matches("[a-zA-Z0-9 ]+")){
//              String message = "Course name cannot contain special charactert.";
//            session.setAttribute("message", message);
//            response.sendRedirect("createCourse");
//            return;
//        }
      if (title == null || title.trim().isEmpty()) {
            String message = "Course title cannot be empty.";
            session.setAttribute("message", message);
            response.sendRedirect("createCourse");
            return;
        }
           CourseDAO courseDAO = new CourseDAO();
        if (courseDAO.isCourseNameExists(name)) {
            String message = "Course name already exists. Please choose a different name.";
            session.setAttribute("message", message);
            response.sendRedirect("createCourse");
            return;
        }

        String courseImageLink = DEFAULT_IMAGE; // Sử dụng ảnh mặc định khi không có ảnh được tải lên
        Part part = request.getPart("avatar");
        String fileName = extractFileName(part);

        if (fileName != null && !fileName.isEmpty()) {
            String uploadPath = UPLOAD_DIRECTORY + File.separator + fileName;
            File uploadDir = new File(UPLOAD_DIRECTORY);

            // Create the upload directory if it does not exist
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            // Save the uploaded file to a temporary location
            File tempFile = new File(uploadDir, "temp_" + fileName);
            part.write(tempFile.getAbsolutePath());

            // Resize the image
            BufferedImage originalImage = ImageIO.read(tempFile);
            BufferedImage resizedImage = resizeImage(originalImage, TARGET_WIDTH, TARGET_HEIGHT);

            // Save the resized image
            File resizedFile = new File(uploadDir, fileName);
            ImageIO.write(resizedImage, "jpg", resizedFile);
            courseImageLink = "img/" + fileName;

            // Delete the temporary file
            tempFile.delete();
        }

        // Log the received data for debugging
        System.out.println("Received data from form:");
        System.out.println("Name: " + name);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Price: " + price);
        System.out.println("Course Image Link: " + courseImageLink);
        System.out.println("Is Locked: " + isLocked);
        System.out.println("Course Type Name: " + courseTypeName);
        System.out.println("User ID: " + user.getId());

        // Create a CourseDAO object and save the course
       
        int courseId = courseDAO.createCourse(name, title, description, price, courseImageLink, isLocked, user.getId(), courseTypeName);

        // Save the updated user object to session
        session.setAttribute("user", user);

        // Save message to session
        String message;
        if (courseId != -1) {
            message = "Course created successfully with ID: " + courseId;
        } else {
            message = "Failed to create course. Please try again.";
        }
        session.setAttribute("message", message);

        // Redirect to created-course1.jsp
        response.sendRedirect("createCourse");
    }

    /**
     * Extracts file name from HTTP header content-disposition
     */
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("create-course1.jsp");
    }
}
