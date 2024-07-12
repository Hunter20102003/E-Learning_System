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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import Model.QuestionsDBO;
import Model.QuizDBO;
import Model.SubLessonDBO;
=======
=======
>>>>>>> origin/create-course1
import Model.MenteeScoreDBO;
import Model.QuestionsDBO;
import Model.QuizDBO;
import Model.SubLessonDBO;
import Model.TotalQuizDBO;
import Model.UserCourseProgressDBO;
<<<<<<< HEAD
>>>>>>> origin/DashBoard
=======
import Model.QuestionsDBO;
import Model.QuizDBO;
import Model.SubLessonDBO;
>>>>>>> origin/crudlesson,sublesson
=======
import Model.QuestionsDBO;
import Model.QuizDBO;
import Model.SubLessonDBO;
>>>>>>> origin/develop
=======
import Model.MenteeScoreDBO;
import Model.QuestionsDBO;
import Model.QuizDBO;
import Model.SubLessonDBO;
import Model.TotalQuizDBO;
import Model.UserCourseProgressDBO;
>>>>>>> origin/AdminManager
=======
>>>>>>> origin/create-course1
=======
import Model.MenteeScoreDBO;
import Model.QuestionsDBO;
import Model.QuizDBO;
import Model.SubLessonDBO;
import Model.TotalQuizDBO;
import Model.UserCourseProgressDBO;
>>>>>>> origin/crud_quiz
=======
import Model.QuestionsDBO;
import Model.QuizDBO;
import Model.SubLessonDBO;
>>>>>>> origin/front-end
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/crudlesson,sublesson
=======
>>>>>>> origin/develop
=======
>>>>>>> origin/comment
=======
>>>>>>> origin/front-end
        CourseDBO course = (CourseDBO) session.getAttribute("course");
        if (course == null) {
            response.sendRedirect("login.jsp");
            return;
        }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/DashBoard
=======
>>>>>>> origin/crudlesson,sublesson
=======
>>>>>>> origin/develop
=======
>>>>>>> origin/AdminManager
=======
>>>>>>> origin/comment
=======
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz
=======
>>>>>>> origin/front-end

        String subLessonId = request.getParameter("sub_lesson_id");
        String quizId = request.getParameter("quiz_id");
        String action = request.getParameter("action");
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
        String course_id = request.getParameter("course_id");
>>>>>>> origin/DashBoard
=======
>>>>>>> origin/crudlesson,sublesson
=======
>>>>>>> origin/develop
=======
        String course_id = request.getParameter("course_id");
>>>>>>> origin/AdminManager
=======
>>>>>>> origin/comment
=======
        String course_id = request.getParameter("course_id");
>>>>>>> origin/crud_quiz

        
        CourseDAO courseDAO = new CourseDAO();
        QuizDAO quizDAO = new QuizDAO();
        CommentDAO commentDAO = new CommentDAO();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

        YouTubeDuration youTubeDuration = new YouTubeDuration();
        ArrayList<LessonDBO> listLesson = courseDAO.getListLessonByCourseID(String.valueOf(course.getId()));
=======
=======
>>>>>>> origin/AdminManager
=======
        String course_id = request.getParameter("course_id");

        
        CourseDAO courseDAO = new CourseDAO();
        QuizDAO quizDAO = new QuizDAO();
        CommentDAO commentDAO = new CommentDAO();
>>>>>>> origin/create-course1
        UserDBO user = (UserDBO) session.getAttribute("user");
        UserCourseProgressDBO UserCourseProgress = quizDAO.getUserCourseProgress(user.getId(), Integer.parseInt(course_id));
        YouTubeDuration youTubeDuration = new YouTubeDuration();
        ArrayList<LessonDBO> listLesson = courseDAO.getListLessonByCourseID(String.valueOf(course_id));
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> origin/DashBoard
=======

        YouTubeDuration youTubeDuration = new YouTubeDuration();
        ArrayList<LessonDBO> listLesson = courseDAO.getListLessonByCourseID(String.valueOf(course.getId()));
