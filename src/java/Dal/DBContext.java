/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import java.sql.*;

/**
 *
 * @author hatro
 */
public class DBContext {

    protected Connection connection;
    protected PreparedStatement statement;
    protected ResultSet resultSet;

    /**
     * get an connection
     *
     * @return connection or null
     * @throws ClassNotFoundException
     */
    public DBContext() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=elearning";
            String user = "sa";
<<<<<<< HEAD
            String password = "1";
=======
            String password = "123456";
>>>>>>> origin/AdminManager
            connection = DriverManager.getConnection(url, user, password);

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error " + e.getMessage() + " at DBContext");

        }
    }

    public static void main(String[] args) {
        DBContext db = new DBContext();
        System.out.println(db.connection);
    }
}
