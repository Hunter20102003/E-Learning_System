package CourseManagementController;

import Dal.CourseDAO;
import Model.CourseDBO;
import Model.EnrollmentDBO;
import Model.ReviewDBO;
<<<<<<< HEAD
<<<<<<< HEAD
import YoutobeDataAPI.YouTubeDuration;
=======
>>>>>>> origin/Authentication
=======
import YoutobeDataAPI.YouTubeDuration;
>>>>>>> origin/front-end
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
<<<<<<< HEAD
<<<<<<< HEAD
import jakarta.servlet.http.HttpSession;
=======
>>>>>>> origin/Authentication
=======
>>>>>>> origin/front-end
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
<<<<<<< HEAD
<<<<<<< HEAD
        HttpSession session =request.getSession();
        session.setAttribute("courseActive", "Active");
=======
>>>>>>> origin/Authentication
=======
>>>>>>> origin/front-end
        CourseDAO courseDAO = new CourseDAO();
        String txtSearch = request.getParameter("txtSearch");
        String[] cbxTypesOfCourse = request.getParameterValues("cbxTypesOfCourse");
        String[] cbxPrices = request.getParameterValues("cbxPrices");
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/front-end
        String []cbxDurations=request.getParameterValues("cbxDurations");
        String rating = request.getParameter("rating");
        String sort = request.getParameter("sort");
        String page = request.getParameter("page");
        YouTubeDuration youTubeDuration = new YouTubeDuration();

        List<CourseDBO> listCourse = new ArrayList<>();
//        List<ReviewDBO> listReview = new ArrayList<>();
//        List<EnrollmentDBO> listEnrollment = new ArrayList<>();
<<<<<<< HEAD
=======
        String rating = request.getParameter("rating");
        String sort = request.getParameter("sort");
        String page = request.getParameter("page");

        List<CourseDBO> listCourse = new ArrayList<>();
        List<ReviewDBO> listReview = new ArrayList<>();
        List<EnrollmentDBO> listEnrollment = new ArrayList<>();
>>>>>>> origin/Authentication
=======
>>>>>>> origin/front-end
        if (sort == null) {
            sort = "mostRelevant";
        }
        try {
<<<<<<< HEAD
<<<<<<< HEAD
            listCourse = courseDAO.searchAndFilterData(txtSearch, cbxTypesOfCourse, cbxPrices,cbxDurations, rating, sort);
=======
            listCourse = courseDAO.searchAndFilterData(txtSearch, cbxTypesOfCourse, cbxPrices, rating, sort);
>>>>>>> origin/Authentication
=======
            listCourse = courseDAO.searchAndFilterData(txtSearch, cbxTypesOfCourse, cbxPrices,cbxDurations, rating, sort);
>>>>>>> origin/front-end

            if (listCourse.isEmpty()) {
                request.setAttribute("emptyCourse", "There are no courses");
            } else {
                List<CourseDBO> coursePaggingList = CoursePaggingList(page, listCourse);
                request.setAttribute("pageCounting", pageCounting(listCourse.size()));
                request.setAttribute("listCourse", coursePaggingList);
            }
<<<<<<< HEAD
<<<<<<< HEAD
            request.setAttribute("cbxDurations", (cbxDurations != null) ? Arrays.asList(cbxDurations) : "");
=======
>>>>>>> origin/Authentication
=======
            request.setAttribute("cbxDurations", (cbxDurations != null) ? Arrays.asList(cbxDurations) : "");
>>>>>>> origin/front-end

            request.setAttribute("txtSearch", (txtSearch != null && !txtSearch.isBlank()) ? txtSearch : "");
            request.setAttribute("cbxTypesOfCourse", (cbxTypesOfCourse != null) ? Arrays.asList(cbxTypesOfCourse) : "");
            request.setAttribute("cbxPrices", (cbxPrices != null) ? Arrays.asList(cbxPrices) : "");
            request.setAttribute("rating", (rating != null) ? rating : "");
            request.setAttribute("page", (page != null) ? page : "1");

        } catch (NullPointerException | NumberFormatException e) {
            e.printStackTrace();
        }
<<<<<<< HEAD
<<<<<<< HEAD
        request.setAttribute("youTubeDuration", youTubeDuration);
=======
>>>>>>> origin/Authentication
=======
        request.setAttribute("youTubeDuration", youTubeDuration);
>>>>>>> origin/front-end
        request.setAttribute("pageCounting", pageCounting(listCourse.size()));
        request.setAttribute("sort", sort);
        request.setAttribute("courseDao", courseDAO);
        request.setAttribute("results", listCourse.size());
        request.setAttribute("listTypeOfCourse", courseDAO.getAllCourseType());
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
