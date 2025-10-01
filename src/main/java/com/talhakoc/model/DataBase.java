package com.talhakoc.model;
import java.sql.*;

public class  DataBase{
    private static final String url = "jdbc:mysql://localhost:3306/library";
    private static final String username = "root";
    private static final String password = "";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,username,password);
            System.out.println("database connected");

        }catch (SQLException e){
           e.printStackTrace();
        }
        return  connection;

    }

}






























/*


    private static String url = "jdbc:mysql://localhost:3306/library";
    private static String user = "root";
    private static String password = "";


    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

 */


/*

 public static void bookList() {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * from books");

                while (rs.next()) {
                    int id = rs.getInt("book_id");
                    String name = rs.getString("book_name");
                    String status = rs.getString("book_status");
                    System.out.println(id + "-" + name  + "-" + status);
                }
                stmt.close();
                rs.close();
                connection.close();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Veriler Getirilemedi");
        }
    }

    public static void bookAdd(String book_name,String book_author) {
        String sql = "INSERT INTO books (book_name,book_author,book_status) VALUES ( ?,?,?)";

        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {


            pstmt.setString(1, book_name);
            pstmt.setString(2, book_author);
            pstmt.setString(3,"Müsait");

            int effectedLine = pstmt.executeUpdate();

            if (effectedLine > 0) {
                System.out.println("Yeni kitap eklendi " + book_name + "-" + book_author + "-" );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void  bookBorrow(String bookName, String memberName) {
        String sqlBook = "SELECT book_id, book_status FROM books WHERE book_name = ?";
        String sqlMembers = "SELECT member_id FROM members WHERE member_name = ?";
        String sqlUpdateBooks = "UPDATE books SET book_status = 'Ödünç' WHERE book_id = ?";
        String sqlInsertBooks = "INSERT INTO books_status (book_id, member_id, status_date) VALUES (?, ?, ?)";

        try (Connection connection = DataBase.getConnection()) {

            PreparedStatement psBook = connection.prepareStatement(sqlBook);
            psBook.setString(1, bookName);
            ResultSet rsBook = psBook.executeQuery();

            if (rsBook.next()) {
                int bookId = rsBook.getInt("book_id");
                String status = rsBook.getString("book_status");

                if (status.equals("Müsait")) {

                    PreparedStatement psMember = connection.prepareStatement(sqlMembers);
                    psMember.setString(1, memberName);
                    ResultSet rsMember = psMember.executeQuery();

                    if (rsMember.next()) {
                        int memberId = rsMember.getInt("member_id");


                        PreparedStatement psUpdate = connection.prepareStatement(sqlUpdateBooks);
                        psUpdate.setInt(1, bookId);
                        psUpdate.executeUpdate();


                        PreparedStatement psBorrow = connection.prepareStatement(sqlInsertBooks);
                        psBorrow.setInt(1, bookId);
                        psBorrow.setInt(2, memberId);
                        psBorrow.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
                        psBorrow.executeUpdate();

                        System.out.println("Kitap ödünç alındı: " + bookName);
                    } else {
                        System.out.println("Üye bulunamadı: " + memberName);
                    }
                } else {
                    System.out.println("Kitap ödünç durumda: " + bookName);
                }
            } else {
                System.out.println("Kitap bulunamadı: " + bookName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void bookReturn(String bookName, String memberName) {
        String sqlBook = "SELECT book_id, book_status FROM books WHERE book_name = ?";
        String sqlMember = "SELECT member_id FROM members WHERE member_name = ?";
        String sqlUpdateBook = "UPDATE books SET book_status = 'Müsait' WHERE book_id = ?";
        String sqlDeleteBorrowBook = "DELETE FROM books_status WHERE book_id = ? AND member_id = ?";

        try (Connection connection = DataBase.getConnection()) {

            PreparedStatement psBook = connection.prepareStatement(sqlBook);
            psBook.setString(1, bookName);
            ResultSet rsBook = psBook.executeQuery();

            if (rsBook.next()) {
                int bookId = rsBook.getInt("book_id");
                String status = rsBook.getString("book_status");

                if (status.equals("Ödünç")) {

                    PreparedStatement psMember = connection.prepareStatement(sqlMember);
                    psMember.setString(1, memberName);
                    ResultSet rsMember = psMember.executeQuery();

                    if (rsMember.next()) {
                        int uyeId = rsMember.getInt("member_id");


                        PreparedStatement psUpdate = connection.prepareStatement(sqlUpdateBook);
                        psUpdate.setInt(1, bookId);
                        psUpdate.executeUpdate();


                        PreparedStatement psDelete = connection.prepareStatement(sqlDeleteBorrowBook);
                        psDelete.setInt(1, bookId);
                        psDelete.setInt(2, uyeId);
                        psDelete.executeUpdate();

                        System.out.println("Kitap geri alındı: " + bookName);
                    } else {
                        System.out.println("Üye bulunamadı: " + memberName);
                    }
                } else {
                    System.out.println("Kitap zaten müsait: " + bookName);
                }
            } else {
                System.out.println("Kitap bulunamadı: " + bookName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

 */






