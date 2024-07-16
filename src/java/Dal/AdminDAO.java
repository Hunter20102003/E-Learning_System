/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.UserDBO;
import Model.RoleDBO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdminDAO extends DBContext {

    public List<UserDBO> getAllUser() {
        String sql = "select * from [User] u join Role r on u.role_id = r.role_id\n"
                + "Where u.is_deleted like '0'";
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

    public UserDBO getUserByID(String id) {
        String sql = "select * from [user]  join Role  on [user].role_id=role.role_id where user_id=?";
        UserDBO user = null;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, id);

            ResultSet r = p.executeQuery();
            if (r.next()) {
                RoleDBO role = new RoleDBO(r.getInt(12), r.getString(13));
                user = new UserDBO(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5), r.getString(6), r.getString(8), r.getDate(9), r.getInt(10), r.getInt(11), role);

            }
        } catch (SQLException e) {

        }
        return user;
    }

    public UserDBO getUserByGmail(String gmail) {
        String sql = "select * from [User] u\n"
                + "join [Role] r on u.role_id = r.role_id\n"
                + "where u.email like ?";
        UserDBO user = null;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, gmail);

            ResultSet r = p.executeQuery();
            if (r.next()) {
                RoleDBO role = new RoleDBO(r.getInt(12), r.getString(13));
                user = new UserDBO(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5), r.getString(6), r.getString(8), r.getDate(9), r.getInt(10), r.getInt(11), role);

            }
        } catch (SQLException e) {

        }
        return user;
    }

    public int isDeleted(int userId, int is) {
        int n = 0;
        String sql = "UPDATE [User] \n"
                + "SET is_deleted = ?\n"
                + "WHERE user_id = ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, is);
            p.setInt(2, userId);

            n = p.executeUpdate();

        } catch (SQLException e) {
            System.out.println("fail");

        }
        return n;
    }

    public int isLocked(int userId, int is) {
        int n = 0;
        String sql = "UPDATE [User] \n"
                + "SET is_locked = ?\n"
                + "WHERE user_id = ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, is);
            p.setInt(2, userId);

            n = p.executeUpdate();

        } catch (SQLException e) {
            System.out.println("fail");

        }
        return n;
    }

    public int editAccount(String userId, String name, String email, String first_name, String last_name, String role_id) {
        int n = 0;
        String sql = "UPDATE [User] \n"
                + "SET username = ?, email = ?, first_name = ?, last_name = ?, role_id = ?\n"
                + " WHERE user_id = ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, name);
            p.setString(2, email);
            p.setString(3, first_name);
            p.setString(4, last_name);
            p.setString(5, role_id);
            p.setString(6, userId);

            n = p.executeUpdate();

        } catch (SQLException e) {
            System.out.println("fail");

        }
        return n;
    }

    public boolean checkEmailExisted(String email) {
        String sql = "select * from [user] where email =?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, email);

            ResultSet r = p.executeQuery();
            if (r.next()) {
                return true;

            }
        } catch (SQLException e) {

        }
        return false;
    }

    public boolean checkUserNameExisted(String UserName) {
        String sql = "select * from [user] where username =?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, UserName);

            ResultSet r = p.executeQuery();
            if (r.next()) {
                return true;

            }
        } catch (SQLException e) {

        }
        return false;
    }

    public int addAccount(String username, String password, String email, String first_name, String last_name, String role_id) {
       int accountId = -1;
        String sql = "insert into [user](username,[password],[email],[first_name],[last_name],[role_id]) values(?,?,?,?,?,?)";
        try {
            PreparedStatement p = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            p.setString(1, username);
            p.setString(2, password);
            p.setString(3, email);
            p.setString(4, first_name);
            p.setString(5, last_name);
            p.setString(6, role_id);

             int n = p.executeUpdate();
             if (n > 0) {
            ResultSet rs = p.getGeneratedKeys();
            if (rs.next()) {
                accountId = rs.getInt(1);
            }
        }

        } catch (SQLException e) {
            System.out.println("fail");

        }
         return accountId;
    }
    

    public int addMentorByManager(String MentorId, String ManagerId) {
        int n = 0;
        String sql = "insert into MentorManager(MentorId, ManagerId)\n"
                + "values(?,?);";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, MentorId);
            p.setString(2, ManagerId);
            

            n = p.executeUpdate();

        } catch (SQLException e) {
            System.out.println("fail");

        }
        return n;
    }



    public static void main(String[] args) {
        AdminDAO db = new AdminDAO();
        System.out.println(db.getUserByGmail("thaibqhe173335@fpt.edu.vn"));
//        int h = db.addAccount("test", "thaisisi89809$", "BuihuyNam@gmail.com", "nam", "huy", "2");
//        int h = db.editAccount("24", "THAIHE173335", "buiquangthai09122003@gmail.com", "Bui", "Thai", "3");
//        System.out.println( h);
//System.err.println(h);
//int h = db.isDeleted(24, 0);


    }
}
