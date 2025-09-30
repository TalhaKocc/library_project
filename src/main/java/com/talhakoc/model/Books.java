
package com.talhakoc.model;

import com.talhakoc.pojo.BooksBean;
import lombok.Getter;
import lombok.Setter;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.talhakoc.model.DataBase.getConnection;


public class Books {

    private String sqlBooksList="SELECT * FROM books";
    public void bookList(){
        try(Connection connection = getConnection();
            PreparedStatement pstmt =connection.prepareStatement(sqlBooksList);
            ResultSet rs=pstmt.executeQuery(); ) {
            while(rs.next()){
                BooksBean book=new BooksBean();
                book.setBookId(rs.getLong("book_id"));
                book.setBookName(rs.getString("book_name"));
                book.setBookAuthor(rs.getString("book_author"));
                book.setBookStatus(rs.getString("book_status"));
                System.out.println("Kitap " +book.getBookId() +" "+ book.getBookName()+" " + book.getBookAuthor()+" "+ book.getBookStatus());
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private String sqlBooksAdd = "INSERT INTO books(book_name,book_author,book_status) VALUES(?,?,?) ";
    public void booksAdd(BooksBean book){

        try(Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sqlBooksAdd))
        {
            pstmt.setString(1,book.getBookName());
            pstmt.setString(2,book.getBookAuthor());
            pstmt.setString(3,"Müsait");

            int effectedLines=pstmt.executeUpdate();
            if(effectedLines>0){
                System.out.println("Books added Successfully");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}


