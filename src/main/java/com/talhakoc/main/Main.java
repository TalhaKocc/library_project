package com.talhakoc.main;

import com.talhakoc.service.LibrarySystem;

import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {
        System.out.println("******** Kütüphane Sistemine Hoşgeldiniz *******");
        Scanner print = new Scanner(System.in);
        int value = 0;

        while (value !=6) {

            System.out.print("1- Kitap Ekle\n" +
                    "2- Kitapları Listele\n" +
                    "3- Üye Ekle\n" +
                    "4- Kitap Ödünç Al\n" +
                    "5- Kitap İade Et\n" +
                    "6- Çıkış\n" +
                    "Seçiminiz: ");
            value = print.nextInt();
            switch (value) {
                case 1: LibrarySystem.bookAdd(); break;
                case 2: LibrarySystem.booksListing(); break;
                case 3: LibrarySystem.memberAdd(); break;
                case 4: LibrarySystem.bookBorrowing(); break;
                case 5: LibrarySystem.bookReturning(); break;
                case 6: System.out.println("Sistemden Çıkış Yaptınız İyi Günler"); break;
                default: System.out.println("Geçersiz Seçim Tekrar Deneyiniz"); break;
            }
        }

    }
}
