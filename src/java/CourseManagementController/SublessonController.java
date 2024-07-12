/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package CourseManagementController;

import Dal.CourseDAO;
import Model.CourseDBO;
import Model.SubLessonDBO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import YoutobeDataAPI.YouTubeDuration;

/**
 *
 * @author LEGION
 */
public class SublessonController extends HttpServlet {

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
            out.println("<title>Servlet SublessonController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SublessonController at " + request.getContextPath() + "</h1>");
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
    private CourseDAO courseDao = new CourseDAO();

<<<<<<< HEAD
    private void addSublesson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String description = request.getParameter("description");
        String videoLink = request.getParameter("videoLink");
        String active = request.getParameter("active");
        String lessonId = request.getParameter("lessonId");

        String direct = "";
        try {
            if (title.isBlank() || content.isBlank() || description.isBlank() || videoLink.isBlank()) {
                request.setAttribute("errorMess", "Please provide complete information about sublesson");

            } else {
                if (YouTubeDuration.isValidYouTubeUrl(videoLink)) {
                    request.setAttribute("errorMess", "Video Link is invalid");

                } else {
                    String idVideo = YouTubeDuration.getYouTubeId(videoLink);
                    String embedLink = YouTubeDuration.convertToEmbedLink(idVideo);
                    long duration = YouTubeDuration.getVideoDuration(idVideo);
                    int check = courseDao.addSubLesson(title, content, description, Integer.parseInt(lessonId), embedLink, duration);
                    if (check > 0) {
                        response.sendRedirect("CourseContentManagement");
                        return;
                    }

                }
            }
        } catch (NullPointerException e) {

        }
        request.setAttribute("title", title);
        request.setAttribute("content", content);
        request.setAttribute("description", description);
        request.setAttribute("videoLink", videoLink);
        request.setAttribute("active", active);
        request.getRequestDispatcher("create-sublesson.jsp").forward(request, response);
    }

    private void editSublesson(HttpServletRequest request, HttpServletResponse response) {

    }

=======
>>>>>>> origin/create-course1
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
<<<<<<< HEAD
        String lessonId = request.getParameter("lessonId");
