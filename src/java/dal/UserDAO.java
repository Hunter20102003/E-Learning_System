package Dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.UserDBO;
import Model.RoleDBO;

public class UserDAO extends DBContext {
//login

    public boolean checkLockedUser(int id) {
        String sql = "select is_locked from [user] where user_id=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                if (r.getInt(1) == 1) {
                    return true;
                }
            }
        } catch (SQLException e) {

        }
        return false;
    }

    public UserDBO LoginCheck(String username, String password) {
        String sql = "select * from [user]  join Role  on [user].role_id=role.role_id where username =? and password=?";
        UserDBO user = null;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, username);
            p.setString(2, password);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                RoleDBO role = new RoleDBO(r.getInt(11), r.getString(12));
                user = new UserDBO(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5), r.getString(6), r.getString(8), r.getDate(9), r.getInt(10), role);

            }
        } catch (SQLException e) {

        }
        return user;
    }
//------------------------------------------------------

    //register
    public boolean checkUserNameExisted(String UserName) {
        String sql = "select * from [user] where usename =?";
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

    public UserDBO getUserByEmail(String email) {
        String sql = "select * from [user]  join Role  on [user].role_id=role.role_id where email=?";
        UserDBO user = null;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, email);

            ResultSet r = p.executeQuery();
            if (r.next()) {
                RoleDBO role = new RoleDBO(r.getInt(11), r.getString(12));
                user = new UserDBO(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5), r.getString(6), r.getString(8), r.getDate(9), r.getInt(10), role);

            }
        } catch (SQLException e) {

        }
        return user;
    }
  public UserDBO getUserByID(String id) {
        String sql = "select * from [user]  join Role  on [user].role_id=role.role_id where user_id=?";
        UserDBO user = null;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, id);

            ResultSet r = p.executeQuery();
            if (r.next()) {
                RoleDBO role = new RoleDBO(r.getInt(11), r.getString(12));
                user = new UserDBO(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5), r.getString(6), r.getString(8), r.getDate(9), r.getInt(10), role);

            }
        } catch (SQLException e) {

        }
        return user;
    }
    public int register(String username, String password, String fisrtName, String lastName, String email) {

        int n = 0;
        String sql = "insert into [user](username,password,first_name,last_name,email,role_id) values(?,?,?,?,?,?)";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, username);
            p.setString(2, password);
            p.setString(3, fisrtName);
            p.setString(4, lastName);
            p.setString(5, email);
            p.setInt(6, 1);
            n = p.executeUpdate();
        } catch (SQLException e) {

        }
        return n;

    }

    public int resetPassword(int userId, String newPassWord) {
        int n = 0;
        String sql = "update  [user] set password=? where user_id=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, newPassWord);
            p.setInt(2, userId);
            n = p.executeUpdate();

        } catch (SQLException e) {
            System.out.println("fail");

        }
        return n;
    }
    public int addUserByGoogleLogin(String fisrtName, String lastName, String email,String avatar) {

        int n = 0;
        String sql = "insert into [user](first_name,last_name,email,avatar,role_id) values(?,?,?,?,?)";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, fisrtName);
            p.setString(2, lastName);
            p.setString(3, email);
            p.setString(4, avatar);
            p.setInt(5, 1);
           
            n = p.executeUpdate();
        } catch (SQLException e) {

        }
        return n;

    }
    
    //-------------------------------------------------------------
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        // System.out.println(UserDAO.LoginCheck("admin","1"));
//        System.out.println(dao.register("2", "1","1","1","1"));
        // System.out.println(UserDAO.checkLockedUser(1));
   //   System.out.println(dao.getUserByEmail("baodaica6677@gmail.com"));
 
//        System.out.println(dao.resetPassword(21, "1"));
//        System.out.println(dao.getUserByEmail("baodaica6677@gmail.com"));
//        if (dao.getUserByEmail("baodaica6677@gmail.com").getUsername()==null){
//            System.out.println("ok");
//        }
System.out.println(dao.getUserByID("28"));
    }
}