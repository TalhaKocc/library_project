package com.talhakoc.member;

import com.talhakoc.database.DataBase;

import java.sql.*;



public class Members extends DataBase {

    public static void membersAdd(String member_name) {
        String sql = "INSERT INTO members (member_name) VALUES (?)";

        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {


            pstmt.setString(1,member_name);

            int affectedLine = pstmt.executeUpdate();

            if (affectedLine > 0) {
                System.out.println("Yeni üye eklendi: "  + " (" + member_name + ")");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