>>>>>>> origin/crudlesson,sublesson
=======

        YouTubeDuration youTubeDuration = new YouTubeDuration();
        ArrayList<LessonDBO> listLesson = courseDAO.getListLessonByCourseID(String.valueOf(course.getId()));
>>>>>>> origin/develop
=======
>>>>>>> origin/AdminManager
=======

        YouTubeDuration youTubeDuration = new YouTubeDuration();
        ArrayList<LessonDBO> listLesson = courseDAO.getListLessonByCourseID(String.valueOf(course.getId()));
>>>>>>> origin/comment
=======
>>>>>>> origin/create-course1
=======
        UserDBO user = (UserDBO) session.getAttribute("user");
        UserCourseProgressDBO UserCourseProgress = quizDAO.getUserCourseProgress(user.getId(), Integer.parseInt(course_id));
        YouTubeDuration youTubeDuration = new YouTubeDuration();
        ArrayList<LessonDBO> listLesson = courseDAO.getListLessonByCourseID(String.valueOf(course_id));
>>>>>>> origin/crud_quiz
=======

        CourseDAO courseDAO = new CourseDAO();
        QuizDAO quizDAO = new QuizDAO();
        CommentDAO commentDAO = new CommentDAO();

        YouTubeDuration youTubeDuration = new YouTubeDuration();
        ArrayList<LessonDBO> listLesson = courseDAO.getListLessonByCourseID(String.valueOf(course.getId()));
>>>>>>> origin/front-end
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/crudlesson,sublesson
=======
>>>>>>> origin/develop
=======
>>>>>>> origin/comment
                                    response.sendRedirect("/E-Learning_System/course/learning" + "?a=sub&sub_lesson_id=" + subLessonId);
=======
                                    response.sendRedirect("/E-Learning_System/course/learning" + "?a=sub&sub_lesson_id=" + subLessonId+"&course_id=" + course_id);
>>>>>>> origin/crud_quiz
                                    return;
                                }
                            }
                        }
                    }
                }
            }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> origin/AdminManager
=======
>>>>>>> origin/create-course1
                                    response.sendRedirect("/E-Learning_System/course/learning" + "?a=sub&sub_lesson_id=" + subLessonId+"&course_id=" + course_id);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
            request.setAttribute("userProgress", UserCourseProgress);
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> origin/DashBoard
=======
>>>>>>> origin/crudlesson,sublesson
=======
>>>>>>> origin/develop
=======
>>>>>>> origin/AdminManager
=======
>>>>>>> origin/comment
=======
>>>>>>> origin/create-course1
=======
            request.setAttribute("userProgress", UserCourseProgress);
>>>>>>> origin/crud_quiz
=======
                                    response.sendRedirect("/E-Learning_System/course/learning" + "?a=sub&sub_lesson_id=" + subLessonId);
                                    return;
                                }
                            }
                        } 
                    }
                }
            }
>>>>>>> origin/front-end
            // Set attributes and forward to videoLearn.jsp
            request.setAttribute("comment", listComment);
            request.setAttribute("youTubeDuration", youTubeDuration);
            request.setAttribute("subLesson", subLesson);
            request.setAttribute("listLesson", listLesson);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
            request.setAttribute("courseId", course_id);
>>>>>>> origin/DashBoard
=======
>>>>>>> origin/crudlesson,sublesson
=======
>>>>>>> origin/develop
=======
            request.setAttribute("courseId", course_id);
>>>>>>> origin/AdminManager
=======
>>>>>>> origin/comment
=======
            request.setAttribute("courseId", course_id);
>>>>>>> origin/create-course1
=======
            request.setAttribute("courseId", course_id);
