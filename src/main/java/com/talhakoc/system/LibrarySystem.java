package com.talhakoc.system;

import com.talhakoc.book.Books;
import com.talhakoc.member.Members;

import java.util.Scanner;

public class LibrarySystem {

    public static void booksListing(){
        Books.bookList();
    }

    public static void booksAdd(){
        Scanner input = new Scanner(System.in);
        System.out.println("Kitap Adı Giriniz");
        String bookNameAdd = input.nextLine();
        System.out.println("Kitap Yazarı Giriniz");
        String bookAuthorAdd = input.nextLine();
        System.out.println("Kitap Durumu Giriniz");
        String bookStatusAdd = input.nextLine();
        Books.bookAdd(bookNameAdd,bookAuthorAdd,bookStatusAdd);
    }

    public static void booksBorrowing(){
        Scanner input = new Scanner(System.in);
        System.out.println("Kitap Adı Giriniz");
        String bookName = input.nextLine();
        System.out.println("Üye Adı Giriniz");
        String memberName = input.nextLine();
        Books.bookBorrow(bookName,memberName);
    }

    public static void booksReturning(){
        Scanner input = new Scanner(System.in);
        System.out.println("Kitap Adı Giriniz");
        String returnBook = input.nextLine();
        System.out.println("Üye Adı Giriniz");
        String returnMember = input.nextLine();
        Books.bookReturn(returnBook,returnMember);
    }


    public static void membersAdd(){
        Scanner input = new Scanner(System.in);
        System.out.println("Üye Adı Giriniz");
        String memberAdd = input.nextLine();
        Members.membersAdd(memberAdd);
    }







}
