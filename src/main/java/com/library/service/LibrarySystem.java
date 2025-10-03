package com.library.service;

import com.library.model.Books;
import com.library.model.Members;
import com.library.pojo.BooksBean;
import com.library.pojo.MembersBean;

import java.util.Scanner;

public class LibrarySystem {
   public static void  booksListing (){
       Books books = new Books();
       books.booksList();
   }

   public static void bookAdd(){
       Scanner input = new Scanner(System.in);
       Books books = new Books();
       BooksBean booksBean = new BooksBean();
       System.out.print("Kitap Adı Giriniz: ");
       String bookName = input.nextLine();
       System.out.print("Kitap Yazarı Giriniz: ");
       String bookAuthor = input.nextLine();
       booksBean.setBookName(bookName);
       booksBean.setBookAuthor(bookAuthor);
       books.booksAdd(booksBean);
   }

    public static void bookBorrowing(){
        Scanner input = new Scanner(System.in);
        BooksBean booksBean = new BooksBean();
        Books books = new Books();
        MembersBean membersBean = new MembersBean();
        System.out.print("Kitap Adı Giriniz: ");
        String bookName = input.nextLine();
        System.out.println("Üye Adı Giriniz: ");
        String memberName = input.nextLine();
        booksBean.setBookName(bookName);
        membersBean.setMemberName(memberName);
        books.booksBorrow(booksBean,membersBean);
    }

    public static void bookReturning(){
        Scanner input = new Scanner(System.in);
        BooksBean booksBean = new BooksBean();
        MembersBean membersBean = new MembersBean();
        Books books = new Books();
        System.out.println("Kitap Adı Giriniz: ");
        String bookName = input.nextLine();
        System.out.println("Üye Adı Giriniz: ");
        String memberName = input.nextLine();
        booksBean.setBookName(bookName);
        membersBean.setMemberName(memberName);
        books.booksReturn(booksBean,membersBean);
    }

    public static void memberAdd(){
        Scanner input = new Scanner(System.in);
        MembersBean membersBean = new MembersBean();
        Members  members = new Members();
        System.out.print("Üye Adı Giriniz: ");
        String memberName = input.nextLine();
        membersBean.setMemberName(memberName);
        members.membersAdd(membersBean);
    }
}











































/*
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
        Books.bookAdd(bookNameAdd,bookAuthorAdd);
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


    public static void membersAdd() {
        Scanner input = new Scanner(System.in);
        System.out.println("Üye Adı Giriniz");
        String memberAdd = input.nextLine();
        Members.membersAdd(memberAdd);
    }






*/



