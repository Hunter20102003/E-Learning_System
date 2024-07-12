/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package CourseManagementController;

import Dal.CommentDAO;
import Dal.CourseDAO;
import Dal.QuizDAO;
import Model.CommentDBO;
import Model.CourseDBO;
import Model.LessonDBO;
import Model.QuestionsDBO;
import Model.QuizDBO;
import Model.SubLessonDBO;
import Model.UserDBO;
import YoutobeDataAPI.YouTubeDuration;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LEGION
 */
public class CourseLearningController extends HttpServlet {

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
            out.println("<title>Servlet CourseLearnController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CourseLearnController at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
<<<<<<< HEAD
<<<<<<< HEAD
        
=======
>>>>>>> origin/AdminManager
=======
>>>>>>> origin/comment
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        CourseDBO course = (CourseDBO) session.getAttribute("course");
        if (course == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String subLessonId = request.getParameter("sub_lesson_id");
        String quizId = request.getParameter("quiz_id");
        String action = request.getParameter("action");
        String a = request.getParameter("a");

        CourseDAO courseDAO = new CourseDAO();
        CommentDAO commentDAO = new CommentDAO();
        QuizDAO quizDAO = new QuizDAO();

        YouTubeDuration youTubeDuration = new YouTubeDuration();
        ArrayList<LessonDBO> listLesson = courseDAO.getListLessonByCourseID(String.valueOf(course.getId()));
        ArrayList<CommentDBO> listComment = new ArrayList<>();
        SubLessonDBO subLesson = null;

        try {
            // Handle navigation actions (next/previous)
            if ("next".equals(action) || "previous".equals(action)) {
                if (subLessonId != null && !subLessonId.isEmpty()) {
                    int subLessonIdInt = Integer.parseInt(subLessonId);
                    Map<Integer, LessonDBO> subLessonIdToLessonMap = new HashMap<>();

                    // Build mapping of sub-lesson IDs to lessons
                    for (LessonDBO lesson : listLesson) {
                        List<SubLessonDBO> subLessons = lesson.getSub_lesson_list();
                        for (SubLessonDBO subLesson1 : subLessons) {
                            subLessonIdToLessonMap.put(subLesson1.getId(), lesson);
                        }
                    }

                    // Retrieve the lesson containing the current sub-lesson
                    LessonDBO lesson = subLessonIdToLessonMap.get(subLessonIdInt);

                    if (lesson != null) {
                        List<SubLessonDBO> subLessons = lesson.getSub_lesson_list();
                        int currentIndex = -1;

                        // Find the index of the current sub-lesson in the lesson's list
                        for (int i = 0; i < subLessons.size(); i++) {
                            if (subLessons.get(i).getId() == subLessonIdInt) {
                                currentIndex = i;
                                break;
                            }
                        }

                        int newSubLessonId = -1;
                        boolean isLastSubLesson = false;

                        if ("next".equals(action)) {
                            if (currentIndex < subLessons.size() - 1) {
                                newSubLessonId = subLessons.get(currentIndex + 1).getId();
                            } else {
                                // If it's the last sub-lesson, set flag
                                isLastSubLesson = true;
                            }
                        } else if ("previous".equals(action)) {
                            if (currentIndex > 0) {
                                newSubLessonId = subLessons.get(currentIndex - 1).getId();
                            } else {
<<<<<<< HEAD
                                // Handle going to the previous lesson's last sub-lesson
                                LessonDBO prevLesson = null;
                                for (int j = listLesson.indexOf(lesson) - 1; j >= 0; j--) {
                                    prevLesson = listLesson.get(j);
                                    List<SubLessonDBO> prevSubLessons = prevLesson.getSub_lesson_list();
                                    if (!prevSubLessons.isEmpty()) {
                                        newSubLessonId = prevSubLessons.get(prevSubLessons.size() - 1).getId();
                                        break;
                                    }
                                }
                                // If previous lesson found, update lesson variable
                                lesson = prevLesson;
                            }
                        }

                        // If it's the last sub-lesson, update session attributes
                        if (isLastSubLesson) {
                            Integer lastSubLessonCount = (Integer) session.getAttribute("lastSubLessonCount");
                            if (lastSubLessonCount == null) {
                                lastSubLessonCount = 0; // Set default value if null
                            }
                            lastSubLessonCount++; // Increment the count
                            session.setAttribute("lastSubLessonCount", lastSubLessonCount);
                        }

                        // Check if we need to redirect to a quiz after the last sub-lesson
                        if (isLastSubLesson) {
                            Integer lastSubLessonCount = (Integer) session.getAttribute("lastSubLessonCount");
                            if (lastSubLessonCount != null) {
                                List<QuizDBO> quizLessons = lesson.getQuiz_lesson_list();
                                if (quizLessons != null && !quizLessons.isEmpty()) {
                                    int quizIndex = (lastSubLessonCount - 1) % quizLessons.size(); // Ensure 0-based index
                                    QuizDBO quiz = quizLessons.get(quizIndex);
                                    quizId = String.valueOf(quiz.getQuizId());
                                    response.sendRedirect(request.getRequestURI() + "?a=quiz&quiz_id=" + quizId);
                                    return;
                                } else {
                                    // After the last quiz, redirect to the next lesson's first sub-lesson
                                    int nextLessonIndex = listLesson.indexOf(lesson) + 1;
                                    if (nextLessonIndex < listLesson.size()) {
                                        LessonDBO nextLesson = listLesson.get(nextLessonIndex);
                                        if (!nextLesson.getSub_lesson_list().isEmpty()) {
                                            newSubLessonId = nextLesson.getSub_lesson_list().get(0).getId();
                                            response.sendRedirect(request.getRequestURI() + "?a=sub&sub_lesson_id=" + newSubLessonId);
                                            return;
                                        }
                                    }
                                }
                            }
                        }

                        // Redirect to the next or previous sub-lesson
                        if (newSubLessonId != -1) {
                            response.sendRedirect(request.getRequestURI() + "?a=sub&sub_lesson_id=" + newSubLessonId);
                            return;
                        } else {
                            // Handle edge case if no new sub-lesson found
                            response.sendRedirect(request.getRequestURI() + "?a=sub&sub_lesson_id=" + subLessonIdInt);
                            return;
                        }
=======
                                // Handle going to the previous lesson's last quiz
                                LessonDBO prevLesson = null;
                                for (int j = listLesson.indexOf(lesson) - 1; j >= 0; j--) {
                                    prevLesson = listLesson.get(j);
                                    List<QuizDBO> prevQuizzes = prevLesson.getQuiz_lesson_list();
                                    if (!prevQuizzes.isEmpty()) {
                                        // Move to the last quiz of the previous lesson
                                        newSubLessonId = prevQuizzes.get(prevQuizzes.size() - 1).getQuizId();
                                        response.sendRedirect(request.getRequestURI() + "?a=quiz&quiz_id=" + newSubLessonId);
                                        return;
                                    }
                                }
                                // If previous lesson found, update lesson variable
                                if (prevLesson != null) {
                                    lesson = prevLesson;
                                }
                            }
                        }
                        // If it's the last sub-lesson, update session attributes
                        if (isLastSubLesson) {
                            Integer lastSubLessonCount = (Integer) session.getAttribute("lastSubLessonCount");
                            if (lastSubLessonCount == null) {
                                lastSubLessonCount = 0; // Set default value if null
                            }
                            lastSubLessonCount++; // Increment the count
                            session.setAttribute("lastSubLessonCount", lastSubLessonCount);
                        }

                        // Check if we need to redirect to a quiz after the last sub-lesson
                        if (isLastSubLesson) {
                            Integer lastSubLessonCount = (Integer) session.getAttribute("lastSubLessonCount");
                            if (lastSubLessonCount != null) {
                                List<QuizDBO> quizLessons = lesson.getQuiz_lesson_list();
                                if (quizLessons != null && !quizLessons.isEmpty()) {
                                    int quizIndex = (lastSubLessonCount - 1) % quizLessons.size(); // Ensure 0-based index
                                    QuizDBO quiz = quizLessons.get(quizIndex);
                                    quizId = String.valueOf(quiz.getQuizId());
                                    response.sendRedirect(request.getRequestURI() + "?a=quiz&quiz_id=" + quizId);
                                    return;
                                } else {
                                    // After the last quiz, redirect to the next lesson's first sub-lesson
                                    int nextLessonIndex = listLesson.indexOf(lesson) + 1;
                                    if (nextLessonIndex < listLesson.size()) {
                                        LessonDBO nextLesson = listLesson.get(nextLessonIndex);
                                        if (!nextLesson.getSub_lesson_list().isEmpty()) {
                                            newSubLessonId = nextLesson.getSub_lesson_list().get(0).getId();
                                            response.sendRedirect(request.getRequestURI() + "?a=sub&sub_lesson_id=" + newSubLessonId);
                                            return;
                                        }
                                    }
                                }
                            }
                        }

                        // Redirect to the next or previous sub-lesson
                        if (newSubLessonId != -1) {
                            response.sendRedirect(request.getRequestURI() + "?a=sub&sub_lesson_id=" + newSubLessonId);
                            return;
                        } else {
                            // Handle edge case if no new sub-lesson found
                            response.sendRedirect(request.getRequestURI() + "?a=sub&sub_lesson_id=" + subLessonIdInt);
                            return;
                        }
>>>>>>> origin/comment
                    } else {
                        // Handle case where lesson is not found for given subLessonId
                        response.sendRedirect(request.getRequestURI()); // Example redirect
                        return;
                    }
                }
            }
<<<<<<< HEAD
            
            // If both sub_lesson_id and quiz_id are null, set to the first sub-lesson or quiz
            if (subLessonId == null && quizId == null) {
                if (!listLesson.isEmpty()) {
                    LessonDBO firstLesson = listLesson.get(0);
                    if (firstLesson != null) {
                        if (!firstLesson.getSub_lesson_list().isEmpty()) {
                            subLesson = firstLesson.getSub_lesson_list().get(0);
                            subLessonId = String.valueOf(subLesson.getId());
                            response.sendRedirect(request.getRequestURI() + "?a=sub&sub_lesson_id=" + subLessonId);
                            return;
                        } else if (!firstLesson.getQuiz_lesson_list().isEmpty()) {
                            QuizDBO firstQuiz = firstLesson.getQuiz_lesson_list().get(0);
                            quizId = String.valueOf(firstQuiz.getQuizId());
                            response.sendRedirect(request.getRequestURI() + "?a=quiz&quiz_id=" + quizId);
                            return;
                        }
                    }
                }
            } else {
                // Handle requests for sub-lessons or quizzes
                if ("sub".equals(a)) {
                    subLesson = courseDAO.getSubLessonByID(Integer.parseInt(subLessonId));
                    listComment = commentDAO.getCommentsFromDatabase(Integer.parseInt(subLessonId));
                } else if ("quiz".equals(a)) {
                    try {
                        int quizIdInt = Integer.parseInt(quizId);
                        QuizDBO quiz = quizDAO.getQuizById(quizIdInt);
                        ArrayList<QuestionsDBO> listQuestions = quizDAO.getListQuestionsByQuizID(quizIdInt);

                        // Retrieve and possibly merge user answers
                        @SuppressWarnings("unchecked")
                        Map<Integer, List<Integer>> userAnswers = (Map<Integer, List<Integer>>) session.getAttribute("userAnswers");
                        String userAnswersLocalStorage = (String) session.getAttribute("userAnswersLocalStorage");

                        // Logic to handle user answers from local storage
                        // Set attributes and forward to quiz.jsp for rendering
                        session.setAttribute("listQuestions", listQuestions);
                        session.setAttribute("userAnswers", userAnswers);
                        request.setAttribute("youtobeDuration", youTubeDuration);
                        request.setAttribute("quiz_id", quizId);
                        request.setAttribute("quiz", quiz);
                        request.setAttribute("listLesson", listLesson);
                        request.setAttribute("userAnswers", userAnswers);

=======

            // If both sub_lesson_id and quiz_id are null, set to the first sub-lesson or quiz
            if (subLessonId == null && quizId == null) {
                if (!listLesson.isEmpty()) {
                    LessonDBO firstLesson = listLesson.get(0);
                    if (firstLesson != null) {
                        if (!firstLesson.getSub_lesson_list().isEmpty()) {
                            subLesson = firstLesson.getSub_lesson_list().get(0);
                            subLessonId = String.valueOf(subLesson.getId());
                            response.sendRedirect(request.getRequestURI() + "?a=sub&sub_lesson_id=" + subLessonId);
                            return;
                        } else if (!firstLesson.getQuiz_lesson_list().isEmpty()) {
                            QuizDBO firstQuiz = firstLesson.getQuiz_lesson_list().get(0);
                            quizId = String.valueOf(firstQuiz.getQuizId());
                            response.sendRedirect(request.getRequestURI() + "?a=quiz&quiz_id=" + quizId);
                            return;
                        }
                    }
                }
            } else {
                // Handle requests for sub-lessons or quizzes
                if ("sub".equals(a)) {
                    subLesson = courseDAO.getSubLessonByID(Integer.parseInt(subLessonId));
                    listComment = commentDAO.getCommentsFromDatabase(Integer.parseInt(subLessonId));
                } else if ("quiz".equals(a)) {
                    try {
                        int quizIdInt = Integer.parseInt(quizId);
                        QuizDBO quiz = quizDAO.getQuizById(quizIdInt);
                        ArrayList<QuestionsDBO> listQuestions = quizDAO.getListQuestionsByQuizID(quizIdInt);

                        // Retrieve and possibly merge user answers
                        @SuppressWarnings("unchecked")
                        Map<Integer, List<Integer>> userAnswers = (Map<Integer, List<Integer>>) session.getAttribute("userAnswers");
                        String userAnswersLocalStorage = (String) session.getAttribute("userAnswersLocalStorage");

                        // Logic to handle user answers from local storage
                        // Set attributes and forward to quiz.jsp for rendering
                        session.setAttribute("listQuestions", listQuestions);
                        session.setAttribute("userAnswers", userAnswers);
                        request.setAttribute("youtobeDuration", youTubeDuration);
                        request.setAttribute("quiz_id", quizId);
                        request.setAttribute("quiz", quiz);
                        request.setAttribute("listLesson", listLesson);
                        request.setAttribute("userAnswers", userAnswers);

>>>>>>> origin/comment
                        request.getRequestDispatcher("/quiz.jsp").forward(request, response);
                        return;
                    } catch (NumberFormatException e) {
                        response.sendRedirect("course.jsp");
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        response.sendRedirect("error.jsp");
                        return;
                    }
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Log the error
        }

        // Set attributes and forward to videoLearn.jsp
        request.setAttribute("comment", listComment);
        request.setAttribute("youtobeDuration", youTubeDuration);
        request.setAttribute("subLesson", subLesson);
        request.setAttribute("listLesson", listLesson);
        request.getRequestDispatcher("/videoLearn.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        CourseDBO course = (CourseDBO) session.getAttribute("course");
        String sub_lesson_id = request.getParameter("sub_lesson_id");
        String content = request.getParameter("content");
        String comment_id = request.getParameter("comment_id");
        String comment = request.getParameter("comment");
        String submitComment = request.getParameter("submitComment");
        String deleteComment = request.getParameter("deleteComment");
        String user_id = request.getParameter("userId");

        CourseDAO courseDAO = new CourseDAO();
        CommentDAO commentDAO = new CommentDAO();

        UserDBO user = (UserDBO) session.getAttribute("user");
        ArrayList<LessonDBO> listLesson = courseDAO.getListLessonByCourseID(String.valueOf(course.getId()));
        SubLessonDBO subLesson = courseDAO.getSubLessonByID(Integer.parseInt(sub_lesson_id));

        try {

            if ("0".equals(comment)) { // Insert root comment
                if (!content.isEmpty()) {
                    commentDAO.InsertComment(null, Integer.parseInt(sub_lesson_id), user.getId(), content);
                }
            } else if ("1".equals(comment)) { // Insert reply comment
                if (!content.isEmpty() && comment_id != null) {
                    commentDAO.InsertComment(comment_id, Integer.parseInt(sub_lesson_id), user.getId(), content);
                }
            }
            // Retrieve updated comments after actions
            ArrayList<CommentDBO> listComment = commentDAO.getCommentsFromDatabase(Integer.parseInt(sub_lesson_id));

            // Set attributes for JSP
            request.setAttribute("listLesson", listLesson);
            request.setAttribute("subLesson", subLesson);
            request.setAttribute("comment", listComment);
        } catch (Exception e) {
            // Handle exceptions appropriately
            e.printStackTrace(); // Or log the exception
        }

        // Forward to JSP page
        request.getRequestDispatcher("/videoLearn.jsp").forward(request, response);
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
