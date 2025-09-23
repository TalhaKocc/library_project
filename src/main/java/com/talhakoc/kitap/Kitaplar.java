package com.talhakoc.kitap;

import com.talhakoc.veritabani.VeriTabani;

import java.sql.*;
import java.time.LocalDate;

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

    public static void  kitapOduncAl(String kitapAdi, String uyeAdi) {
        String sqlKitap = "SELECT kitap_id, kitap_durumu FROM kitaplar WHERE kitap_adi = ?";
        String sqlUye = "SELECT uye_id FROM uyeler WHERE uye_adi = ?";
        String sqlGuncelleKitap = "UPDATE kitaplar SET kitap_durumu = 'Ödünç' WHERE kitap_id = ?";
        String sqlInsertOdunc = "INSERT INTO kitap_durumu (kitap_id, uye_id, odunc_tarihi) VALUES (?, ?, ?)";

        try (Connection connection = VeriTabani.getConnection()) {
            // 1️⃣ Kitap ve durumu
            PreparedStatement psKitap = connection.prepareStatement(sqlKitap);
            psKitap.setString(1, kitapAdi);
            ResultSet rsKitap = psKitap.executeQuery();

            if (rsKitap.next()) {
                int kitapId = rsKitap.getInt("kitap_id");
                String durum = rsKitap.getString("kitap_durumu");

                if (durum.equals("Müsait")) {
                    // 2️⃣ Üye id
                    PreparedStatement psUye = connection.prepareStatement(sqlUye);
                    psUye.setString(1, uyeAdi);
                    ResultSet rsUye = psUye.executeQuery();

                    if (rsUye.next()) {
                        int uyeId = rsUye.getInt("uye_id");

                        // 3️⃣ Kitap durumu güncelle
                        PreparedStatement psGuncelle = connection.prepareStatement(sqlGuncelleKitap);
                        psGuncelle.setInt(1, kitapId);
                        psGuncelle.executeUpdate();

                        // 4️⃣ Odunc tablosuna ekle
                        PreparedStatement psOdunc = connection.prepareStatement(sqlInsertOdunc);
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

    public static void kitapİadeAlma(String kitapAdi, String uyeAdi) {
        String sqlKitap = "SELECT kitap_id, kitap_durumu FROM kitaplar WHERE kitap_adi = ?";
        String sqlUye = "SELECT uye_id FROM uyeler WHERE uye_adi = ?";
        String sqlGuncelleKitap = "UPDATE kitaplar SET kitap_durumu = 'Müsait' WHERE kitap_id = ?";
        String sqlDeleteOdunc = "DELETE FROM kitap_durumu WHERE kitap_id = ? AND uye_id = ?";

        try (Connection connection = VeriTabani.getConnection()) {
            // Kitap id ve durumu
            PreparedStatement psKitap = connection.prepareStatement(sqlKitap);
            psKitap.setString(1, kitapAdi);
            ResultSet rsKitap = psKitap.executeQuery();

            if (rsKitap.next()) {
                int kitapId = rsKitap.getInt("kitap_id");
                String durum = rsKitap.getString("kitap_durumu");

                if (durum.equals("Ödünç")) {
                    // Üye id
                    PreparedStatement psUye = connection.prepareStatement(sqlUye);
                    psUye.setString(1, uyeAdi);
                    ResultSet rsUye = psUye.executeQuery();

                    if (rsUye.next()) {
                        int uyeId = rsUye.getInt("uye_id");

                        // Kitap durumu güncelle
                        PreparedStatement psGuncelle = connection.prepareStatement(sqlGuncelleKitap);
                        psGuncelle.setInt(1, kitapId);
                        psGuncelle.executeUpdate();

                        // Odunc tablosundan sil
                        PreparedStatement psDelete = connection.prepareStatement(sqlDeleteOdunc);
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

}