>>>>>>> origin/crud_quiz
=======
>>>>>>> origin/front-end
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/crudlesson,sublesson
=======
>>>>>>> origin/develop
=======
>>>>>>> origin/front-end
        CourseDBO course = (CourseDBO) session.getAttribute("course");
        String quiz_id = request.getParameter("quiz_id");
        CourseDAO courseDAO = new CourseDAO();
        ArrayList<LessonDBO> listLesson = courseDAO.getListLessonByCourseID("" + course.getId());
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> origin/create-course1
        String course_id = request.getParameter("course_id");
        String quiz_id = request.getParameter("quiz_id");
        CourseDAO courseDAO = new CourseDAO();
        ArrayList<LessonDBO> listLesson = courseDAO.getListLessonByCourseID("" + course_id);
<<<<<<< HEAD
>>>>>>> origin/DashBoard
=======
>>>>>>> origin/crudlesson,sublesson
=======
>>>>>>> origin/develop
=======
        String course_id = request.getParameter("course_id");
        String quiz_id = request.getParameter("quiz_id");
        CourseDAO courseDAO = new CourseDAO();
        ArrayList<LessonDBO> listLesson = courseDAO.getListLessonByCourseID("" + course_id);
>>>>>>> origin/AdminManager
=======
>>>>>>> origin/create-course1
=======
        String course_id = request.getParameter("course_id");
        String quiz_id = request.getParameter("quiz_id");
        CourseDAO courseDAO = new CourseDAO();
        ArrayList<LessonDBO> listLesson = courseDAO.getListLessonByCourseID("" + course_id);
