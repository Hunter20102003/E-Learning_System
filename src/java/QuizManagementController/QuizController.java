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
import Model.QuestionsDBO;
import Model.QuizDBO;
import Model.SubLessonDBO;
import Model.UserDBO;
import YoutobeDataAPI.YouTubeDuration;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        CourseDBO course = (CourseDBO) session.getAttribute("course");
        UserDBO user = (UserDBO) session.getAttribute("user");

        if (course == null || user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String quiz_id = request.getParameter("quiz_id");
        if (quiz_id == null || quiz_id.isEmpty()) {
            response.sendRedirect("course.jsp");
            return;
        }

        try {
            int quizIdInt = Integer.parseInt(quiz_id);
            CourseDAO courseDAO = new CourseDAO();
            QuizDAO quizDAO = new QuizDAO();

            ArrayList<LessonDBO> listLesson = courseDAO.getListLessonByCourseID(String.valueOf(course.getId()));
            QuizDBO quiz = quizDAO.getQuizById(quizIdInt);
            ArrayList<QuestionsDBO> listQuestions = quizDAO.getListQuestionsByQuizID(quizIdInt);

            // Retrieve user answers from session
            Map<Integer, List<Integer>> userAnswers = (Map<Integer, List<Integer>>) session.getAttribute("userAnswers");

            // Add userAnswers from localStorage if available
            String userAnswersLocalStorage = (String) session.getAttribute("userAnswersLocalStorage");
           
            // Set listQuestions and userAnswers in session
            session.setAttribute("listQuestions", listQuestions);
            session.setAttribute("userAnswers", userAnswers);

            // Forward attributes to quiz.jsp for rendering
            request.setAttribute("quiz_id", quiz_id);
            request.setAttribute("quiz", quiz);
            request.setAttribute("listLesson", listLesson);
            request.setAttribute("userAnswers", userAnswers);

            request.getRequestDispatcher("/quiz.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendRedirect("course.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
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
        CourseDBO course = (CourseDBO) session.getAttribute("course");
        String quiz_id = request.getParameter("quiz_id");
        CourseDAO courseDAO = new CourseDAO();
        ArrayList<LessonDBO> listLesson = courseDAO.getListLessonByCourseID("" + course.getId());
        UserDBO user = (UserDBO) session.getAttribute("user");
        QuizDAO quizDAO = new QuizDAO();
        UserDAO userDAO = new UserDAO();

        if (listQuestions == null) {
            response.sendRedirect("quiz.jsp");
            return;
        }

        for (QuestionsDBO question : listQuestions) {
            List<Integer> correctAnswers = question.getAnswers_list().stream()
                    .filter(AnswersDBO::isIsCorrect)
                    .map(AnswersDBO::getAnswerId)
                    .collect(Collectors.toList());
            question.setCorrectAnswerIds(correctAnswers); // Ensure this method exists in QuestionsDBO
        }

        // Map to store the question ID and the selected answer IDs
        Map<Integer, List<Integer>> userAnswers = new HashMap<>();

        // Iterate over the list of questions to retrieve user responses
        for (QuestionsDBO question : listQuestions) {
            String[] selectedAnswers = request.getParameterValues("q" + question.getQuestionId());
            if (selectedAnswers != null) {
                List<Integer> answerIds = Arrays.stream(selectedAnswers)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                userAnswers.put(question.getQuestionId(), answerIds);
            }
        }
        session.setAttribute("userAnswers", userAnswers);

        // Process user answers (e.g., calculate score, store results, etc.)
        int score = calculateScore(listQuestions, userAnswers);
        if (userDAO.checkUserScoreByIdExitd(user.getId(), Integer.parseInt(quiz_id))) {
            quizDAO.UpdateScoreMentee( score, user.getId(),Integer.parseInt(quiz_id));
        } else {
            quizDAO.insertScoreMentee(user.getId(), Integer.parseInt(quiz_id), score);
        }
        // Store the score and user answers in the request or session
        request.setAttribute("score", score);
        request.setAttribute("quiz_id", quiz_id);
        request.setAttribute("userAnswers", userAnswers);
        request.setAttribute("listLesson", listLesson);
        // Forward to the result page
        request.getRequestDispatcher("/result-quiz.jsp").forward(request, response);
    }

// Helper method to calculate the score
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
