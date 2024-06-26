/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package UserManagermentController;

import Dal.UserDAO;
import Model.UserDBO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Paths;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author ADMIN
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 12)

public class UpdateProfileController extends HttpServlet {

    private static final String UPLOAD_DIRECTORY = "E:\\E-Learning_System\\web\\img";

    private static final long serialVersionUID = 1L;

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
            out.println("<title>Servlet UpdateProfileController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateProfileController at " + request.getContextPath() + "</h1>");
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
        UserDAO dao = new UserDAO();
        UserDBO user = (UserDBO) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            String firstName = request.getParameter("firstname");
            String lastName = request.getParameter("lastname");
            String email = request.getParameter("email");

            if (dao.checkEmailExisted(email) && !email.equals(user.getEmail())) {
                request.setAttribute("errorEmail", "Email has been existed!!!");
                request.getRequestDispatcher("editProfile.jsp").forward(request, response);
                return;
            }

            Part part = request.getPart("avatar");
            boolean isAvatarUploaded = part != null && part.getSize() > 0;

            String fileName = null;

            if (firstName.matches("^[a-zA-Z0-9]+$") && lastName.matches("^[a-zA-Z0-9]+$")) {
                dao.updateProfileUser(firstName, lastName, email, user.getId());
                if (isAvatarUploaded) {
                String submittedFileName = part.getSubmittedFileName();
                if (submittedFileName == null || submittedFileName.isEmpty()) {
                    throw new ServletException("File name is invalid.");
                }
                fileName = Paths.get(submittedFileName).getFileName().toString();

                Path uploadDir = Paths.get(UPLOAD_DIRECTORY);
                if (!Files.exists(uploadDir)) {
                    Files.createDirectories(uploadDir);
                }

                String contentType = part.getContentType();
                if (contentType == null || !contentType.startsWith("image/")) {
                    throw new ServletException("Only image files are allowed.");
                }

                Path filePath = uploadDir.resolve(fileName);
                part.write(filePath.toString());
            }

            if (isAvatarUploaded) {
                dao.updateProfileUserByAvatar(firstName, lastName, "img\\" + fileName, email, user.getId());
            } else {
                dao.updateProfileUser(firstName, lastName, email, user.getId());
            }

            session.setAttribute("user", dao.getUserByID("" + user.getId()));
            request.getRequestDispatcher("editProfile.jsp").forward(request, response);
            } else {
                request.setAttribute(email, dao);
                request.getRequestDispatcher("editProfile.jsp").forward(request, response);
            }

            

        } catch (ServletException | IOException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("Error occurred: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("Unexpected error occurred: " + e.getMessage());
        }
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
