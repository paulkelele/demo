package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
    private static Connection connection;

    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String urlConnection = "jdbc:mysql://localhost:3306/tada?serverTimezone=Europe/Paris&useUnicode=true&characterEncoding=UTF8";
            String user="root";
            String password="cerise";
            connection = DriverManager.getConnection(urlConnection, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return connection;
    }
}
