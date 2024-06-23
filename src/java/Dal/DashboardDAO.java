/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.DashBoardPaymentDBO;
import Model.DashBoardCourseDBO;
import Model.EnrollmentDBO;
import Model.Payment;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.UserDBO;
import Model.RoleDBO;

/**
 *
 * @author buiqu
 */
public class DashboardDAO extends DBContext {
    //    
//    public ArrayList<Payment> FindPaymentByUserID(String Id) {
//
//        String sql = "SELECT TOP (1000) [payment_id]\n"
//                + "      ,[user_id]\n"
//                + "      ,[course_id]\n"
//                + "      ,[amount]\n"
//                + "      ,[payment_date]\n"
//                + "      ,[transaction_code]\n"
//                + "  FROM [elearning].[dbo].[Payment]\n"
//                + "Where [user_id] like ?";
//        ArrayList<Payment> list = new ArrayList<>();
//        try {
//            PreparedStatement p = connection.prepareStatement(sql);
//            p.setString(1, Id);
//            ResultSet r = p.executeQuery();
//            while (r.next()) {
//
//                list.add(new Payment(r.getInt(1),
//                        r.getInt(2),
//                        r.getInt(3),
//                        r.getDouble(4),
//                        r.getString(5),
//                        r.getString(6)));
//            }
//        } catch (SQLException e) {
//
//        }
//        return list;
//    }
//
//    public ArrayList<EnrollmentDBO> FindEnrollMentByUserID(String Id) {
//
//        String sql = "select * from Enrollment where user_id=?";
//        ArrayList<EnrollmentDBO> list = new ArrayList<>();
//        try {
//            PreparedStatement p = connection.prepareStatement(sql);
//            p.setString(1, Id);
//            ResultSet r = p.executeQuery();
//            while (r.next()) {
//
//                list.add(new EnrollmentDBO(r.getInt("user_id"),
//                        r.getInt("course_id"),
//                        r.getDate("enrollment_date")));
//            }
//        } catch (SQLException e) {
//
//        }
//        return list;
//    }
//
//    public void AddPayment(String UserID, String CourseID, Double Amount, String Date, String transaction_code) {
//        String sql = "INSERT INTO [elearning].[dbo].[Payment] ([user_id], [course_id], [amount], [payment_date], [transaction_code]) VALUES (?, ?, ?,?,?);";
//        try {
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1, UserID);
//            ps.setString(2, CourseID);
//            ps.setDouble(3, Amount);
//            ps.setString(4, Date);
//            ps.setString(5, transaction_code);
//            ps.executeUpdate();
//            System.out.println("Payment inserted successfully.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("Error inserting payment: " + e.getMessage());
//        }
//    }
//
//    public void AddEnrollMent(String UserID, String CourseID) {
//        String sql = "    insert into Enrollment ([user_id], course_id)\n"
//                + "values (?, ?);";
//        try {
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1, UserID);
//            ps.setString(2, CourseID);
//
//            ps.executeUpdate();
//            System.out.println("EnrollMent inserted successfully.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("Error inserting payment: " + e.getMessage());
//        }
//    }
//    
//    public ArrayList<Payment> FindPaymentByUserID(String Id) {
//
//        String sql = "SELECT TOP (1000) [payment_id]\n"
//                + "      ,[user_id]\n"
//                + "      ,[course_id]\n"
//                + "      ,[amount]\n"
//                + "      ,[payment_date]\n"
//                + "      ,[transaction_code]\n"
//                + "  FROM [elearning].[dbo].[Payment]\n"
//                + "Where [user_id] like ?";
//        ArrayList<Payment> list = new ArrayList<>();
//        try {
//            PreparedStatement p = connection.prepareStatement(sql);
//            p.setString(1, Id);
//            ResultSet r = p.executeQuery();
//            while (r.next()) {
//
//                list.add(new Payment(r.getInt(1),
//                        r.getInt(2),
//                        r.getInt(3),
//                        r.getDouble(4),
//                        r.getString(5),
//                        r.getString(6)));
//            }
//        } catch (SQLException e) {
//
//        }
//        return list;
//    }
//
//    public ArrayList<EnrollmentDBO> FindEnrollMentByUserID(String Id) {
//
//        String sql = "select * from Enrollment where user_id=?";
//        ArrayList<EnrollmentDBO> list = new ArrayList<>();
//        try {
//            PreparedStatement p = connection.prepareStatement(sql);
//            p.setString(1, Id);
//            ResultSet r = p.executeQuery();
//            while (r.next()) {
//
//                list.add(new EnrollmentDBO(r.getInt("user_id"),
//                        r.getInt("course_id"),
//                        r.getDate("enrollment_date")));
//            }
//        } catch (SQLException e) {
//
//        }
//        return list;
//    }
//
//    public void AddPayment(String UserID, String CourseID, Double Amount, String Date, String transaction_code) {
//        String sql = "INSERT INTO [elearning].[dbo].[Payment] ([user_id], [course_id], [amount], [payment_date], [transaction_code]) VALUES (?, ?, ?,?,?);";
//        try {
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1, UserID);
//            ps.setString(2, CourseID);
//            ps.setDouble(3, Amount);
//            ps.setString(4, Date);
//            ps.setString(5, transaction_code);
//            ps.executeUpdate();
//            System.out.println("Payment inserted successfully.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("Error inserting payment: " + e.getMessage());
//        }
//    }
//
//    public void AddEnrollMent(String UserID, String CourseID) {
//        String sql = "    insert into Enrollment ([user_id], course_id)\n"
//                + "values (?, ?);";
//        try {
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1, UserID);
//            ps.setString(2, CourseID);
//
//            ps.executeUpdate();
//            System.out.println("EnrollMent inserted successfully.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("Error inserting payment: " + e.getMessage());
//        }
//    }

    public List<DashBoardPaymentDBO> getAllpaymentByMonthAndYear(String year, String month) {
        String sql = "SELECT * \n"
                + "FROM Payment p \n"
                + "JOIN Course c ON p.course_id = c.course_id\n"
                + "WHERE YEAR(p.payment_date) =? and MONTH(p.payment_date) = ?;";
       List<DashBoardPaymentDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, year);
            p.setString(2, month);

            ResultSet r = p.executeQuery();

            while (r.next()) {
                DashBoardCourseDBO course = new DashBoardCourseDBO(r.getInt(7), r.getString(8), r.getString(9), r.getString(10), r.getInt(11), r.getDouble(12), r.getString(13), r.getInt(14), r.getInt(15), r.getBoolean(16), r.getDate(17), r.getBoolean(18));
                DashBoardPaymentDBO dasPayment = new DashBoardPaymentDBO(r.getInt(1), r.getInt(2), r.getInt(3), r.getDouble(4), r.getString(5), r.getString(6), course);

                list.add(dasPayment);
            }
        } catch (SQLException e) {

        }
        return list;
    }
       public List<DashBoardPaymentDBO> getAllpaymentByYear(String year) {
        String sql = "SELECT * \n"
                + "FROM Payment p \n"
                + "JOIN Course c ON p.course_id = c.course_id\n"
                + "WHERE YEAR(p.payment_date) =? ;";
        List<DashBoardPaymentDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, year);
         

            ResultSet r = p.executeQuery();

            while (r.next()) {
                DashBoardCourseDBO course = new DashBoardCourseDBO(r.getInt(7), r.getString(8), r.getString(9), r.getString(10), r.getInt(11), r.getDouble(12), r.getString(13), r.getInt(14), r.getInt(15), r.getBoolean(16), r.getDate(17), r.getBoolean(18));
                DashBoardPaymentDBO dasPayment = new DashBoardPaymentDBO(r.getInt(1), r.getInt(2), r.getInt(3), r.getDouble(4), r.getString(5), r.getString(6), course);

                list.add(dasPayment);
            }
        } catch (SQLException e) {

        }
        return list;
    }

    public static void main(String[] args) {
        DashboardDAO db = new DashboardDAO();
        System.out.println(db.getAllpaymentByYear("2024"));
//        int h = db.editAccount("24", "THAIHE173335", "buiquangthai09122003@gmail.com", "Bui", "Thai", "3");
//        System.out.println( h);
//int h = db.isDeleted(24, 0);

    }
}
