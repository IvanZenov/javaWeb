package by.bsu.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String URL = "jdbc:mysql://localhost:3306/videolibrary?useUnicode=true&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Connection newConnection() throws SQLException {
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);

    }
}
