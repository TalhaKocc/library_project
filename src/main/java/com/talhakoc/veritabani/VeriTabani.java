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



    public static void kitapGuncelle(int id, String yeniAdi, String yeniDurum) {
        String sql = "UPDATE kitaplar SET adi = ?, durumu = ? WHERE id = ?";

        try (Connection connection = VeriTabani.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

             ps.setString(1, yeniAdi);
             ps.setString(2, yeniDurum);
             ps.setInt(3, id);

             int rows = ps.executeUpdate();
             System.out.println(rows + " satır güncellendi.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}













































