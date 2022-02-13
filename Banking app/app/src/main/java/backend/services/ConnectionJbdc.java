package backend.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionJbdc {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/banking-app";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "Agent47owns@";

    public static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", DATABASE_USERNAME);
        properties.setProperty("password", DATABASE_PASSWORD);

        return DriverManager.getConnection(DATABASE_URL, properties);
    }
}
