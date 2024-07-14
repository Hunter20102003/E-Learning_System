package UserManagermentController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Dal.CourseDAO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import static UserManagementController.Google.GoogleLogin.getToken;
import static UserManagementController.Google.GoogleLogin.getUserInfo;
import Dal.UserDAO;
import Model.CourseDBO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Model.UserDBO;
import Model.UserGoogleDto;

public class GoogleLoginController extends HttpServlet {

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
        HttpSession session = request.getSession();
        String course_id = request.getParameter("course_id");
        if (course_id != null) {

            if (session.getAttribute("course_idSession") == null) {
                session.setAttribute("course_idSession", course_id);
            }
        }
        String course_idSession = (String) session.getAttribute("course_idSession");
        String code = request.getParameter("code");
        String accessToken = getToken(code);
        if (accessToken == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        UserGoogleDto userFromGoogle = getUserInfo(accessToken);
        UserDAO dao = new UserDAO();
        UserDBO user = null;
        String action = (String) session.getAttribute("action");

        if (userFromGoogle != null) {
            String email = userFromGoogle.getEmail();
            String firstName = userFromGoogle.getFamily_name();
            String lastName = userFromGoogle.getGiven_name();
            String img = userFromGoogle.getPicture();
            if (dao.checkEmailExisted(email)) {
                user = dao.getUserByEmail(email);
                session.setAttribute("user", user);

            } else {
                int n = dao.addUserByGoogleLogin(firstName, lastName, email, img);
                if (n > 0) {
                    user = dao.getUserByEmail(email);
                    session.setAttribute("user", user);

                }
            }
        }
        if (course_idSession != null) {
            response.sendRedirect("course/detail?course_id=" + course_idSession);
            session.removeAttribute("course_idSession");

        } else {
            response.sendRedirect("home");
            

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the +
    // sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
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
