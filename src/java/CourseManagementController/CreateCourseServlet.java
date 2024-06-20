package CourseManagementController;

import Dal.CourseDAO;
import Model.CourseDBO;
import Model.UserDBO;
import Dal.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/createCourse")
public class CreateCourseServlet extends HttpServlet {

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Extract form parameters
    String name = request.getParameter("name");
    String title = request.getParameter("title");
    String description = request.getParameter("description");
    double price = Double.parseDouble(request.getParameter("price"));
    String courseImageLink = request.getParameter("courseImageLink");
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
    CourseDAO courseDAO = new CourseDAO();
    int courseId = courseDAO.createCourse(name, title, description, price, courseImageLink, isLocked, user.getId(), courseTypeName);

    // Save the updated user object to session
    session.setAttribute("user", user);

    // Respond to the client
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Course Creation</title>");
        out.println("</head>");
        out.println("<body>");
        if (courseId != -1) {
            out.println("<h1>Course created successfully with ID: " + courseId + "</h1>");
        } else {
            out.println("<h1>Failed to create course.</h1>");
        }
        out.println("<a href=\"create-course1.jsp\">Back to course creation</a>");
        out.println("</body>");
        out.println("</html>");
    }
}


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("create-course1.jsp");
    }
}
