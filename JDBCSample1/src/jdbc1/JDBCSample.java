package jdbc1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSample {
    public static void main(String[] args) {
        way1();
        way2();
    }

    private static void way2() {
        try (Connection conn = ConnectionUtils.getConnection();
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM HOC_SINH");
            // MASV | TENSV|
            // SV_01 | Vu
            // SV_02 | Hoang
            // SV_03 | Truong
            // SV_04 | Nam
            // CON TRO: TRUOC SV_01
            rs.next();
            // CON TRO: SV_01
            System.out.println("MaSV:" + rs.getString("MaSV") + ", TenSV:" + rs.getString("TenSV"));
            rs.next();
            System.out.println("MaSV:" + rs.getString("MaSV") + ", TenSV:" + rs.getString("TenSV"));
            // CON TRO: SV_02
            rs.beforeFirst();
            // CON TRO: TRUOC SV_01
            System.out.println("MaSV:" + rs.getString("MaSV") + ", TenSV:" + rs.getString("TenSV")); // LOI
            rs.next();
            rs.next();
            rs.first();
            rs.last();
            rs.absolute(3);// SV_03 | Truong
            System.out.println(rs.getRow());//Print 3
            rs.absolute(1);// SV_01 | Vu
            rs.relative(2);//SV_03 | Truong
            rs.relative(-1); //SV_02 | Hoang 
            System.out.println(rs.getRow());//Print 2
            rs.previous();// SV_01 | Vu
            System.out.println(rs.getRow());//Print 1
            
            // UPDATE
            rs.updateString(2, "Huy");
            rs.updateRow();
            
            // DELETE
            rs.deleteRow();
            
            // INSERT
            rs.moveToInsertRow();
            rs.updateString("MaSV", "SV_05");
            rs.updateString(2, "Tuan");
            rs.insertRow();
            
            System.out.println("MaSV:" + rs.getString("MaSV") + ", TenSV:" + rs.getString("TenSV")); 
            rs.afterLast();
            System.out.println("MaSV:" + rs.getString("MaSV") + ", TenSV:" + rs.getString("TenSV")); // LOI
            
            // SEARCH
           while (rs.next()) {
            String masv = rs.getString(1);
            if ("SV_01".equals(masv)) {
                rs.updateString(2, "Huy");
                rs.updateRow();
                break;
            }
        }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void way1() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // Register driver manager
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Create connection
            conn = ConnectionUtils.getConnection();
            // Optional
            conn.setAutoCommit(false);
            // Create statement
//            stmt = conn.createStatement();
            stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            // Execute queries
            rs = stmt.executeQuery("SELECT MaSV, TenSV FROM SINH_VIEN");
            // Read
            while (rs.next()) {
                System.out.println("MaSV:" + rs.getString("MaSV") + ", TenSV:" + rs.getString("TenSV"));
            }
            // Optional
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            // Optional
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            ConnectionUtils.closeConnection(conn, stmt, rs);
        }
    }
}
