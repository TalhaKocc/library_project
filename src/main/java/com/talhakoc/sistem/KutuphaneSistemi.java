package com.talhakoc.sistem;

import com.talhakoc.kitap.Kitaplar;
import com.talhakoc.uye.Uyeler;
import com.talhakoc.veritabani.VeriTabani;

import java.sql.Connection;
import java.util.Scanner;

public class KutuphaneSistemi {

    public static void kitaplariListele(){
        Kitaplar.kitapListele();
    }

    public static void kitaplariEkleme(){
        Scanner input = new Scanner(System.in);
        System.out.println("Kitap Adı Giriniz");
        String kitapAdiEkle = input.nextLine();
        System.out.println("Kitap Yazarı Giriniz");
        String kitapYazariEkle = input.nextLine();
        System.out.println("Kitap Durumu Giriniz");
        String kitapDurumEkle = input.nextLine();
        Kitaplar.kitapEkle(kitapAdiEkle,kitapYazariEkle,kitapDurumEkle);
    }

    public static void kitapOduncAlma(){
        Scanner input = new Scanner(System.in);
        System.out.println("Kitap Adı Giriniz");
        String kitapAdiGiriniz = input.nextLine();
        System.out.println("Üye Adı Giriniz");
        String uyeAdiGiriniz = input.nextLine();
        Kitaplar.kitapOduncAl(kitapAdiGiriniz,uyeAdiGiriniz);
    }

    public static void kitapGeriVerme(){
        Scanner input = new Scanner(System.in);
        System.out.println("Kitap Adı Giriniz");
        String iadeKitapAdi = input.nextLine();
        System.out.println("Üye Adı Giriniz");
        String iadeUyeAdi = input.nextLine();
        Kitaplar.kitapİadeAlma(iadeKitapAdi,iadeUyeAdi);
    }


    public static void uyeleriEkleme(){
        Scanner input = new Scanner(System.in);
        System.out.println("Üye Adı Giriniz");
        String uyeEkle = input.nextLine();
        Uyeler.uyeEkle(uyeEkle);
    }







}
