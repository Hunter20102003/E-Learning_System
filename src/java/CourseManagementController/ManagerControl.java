package CourseManagementController;

import Dal.CourseDAO;
import Dal.UserDAO;
import Model.CourseDBO;
import Model.LessonDBO;
import Model.SubLessonDBO;
import Model.UserDBO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        UserDAO userDAO = new UserDAO();
<<<<<<< HEAD
<<<<<<< HEAD
        ArrayList<UserDBO> users = userDAO.getAllUsers();
=======
=======
>>>>>>> origin/front-end

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

                // Fetch lessons and sublessons for each course
                Map<Integer, List<LessonDBO>> courseLessonsMap = new HashMap<>();
                Map<Integer, List<SubLessonDBO>> lessonSubLessonsMap = new HashMap<>();

                for (CourseDBO course : coursePaggingList) {
                    List<LessonDBO> lessons = courseDAO.getLessonsByCourseId1(course.getId());
                    if (!lessons.isEmpty()) {
                        courseLessonsMap.put(course.getId(), lessons);

                        for (LessonDBO lesson : lessons) {
                            List<SubLessonDBO> subLessons = courseDAO.getSubLessonsByLessonId1(lesson.getId());
                            if (!subLessons.isEmpty()) {
                                lesson.setSub_lesson_list(new ArrayList<>(subLessons));
                                lessonSubLessonsMap.put(lesson.getId(), subLessons);
                            }
                        }
                    }
                }

                request.setAttribute("courseLessonsMap", courseLessonsMap);
                request.setAttribute("lessonSubLessonsMap", lessonSubLessonsMap);
            }

            request.setAttribute("txtSearch", (txtSearch != null && !txtSearch.isBlank()) ? txtSearch : "");
            request.setAttribute("page", (page != null) ? page : "1");

        } catch (NullPointerException | NumberFormatException e) {
        }

        List<UserDBO> users = userDAO.getAllUsers();
<<<<<<< HEAD
>>>>>>> origin/create-course1
=======
>>>>>>> origin/front-end
        Map<Integer, String> teacherMap = new HashMap<>();
        for (UserDBO u : users) {
            teacherMap.put(u.getId(), u.getFirstName() + " " + u.getLastName());
        }

        // Fetch teachers separately if needed
        List<UserDBO> teachers = userDAO.getUsersByRole(2);

        request.setAttribute("teacherMap", teacherMap);

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