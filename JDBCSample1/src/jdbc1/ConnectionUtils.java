package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtils {
    public static final String HOSTNAME = "localhost";
    public static final String PORT = "1433";
    public static final String DATABASE = "QLBH";
    public static final String USER = "sa";
    public static final String PW = "Diamond123456";

    public static Connection getConnection() {
        Connection conn = null;

        try {
            String url = "jdbc:sqlserver://" + HOSTNAME + ":" + PORT + ";databaseName=" + DATABASE;
            conn = DriverManager.getConnection(url, USER, PW);
            System.out.println("KET NOI THANH CONG");
        } catch (SQLException e) {
            System.out.println("KET NOI THAT BAI");
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