>>>>>>> origin/crud_quiz
=======
>>>>>>> origin/front-end
        UserDBO user = (UserDBO) session.getAttribute("user");
        YouTubeDuration youTubeDuration = new YouTubeDuration();
        QuizDAO quizDAO = new QuizDAO();
        UserDAO userDAO = new UserDAO();

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        if (listQuestions == null) {
=======
        // Check for necessary session attributes and parameters
        if (listQuestions == null || quiz_id == null || user == null) {
>>>>>>> origin/DashBoard
=======
        if (listQuestions == null) {
>>>>>>> origin/crudlesson,sublesson
=======
        if (listQuestions == null) {
>>>>>>> origin/develop
=======
        // Check for necessary session attributes and parameters
        if (listQuestions == null || quiz_id == null || user == null) {
>>>>>>> origin/AdminManager
=======
        // Check for necessary session attributes and parameters
        if (listQuestions == null || quiz_id == null || user == null) {
>>>>>>> origin/create-course1
=======
        // Check for necessary session attributes and parameters
        if (listQuestions == null || quiz_id == null || user == null) {
>>>>>>> origin/crud_quiz
=======
        if (listQuestions == null) {
>>>>>>> origin/front-end
            response.sendRedirect("quiz.jsp");
            return;
        }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
        // Process and store correct answers for each question
>>>>>>> origin/DashBoard
=======
>>>>>>> origin/crudlesson,sublesson
=======
>>>>>>> origin/develop
=======
        // Process and store correct answers for each question
>>>>>>> origin/AdminManager
=======
        // Process and store correct answers for each question
>>>>>>> origin/create-course1
=======
        // Process and store correct answers for each question
>>>>>>> origin/crud_quiz
=======
>>>>>>> origin/front-end
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        // Iterate over the list of questions to retrieve user responses
=======
        // Retrieve user responses for each question
>>>>>>> origin/DashBoard
=======
        // Iterate over the list of questions to retrieve user responses
>>>>>>> origin/crudlesson,sublesson
=======
        // Iterate over the list of questions to retrieve user responses
>>>>>>> origin/develop
=======
        // Retrieve user responses for each question
>>>>>>> origin/AdminManager
=======
        // Retrieve user responses for each question
>>>>>>> origin/create-course1
=======
        // Retrieve user responses for each question
>>>>>>> origin/crud_quiz
=======
        // Iterate over the list of questions to retrieve user responses
>>>>>>> origin/front-end
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/crudlesson,sublesson
=======
>>>>>>> origin/develop
=======

>>>>>>> origin/AdminManager
=======

>>>>>>> origin/crud_quiz
        session.setAttribute("userAnswers", userAnswers);

        // Calculate user score
        int score = calculateScore(listQuestions, userAnswers);
<<<<<<< HEAD
<<<<<<< HEAD
=======
        session.setAttribute("userAnswers", userAnswers);

        // Process user answers (e.g., calculate score, store results, etc.)
        int score = calculateScore(listQuestions, userAnswers);
>>>>>>> origin/front-end
        if (userDAO.checkUserScoreByIdExitd(user.getId(), Integer.parseInt(quiz_id))) {
            quizDAO.UpdateScoreMentee(score, user.getId(), Integer.parseInt(quiz_id));
        } else {
            quizDAO.insertScoreMentee(user.getId(), Integer.parseInt(quiz_id), score);
<<<<<<< HEAD
=======
=======
>>>>>>> origin/crud_quiz

        // Calculate total number of quizzes for the course
        int totalQuiz = quizDAO.getListQuizByCourse(Integer.parseInt(course_id)).size();    

        // Ensure totalQuiz is not zero to avoid division by zero
        if (totalQuiz == 0) {
            response.sendRedirect("quiz.jsp");
            return;
<<<<<<< HEAD
>>>>>>> origin/AdminManager
=======
>>>>>>> origin/crud_quiz
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
<<<<<<< HEAD
<<<<<<< HEAD
        request.setAttribute("score", score);
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> origin/create-course1

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
<<<<<<< HEAD
>>>>>>> origin/DashBoard
=======
>>>>>>> origin/crudlesson,sublesson
=======
>>>>>>> origin/develop
=======
        request.setAttribute("menteeScore", menteeScore);
        request.setAttribute("userProgress", userCourseProgress);
>>>>>>> origin/AdminManager
=======
>>>>>>> origin/create-course1
=======
        request.setAttribute("menteeScore", menteeScore);
        request.setAttribute("userProgress", userCourseProgress);
>>>>>>> origin/crud_quiz
=======
        }
        // Store the score and user answers in the request or session
        request.setAttribute("score", score);
>>>>>>> origin/front-end
        request.setAttribute("quiz_id", quiz_id);
        request.setAttribute("userAnswers", userAnswers);
        request.setAttribute("listLesson", listLesson);
        request.setAttribute("youtobeDuration", youTubeDuration);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/crudlesson,sublesson
=======
>>>>>>> origin/develop
=======
        request.setAttribute("courseId", course_id);

>>>>>>> origin/AdminManager
=======
>>>>>>> origin/comment
=======
        request.setAttribute("courseId", course_id);

>>>>>>> origin/crud_quiz
        // Forward to the result page
        request.getRequestDispatcher("/result-quiz.jsp").forward(request, response);
    }
// Helper method to calculate the score
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> origin/create-course1
        request.setAttribute("courseId", course_id);

        // Forward to the result page
        request.getRequestDispatcher("/result-quiz.jsp").forward(request, response);
    }
// Helper method to calculate the score

<<<<<<< HEAD
>>>>>>> origin/DashBoard
=======
>>>>>>> origin/crudlesson,sublesson
=======
>>>>>>> origin/develop
=======

>>>>>>> origin/AdminManager
=======
>>>>>>> origin/create-course1
=======

>>>>>>> origin/crud_quiz
=======
        // Forward to the result page
        request.getRequestDispatcher("/result-quiz.jsp").forward(request, response);
    }

// Helper method to calculate the score
>>>>>>> origin/front-end
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

}
=======
}
>>>>>>> origin/create-course1
=======
}
>>>>>>> origin/crud_quiz
=======

}
>>>>>>> origin/front-end