=======
>>>>>>> origin/create-course1

        if (action != null) {
            request.setAttribute("action", action);

<<<<<<< HEAD
            if (lessonId != null) {
                request.setAttribute("lesson", courseDao.getLessonByID(lessonId));
            }
            switch (action) {
                case "addSublesson":
                    String title = request.getParameter("title");
                    String content = request.getParameter("content");
                    String description = request.getParameter("description");
                    String videoLink = request.getParameter("videoLink");
                    String active = request.getParameter("active");

                    try {
                        if (title.isBlank() || content.isBlank() || description.isBlank() || videoLink.isBlank() || active == null) {
                            request.setAttribute("errorMess", "Please provide complete information about sublesson");

                        } else {
                            if (!YouTubeDuration.isValidYouTubeUrl(videoLink)) {
                                request.setAttribute("errorMess", "Video Link is invalid");

                            } else {
                                String idVideo = YouTubeDuration.getYouTubeId(videoLink);
                                String embedLink = YouTubeDuration.convertToEmbedLink(videoLink);
                                long duration = YouTubeDuration.getVideoDuration(idVideo);
                                int check = courseDao.addSubLesson(title, content, description, Integer.parseInt(lessonId), embedLink, duration);
                                if (check > 0) {
                                    response.sendRedirect("CourseContentManagement");
                                    return;
                                } else {
                                    request.setAttribute("errorMess", "Add sublesson falure");

                                }

                            }
                        }
                    } catch (NullPointerException e) {

                    }
                    request.setAttribute("lessonId", lessonId);
                    request.setAttribute("title", title);
                    request.setAttribute("content", content);
                    request.setAttribute("description", description);
                    request.setAttribute("videoLink", videoLink);
                    request.setAttribute("active", active == null ? 0 : active);
                    request.getRequestDispatcher("create-sublesson.jsp").forward(request, response);
                    break;
                case "editSublesson":
                    title = request.getParameter("title");
                    content = request.getParameter("content");
                    description = request.getParameter("description");
                    videoLink = request.getParameter("videoLink");
                    active = request.getParameter("active");
                    String subLessonId = request.getParameter("subLessonId");

                    try {
                        if (title.isBlank() || content.isBlank() || description.isBlank() || videoLink.isBlank() || active == null) {
                            request.setAttribute("errorMess", "Please provide complete information about sublesson");

                        } else {
                            if (!YouTubeDuration.isValidYouTubeUrl(videoLink)) {
                                request.setAttribute("errorMess", "Video Link is invalid");

                            } else {
                                String idVideo = YouTubeDuration.getYouTubeId(videoLink);
                                String embedLink = YouTubeDuration.convertToEmbedLink(videoLink);
                                long duration = YouTubeDuration.getVideoDuration(idVideo);
                                int check = courseDao.editSubLesson(title, content, description, embedLink, duration, Integer.parseInt(subLessonId));
                                if (check > 0) {
                                    response.sendRedirect("CourseContentManagement");
                                    return;
                                } else {
                                    request.setAttribute("errorMess", "Add sublesson falure");

                                }

                            }
                        }
                    } catch (NullPointerException e) {

                    }
                    SubLessonDBO sl = courseDao.getSubLessonByID(Integer.parseInt(subLessonId));
                    if (sl != null) {
                        request.setAttribute("title", sl.getTitle());
                        request.setAttribute("content", sl.getContent());
                        request.setAttribute("description", sl.getDescription());
                        request.setAttribute("videoLink", sl.getVideo_link());
                        request.setAttribute("active", sl.isIs_locked() == false ? 0 : 1);

                    }
                    request.setAttribute("lessonId", lessonId);

                    request.setAttribute("subLessonId", subLessonId);
                    request.getRequestDispatcher("edit-sublesson.jsp").forward(request, response);

                    break;
                default:
                    String idSublesson = request.getParameter("subLessonId");
                    int check = courseDao.removeSubLesson(Integer.parseInt(idSublesson));
                    response.sendRedirect("CourseContentManagement");

                    ;
=======
            switch (action) {
                case "addSublesson":
                    addSublesson(request, response);

                    break;
                case "editSublesson":
                    editSublesson(request, response);
                    break;
                default:
                    removeSublesson(request, response);
>>>>>>> origin/create-course1
            }
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
<<<<<<< HEAD
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
=======
    private void addSublesson(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String lessonId = request.getParameter("lessonId");
        if (lessonId == null) {
            return;
        }
        request.setAttribute("lesson", courseDao.getLessonByID(lessonId));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String description = request.getParameter("description");
        String videoLink = request.getParameter("videoLink");
        String active = request.getParameter("active");

        try {
            if (title.isBlank() || content.isBlank() || description.isBlank() || videoLink.isBlank() || active == null) {
                request.setAttribute("errorMess", "Please provide complete information about sublesson");

            } else {
                if (!YouTubeDuration.isValidYouTubeUrl(videoLink)) {
                    request.setAttribute("errorMess", "Video Link is invalid");

                } else {
                    String embedLink = YouTubeDuration.convertToEmbedLink(videoLink);
                    if (embedLink == null) {
                        request.setAttribute("errorMess", "Video Link is invalid");

                    } else {

                        String idVideo = YouTubeDuration.getYouTubeId(videoLink);
                        long duration = YouTubeDuration.getVideoDuration(idVideo);
                        int check = courseDao.addSubLesson(title, content, description, Integer.parseInt(lessonId), embedLink, duration);
                        if (check > 0) {
                            response.sendRedirect("CourseContentManagement?mess=Added sublesson successfully");
                            return;
                        } else {
                            request.setAttribute("errorMess", "Add sublesson falure");

                        }
                    }

                }
            }
        } catch (NullPointerException e) {

        }
        request.setAttribute("title", title);
        request.setAttribute("content", content);
        request.setAttribute("description", description);
        request.setAttribute("videoLink", videoLink);
        request.setAttribute("active", active == null ? 0 : active);
        request.getRequestDispatcher("create-sublesson.jsp").forward(request, response);
    }

    private void editSublesson(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String lessonId = request.getParameter("lessonId");
        if (lessonId == null) {
            return;
        }
        request.setAttribute("lesson", courseDao.getLessonByID(lessonId));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String description = request.getParameter("description");
        String videoLink = request.getParameter("videoLink");
        String active = request.getParameter("active");
        String subLessonId = request.getParameter("subLessonId");

        try {
            if (title.isBlank() || content.isBlank() || description.isBlank() || videoLink.isBlank() || active == null) {
                request.setAttribute("errorMess", "Please provide complete information about sublesson");

            } else {
                if (!YouTubeDuration.isValidYouTubeUrl(videoLink)) {
                    request.setAttribute("errorMess", "Video Link is invalid");

                } else {
                    String embedLink = YouTubeDuration.convertToEmbedLink(videoLink);
                    if (embedLink == null) {
                        request.setAttribute("errorMess", "Video Link is invalid");

                    } else {
                        String idVideo = YouTubeDuration.getYouTubeId(videoLink);
                        long duration = YouTubeDuration.getVideoDuration(idVideo);
                        //response.getWriter().print(embedLink + duration); return
                        int check = courseDao.editSubLesson(title, content, description, embedLink, duration, Integer.parseInt(subLessonId));
                        if (check > 0) {
                            request.setAttribute("successMess", "Update sublesson successfully");

                        } else {
                            request.setAttribute("errorMess", "Update sublesson falure");

                        }
                    }

                }
            }
        } catch (NullPointerException e) {

        }
        SubLessonDBO sl = courseDao.getSubLessonByID(Integer.parseInt(subLessonId));
        if (sl == null) {
            return;
        }
        request.setAttribute("title", sl.getTitle());
        request.setAttribute("content", sl.getContent());
        request.setAttribute("description", sl.getDescription());
        request.setAttribute("videoLink", sl.getVideo_link());
        request.setAttribute("active", sl.isIs_locked() == false ? 0 : 1);
        request.setAttribute("subLessonId", subLessonId);
        request.getRequestDispatcher("edit-sublesson.jsp").forward(request, response);
    }

    private void removeSublesson(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idSublesson = request.getParameter("subLessonId");
        int check = courseDao.removeSubLesson(Integer.parseInt(idSublesson));
        String mess = "";
        if (check > 0) {
            mess = "Removed sublesson successfully";
        } else {
            mess = "Removed sublesson failed";

        }
        response.sendRedirect("CourseContentManagement?mess=" + mess);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            return;
        }
        request.setAttribute("action", action);
        switch (action) {
            case "addSublesson":
                addSublesson(request, response);
                break;
            case "editSublesson":
                editSublesson(request, response);
                break;

        }
>>>>>>> origin/create-course1
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
