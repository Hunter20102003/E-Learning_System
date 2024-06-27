/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package QuizManagementController;

import Dal.CourseDAO;
import Dal.QuizDAO;
import Dal.UserDAO;
import Model.AnswersDBO;
import Model.LessonDBO;
import Model.MenteeScoreDBO;
import Model.QuestionsDBO;
import Model.UserCourseProgressDBO;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author ADMIN
 */
public class ResultCommentQuizController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet ResultCommentQuizController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResultCommentQuizController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       HttpSession session = request.getSession();
        List<QuestionsDBO> listQuestions = (List<QuestionsDBO>) session.getAttribute("listQuestions");

        String course_id = request.getParameter("course_id");
        String quiz_id = request.getParameter("quiz_id");
        CourseDAO courseDAO = new CourseDAO();
        ArrayList<LessonDBO> listLesson = courseDAO.getListLessonByCourseID(course_id);
        UserDBO user = (UserDBO) session.getAttribute("user");
        YouTubeDuration youTubeDuration = new YouTubeDuration();
        QuizDAO quizDAO = new QuizDAO();
        UserDAO userDAO = new UserDAO();
        UserCourseProgressDBO UserCourseProgress = quizDAO.getUserCourseProgress(user.getId(), Integer.parseInt(course_id));

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
        MenteeScoreDBO menteeScore = quizDAO.getScoreByUserIdQuizId(user.getId(), Integer.parseInt(quiz_id));

        // Store the score and user answers in the request or session
        request.setAttribute("menteeScore", menteeScore);
        request.setAttribute("quiz_id", quiz_id);
        request.setAttribute("listLesson", listLesson);
        request.setAttribute("youtobeDuration", youTubeDuration);
        request.setAttribute("courseId", course_id);
        request.setAttribute("userProgress", UserCourseProgress);
        // Forward to the result page
        request.getRequestDispatcher("/result-quiz.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
