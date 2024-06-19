/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

<<<<<<< HEAD
<<<<<<< HEAD


import Model.EnrollmentDBO;
import Model.Payment;

=======
=======
>>>>>>> origin/profile
import Model.Payment;
import Model.Payment;
import Model.CourseDBO;
import Model.CourseTypeDBO;
import Model.LessonDBO;
<<<<<<< HEAD
>>>>>>> origin/front-end
=======
>>>>>>> origin/profile
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
<<<<<<< HEAD
<<<<<<< HEAD


=======
=======
>>>>>>> origin/profile
import Model.UserDBO;
import Model.RoleDBO;
import Model.SubLessonDBO;
import java.util.AbstractList;
import java.util.List;
<<<<<<< HEAD
>>>>>>> origin/front-end
=======
>>>>>>> origin/profile
/**
 *
 * @author buiqu
 */
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
=======
>>>>>>> origin/profile
public class PaymentDAO extends DBContext{
    public ArrayList<Payment>  FindPaymentByUserID(String Id){
       
           String sql = "select * from Payment\n" +
"where Payment.user_id like ?";
<<<<<<< HEAD
>>>>>>> origin/front-end
=======
>>>>>>> origin/profile
        ArrayList<Payment> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, Id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
<<<<<<< HEAD
<<<<<<< HEAD

                list.add(new Payment(r.getInt(1),
                        r.getInt(2),
                        r.getInt(3),
                        r.getDouble(4),
                        r.getString(5),
                        r.getString(6)));
=======
=======
>>>>>>> origin/profile
                
                list.add(new Payment(r.getInt(1), 
                        r.getInt(2), 
                        r.getInt(3), 
                        r.getDouble(4), 
                        r.getString(5)));
<<<<<<< HEAD
>>>>>>> origin/front-end
=======
>>>>>>> origin/profile
            }
        } catch (SQLException e) {

        }
        return list;
    }
<<<<<<< HEAD
<<<<<<< HEAD

    public ArrayList<EnrollmentDBO> FindEnrollMentByUserID(String Id) {

        String sql = "select * from Enrollment where user_id=?";
        ArrayList<EnrollmentDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, Id);
            ResultSet r = p.executeQuery();
            while (r.next()) {

                list.add(new EnrollmentDBO(r.getInt("user_id"),
                        r.getInt("course_id"),
                        r.getDate("enrollment_date")));
            }
        } catch (SQLException e) {

        }
        return list;
    }

    public void AddPayment(String UserID, String CourseID, Double Amount, String Date, String transaction_code) {
        String sql = "INSERT INTO [elearning].[dbo].[Payment] ([user_id], [course_id], [amount], [payment_date], [transaction_code]) VALUES (?, ?, ?,?,?);";
=======
    
      public void AddPayment(String UserID, String CourseID, Double Amount, String Date) {
        String sql = "INSERT INTO [elearning].[dbo].[Payment] ([user_id], [course_id], [amount], [payment_date]) VALUES (?, ?, ?, ?);";
>>>>>>> origin/front-end
=======
    
      public void AddPayment(String UserID, String CourseID, Double Amount, String Date) {
        String sql = "INSERT INTO [elearning].[dbo].[Payment] ([user_id], [course_id], [amount], [payment_date]) VALUES (?, ?, ?, ?);";
>>>>>>> origin/profile
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, UserID);
            ps.setString(2, CourseID);
            ps.setDouble(3, Amount);
            ps.setString(4, Date);
<<<<<<< HEAD
<<<<<<< HEAD
            ps.setString(5, transaction_code);
=======
>>>>>>> origin/front-end
=======
>>>>>>> origin/profile
            ps.executeUpdate();
            System.out.println("Payment inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error inserting payment: " + e.getMessage());
        }
    }

<<<<<<< HEAD
<<<<<<< HEAD
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

=======
=======
>>>>>>> origin/profile
    public static void main(String[] args) {
        double amount = 5.5;
        PaymentDAO lis = new PaymentDAO();
        lis.AddPayment("24", "1", amount, "2024-06-07 00:55:19"); // Example date format: YYYY-MM-DD
    }
    
<<<<<<< HEAD
>>>>>>> origin/front-end
=======
>>>>>>> origin/profile
}
