package com.talhakoc.kitap;

import com.talhakoc.veritabani.VeriTabani;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

}
