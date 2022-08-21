package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
    private static Connection connection;

    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://${MYSQL_HOST:localhost}:3306/jsp?serverTimezone=Europe/Paris");
        } catch (Exception e) {
            e.getMessage();
        }
    }
    public static Connection getConnection() {
        return connection;
    }
}
