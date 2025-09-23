package com.talhakoc.main;

import com.talhakoc.kitap.Kitaplar;
import com.talhakoc.sistem.KutuphaneSistemi;
import com.talhakoc.uye.Uyeler;
import com.talhakoc.veritabani.VeriTabani;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("******** Kütüphane Sistemine Hoşgeldiniz *******");
        Scanner oku = new Scanner(System.in);
        System.out.print("1- Kitap Ekle\n" +
                "2- Kitapları Listele\n" +
                "3- Üye Ekle\n" +
                "4- Kitap Ödünç Al\n" +
                "5- Kitap İade Et\n" +
                "6- Çıkış\n" +
                "Seçiminiz: ");
        int deger = oku.nextInt();
         switch (deger) {
                case 1: KutuphaneSistemi.kitaplariEkleme(); break;
                case 2: KutuphaneSistemi.kitaplariListele(); break;
                case 3: KutuphaneSistemi.uyeleriEkleme(); break;
                case 4: break;
                case 5: break;
                case 6: break;
            }




    }
}

