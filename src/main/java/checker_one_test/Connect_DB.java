package checker_one_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect_DB {
	private static String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=check_one;";
    private static final String USER = "sa";
    private static final String PASS = "12345";

    public static Connection getConnect() {
        Connection conn = null;
        try {
            Class.forName(Driver);
            try {
                conn = DriverManager.getConnection(URL, USER, PASS);
                return conn;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
