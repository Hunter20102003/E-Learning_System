<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/create-course1
package CourseManagementController;

import Dal.CourseDAO;
import Dal.QuizDAO;
<<<<<<< HEAD
import Model.QuizDBO;
import com.sun.net.httpserver.HttpsServer;
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package CourseManagementController;

>>>>>>> origin/crudlesson,sublesson
=======
package CourseManagementController;

import Dal.CourseDAO;
import Dal.QuizDAO;
import Model.QuizDBO;
import com.sun.net.httpserver.HttpsServer;
>>>>>>> origin/crud_quiz
=======
import Model.QuestionsDBO;
import Model.QuizDBO;
>>>>>>> origin/create-course1
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
<<<<<<< HEAD
=======
import jakarta.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
>>>>>>> origin/create-course1

/**
 *
 * @author LEGION
 */
public class QuizzesController extends HttpServlet {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/create-course1

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
<<<<<<< HEAD
        return name.matches("^[a-zA-Z0-9]+$");
=======
        String[] s = name.split("\\s+");
        for (var a : s) {
            if (!a.matches("^[a-zA-Z0-9]+$")) {
                return false;
            }
        }
        return true;
>>>>>>> origin/create-course1
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
<<<<<<< HEAD

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
=======
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
=======

>>>>>>> origin/crud_quiz
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

=======
        HttpSession session = request.getSession();
        if (session.getAttribute("lessonId") == null) {
            session.setAttribute("lessonId", lessonId);
        } else {
            lessonId = (String) session.getAttribute("lessonId");
        }
>>>>>>> origin/create-course1
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
<<<<<<< HEAD
        CourseDAO courseDAO = new CourseDAO();
        QuizDAO quizDao = new QuizDAO();
        String quizId = request.getParameter("quizId");
        String lessonId = request.getParameter("lessonId");
=======
        HttpSession session = request.getSession();
        CourseDAO courseDAO = new CourseDAO();
        QuizDAO quizDao = new QuizDAO();
        String lessonId = (String) session.getAttribute("lessonId");
        String quizId = request.getParameter("quizId");
>>>>>>> origin/create-course1
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

<<<<<<< HEAD
          
=======
>>>>>>> origin/create-course1
        } catch (NumberFormatException e) {
            request.setAttribute("errorMess", "Invalid format number for setting time of quiz");
        } catch (NullPointerException e) {
            request.setAttribute("errorMess", e.getMessage());
        }
<<<<<<< HEAD
        
=======

>>>>>>> origin/create-course1
        request.setAttribute("quiz", quizDao.getQuizById(Integer.parseInt(quizId)));
        request.setAttribute("lesson", courseDAO.getLessonByID(lessonId));
        request.setAttribute("listQuestion", quizDao.getListQuestionsByQuizID(Integer.parseInt(quizId)));
        request.getRequestDispatcher("edit-quiz.jsp").forward(request, response);
    }

