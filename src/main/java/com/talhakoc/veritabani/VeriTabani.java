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


/*

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class KitapIslemleri {

    public void oduncAl(String kitapAdi, String uyeAdi) {
        String sqlKitap = "SELECT kitap_id, kitap_durumu FROM kitaplar WHERE kitap_adi = ?";
        String sqlUye = "SELECT uye_id FROM uyeler WHERE uye_adi = ?";
        String sqlGuncelleKitap = "UPDATE kitaplar SET kitap_durumu = 'Ödünç' WHERE kitap_id = ?";
        String sqlInsertOdunc = "INSERT INTO odunc (kitap_id, uye_id, odunc_tarihi) VALUES (?, ?, ?)";

        try (Connection con = VeriTabani.getConnection()) {
            // 1️⃣ Kitap ve durumu
            PreparedStatement psKitap = con.prepareStatement(sqlKitap);
            psKitap.setString(1, kitapAdi);
            ResultSet rsKitap = psKitap.executeQuery();

            if (rsKitap.next()) {
                int kitapId = rsKitap.getInt("kitap_id");
                String durum = rsKitap.getString("kitap_durumu");

                if (durum.equals("Müsait")) {
                    // 2️⃣ Üye id
                    PreparedStatement psUye = con.prepareStatement(sqlUye);
                    psUye.setString(1, uyeAdi);
                    ResultSet rsUye = psUye.executeQuery();

                    if (rsUye.next()) {
                        int uyeId = rsUye.getInt("uye_id");

                        // 3️⃣ Kitap durumu güncelle
                        PreparedStatement psGuncelle = con.prepareStatement(sqlGuncelleKitap);
                        psGuncelle.setInt(1, kitapId);
                        psGuncelle.executeUpdate();

                        // 4️⃣ Odunc tablosuna ekle
                        PreparedStatement psOdunc = con.prepareStatement(sqlInsertOdunc);
                        psOdunc.setInt(1, kitapId);
                        psOdunc.setInt(2, uyeId);
                        psOdunc.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
                        psOdunc.executeUpdate();

                        System.out.println("Kitap ödünç alındı: " + kitapAdi);
                    } else {
                        System.out.println("Üye bulunamadı: " + uyeAdi);
                    }
                } else {
                    System.out.println("Kitap ödünç durumda: " + kitapAdi);
                }
            } else {
                System.out.println("Kitap bulunamadı: " + kitapAdi);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


 */


/*

public void geriAl(String kitapAdi, String uyeAdi) {
    String sqlKitap = "SELECT kitap_id, kitap_durumu FROM kitaplar WHERE kitap_adi = ?";
    String sqlUye = "SELECT uye_id FROM uyeler WHERE uye_adi = ?";
    String sqlGuncelleKitap = "UPDATE kitaplar SET kitap_durumu = 'Müsait' WHERE kitap_id = ?";
    String sqlDeleteOdunc = "DELETE FROM odunc WHERE kitap_id = ? AND uye_id = ?";

    try (Connection con = VeriTabani.getConnection()) {
        // Kitap id ve durumu
        PreparedStatement psKitap = con.prepareStatement(sqlKitap);
        psKitap.setString(1, kitapAdi);
        ResultSet rsKitap = psKitap.executeQuery();

        if (rsKitap.next()) {
            int kitapId = rsKitap.getInt("kitap_id");
            String durum = rsKitap.getString("kitap_durumu");

            if (durum.equals("Ödünç")) {
                // Üye id
                PreparedStatement psUye = con.prepareStatement(sqlUye);
                psUye.setString(1, uyeAdi);
                ResultSet rsUye = psUye.executeQuery();

                if (rsUye.next()) {
                    int uyeId = rsUye.getInt("uye_id");

                    // Kitap durumu güncelle
                    PreparedStatement psGuncelle = con.prepareStatement(sqlGuncelleKitap);
                    psGuncelle.setInt(1, kitapId);
                    psGuncelle.executeUpdate();

                    // Odunc tablosundan sil
                    PreparedStatement psDelete = con.prepareStatement(sqlDeleteOdunc);
                    psDelete.setInt(1, kitapId);
                    psDelete.setInt(2, uyeId);
                    psDelete.executeUpdate();

                    System.out.println("Kitap geri alındı: " + kitapAdi);
                } else {
                    System.out.println("Üye bulunamadı: " + uyeAdi);
                }
            } else {
                System.out.println("Kitap zaten müsait: " + kitapAdi);
            }
        } else {
            System.out.println("Kitap bulunamadı: " + kitapAdi);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}


 */



































