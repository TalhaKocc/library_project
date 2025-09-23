package com.talhakoc.kitap;

import com.talhakoc.veritabani.VeriTabani;

import java.sql.*;

import static com.talhakoc.veritabani.VeriTabani.getConnection;

public class Kitaplar {

    public static void kitapListele() {
        Connection connection = getConnection();

        if (connection != null) {
            try {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * from kitaplar");

                while (rs.next()) {
                    int id = rs.getInt("kitap_id");
                    String adi = rs.getString("kitap_adi");
                    String durum = rs.getString("kitap_durumu");
                    System.out.println(id + "-" + adi  + "-" + durum);
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

    public static void kitapEkle(String kitap_adi,String kitap_yazari,String kitap_durumu) {
        String sql = "INSERT INTO kitaplar (kitap_adi,kitap_yazari,kitap_durumu) VALUES ( ?,?,?)";

        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {


            pstmt.setString(1, kitap_adi);
            pstmt.setString(2, kitap_yazari);
            pstmt.setString(3, kitap_durumu);

            int etkilenenSatir = pstmt.executeUpdate();

            if (etkilenenSatir > 0) {
                System.out.println("Yeni kitap eklendi " + kitap_adi + "-" + kitap_yazari + "-" + kitap_durumu);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
