package Dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.UserDBO;
import Model.RoleDBO;
import java.util.List;

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
public ArrayList<UserDBO> getUsersByRole(int roleId) {
    ArrayList<UserDBO> users = new ArrayList<>();
    String sql = "SELECT user_id, first_name, last_name,email FROM [User] WHERE role_id = ?";
    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setInt(1, roleId);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                UserDBO user = new UserDBO();
                user.setId(rs.getInt("user_id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return users;
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
    public ArrayList<UserDBO> getAllUsers() {
        ArrayList<UserDBO> users = new ArrayList<>();
        String sql = "SELECT user_id, first_name, last_name FROM [User]";
        try (
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
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

    public UserDBO getUserByEmail(String email) {
        String sql = "select * from [user]  join Role  on [user].role_id=role.role_id where email=?";
        UserDBO user = null;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, email);

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

    public UserDBO getUserByID(String id) {
        String sql = "select * from [user]  join Role  on [user].role_id=role.role_id where user_id=?";
        UserDBO user = null;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, id);

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

    public int addUserByGoogleLogin(String fisrtName, String lastName, String email, String avatar) {

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

    public void updateProfileUserByAvatar(String firstName, String lastName, String avatar, String email, int userId) {
        String sql = "update [User] set first_name=?, "
                + "last_name=?,avatar=?,email=? "
                + "where user_id =?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, firstName);
            p.setString(2, lastName);
            p.setString(3, avatar);
            p.setString(4, email);
            p.setInt(5, userId);
            p.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateProfileUser(String firstName, String lastName, String email, int userId) {
        String sql = "update [User] set first_name=?, "
                + "last_name=?,email=? "
                + "where user_id =?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, firstName);
            p.setString(2, lastName);
            p.setString(3, email);
            p.setInt(4, userId);
            p.executeUpdate();
        } catch (Exception e) {
        }
    }
//    public ArrayList<UserDBO> getUserByRoleID(String id) {
//        String sql = "select * from [user]  join Role  on [user].role_id=role.role_id where role.role_id = ?";
//        ArrayList<UserDBO> list = new ArrayList<>();
//        try {
//            PreparedStatement p = connection.prepareStatement(sql);
//            p.setString(1, id);
//            ResultSet r = p.executeQuery();
//            while (r.next()) {
//                RoleDBO role = new RoleDBO(r.getInt(11), r.getString(12));
//                list.add( new UserDBO(
//                        r.getInt(1),
//                        r.getString(2), 
//                        r.getString(3),
//                        r.getString(4),
//                        r.getString(5), 
//                        r.getString(6), 
//                        r.getString(8),
//                        r.getDate(9), 
//                        r.getInt(10), 
//                        role));
//
//            }
//        } catch (SQLException e) {
//
//        }
//        return list;
//    }
    
    public int getUserIdByLoginAndRoleID(String username, String password) {
    int userId = -1; // Giá trị mặc định nếu không tìm thấy người dùng

    // Query để lấy ID người dùng từ username và password, và kiểm tra role_id = 4
    String sql = "SELECT user_id FROM [user] " +
                 "JOIN Role ON [user].role_id = Role.role_id " +
                 "WHERE username = ? AND password = ? AND [user].role_id = 4";

    try {
        PreparedStatement p = connection.prepareStatement(sql);
        p.setString(1, username);
        p.setString(2, password);
        ResultSet r = p.executeQuery();
        
        if (r.next()) {
            userId = r.getInt("user_id");
        }
    } catch (SQLException e) {
        // Xử lý exception nếu có
        e.printStackTrace();
    }

    return userId;
}
//    public List<UserDBO> getAllUsers() {
//        List<UserDBO> users = new ArrayList<>();
//        String sql = "SELECT user_id, first_name, last_name FROM [User]";
//        try (
//             PreparedStatement ps = connection.prepareStatement(sql);
//             ResultSet rs = ps.executeQuery()) {
//            while (rs.next()) {
//                UserDBO user = new UserDBO();
//                user.setId(rs.getInt("user_id"));
//                user.setFirstName(rs.getString("first_name"));
//                user.setLastName(rs.getString("last_name"));
//                users.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return users;
//    }
//     public List<UserDBO> getUsersByRole(int roleId) {
//    List<UserDBO> users = new ArrayList<>();
//    String sql = "SELECT user_id, first_name, last_name,email FROM [User] WHERE role_id = ?";
//    try (PreparedStatement ps = connection.prepareStatement(sql)) {
//        ps.setInt(1, roleId);
//        try (ResultSet rs = ps.executeQuery()) {
//            while (rs.next()) {
//                UserDBO user = new UserDBO();
//                user.setId(rs.getInt("user_id"));
//                user.setFirstName(rs.getString("first_name"));
//                user.setLastName(rs.getString("last_name"));
//                user.setEmail(rs.getString("email"));
//                users.add(user);
//            }
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//    return users;
//}
public boolean checkUserScoreByIdExitd(int userId,int quizId) {
        String sql = "select * from mentee_scores where user_id = ? and quiz_id= ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, userId);
            p.setInt(2, quizId);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                return true;
            }
        } catch (SQLException e) {
        }
        return false;
    }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> origin/crud_quiz
//lay thong tin mentor
=======


        // Phương thức tìm kiếm giáo viên với phân trang
    public List<UserDBO> searchTeachers(String searchQuery, int page) {
        List<UserDBO> teachers = new ArrayList<>();
        int pageSize = 10;
        int startItem = (page - 1) * pageSize;

        String sql = "SELECT [user_id], [username], [password], [email], [first_name], [last_name], [role_id], [avatar], [created_at], [is_locked], [is_deleted] " +
                     "FROM [elearning].[dbo].[User] " +
                     "WHERE role_id = ? AND (first_name LIKE ? OR last_name LIKE ?) " +
                     "ORDER BY user_id " +
                     "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        try (
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, 2); // role_id = 2 cho giáo viên
            stmt.setString(2, "%" + searchQuery + "%");
            stmt.setString(3, "%" + searchQuery + "%");
            stmt.setInt(4, startItem);
            stmt.setInt(5, pageSize);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                UserDBO teacher = new UserDBO();
                teacher.setId(rs.getInt("user_id"));
                teacher.setUsername(rs.getString("username"));
                teacher.setPassword(rs.getString("password"));
                teacher.setEmail(rs.getString("email"));
                teacher.setFirstName(rs.getString("first_name"));
                teacher.setLastName(rs.getString("last_name"));
                teacher.setRole(new RoleDBO(rs.getInt("role_id"), "teacher")); // Tạo đối tượng RoleDBO từ role_id
                teacher.setAvatar(rs.getString("avatar"));
                teacher.setCreated_at(rs.getTimestamp("created_at"));
                teacher.setIs_looked(rs.getInt("is_locked"));
                teachers.add(teacher);
            }
        } catch (SQLException e) {
        }
        return teachers;
    }

    // Phương thức đếm tổng số giáo viên theo tìm kiếm
    public int countTeachers(String searchQuery) {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM [elearning].[dbo].[User] " +
                     "WHERE role_id = ? AND (first_name LIKE ? OR last_name LIKE ?)";

        try (
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, 2); // role_id = 2 cho giáo viên
            stmt.setString(2, "%" + searchQuery + "%");
            stmt.setString(3, "%" + searchQuery + "%");

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
        }
        return count;
    }
     // Hàm mới để lấy thông tin giáo viên bằng teacherId kiểu int
    public UserDBO getUserByID(int userID) {
        UserDBO user = null;
        String query = "SELECT * FROM [User] WHERE [user_id] = ?"; // Đảm bảo tên cột khớp với cơ sở dữ liệu
        
        try (
             PreparedStatement stmt = connection.prepareStatement(query)) {
             
            stmt.setInt(1, userID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user = new UserDBO();
                    user.setId(rs.getInt("user_id")); // Đảm bảo tên cột khớp với cơ sở dữ liệu
                    user.setFirstName(rs.getString("first_name"));
                    user.setLastName(rs.getString("last_name"));
                    user.setEmail(rs.getString("email"));
                    // Set other fields as needed
                }
            }
        } catch (SQLException e) {
        }
        return user;
    }
 //lay thong tin mentor
