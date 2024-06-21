package CourseManagementController;

import Dal.CourseDAO;
import Model.CourseDBO;
import Model.UserDBO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/manage-courses")
public class ManagerControl extends HttpServlet {
    private List<CourseDBO> CoursePaggingList(String page, List<CourseDBO> listCourse) {
        int pageSize = 10; // Số lượng khóa học trên mỗi trang
        int currentPage = (page != null) ? Integer.parseInt(page) : 1;
        int startItem = (currentPage - 1) * pageSize;
        int endItem = Math.min(startItem + pageSize, listCourse.size());

        return listCourse.subList(startItem, endItem);
    }

    private int pageCounting(int totalItems) {
        int pageSize = 10; // Số lượng khóa học trên mỗi trang
        return (int) Math.ceil((double) totalItems / pageSize);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        CourseDAO courseDAO = new CourseDAO();

        String txtSearch = request.getParameter("txtSearch");
        String page = request.getParameter("page");

        List<CourseDBO> listCourse = new ArrayList<>();

        HttpSession session = request.getSession();
        UserDBO user = (UserDBO) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            if (txtSearch != null && !txtSearch.isEmpty()) {
                listCourse = courseDAO.searchAndFilterData1(txtSearch, user.getId());
            } else {
                listCourse = courseDAO.getAllCourseByUserId(user.getId());
            }

            if (listCourse.isEmpty()) {
                request.setAttribute("emptyCourse", "There are no courses");
            } else {
                List<CourseDBO> coursePaggingList = CoursePaggingList(page, listCourse);
                request.setAttribute("pageCounting", pageCounting(listCourse.size()));
                request.setAttribute("listCourse", coursePaggingList);
            }

            request.setAttribute("txtSearch", (txtSearch != null && !txtSearch.isBlank()) ? txtSearch : "");
            request.setAttribute("page", (page != null) ? page : "1");

        } catch (NullPointerException | NumberFormatException e) {
            e.printStackTrace();
        }

        request.setAttribute("results", listCourse.size());
        request.getRequestDispatcher("manage-courses.jsp").forward(request, response);
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
        return "Short description";
    }
}