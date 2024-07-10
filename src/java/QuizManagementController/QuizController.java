/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package QuizManagementController;

import Dal.CommentDAO;
import Dal.CourseDAO;
import Dal.QuizDAO;
import Dal.UserDAO;
import Model.AnswersDBO;
import Model.CommentDBO;
import Model.CourseDBO;
import Model.LessonDBO;
<<<<<<< HEAD
import Model.QuestionsDBO;
import Model.QuizDBO;
import Model.SubLessonDBO;
=======
import Model.MenteeScoreDBO;
import Model.QuestionsDBO;
import Model.QuizDBO;
import Model.SubLessonDBO;
import Model.TotalQuizDBO;
import Model.UserCourseProgressDBO;
>>>>>>> origin/DashBoard
import Model.UserDBO;
import YoutobeDataAPI.YouTubeDuration;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author _aquyndz
 */
public class QuizController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet QuizController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet QuizController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("login.jsp");
            return;
        }

<<<<<<< HEAD
        CourseDBO course = (CourseDBO) session.getAttribute("course");
        if (course == null) {
            response.sendRedirect("login.jsp");
            return;
        }
=======
>>>>>>> origin/DashBoard

        String subLessonId = request.getParameter("sub_lesson_id");
        String quizId = request.getParameter("quiz_id");
        String action = request.getParameter("action");
<<<<<<< HEAD
=======
        String course_id = request.getParameter("course_id");
>>>>>>> origin/DashBoard

        CourseDAO courseDAO = new CourseDAO();
        QuizDAO quizDAO = new QuizDAO();
        CommentDAO commentDAO = new CommentDAO();
<<<<<<< HEAD

        YouTubeDuration youTubeDuration = new YouTubeDuration();
        ArrayList<LessonDBO> listLesson = courseDAO.getListLessonByCourseID(String.valueOf(course.getId()));
=======
        UserDBO user = (UserDBO) session.getAttribute("user");
        UserCourseProgressDBO UserCourseProgress = quizDAO.getUserCourseProgress(user.getId(), Integer.parseInt(course_id));
        YouTubeDuration youTubeDuration = new YouTubeDuration();
        ArrayList<LessonDBO> listLesson = courseDAO.getListLessonByCourseID(String.valueOf(course_id));