<<<<<<< HEAD
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
=======
    private void questionAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String questionTitle = request.getParameter("questionTitle");
        String quizId = request.getParameter("quizId");
        String typeOfQuestion = request.getParameter("typeOfQuestion");
        if (questionTitle.isBlank() || quizId.isBlank() || typeOfQuestion.isBlank()) {
            return;
        }
        QuizDAO quizDao = new QuizDAO();
        int type = typeOfQuestion.equals("radio") ? 1 : 2;
        int questionId = quizDao.addQuestionByQuizId(Integer.parseInt(quizId), questionTitle, type);
        if (questionId > 0) {
            int cnt = 0;
            boolean answerAddCheck = true;
            List<String> answers = Arrays.asList(request.getParameterValues("answers_"));;

            while (true) {
                String answerText = request.getParameter("answerText_" + cnt);
                if (answerText == null) {
                    break;
                }
                int check = 0;
                if (answers.contains("" + cnt)) {
                    check = quizDao.addAnswerByQuestionId(questionId, answerText.trim(), 1);

                } else {
                    check = quizDao.addAnswerByQuestionId(questionId, answerText.trim(), 0);
                }
                if (check <= 0) {
                    request.setAttribute("answerFailed", "Answers added failed");
                    answerAddCheck = false;
                    break;
                }
                cnt++;

            }
            if (answerAddCheck) {
                request.setAttribute("questionAddSuccess", "Question added successful");
            }
        } else {
            request.setAttribute("questionAddFailed", "Question added failed");
        }

        displayQuizEdit(request, response);

    }

    private void questionRemove(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String questionId = request.getParameter("questionId");
        if (questionId == null || questionId.isBlank()) {
            return;
        }
        QuizDAO quizDao = new QuizDAO();
        int check = quizDao.removeQuestionById(Integer.parseInt(questionId));
        if (check > 0) {
            request.setAttribute("questionRemoveSuccess", "Question removed successfully");
        } else {
            request.setAttribute("questionRemoveFailed", "Question removed failed");

        }
        displayQuizEdit(request, response);

    }

    private void questionEditDisplay(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String quizId = request.getParameter("quizId");
        String questionId = request.getParameter("questionId");
        if (questionId == null || questionId.isBlank() || quizId == null || quizId.isBlank()) {
            // response.getWriter().print("ok");
            return;
        }
        QuizDAO quizDao = new QuizDAO();
        QuestionsDBO question = quizDao.getQuestionById(questionId);
        if (question == null) {
            //    response.getWriter().print("ok");
            return;
        }
        request.setAttribute("question", question);
        request.setAttribute("quizId", quizId);
        request.getRequestDispatcher("edit-question.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
>>>>>>> origin/create-course1

        String action = request.getParameter("action");

        if (action != null) {
            request.setAttribute("action", action);
            switch (action) {
                case "quizAdd":
                    displayQuizAdd(request, response);
<<<<<<< HEAD

=======
>>>>>>> origin/create-course1
                    break;
                case "quizEdit":
                    displayQuizEdit(request, response);
                    break;
                case "quizRemove":
                    quizRemove(request, response);
                    break;
<<<<<<< HEAD
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
=======
                case "questionEdit":
                    questionEditDisplay(request, response);
                    break;
                case "questionRemove":
                    questionRemove(request, response);
                    break;

>>>>>>> origin/create-course1
                default:
                    request.setAttribute("errorMess", "Invalid action");
            }
        }

    }

<<<<<<< HEAD
=======
    private void questionEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String questionId = request.getParameter("questionId");
        String questionTitle = request.getParameter("questionTitle");
        String quizId = request.getParameter("quizId");
        String typeOfQuestion = request.getParameter("typeOfQuestion");
        if (questionId == null || questionId.isBlank() || questionTitle.isBlank() || quizId.isBlank() || typeOfQuestion == null) {
            return;
        }
        QuizDAO quizDao = new QuizDAO();
        QuestionsDBO question = quizDao.getQuestionById(questionId);
        if (question == null) {
            return;
        }
//        if (answersRemoveCheck <= 0) {
//            return;
//        }
        int type = typeOfQuestion.equals("radio") ? 1 : 2;

        int questionIdEdited = quizDao.editQuestionById(question.getQuestionId(), questionTitle, type);
        int answersRemoveCheck = quizDao.removeAllAnswerOfQuestionByQuestionId(question.getQuestionId());

        if (questionIdEdited > 0) {
            int cnt = 0;
            boolean answerAddCheck = true;
            List<String> answers = Arrays.asList(request.getParameterValues("answers_"));;

            while (true) {
                String answerText = request.getParameter("answerText_" + cnt);
                if (answerText == null) {
                            //response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing or invalid parameters");

                    break;
                }

                int check = 0;
                if (answers.contains("" + cnt)) {
                    check = quizDao.addAnswerByQuestionId(question.getQuestionId(), answerText.trim(), 1);

                } else {
                    check = quizDao.addAnswerByQuestionId(question.getQuestionId(), answerText.trim(), 0);
                }
                if (check <= 0) {
                    request.setAttribute("answerFailed", "Answers added failed");
                    answerAddCheck = false;
                    break;
                }
                cnt++;

            }
            if (answerAddCheck) {
                request.setAttribute("questionUpdateSuccess", "Question updated successful");
            }
        } else {
            request.setAttribute("questionUpdateFailed", "Question updated failed");
        }

        questionEditDisplay(request, response);

    }

>>>>>>> origin/create-course1
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
<<<<<<< HEAD
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
=======
                    questionAdd(request, response);
                    // Add questionAdd logic here
                    break;
                case "questionEdit":
                    questionEdit(request, response);
                    break;

>>>>>>> origin/create-course1
                default:
                    request.setAttribute("errorMess", "Invalid action");
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
<<<<<<< HEAD
<<<<<<< HEAD
    }// </editor-fold>

>>>>>>> origin/crudlesson,sublesson
=======
    }
>>>>>>> origin/crud_quiz
=======
    }

>>>>>>> origin/create-course1
}
