package com.talhakoc.uye;

import com.talhakoc.veritabani.VeriTabani;

import java.sql.*;

import static com.talhakoc.veritabani.VeriTabani.getConnection;

public class Uyeler {
    public static void uyeListele() {
        Connection connection = getConnection();

        if (connection != null) {
            try {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * from kitaplar");

                while (rs.next()) {
                    String id = rs.getString("uye_id");
                    String adi = rs.getString("uye_adi");
                    System.out.println(id + "-" + adi  + "-" );
                }
                stmt.close();
                rs.close();
                connection.close();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Veriler Getirilemedi");
        }
    }

    public static void uyeEkle(String uye_adi) {
        String sql = "INSERT INTO uyeler ( uye_adi) VALUES ( ?)";

        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {


            pstmt.setString(1, uye_adi);

            int etkilenenSatir = pstmt.executeUpdate();

            if (etkilenenSatir > 0) {
                System.out.println("Yeni üye eklendi: "  + " (" + uye_adi + ")");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