>>>>>>> origin/DashBoard
        ArrayList<CommentDBO> listComment = new ArrayList<>();
        SubLessonDBO subLesson = null;

        try {
            // Handle the "next" action
            if ("next".equals(action)) {
                if (quizId != null && !quizId.isEmpty()) {
                    int quizIdInt = Integer.parseInt(quizId);
                    Map<Integer, LessonDBO> quizIdToLessonMap = new HashMap<>();

                    // Build mapping of quiz IDs to lessons
                    for (LessonDBO lesson : listLesson) {
                        for (QuizDBO quiz : lesson.getQuiz_lesson_list()) {
                            quizIdToLessonMap.put(quiz.getQuizId(), lesson);
                        }
                    }

                    // Retrieve the lesson containing the current quiz
                    LessonDBO currentLesson = quizIdToLessonMap.get(quizIdInt);

                    if (currentLesson != null) {
                        int currentLessonIndex = listLesson.indexOf(currentLesson);

                        // Check if the current quiz is the last one in the lesson
                        List<QuizDBO> quizzes = currentLesson.getQuiz_lesson_list();
                        if (quizzes.get(quizzes.size() - 1).getQuizId() == quizIdInt) {
                            // If it's the last quiz, move to the first sub-lesson of the next lesson
                            if (currentLessonIndex < listLesson.size() - 1) {
                                LessonDBO nextLesson = listLesson.get(currentLessonIndex + 1);
                                if (nextLesson != null && !nextLesson.getSub_lesson_list().isEmpty()) {
                                    subLessonId = String.valueOf(nextLesson.getSub_lesson_list().get(0).getId());
<<<<<<< HEAD
                                    response.sendRedirect("/E-Learning_System/course/learning" + "?a=sub&sub_lesson_id=" + subLessonId);
                                    return;
                                }
                            }
                        } 
                    }
                }
            }
=======
                                    response.sendRedirect("/E-Learning_System/course/learning" + "?a=sub&sub_lesson_id=" + subLessonId+"&course_id=" + course_id);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
            request.setAttribute("userProgress", UserCourseProgress);
>>>>>>> origin/DashBoard
            // Set attributes and forward to videoLearn.jsp
            request.setAttribute("comment", listComment);
            request.setAttribute("youTubeDuration", youTubeDuration);
            request.setAttribute("subLesson", subLesson);
            request.setAttribute("listLesson", listLesson);
<<<<<<< HEAD
=======
            request.setAttribute("courseId", course_id);
>>>>>>> origin/DashBoard
            request.getRequestDispatcher("/videoLearn.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the quiz questions
        HttpSession session = request.getSession();
        List<QuestionsDBO> listQuestions = (List<QuestionsDBO>) session.getAttribute("listQuestions");
<<<<<<< HEAD
        CourseDBO course = (CourseDBO) session.getAttribute("course");
        String quiz_id = request.getParameter("quiz_id");
        CourseDAO courseDAO = new CourseDAO();
        ArrayList<LessonDBO> listLesson = courseDAO.getListLessonByCourseID("" + course.getId());
=======
        String course_id = request.getParameter("course_id");
        String quiz_id = request.getParameter("quiz_id");
        CourseDAO courseDAO = new CourseDAO();
        ArrayList<LessonDBO> listLesson = courseDAO.getListLessonByCourseID("" + course_id);
>>>>>>> origin/DashBoard
        UserDBO user = (UserDBO) session.getAttribute("user");
        YouTubeDuration youTubeDuration = new YouTubeDuration();
        QuizDAO quizDAO = new QuizDAO();
        UserDAO userDAO = new UserDAO();

<<<<<<< HEAD
        if (listQuestions == null) {
=======
        // Check for necessary session attributes and parameters
        if (listQuestions == null || quiz_id == null || user == null) {
>>>>>>> origin/DashBoard
            response.sendRedirect("quiz.jsp");
            return;
        }

<<<<<<< HEAD
=======
        // Process and store correct answers for each question
>>>>>>> origin/DashBoard
        for (QuestionsDBO question : listQuestions) {
            List<Integer> correctAnswers = question.getAnswers_list().stream()
                    .filter(AnswersDBO::isIsCorrect)
                    .map(AnswersDBO::getAnswerId)
                    .collect(Collectors.toList());
            question.setCorrectAnswerIds(correctAnswers); // Ensure this method exists in QuestionsDBO
        }

        // Map to store the question ID and the selected answer IDs
        Map<Integer, List<Integer>> userAnswers = new HashMap<>();

<<<<<<< HEAD
        // Iterate over the list of questions to retrieve user responses
=======
        // Retrieve user responses for each question
>>>>>>> origin/DashBoard
        for (QuestionsDBO question : listQuestions) {
            String[] selectedAnswers = request.getParameterValues("q" + question.getQuestionId());
            if (selectedAnswers != null) {
                List<Integer> answerIds = Arrays.stream(selectedAnswers)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                userAnswers.put(question.getQuestionId(), answerIds);
            }
        }
<<<<<<< HEAD
        session.setAttribute("userAnswers", userAnswers);

        // Process user answers (e.g., calculate score, store results, etc.)
        int score = calculateScore(listQuestions, userAnswers);
        if (userDAO.checkUserScoreByIdExitd(user.getId(), Integer.parseInt(quiz_id))) {
            quizDAO.UpdateScoreMentee(score, user.getId(), Integer.parseInt(quiz_id));
        } else {
            quizDAO.insertScoreMentee(user.getId(), Integer.parseInt(quiz_id), score);
        }
        // Store the score and user answers in the request or session
        request.setAttribute("score", score);
=======

        session.setAttribute("userAnswers", userAnswers);

        // Calculate user score
        int score = calculateScore(listQuestions, userAnswers);

        // Calculate total number of quizzes for the course
        int totalQuiz = quizDAO.getListQuizByCourse(Integer.parseInt(course_id)).size();    

        // Ensure totalQuiz is not zero to avoid division by zero
        if (totalQuiz == 0) {
            response.sendRedirect("quiz.jsp");
            return;
        }

        // Retrieve or initialize session progress
        Integer sessionProgress = (Integer) session.getAttribute("progress");

        // Initialize progress
        int progress = 0;

        // Check if the progress already exists in the database
        if (quizDAO.checkUserProgress(user.getId(),Integer.parseInt(course_id))) {
            UserCourseProgressDBO userCourseProgress = quizDAO.getUserCourseProgress(user.getId(), Integer.parseInt(course_id));
            progress = userCourseProgress.getProgress();

            if (score >= 8) {
                if (userDAO.checkUserScoreByIdExitd(user.getId(), Integer.parseInt(quiz_id))) {
                    quizDAO.UpdateScoreMentee(score, user.getId(), Integer.parseInt(quiz_id));
                } else {
                    quizDAO.insertScoreMentee(user.getId(), Integer.parseInt(quiz_id), score);
                }
                int progressIncrement = 100 / totalQuiz;
                progress += progressIncrement;

                // Cap progress at 100%
                if (progress > 100) {
                    progress = 100;
                }
            } else {
                // Decrease progress if the score is less than 5
                if (userDAO.checkUserScoreByIdExitd(user.getId(), Integer.parseInt(quiz_id))) {
                    quizDAO.UpdateScoreMentee(score, user.getId(), Integer.parseInt(quiz_id));
                } else {
                    quizDAO.insertScoreMentee(user.getId(), Integer.parseInt(quiz_id), score);
                }
                int progressDecrement = 100 / totalQuiz;

                // Ensure progress doesn't go below 0%
                if (progress < 0) {
                    progress = 0;
                }
            }
            quizDAO.UpdateProgressCourse(progress, user.getId(), Integer.parseInt(course_id));
        } else { // progress chưa có trong bảng
            if (score >= 8) {
                if (userDAO.checkUserScoreByIdExitd(user.getId(), Integer.parseInt(quiz_id))) {
                    quizDAO.UpdateScoreMentee(score, user.getId(), Integer.parseInt(quiz_id));
                } else {
                    quizDAO.insertScoreMentee(user.getId(), Integer.parseInt(quiz_id), score);
                }
                int progressIncrement = 100 / totalQuiz;
                progress += progressIncrement;
                quizDAO.insertProgressCourse(user.getId(), Integer.parseInt(course_id), progress);
            } else {
                if (userDAO.checkUserScoreByIdExitd(user.getId(), Integer.parseInt(quiz_id))) {
                    quizDAO.UpdateScoreMentee(score, user.getId(), Integer.parseInt(quiz_id));
                } else {
                    quizDAO.insertScoreMentee(user.getId(), Integer.parseInt(quiz_id), score);
                }
                progress = 0;
                quizDAO.insertProgressCourse(user.getId(), Integer.parseInt(course_id), progress);
            }
        }

        // Update session attribute for progress
        session.setAttribute("progress", progress);

        // Retrieve updated scores and progress
        MenteeScoreDBO menteeScore = quizDAO.getScoreByUserIdQuizId(user.getId(), Integer.parseInt(quiz_id));
        UserCourseProgressDBO userCourseProgress = quizDAO.getUserCourseProgress(user.getId(),Integer.parseInt(course_id));

        // Store the score and user answers in the request or session
        request.setAttribute("menteeScore", menteeScore);
        request.setAttribute("userProgress", userCourseProgress);
>>>>>>> origin/DashBoard
        request.setAttribute("quiz_id", quiz_id);
        request.setAttribute("userAnswers", userAnswers);
        request.setAttribute("listLesson", listLesson);
        request.setAttribute("youtobeDuration", youTubeDuration);
<<<<<<< HEAD
        // Forward to the result page
        request.getRequestDispatcher("/result-quiz.jsp").forward(request, response);
    }

// Helper method to calculate the score
=======
        request.setAttribute("courseId", course_id);

        // Forward to the result page
        request.getRequestDispatcher("/result-quiz.jsp").forward(request, response);
    }
// Helper method to calculate the score

>>>>>>> origin/DashBoard
    private int calculateScore(List<QuestionsDBO> listQuestions, Map<Integer, List<Integer>> userAnswers) {
        int score = 0;
        for (QuestionsDBO question : listQuestions) {
            List<Integer> correctAnswers = question.getAnswers_list().stream()
                    .filter(AnswersDBO::isIsCorrect)
                    .map(AnswersDBO::getAnswerId)
                    .collect(Collectors.toList());
            List<Integer> userSelectedAnswers = userAnswers.get(question.getQuestionId());
            if (userSelectedAnswers != null && userSelectedAnswers.equals(correctAnswers)) {
                score++;
            }
        }
        return score;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
