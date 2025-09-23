package com.talhakoc.veritabani;
import java.net.URL;
import java.sql.*;

public class VeriTabani {
    private static final String URL = "jdbc:mysql://localhost:3306/kutuphane";
    private static final String USER = "root";
    private static final String PASSWORD = "";


    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

}






































