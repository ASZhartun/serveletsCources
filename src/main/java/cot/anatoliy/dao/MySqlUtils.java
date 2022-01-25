package cot.anatoliy.dao;

import org.apache.commons.dbcp2.DriverManagerConnectionFactory;

import java.sql.*;

public class MySqlUtils {
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/my_database";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASSWORD = "root";
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    private static DriverManagerConnectionFactory driverManagerConnection =  new DriverManagerConnectionFactory(JDBC_URL, JDBC_USER, JDBC_PASSWORD);


    public static Connection getConnection() throws SQLException {
        return driverManagerConnection.createConnection();
    }


}
