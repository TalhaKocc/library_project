package com.talhakoc.main;

import com.talhakoc.system.LibrarySystem;

import java.util.Scanner;

public class Main extends LibrarySystem {
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
              case 1: LibrarySystem.booksAdd(); break;
              case 2: LibrarySystem.booksListing(); break;
              case 3: LibrarySystem.membersAdd(); break;
              case 4: LibrarySystem.booksBorrowing(); break;
              case 5: LibrarySystem.booksReturning(); break;
              case 6: System.out.println("Sistemden Çıkış Yaptınız İyi Günler"); break;
              default: System.out.println("Geçersiz Seçim Tekrar Deneyiniz"); break;
          }
      }




    }
}

