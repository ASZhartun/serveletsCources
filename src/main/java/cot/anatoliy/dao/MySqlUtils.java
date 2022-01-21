package cot.anatoliy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlUtils {
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/my_database";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASSWORD = "root";
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    private static Connection connection;
    private static Statement statement;

    private static void checkDriver() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (connection == null || isConnectionClosed()) {
            checkDriver();
            try {
                connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    private static boolean isConnectionClosed()  {
        boolean closed = false;
        try {
            closed = connection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return closed;
    }

    public static Statement getStatement() {
        if (statement == null) {
            try {
                statement = getConnection().createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return statement;
    }
}
