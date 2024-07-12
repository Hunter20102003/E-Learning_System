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
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 *
 * @author buiqu
 */
public class DashboardDAO extends DBContext {

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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
    
>>>>>>> origin/AdminManager
=======
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz

    public List<DashBoardPaymentDBO> getAllpaymentByMonthAndYearAndManagerID(String year, String month, String ManagerId) {
        String sql = "SELECT * \n"
                + "FROM Payment p \n"
                + "JOIN Course c ON p.course_id = c.course_id\n"
                + "WHERE YEAR(p.payment_date) = ?  and MONTH(p.payment_date) = ? and c.created_by = ?";
        List<DashBoardPaymentDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, year);
            p.setString(2, month);
            p.setString(3, ManagerId);

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

    public List<DashBoardPaymentDBO> getAllIncomeManager(String year, String month, String ManagerId) {
        String sql = "SELECT * \n"
                + "FROM Payment p \n"
                + "JOIN Course c ON p.course_id = c.course_id\n"
                + "WHERE YEAR(p.payment_date) = ?  and MONTH(p.payment_date) = ? and c.created_by = ?";
        List<DashBoardPaymentDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, year);
            p.setString(2, month);
            p.setString(3, ManagerId);

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

    public List<DashBoardPaymentDBO> getAllIncomeManager(String year, String ManagerId) {
        String sql = "    SELECT * \n"
                + "FROM Payment p\n"
                + "JOIN Course c ON p.course_id = c.course_id\n"
                + "WHERE YEAR(p.payment_date) = ? and c.created_by = ?";
        List<DashBoardPaymentDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, year);
            p.setString(2, ManagerId);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
            
>>>>>>> origin/AdminManager
=======
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz

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

    public List<UserDBO> getAllUser() {
        String sql = "SELECT *\n"
                + "FROM [User] u\n"
                + "JOIN [Role] r ON u.role_id = r.role_id\n"
                + "Where u.role_id =4 \n"
                + ""
                + "";
        List<UserDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                RoleDBO role = new RoleDBO(r.getInt("role_id"), r.getString("role_name"));
                UserDBO user = new UserDBO(r.getInt("user_id"),
                        r.getString("username"),
                        r.getString("password"),
                        r.getString("email"),
                        r.getString("first_name"),
                        r.getString("last_name"),
                        r.getString("avatar"),
                        r.getDate("created_at"),
                        r.getInt("is_locked"),
                        r.getInt("is_Deleted"),
                        role
                );
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi để dễ dàng theo dõi
        }
        return list;
    }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz
     public List<UserDBO> getAllUser(String role_id) {
        String sql = "SELECT *\n"
                + "FROM [User] u\n"
                + "JOIN [Role] r ON u.role_id = r.role_id\n"
                + "Where u.role_id =? \n"
                + ""
                + "";
        List<UserDBO> list = new ArrayList<>();
        try {
             PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, role_id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                RoleDBO role = new RoleDBO(r.getInt("role_id"), r.getString("role_name"));
                UserDBO user = new UserDBO(r.getInt("user_id"),
                        r.getString("username"),
                        r.getString("password"),
                        r.getString("email"),
                        r.getString("first_name"),
                        r.getString("last_name"),
                        r.getString("avatar"),
                        r.getDate("created_at"),
                        r.getInt("is_locked"),
                        r.getInt("is_Deleted"),
                        role
                );
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi để dễ dàng theo dõi
        }
        return list;
    }

    public List<UserDBO> getAllUser_ALL() {
        String sql = "SELECT *\n"
                + "FROM [User] u\n"
                + "JOIN [Role] r ON u.role_id = r.role_id\n";
        List<UserDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                RoleDBO role = new RoleDBO(r.getInt("role_id"), r.getString("role_name"));
                UserDBO user = new UserDBO(r.getInt("user_id"),
                        r.getString("username"),
                        r.getString("password"),
                        r.getString("email"),
                        r.getString("first_name"),
                        r.getString("last_name"),
                        r.getString("avatar"),
                        r.getDate("created_at"),
                        r.getInt("is_locked"),
                        r.getInt("is_Deleted"),
                        role
                );
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi để dễ dàng theo dõi
        }
        return list;
    }

    public List<UserDBO> getAllUserBefore10Day() {
        String sql = "SELECT *\n"
                + "               FROM [User] u\n"
                + "              JOIN [Role] r ON u.role_id = r.role_id\n"
                + "			   WHERE u.created_at < DATEADD(DAY, -10, GETDATE())";
        List<UserDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                RoleDBO role = new RoleDBO(r.getInt("role_id"), r.getString("role_name"));
                UserDBO user = new UserDBO(r.getInt("user_id"),
                        r.getString("username"),
                        r.getString("password"),
                        r.getString("email"),
                        r.getString("first_name"),
                        r.getString("last_name"),
                        r.getString("avatar"),
                        r.getDate("created_at"),
                        r.getInt("is_locked"),
                        r.getInt("is_Deleted"),
                        role
                );
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi để dễ dàng theo dõi
        }
        return list;
    }

    public List<Payment> getAllPayment() {
        String sql = "SELECT TOP (1000) [payment_id]\n"
                + "      ,[user_id]\n"
                + "      ,[course_id]\n"
                + "      ,[amount]\n"
                + "      ,[payment_date]\n"
                + "      ,[transaction_code]\n"
                + "  FROM [elearning].[dbo].[Payment]";
        List<Payment> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {

                Payment pay = new Payment(r.getInt(1), r.getInt(2), r.getInt(3), r.getDouble(4), r.getString(5), r.getString(6));
                list.add(pay);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra lỗi để dễ dàng theo dõi
        }
        return list;
    }

    public Double TotalPrice(String year) {
<<<<<<< HEAD
<<<<<<< HEAD
=======
   public Double TotalPrice(String year) {
>>>>>>> origin/AdminManager
=======
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz
        DashboardDAO db = new DashboardDAO();
        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByYear(year);
        double total = 0.0;
        for (DashBoardPaymentDBO payment : pay_list) {
            total += payment.getAmount();
        }
        return total;
    }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz

    public static void main(String[] args) {
        DashboardDAO db = new DashboardDAO();
//        double b = db.TotalPrice("2024");
//        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
//        symbols.setGroupingSeparator('.');
//        DecimalFormat df = new DecimalFormat("#,###", symbols); // Định dạng số với phân tách nhóm là dấu chấm
//        String formattedNumber = df.format(b);
//
//        System.out.println(formattedNumber);
//        int h = db.editAccount("24", "THAIHE173335", "buiquangthai09122003@gmail.com", "Bui", "Thai", "3");
//        System.out.println( h);
//int h = db.isDeleted(24, 0);
        System.err.println(db.getAllUser("1"));
<<<<<<< HEAD
<<<<<<< HEAD
=======
    public static void main(String[] args) {
        DashboardDAO db = new DashboardDAO();
        double b= db.TotalPrice("2024");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
symbols.setGroupingSeparator('.');
DecimalFormat df = new DecimalFormat("#,###", symbols); // Định dạng số với phân tách nhóm là dấu chấm
String formattedNumber = df.format(b);
        
        System.out.println(formattedNumber);
//        int h = db.editAccount("24", "THAIHE173335", "buiquangthai09122003@gmail.com", "Bui", "Thai", "3");
//        System.out.println( h);
//int h = db.isDeleted(24, 0);
>>>>>>> origin/AdminManager
=======
>>>>>>> origin/create-course1
=======
>>>>>>> origin/crud_quiz

    }
}
