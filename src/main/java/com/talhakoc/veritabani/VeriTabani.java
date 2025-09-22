package com.talhakoc.veritabani;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VeriTabani {
    private static final String URL = "jdbc:mysql://localhost:3306/kutuphane";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static  Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Veri Tabanı Bağlandı ");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }



}


 /*
    public void listeleUyeler() {
        Connection connection = getConnection(); // önce bağlantıyı al

        if(connection != null) {
            try {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM uyeler");

                while(rs.next()) {
                    int id = rs.getInt("uye_id");
                    String adi = rs.getString("uye_adi");
                    System.out.println(id + " - " + adi);
                }

                rs.close();
                stmt.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Bağlantı yok, listeleme yapılamaz!");
        }
       */


































