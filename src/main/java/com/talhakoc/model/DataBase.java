package com.talhakoc.model;
import java.sql.*;

public class  DataBase{
    private static final String url = "jdbc:mysql://localhost:3306/library";
    private static final String username = "root";
    private static final String password = "";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,username,password);
            System.out.println("database connected");

        }catch (SQLException e){
           e.printStackTrace();
        }
        return  connection;

    }

}


