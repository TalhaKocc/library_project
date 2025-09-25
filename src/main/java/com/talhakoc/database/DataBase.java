package com.talhakoc.database;
import java.sql.*;

public class DataBase{
    private static String url = "jdbc:mysql://localhost:3306/library";
    private static String user = "root";
    private static String password = "";


    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

}






































