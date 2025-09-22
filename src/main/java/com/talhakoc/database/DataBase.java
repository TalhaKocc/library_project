package com.talhakoc.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

    private static final String URL = "jdbc:mysql://localhost:3306/okul";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // boş şifre

    public static Connection Connection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Veritabanına bağlantı başarılı!");
        } catch (SQLException e) {
            System.out.println("Veritabanına bağlanırken hata oluştu!");
        }
        return connection;
    }
}













/*
package com.talhakoc.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

    private static final String URL = "jdbc:mysql://localhost:3306/okul";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // boş şifre

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Veritabanına bağlantı başarılı!");
        } catch (SQLException e) {
            System.out.println("Veritabanına bağlanırken hata oluştu!");
        }
        return connection;
    }
}

*/