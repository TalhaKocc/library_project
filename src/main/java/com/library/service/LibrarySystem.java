package com.library.service;

import com.library.model.Books;
import com.library.model.Members;
import com.library.pojo.BooksBean;
import com.library.pojo.MembersBean;

import java.util.Scanner;

public class LibrarySystem {
   public static void  listBook(){
       Books books = new Books();
       books.listBooks();
   }

   public static void addBook(){
       Scanner input = new Scanner(System.in);
       Books books = new Books();
       BooksBean booksBean = new BooksBean();
       System.out.print("Kitap Adı Giriniz: ");
       String bookName = input.nextLine();
       System.out.print("Kitap Yazarı Giriniz: ");
       String bookAuthor = input.nextLine();
       booksBean.setName(bookName);
       booksBean.setAuthor(bookAuthor);
       books.addBooks(booksBean);
   }

    public static void borrowBook(){
        Scanner input = new Scanner(System.in);
        BooksBean booksBean = new BooksBean();
        Books books = new Books();
        MembersBean membersBean = new MembersBean();
        System.out.print("Kitap Adı Giriniz: ");
        String bookName = input.nextLine();
        System.out.println("Üye Adı Giriniz: ");
        String memberName = input.nextLine();
        booksBean.setName(bookName);
        membersBean.setName(memberName);
        books.borrowBooks(booksBean,membersBean);
    }

    public static void returnBook(){
        Scanner input = new Scanner(System.in);
        BooksBean booksBean = new BooksBean();
        MembersBean membersBean = new MembersBean();
        Books books = new Books();
        System.out.println("Kitap Adı Giriniz: ");
        String bookName = input.nextLine();
        System.out.println("Üye Adı Giriniz: ");
        String memberName = input.nextLine();
        booksBean.setName(bookName);
        membersBean.setName(memberName);
        books.returnBooks(booksBean,membersBean);
    }

    public static void listMember(){
        Scanner input = new Scanner(System.in);
        MembersBean membersBean = new MembersBean();
        Members  members = new Members();
        System.out.print("Üye Adı Giriniz: ");
        String memberName = input.nextLine();
        membersBean.setName(memberName);
        members.addMembers(membersBean);
    }

    public static void addMember(){
       Members members = new Members();
       members.listMembers();
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