>>>>>>> origin/front-end
    public ArrayList<UserDBO> getUserByRoleID(String id) {
        String sql = "select * from [user]  join Role  on [user].role_id=role.role_id where role.role_id = ?";
        ArrayList<UserDBO> user = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                RoleDBO role = new RoleDBO(r.getInt("role_id"), r.getString("role_name"));
                user.add( new UserDBO(
                        r.getInt("user_id"),
                        r.getString("username"),
                        r.getString("password"), 
                        r.getString("email"),
                        r.getString("first_name"),
                        r.getString("last_name"),
                        r.getString("avatar"),
                        r.getDate("created_at"), 
                        r.getInt("is_locked"), 
                        r.getInt("is_deleted"), 
                        role));
            }
        } catch (SQLException e) {

        }
        return user;
    }
<<<<<<< HEAD
<<<<<<< HEAD
    public List<UserDBO> searchTeachers(String searchQuery, int page, int managerId) {
    List<UserDBO> teachers = new ArrayList<>();
    int pageSize = 10;
    int startItem = (page - 1) * pageSize;

    String sql = "SELECT u.[user_id], u.[username], u.[password], u.[email], u.[first_name], u.[last_name], u.[role_id], u.[avatar], u.[created_at], u.[is_locked], u.[is_deleted] " +
                 "FROM [elearning].[dbo].[User] u " +
                 "JOIN [elearning].[dbo].[MentorManager] mm ON u.[user_id] = mm.[MentorId] " +
                 "WHERE u.role_id = ? AND mm.[ManagerId] = ? AND (u.[first_name] LIKE ? OR u.[last_name] LIKE ?) " +
                 "ORDER BY u.[user_id] " +
                 "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

    try (
         PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, 2); // role_id = 2 cho giáo viên
        stmt.setInt(2, managerId); // ID của người quản lý đã đăng nhập
        stmt.setString(3, "%" + searchQuery + "%");
        stmt.setString(4, "%" + searchQuery + "%");
        stmt.setInt(5, startItem);
        stmt.setInt(6, pageSize);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            UserDBO teacher = new UserDBO();
            teacher.setId(rs.getInt("user_id"));
            teacher.setUsername(rs.getString("username"));
            teacher.setPassword(rs.getString("password"));
            teacher.setEmail(rs.getString("email"));
            teacher.setFirstName(rs.getString("first_name"));
            teacher.setLastName(rs.getString("last_name"));
            teacher.setRole(new RoleDBO(rs.getInt("role_id"), "teacher")); // Tạo đối tượng RoleDBO từ role_id
            teacher.setAvatar(rs.getString("avatar"));
            teacher.setCreated_at(rs.getTimestamp("created_at"));
            teacher.setIs_looked(rs.getInt("is_locked"));
            teachers.add(teacher);
        }
    } catch (SQLException e) {
        // Thêm log lỗi để biết chi tiết lỗi xảy ra
        
    }
    return teachers;
}
       // Phương thức đếm tổng số giáo viên theo tìm kiếm
    public int countTeachers(String searchQuery) {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM [elearning].[dbo].[User] " +
                     "WHERE role_id = ? AND (first_name LIKE ? OR last_name LIKE ?)";
>>>>>>> origin/create-course1

        try (
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, 2); // role_id = 2 cho giáo viên
            stmt.setString(2, "%" + searchQuery + "%");
            stmt.setString(3, "%" + searchQuery + "%");

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
        }
        return count;
    }
 public UserDBO getUserByID(int userID) {
        UserDBO user = null;
        String query = "SELECT * FROM [User] WHERE [user_id] = ?"; // Đảm bảo tên cột khớp với cơ sở dữ liệu
        
        try (
             PreparedStatement stmt = connection.prepareStatement(query)) {
             
            stmt.setInt(1, userID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user = new UserDBO();
                    user.setId(rs.getInt("user_id")); // Đảm bảo tên cột khớp với cơ sở dữ liệu
                    user.setFirstName(rs.getString("first_name"));
                    user.setLastName(rs.getString("last_name"));
                    user.setEmail(rs.getString("email"));
                    // Set other fields as needed
                }
            }
        } catch (SQLException e) {
        }
        return user;
    }
=======
>>>>>>> origin/crud_quiz
=======

>>>>>>> origin/front-end
=======

>>>>>>> origin/payment
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
//        System.out.println(dao.getUserByID("28"));
//System.out.println(dao.getUserByID("28"));
        //System.out.println(dao.LoginCheck("mentor", "1"));
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        System.out.println(dao.getUserByID("1"));
=======
        System.out.println(dao.getUserByID("46"));
>>>>>>> origin/DashBoard
=======
        System.out.println(dao.getUserByID("46"));
>>>>>>> origin/develop
=======
        System.out.println(dao.getUserByID("1"));
>>>>>>> origin/crud_quiz
=======
        System.out.println(dao.getUserByID("46"));
>>>>>>> origin/AdminManager
=======
        System.out.println(dao.getUserByID("46"));
>>>>>>> origin/comment
=======
        System.out.println(dao.getUserByID("1"));
>>>>>>> origin/create-course1
=======
        System.out.println(dao.getUserByID("1"));
>>>>>>> origin/front-end
=======
        System.out.println(dao.getUserByID("46"));
>>>>>>> origin/payment
    }
}
