/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Payment;
import Model.Payment;
import Model.CourseDBO;
import Model.CourseTypeDBO;
import Model.Enrollment;
import Model.LessonDBO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.UserDBO;
import Model.RoleDBO;
import Model.SubLessonDBO;
import java.util.AbstractList;
import java.util.List;

/**
 *
 * @author buiqu
 */
public class PaymentDAO extends DBContext {

    public ArrayList<Payment> FindPaymentByUserID(String Id) {

        String sql = "SELECT TOP (1000) [payment_id]\n"
                + "      ,[user_id]\n"
                + "      ,[course_id]\n"
                + "      ,[amount]\n"
                + "      ,[payment_date]\n"
                + "      ,[transaction_code]\n"
                + "  FROM [elearning].[dbo].[Payment]\n"
                + "Where [user_id] like ?";
        ArrayList<Payment> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, Id);
            ResultSet r = p.executeQuery();
            while (r.next()) {

                list.add(new Payment(r.getInt(1),
                        r.getInt(2),
                        r.getInt(3),
                        r.getDouble(4),
                        r.getString(5),
                        r.getString(6)));
            }
        } catch (SQLException e) {

        }
        return list;
    }

    public ArrayList<Enrollment> FindEnrollMentByUserID(String Id) {

        String sql = "SELECT TOP (1000) [user_id]\n"
                + "      ,[course_id]\n"
                + "      ,[enrollment_date]\n"
                + "  FROM [elearning].[dbo].[Enrollment]\n"
                + "  where [user_id] like ?";
        ArrayList<Enrollment> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, Id);
            ResultSet r = p.executeQuery();
            while (r.next()) {

                list.add(new Enrollment(r.getString(1),
                        r.getString(2),
                        r.getString(3)));
            }
        } catch (SQLException e) {

        }
        return list;
    }

    public void AddPayment(String UserID, String CourseID, Double Amount, String Date, String transaction_code) {
        String sql = "INSERT INTO [elearning].[dbo].[Payment] ([user_id], [course_id], [amount], [payment_date], [transaction_code]) VALUES (?, ?, ?,?,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, UserID);
            ps.setString(2, CourseID);
            ps.setDouble(3, Amount);
            ps.setString(4, Date);
            ps.setString(5, transaction_code);
            ps.executeUpdate();
            System.out.println("Payment inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error inserting payment: " + e.getMessage());
        }
    }

    public void AddEnrollMent(String UserID, String CourseID) {
        String sql = "    insert into Enrollment ([user_id], course_id)\n"
                + "values (?, ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, UserID);
            ps.setString(2, CourseID);

            ps.executeUpdate();
            System.out.println("EnrollMent inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error inserting payment: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        double amount = 5.5;
        PaymentDAO lis = new PaymentDAO();
        System.out.println(lis.FindEnrollMentByUserID("24"));
    }

}
