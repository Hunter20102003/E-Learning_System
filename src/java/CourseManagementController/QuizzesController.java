package CourseManagementController;

import Dal.CourseDAO;
import Dal.QuizDAO;
import Model.QuizDBO;
import com.sun.net.httpserver.HttpsServer;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author LEGION
 */
public class QuizzesController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet QuizzesController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet QuizzesController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public boolean validName(String name) {
        return name.matches("^[a-zA-Z0-9]+$");
    }

    private void quizAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lessonId = request.getParameter("lessonId");
        if (lessonId == null) {

            response.sendRedirect("CourseContentManagement");

        }
        String quizTitle = request.getParameter("quizTitle");
        String time = request.getParameter("time");
        String timeSet = request.getParameter("timeSet");
        String typeOfTime = request.getParameter("typeOfTime");
        String active = request.getParameter("active");

        CourseDAO courseDao = new CourseDAO();
        QuizDAO quizDao = new QuizDAO();

        try {
            if (quizTitle.isBlank() || (time != null && timeSet.isBlank())) {
                request.setAttribute("errorMess", "Please enter complete quiz's information");
            } else {
                if (!validName(quizTitle)) {
                    request.setAttribute("errorMess", "Invalid quiz title");

                } else {
                    int lessonIdConvert = Integer.parseInt(lessonId);
                    int activeConvert = (active != null ? 0 : 1);
                    int check = 0;
                    if (time == null) {

                        check = quizDao.addQuizByLessonId(lessonIdConvert, quizTitle, 0, activeConvert);

                    } else {
                        int timeConvert = Integer.parseInt(timeSet);
                        if (typeOfTime.equals("hour")) {
                            timeConvert *= 60;
                        }
                        check = quizDao.addQuizByLessonId(lessonIdConvert, quizTitle, timeConvert, activeConvert);

                    }
                    if (check > 0) {
                        response.sendRedirect("CourseContentManagement?mess=Quiz added successfully !!!");
                        return;
                    } else {
                        request.setAttribute("errorMess", "Failed to add quiz");

                    }
                }
            }
        } catch (NumberFormatException | NullPointerException e) {
            //  request.setAttribute("errorMess", "Invalid input");
            e.printStackTrace(); // Consider logging this error properly
        }
        request.setAttribute("quizTitle", quizTitle);
        request.setAttribute("time", time);
        request.setAttribute("timeSet", timeSet);
        request.setAttribute("typeOfTime", typeOfTime);
        request.setAttribute("active", active);
        request.setAttribute("lesson", courseDao.getLessonByID(lessonId));

        request.getRequestDispatcher("create-quiz.jsp").forward(request, response);

    }

    private void quizRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String quizId = request.getParameter("quizId");
        if (quizId == null) {
            request.setAttribute("mess", "Quiz ID is required");
            return;
        }
        QuizDAO quizDao = new QuizDAO();
        int checkDelete = quizDao.removeQuizById(Integer.parseInt(quizId));
        if (checkDelete > 0) {
            response.sendRedirect("CourseContentManagement?mess=Quiz removed successfully !!!");

        } else {

            response.sendRedirect("CourseContentManagement?mess=Quiz removed  not successfully !!!");

        }

    }

    private void displayQuizAdd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        CourseDAO courseDAO = new CourseDAO();
        String lessonId = request.getParameter("lessonId");
        request.setAttribute("active", "checked");
        request.setAttribute("lesson", courseDAO.getLessonByID(lessonId));

        request.getRequestDispatcher("create-quiz.jsp").forward(request, response);
    }

    private void displayQuizEdit(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        String quizId = request.getParameter("quizId");
        String lessonId = request.getParameter("lessonId");

        CourseDAO courseDAO = new CourseDAO();
        QuizDAO quizDao = new QuizDAO();
        if (quizId == null || lessonId == null) {
            return;
        }
        try {
            QuizDBO quizDBO = quizDao.getQuizById(Integer.parseInt(quizId));
            if (quizDBO == null) {

            } else {

                request.setAttribute("quiz", quizDao.getQuizById(Integer.parseInt(quizId)));
                request.setAttribute("lesson", courseDAO.getLessonByID(lessonId));
                request.setAttribute("listQuestion", quizDao.getListQuestionsByQuizID(Integer.parseInt(quizId)));
                request.getRequestDispatcher("edit-quiz.jsp").forward(request, response);
            }
        } catch (NumberFormatException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void quizEdit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        CourseDAO courseDAO = new CourseDAO();
        QuizDAO quizDao = new QuizDAO();
        String quizId = request.getParameter("quizId");
        String lessonId = request.getParameter("lessonId");
        String quizTitle = request.getParameter("quizTitle").trim();
        String time = request.getParameter("time");
        String timeSet = request.getParameter("timeSet").trim();
        String typeOfTime = request.getParameter("typeOfTime");
        String active = request.getParameter("active");

        if (quizId == null || lessonId == null) {
            request.setAttribute("errorMess", "Quiz ID and Lesson ID are required.");
            request.getRequestDispatcher("edit-quiz.jsp").forward(request, response);
            return;
        }

        try {
            int quizIdInt = Integer.parseInt(quizId);

            QuizDBO quizDBO = quizDao.getQuizById(quizIdInt);
            if (quizDBO == null) {
                request.setAttribute("errorMess", "Quiz not found.");
                request.getRequestDispatcher("edit-quiz.jsp").forward(request, response);
                return;
            }

            if (quizTitle.isBlank() || (time != null && timeSet.isBlank())) {
                request.setAttribute("errorMess", "Please enter complete quiz's information");
            } else if (!validName(quizTitle)) {
                request.setAttribute("errorMess", "Invalid quiz title");
            } else {
                int activeConvert = (active != null ? 0 : 1);
                int check;

                if (time == null) {
                    check = quizDao.editQuizById(quizIdInt, quizTitle, 0, activeConvert);
                } else {
                    int timeConvert = Integer.parseInt(timeSet);
                    if (typeOfTime.equals("hour")) {
                        timeConvert *= 60;
                    }
                    check = quizDao.editQuizById(quizIdInt, quizTitle, timeConvert, activeConvert);
                }

                if (check > 0) {
                    request.setAttribute("alertChangeQuizSuccess", "Quiz have been changed quiz successfully!!!");
                } else {
                    request.setAttribute("errorMess", "Failed to change quiz");
                }
            }

          
        } catch (NumberFormatException e) {
            request.setAttribute("errorMess", "Invalid format number for setting time of quiz");
        } catch (NullPointerException e) {
            request.setAttribute("errorMess", e.getMessage());
        }
        
        request.setAttribute("quiz", quizDao.getQuizById(Integer.parseInt(quizId)));
        request.setAttribute("lesson", courseDAO.getLessonByID(lessonId));
        request.setAttribute("listQuestion", quizDao.getListQuestionsByQuizID(Integer.parseInt(quizId)));
        request.getRequestDispatcher("edit-quiz.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action != null) {
            request.setAttribute("action", action);
            switch (action) {
                case "quizAdd":
                    displayQuizAdd(request, response);

                    break;
                case "quizEdit":
                    displayQuizEdit(request, response);
                    break;
                case "quizRemove":
                    quizRemove(request, response);
                    break;
                case "questionAdd":
                    // Add questionAdd logic here
                    break;
                case "questionEdit":
                    // Add questionEdit logic here
                    break;
                case "questionRemove":
                    // Add questionRemove logic here
                    break;
                case "answerAdd":
                    // Add answerAdd logic here
                    break;
                case "answerEdit":
                    // Add answerEdit logic here
                    break;
                case "answerRemove":
                    // Add answerRemove logic here
                    break;
                default:
                    request.setAttribute("errorMess", "Invalid action");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            request.setAttribute("action", action);
            switch (action) {
                case "quizAdd":
                    quizAdd(request, response);
                    break;
                case "quizEdit":
                    quizEdit(request, response);
                    break;

                case "questionAdd":
                    // Add questionAdd logic here
                    break;
                case "questionEdit":
                    // Add questionEdit logic here
                    break;
                case "questionRemove":
                    // Add questionRemove logic here
                    break;
                case "answerAdd":
                    // Add answerAdd logic here
                    break;
                case "answerEdit":
                    // Add answerEdit logic here
                    break;
                case "answerRemove":
                    // Add answerRemove logic here
                    break;
                default:
                    request.setAttribute("errorMess", "Invalid action");
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
