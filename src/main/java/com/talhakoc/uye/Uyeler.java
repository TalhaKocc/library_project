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
                    int id = rs.getInt("uye_id");
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

    public static void uyeEkle(int uye_id, String uye_adi) {
        String sql = "INSERT INTO uyeler (uye_id, uye_adi) VALUES (?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, uye_id);  // ilk ? yerine kitap adı
            pstmt.setString(2, uye_adi);     // ikinci ? yerine yazar adı

            int etkilenenSatir = pstmt.executeUpdate();

            if (etkilenenSatir > 0) {
                System.out.println("Yeni üye eklendi: " + uye_id + " (" + uye_adi + ")");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
