package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/sitio_palmital";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch (SQLException e) {
            System.err.println("Failed to connect to the database.");
            throw e;
        }
    }
}

