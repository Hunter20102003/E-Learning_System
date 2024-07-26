/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.CourseDBO;
import Model.CourseTypeDBO;
import Model.RoleDBO;
import Model.UserCourseProgressDBO;
import Model.UserDBO;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class CertificateDAO extends DBContext {
    
    public List<UserCourseProgressDBO> getUserCourseProgress() throws Exception {
        List<UserCourseProgressDBO> list = new ArrayList<>();
        String sql = "SELECT TOP (1000) user_id, course_id, completion_date, progress FROM dbo.UserCourseProgress";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                UserCourseProgressDBO ucp = new UserCourseProgressDBO(
                        rs.getInt("user_id"),
                        rs.getInt("course_id"),
                        rs.getDate("completion_date"),
                        rs.getInt("progress"));
                list.add(ucp);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
        
    }
    
    public ArrayList<UserDBO> getUsers() {
        ArrayList<UserDBO> users = new ArrayList<>();
        String sql = "SELECT user_id, first_name, last_name FROM [User]";
        try (
                PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                UserDBO user = new UserDBO();
                user.setId(rs.getInt("user_id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    
    public List<CourseDBO> getCourses() throws Exception {
        List<CourseDBO> list = new ArrayList<>();
        String sql = "SELECT TOP (1000) c.course_id, c.name, c.title, c.description, c.course_type_id, ct.course_type_name, c.price, c.course_img, c.created_by, c.teacher_id, c.is_locked, c.created_at, c.is_deleted "
                + "FROM dbo.Course c "
                + "JOIN dbo.CourseType ct ON c.course_type_id = ct.course_type_id";
        
        List<CourseDBO> courses = new ArrayList<>();
        
        try (PreparedStatement p = connection.prepareStatement(sql); ResultSet r = p.executeQuery()) {
            while (r.next()) {
                CourseTypeDBO type = new CourseTypeDBO(r.getInt("course_type_id"), r.getString("course_type_name"));
                CourseDBO course = new CourseDBO(
                        r.getInt("course_id"),
                        r.getString("name"),
                        r.getString("title"),
                        r.getString("description"),
                        r.getDouble("price"),
                        r.getString("course_img"),
                        r.getInt("created_by"),
                        r.getInt("teacher_id"),
                        r.getBoolean("is_locked"),
                        r.getDate("created_at"),
                        type,
                        r.getBoolean("is_deleted")
                );
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return courses;
    }
    
    public UserDBO getUserByID(int id) {
        String sql = "select * from [user]  join Role  on [user].role_id=role.role_id where user_id=?";
        UserDBO user = null;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, id);
            
            ResultSet r = p.executeQuery();
            if (r.next()) {
                RoleDBO role = new RoleDBO(r.getInt("role_id"), r.getString("role_name"));
                user = new UserDBO(r.getInt("user_id"), r.getString("username"),
                        r.getString("password"), r.getString("email"),
                        r.getString("first_name"), r.getString("last_name"), r.getString("avatar"),
                        r.getDate("created_at"), r.getInt("is_locked"), r.getInt("is_deleted"), role);
                
            }
        } catch (SQLException e) {
            
        }
        return user;
    }
    
    public CourseDBO getCourseByID(int id) {
        String sql = "SELECT \n"
                + "    c.course_id, \n"
                + "    c.name, \n"
                + "    c.title, \n"
                + "    c.description, \n"
                + "    c.price, \n"
                + "    c.course_img, \n"
                + "    c.created_by, \n"
                + "    c.teacher_id, \n"
                + "    c.is_locked, \n"
                + "    c.created_at, \n"
                + "    c.is_deleted,\n"
                + "    ct.course_type_id, \n"
                + "    ct.course_type_name \n"
                + "FROM \n"
                + "    course AS c \n"
                + "JOIN \n"
                + "    coursetype AS ct \n"
                + "ON \n"
                + "    ct.course_type_id = c.course_type_id \n"
                + "WHERE \n"
                + "    c.course_id = ? \n"
                + "    AND c.is_deleted = 0;"; // chỉ lấy khóa học chưa bị xóa

        CourseDBO course = null;
        
        try (PreparedStatement p = connection.prepareStatement(sql)) {
            p.setInt(1, id);
            try (ResultSet r = p.executeQuery()) {
                if (r.next()) {
                    CourseTypeDBO type = new CourseTypeDBO(r.getInt("course_type_id"), r.getString("course_type_name"));
                    course = new CourseDBO(
                            r.getInt("course_id"),
                            r.getString("name"),
                            r.getString("title"),
                            r.getString("description"),
                            r.getDouble("price"),
                            r.getString("course_img"),
                            r.getInt("created_by"),
                            r.getInt("teacher_id"),
                            r.getBoolean("is_locked"),
                            r.getDate("created_at"),
                            type,
                            r.getBoolean("is_deleted") // Không cần lấy is_deleted vì chỉ lấy khóa học chưa bị xóa
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return course;
    }
    
    public boolean hasUserCompletedCourse(int userId, int courseId) throws Exception {
    String sql = "SELECT progress FROM dbo.UserCourseProgress WHERE user_id = ? AND course_id = ?";
    
    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        
        stmt.setInt(1, userId);
        stmt.setInt(2, courseId);
        
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                double progress = rs.getDouble("progress");
                return progress >= 100.0;  // Assuming 100% progress indicates course completion
            }
        }
    }
    
    return false;
}

    
    public static void main(String[] args) {
        
        try {
            CertificateDAO dao = new CertificateDAO();
            //System.out.println(dao.getUserCourseProgress());
//            System.out.println(dao.getUsers());
//            System.out.println(dao.getCourses());
//System.out.println(dao.getCourseByID(1));
//            System.out.println(dao.getUserByID("1"));
System.out.println(dao.hasUserCompletedCourse(1, 1));
        } catch (Exception ex) {
            Logger.getLogger(CertificateDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
