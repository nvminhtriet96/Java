package jdbc1;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) {
        Connection conn = ConnectionUtils.getConnection();
    }
}
