package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.management.relation.Role;
import model.UserDBO;
import model.RoleDBO;

public class dao extends DBContext {

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
        String sql = "select * from [user]  join Role  on [user].role_id=role.role_id where usename =? and password=?";
        UserDBO user = null;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, username);
            p.setString(2, password);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                RoleDBO role = new RoleDBO(r.getInt(15), r.getString(16));
                user = new UserDBO(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5), r.getString(6), r.getInt(7), r.getDate(8), r.getString(9), r.getString(10), r.getString(12), r.getInt(14), role);

            }
        } catch (SQLException e) {

        }
        return user;
    }

    public static void main(String[] args) {
        dao dao = new dao();
        System.out.println(dao.LoginCheck("admin", "1"));
        System.out.println(dao.checkLockedUser(1));
    }
}
