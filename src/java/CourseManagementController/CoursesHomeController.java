package CourseManagementController;

import Dal.CourseDAO;
import Model.CourseDBO;
import Model.CourseType2DBO;
import YoutobeDataAPI.YouTubeDuration;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoursesHomeController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        CourseDAO courseDAO = new CourseDAO();

        YouTubeDuration youTubeDuration = new YouTubeDuration();

        List<CourseDBO> listCourse = courseDAO.getCoursesByRating();
        request.setAttribute("listCourse", listCourse);
        
        List<CourseType2DBO> listType = courseDAO.getAllCourseType2();
        request.setAttribute("listT", listType);

        request.setAttribute("youTubeDuration", youTubeDuration);
        request.setAttribute("courseDao", courseDAO);
        request.setAttribute("listTypeOfCourse", courseDAO.getAllCourseType());
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "CourseController Servlet handles course-related operations.";
    }

}
