package com.talhakoc.model;


import com.talhakoc.pojo.BooksBean;
import com.talhakoc.pojo.MembersBean;

import java.sql.*;

import static com.talhakoc.model.DataBase.getConnection;


public class Members{

    private String sqlMembersList="SELECT * FROM members";
    public void membersList(){
        try(Connection connection = getConnection();
            PreparedStatement pstmt =connection.prepareStatement(sqlMembersList);
            ResultSet rs=pstmt.executeQuery(); ) {
            while(rs.next()){
                MembersBean member = new MembersBean();
                member.setMemberId(rs.getLong("member_id"));
                member.setMemberName(rs.getString("member_name"));
                System.out.println("Üye " +member.getMemberId() +" "+ member.getMemberName());
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }




}
