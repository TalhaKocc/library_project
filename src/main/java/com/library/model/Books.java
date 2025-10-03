
package com.library.model;

import com.library.dao.BooksDAO;
import com.library.pojo.BooksBean;
import com.library.pojo.MembersBean;

import java.sql.*;
import java.time.LocalDate;

import static com.library.model.DataBase.getConnection;


public class Books implements BooksDAO {

    private String sqlListBooks="SELECT * FROM books";

    @Override
    public void listBooks(){
        try(Connection connection = getConnection();
            PreparedStatement pstmt =connection.prepareStatement(sqlListBooks);
            ResultSet rs=pstmt.executeQuery(); ) {
            while(rs.next()){
                BooksBean book = new BooksBean();
                book.setId(rs.getLong("book_id"));
                book.setName(rs.getString("book_name"));
                book.setAuthor(rs.getString("book_author"));
                book.setStatus(rs.getString("book_status"));
                System.out.println("Kitap " +book.getId() +" "+ book.getName()+" " + book.getAuthor()+" "+ book.getStatus());
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private String sqlAddBooks = "INSERT INTO books(book_name,book_author,book_status) VALUES(?,?,?) ";
    @Override
    public void addBooks(BooksBean book){

        try(Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sqlAddBooks))
        {
            pstmt.setString(1,book.getName());
            pstmt.setString(2,book.getAuthor());
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

    @Override
    public void borrowBooks(BooksBean book, MembersBean member){
        try(Connection connection = getConnection();)
        {
            PreparedStatement psbook = connection.prepareStatement(sqlBook);
            psbook.setString(1, book.getName());
            ResultSet rs = psbook.executeQuery();

            if(rs.next()){
                book.setId(rs.getLong("book_id"));
                book.setStatus(rs.getString("book_status"));

                if(book.getStatus().equals("Müsait")){

                    PreparedStatement psmember = connection.prepareStatement(sqlMember);
                    psmember.setString(1, member.getName());
                    ResultSet rsmember = psmember.executeQuery();

                    if(rsmember.next()){
                        member.setId(rsmember.getLong("member_id"));

                        PreparedStatement psUpdate = connection.prepareStatement(sqlUpdateBook);
                        psUpdate.setLong(1, book.getId());
                        psUpdate.executeUpdate();

                        PreparedStatement psBorrow = connection.prepareStatement(sqlInsertBook);
                        psBorrow.setLong(1,book.getId());
                        psBorrow.setLong(2,member.getId());
                        psBorrow.setDate(3,java.sql.Date.valueOf(LocalDate.now()));
                        psBorrow.executeUpdate();

                        System.out.println("Kitap Ödünç Alındı");
                    }else {
                        System.out.println("Üye bulunamadı");
                    }

                }else {
                    System.out.println("Kitap Ödünç Durumda ");
                }
            }else {
                System.out.println("Kitap bulunamadı");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private String sqlBookReturn = "SELECT book_id, book_status FROM books WHERE book_name = ?";
    private String sqlMemberReturn = "SELECT member_id FROM members WHERE member_name = ?";
    private String sqlUpdateBookReturn = "UPDATE books SET book_status = 'Müsait' WHERE book_id = ?";
    private String sqlDeleteReturn = "DELETE FROM books_status WHERE book_id = ? AND member_id = ?";

    @Override
    public void returnBooks(BooksBean book, MembersBean member){
        try (Connection connection = getConnection()){

            PreparedStatement psbook = connection.prepareStatement(sqlBookReturn);
            psbook.setString(1, book.getName());
            ResultSet rs = psbook.executeQuery();
            if(rs.next()){
                book.setId(rs.getLong("book_id"));
                book.setStatus(rs.getString("book_status"));

                if(book.getStatus().equals("Ödünç")){
                    PreparedStatement psmember = connection.prepareStatement(sqlMemberReturn);
                    psmember.setString(1, member.getName());
                    ResultSet rsmember = psmember.executeQuery();

                    if(rsmember.next()){
                        member.setId(rsmember.getLong("member_id"));

                        PreparedStatement psUpdate = connection.prepareStatement(sqlUpdateBookReturn);
                        psUpdate.setLong(1, book.getId());
                        psUpdate.executeUpdate();

                        PreparedStatement psReturn = connection.prepareStatement(sqlDeleteReturn);
                        psReturn.setLong(1,book.getId() );
                        psReturn.setLong(2,member.getId() );
                        psReturn.executeUpdate();
                        System.out.println("Kitap Geri Alındı");

                    }else {
                        System.out.println("Üye Bulunamadı");
                    }

                }else {
                    System.out.println("Kitap Zaten Müsait");
                }


            }else {
                System.out.println("Kitap Bulunamadı");
            }



        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}


