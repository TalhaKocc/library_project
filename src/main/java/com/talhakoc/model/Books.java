
package com.talhakoc.model;

import com.talhakoc.pojo.BooksBean;
import com.talhakoc.pojo.BooksStatusBean;
import com.talhakoc.pojo.MembersBean;
import lombok.Getter;
import lombok.Setter;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.talhakoc.model.DataBase.getConnection;


public class Books {

    private String sqlBooksList="SELECT * FROM books";
    public void bookList(BooksBean book){
        try(Connection connection = getConnection();
            PreparedStatement pstmt =connection.prepareStatement(sqlBooksList);
            ResultSet rs=pstmt.executeQuery(); ) {
            while(rs.next()){
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

    private String sqlBook = "SELECT book_id, book_status FROM books WHERE book_name = ?";
    private String sqlMember = "SELECT member_id FROM members WHERE member_name = ?";
    private String sqlUpdateBook = "UPDATE books SET book_status = 'Ödünç' WHERE book_id = ?";
    private String sqlInsertBook = "INSERT INTO books_status (book_id, member_id, status_date) VALUES (?, ?, ?)";

    public void bookBorrow(BooksBean book, MembersBean member, BooksStatusBean  status){
        try(Connection connection = getConnection();)
        {
            PreparedStatement psbook = connection.prepareStatement(sqlBook);
            ResultSet rs = psbook.executeQuery();
            psbook.setString(1, book.getBookName());
            if(rs.next()){
                book.setBookId(rs.getLong("book_id"));
                book.setBookStatus(rs.getString("book_status"));
                if(book.getBookStatus().equals("Müsait")){
                    PreparedStatement psmember = connection.prepareStatement(sqlMember);
                    ResultSet rsmember=psmember.executeQuery();
                    psmember.setString(1, member.getMemberName());
                    if(rsmember.next()){
                        member.setMemberId(rsmember.getLong("member_id"));
                    }



                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}


