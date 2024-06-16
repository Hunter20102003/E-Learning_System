package CourseManagementController;

import Dal.CourseDAO;
import Model.CourseDBO;
import YoutobeDataAPI.YouTubeDuration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession; // Import HttpSession class

@WebServlet("/courses")
public class CourseController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CourseController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CourseController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private int pageCounting(int n) {
        if (n == 0) {
            return 1;
        }
        return (n + 5) / 6;
    }

    private List<CourseDBO> CoursePaggingList(String page, List<CourseDBO> listCourse) {
        int pageSize = 6;
        int p = (page == null) ? 1 : Integer.parseInt(page);
        int fromIndex = (p - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, listCourse.size());
        return listCourse.subList(fromIndex, toIndex);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CourseDAO courseDAO = new CourseDAO();
        String txtSearch = request.getParameter("txtSearch");
        String[] cbxTypesOfCourse = request.getParameterValues("cbxTypesOfCourse");
        String[] cbxPrices = request.getParameterValues("cbxPrices");
        String[] cbxDurations = request.getParameterValues("cbxDurations");
        String rating = request.getParameter("rating");
        String sort = request.getParameter("sort");
        String page = request.getParameter("page");
        YouTubeDuration youTubeDuration = new YouTubeDuration();

        List<CourseDBO> listCourse = new ArrayList<>();

// Trong servlet của trang course
HttpSession session = request.getSession();
Integer userID = (Integer) session.getAttribute("userID");
if (userID == null) {
    response.sendRedirect("login.jsp"); // Chuyển hướng đến trang đăng nhập nếu session không có thông tin người dùng
    return;
}
// Tiếp tục xử lý khi người dùng đã đăng nhập


        if (sort == null) {
            sort = "mostRelevant";
        }
        try {
            listCourse = courseDAO.searchAndFilterData(txtSearch, cbxTypesOfCourse, cbxPrices, cbxDurations, rating, sort);

            if (listCourse.isEmpty()) {
                request.setAttribute("emptyCourse", "There are no courses");
            } else {
                List<CourseDBO> coursePaggingList = CoursePaggingList(page, listCourse);
                request.setAttribute("pageCounting", pageCounting(listCourse.size()));
                request.setAttribute("listCourse", coursePaggingList);
            }
            request.setAttribute("cbxDurations", (cbxDurations != null) ? Arrays.asList(cbxDurations) : "");

            request.setAttribute("txtSearch", (txtSearch != null && !txtSearch.isBlank()) ? txtSearch : "");
            request.setAttribute("cbxTypesOfCourse", (cbxTypesOfCourse != null) ? Arrays.asList(cbxTypesOfCourse) : "");
            request.setAttribute("cbxPrices", (cbxPrices != null) ? Arrays.asList(cbxPrices) : "");
            request.setAttribute("rating", (rating != null) ? rating : "");
            request.setAttribute("page", (page != null) ? page : "1");

        } catch (NullPointerException | NumberFormatException e) {
            e.printStackTrace();
        }
        request.setAttribute("youTubeDuration", youTubeDuration);
        request.setAttribute("pageCounting", pageCounting(listCourse.size()));
        request.setAttribute("sort", sort);
        request.setAttribute("courseDao", courseDAO);
        request.setAttribute("results", listCourse.size());
        request.getRequestDispatcher("course.jsp").forward(request, response);
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
