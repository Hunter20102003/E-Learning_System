/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

package ControllerPayWithCourse;



=======
package ControllerPayWithCourse;

>>>>>>> origin/create-course1
=======
package ControllerPayWithCourse;

>>>>>>> origin/crud_quiz
import Dal.CourseDAO;
import Model.CourseDBO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
=======

package AdminManagementController;

<<<<<<<< HEAD:src/java/AdminManagementController/EditAccount.java
import Dal.AdminDAO;
import java.io.IOException;
import java.io.PrintWriter;
========


import Dal.CourseDAO;
import Model.CourseDBO;
>>>>>>>> origin/front-end:src/java/ControllerPayWithCourse/Payment.java
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
<<<<<<<< HEAD:src/java/AdminManagementController/EditAccount.java
========
>>>>>>> origin/front-end
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
<<<<<<< HEAD
=======
>>>>>>>> origin/front-end:src/java/ControllerPayWithCourse/Payment.java
>>>>>>> origin/front-end

/**
 *
 * @author buiqu
 */
<<<<<<< HEAD
public class Payment extends HttpServlet {
<<<<<<< HEAD
<<<<<<< HEAD
     public static String generateRandomCode() {
=======

    public static String generateRandomCode() {
>>>>>>> origin/create-course1
=======

    public static String generateRandomCode() {
>>>>>>> origin/crud_quiz
=======
<<<<<<<< HEAD:src/java/AdminManagementController/EditAccount.java
public class EditAccount extends HttpServlet {
========
public class Payment extends HttpServlet {
     public static String generateRandomCode() {
>>>>>>> origin/front-end
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        Random random = new Random();
        StringBuilder code = new StringBuilder();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        
=======

>>>>>>> origin/crud_quiz
        // Thêm 1 ký tự chữ
        code.append(letters.charAt(random.nextInt(letters.length())));

        // Thêm 1 ký tự số
        code.append(numbers.charAt(random.nextInt(numbers.length())));

        // Thêm 1 ký tự chữ
        code.append(letters.charAt(random.nextInt(letters.length())));
<<<<<<< HEAD
        
=======

        // Thêm 1 ký tự chữ
        code.append(letters.charAt(random.nextInt(letters.length())));

        // Thêm 1 ký tự số
        code.append(numbers.charAt(random.nextInt(numbers.length())));

        // Thêm 1 ký tự chữ
        code.append(letters.charAt(random.nextInt(letters.length())));

>>>>>>> origin/create-course1
=======

>>>>>>> origin/crud_quiz
=======
        
        // Thêm 1 ký tự chữ
        code.append(letters.charAt(random.nextInt(letters.length())));
        
        // Thêm 1 ký tự số
        code.append(numbers.charAt(random.nextInt(numbers.length())));
        
        // Thêm 1 ký tự chữ
        code.append(letters.charAt(random.nextInt(letters.length())));
        
>>>>>>> origin/front-end
        // Thêm 6 ký tự số
        for (int i = 0; i < 6; i++) {
            code.append(numbers.charAt(random.nextInt(numbers.length())));
        }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        
        return code.toString();
    }
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
=======

        return code.toString();
    }
=======

        return code.toString();
    }
>>>>>>> origin/crud_quiz

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
<<<<<<< HEAD
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz
=======
        
        return code.toString();
    }
>>>>>>>> origin/front-end:src/java/ControllerPayWithCourse/Payment.java
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
>>>>>>> origin/front-end
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<<< HEAD:src/java/AdminManagementController/EditAccount.java
========
>>>>>>> origin/front-end
        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
     Dal.CourseDAO db = new CourseDAO();
        HttpSession session = request.getSession();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        CourseDBO course = (CourseDBO) session.getAttribute("course");
=======
        
        CourseDBO course = db.getCourseByID(Integer.parseInt(request.getParameter("course_id")));
>>>>>>> origin/DashBoard
=======
        CourseDBO course = (CourseDBO) session.getAttribute("course");
>>>>>>> origin/crudlesson,sublesson
=======
        CourseDBO course = (CourseDBO) session.getAttribute("course");
>>>>>>> origin/develop
=======
        
        CourseDBO course = db.getCourseByID(Integer.parseInt(request.getParameter("course_id")));
>>>>>>> origin/AdminManager
=======
        CourseDBO course = (CourseDBO) session.getAttribute("course");
>>>>>>> origin/comment
=======
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
=======
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
>>>>>>> origin/crud_quiz
            throws ServletException, IOException {
        Dal.CourseDAO db = new CourseDAO();
      //  HttpSession session = request.getSession();

        CourseDBO course = db.getCourseByID(Integer.parseInt(request.getParameter("course_id")));
<<<<<<< HEAD
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz
=======
        CourseDBO course = (CourseDBO) session.getAttribute("course");
>>>>>>> origin/front-end
=======
        
        CourseDBO course = db.getCourseByID(Integer.parseInt(request.getParameter("course_id")));
>>>>>>> origin/payment
        if (course != null) {
            String descriptonRandom = generateRandomCode();

            String amount = course.getPrice() + "";
//            String description = liscourse.getId();
            String description = descriptonRandom;
            String accountName = "";
            // Cú pháp tạo URL Quick Link
            String bankId = "970422"; // BIDV
            String accountNo = "9096936252243"; // Số tài khoản 
            String template = "qr_only";
            String qrLink = String.format(
                    "https://img.vietqr.io/image/%s-%s-%s.png?amount=%s&addInfo=%s&accountName=%s",
                    bankId, accountNo, template, amount, description, accountName);
            request.getSession().setAttribute("qrLink", qrLink);
            request.setAttribute("random", descriptonRandom);

            // Lưu URL mã QR vào session để tạo mã QR
        }
        request.setAttribute("listcourse", course);
        String check = (String) request.getAttribute("check"); // Use getAttribute instead of getParameter
        request.setAttribute("check", check);
        request.getRequestDispatcher("payQR.jsp").forward(request, response);
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    /** 
=======
    /**
>>>>>>> origin/crud_quiz
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
<<<<<<< HEAD
    throws ServletException, IOException {
=======
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
>>>>>>> origin/create-course1
=======
            throws ServletException, IOException {
>>>>>>> origin/crud_quiz
=======
    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
>>>>>>>> origin/front-end:src/java/ControllerPayWithCourse/Payment.java
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
>>>>>>> origin/front-end
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
            out.println("<title>Servlet PayCourse</title>");  
=======
            out.println("<title>Servlet PayCourse</title>");
>>>>>>> origin/crud_quiz
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PayCourse at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
<<<<<<< HEAD
=======
            out.println("<title>Servlet PayCourse</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PayCourse at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
>>>>>>> origin/create-course1
=======
     *
>>>>>>> origin/crud_quiz
=======
            out.println("<title>Servlet EditAccount</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditAccount at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
>>>>>>> origin/front-end
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/front-end
          throws ServletException, IOException {
            Dal.CourseDAO db = new CourseDAO();
        HttpSession session = request.getSession();
        CourseDBO course = (CourseDBO) session.getAttribute("course");
<<<<<<< HEAD
=======
            throws ServletException, IOException {
        Dal.CourseDAO db = new CourseDAO();
        HttpSession session = request.getSession();
=======
            throws ServletException, IOException {
        Dal.CourseDAO db = new CourseDAO();
        HttpSession session = request.getSession();
>>>>>>> origin/crud_quiz
        String course_id = request.getParameter("course_id");
        if (course_id == null) {
            return;
        }
        CourseDBO course = db.getCourseByID(Integer.parseInt(course_id));
<<<<<<< HEAD
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz
=======
>>>>>>> origin/front-end
        if (course != null) {
            String descriptonRandom = generateRandomCode();

            String amount = course.getPrice() + "";
//            String description = liscourse.getId();
            String description = descriptonRandom;
            String accountName = "";
            // Cú pháp tạo URL Quick Link
            String bankId = "970422"; // BIDV
            String accountNo = "9096936252243"; // Số tài khoản 
            String template = "qr_only";
            String qrLink = String.format(
                    "https://img.vietqr.io/image/%s-%s-%s.png?amount=%s&addInfo=%s&accountName=%s",
                    bankId, accountNo, template, amount, description, accountName);
            request.getSession().setAttribute("qrLink", qrLink);
            request.setAttribute("random", descriptonRandom);

            // Lưu URL mã QR vào session để tạo mã QR
        }
        request.setAttribute("listcourse", course);
        String check = (String) request.getAttribute("check"); // Use getAttribute instead of getParameter
        request.setAttribute("check", check);
        request.getRequestDispatcher("payQR.jsp").forward(request, response);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    } 
=======
    }
>>>>>>> origin/crud_quiz

    /**
     * Handles the HTTP <code>POST</code> method.
<<<<<<< HEAD
=======
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
>>>>>>> origin/create-course1
=======
     *
>>>>>>> origin/crud_quiz
=======
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
>>>>>>> origin/front-end
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
 
=======
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz
=======
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Dal.AdminDAO db = new AdminDAO();
        
        String user_id = request.getParameter("id");
        String name = request.getParameter("name");
        
        String email = request.getParameter("email");
        String frit_name = request.getParameter("fname");
        String last_name =request.getParameter("lname");
        String role_id = request.getParameter("role");
        
       db.editAccount(user_id, name, email, frit_name, last_name, role_id);
       request.setAttribute("id", user_id);
       
        request.getRequestDispatcher("display_edit").forward(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
>>>>>>> origin/front-end
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
