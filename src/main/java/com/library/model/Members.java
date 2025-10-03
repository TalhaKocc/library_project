package com.library.model;


import com.library.dao.MemebersDAO;
import com.library.pojo.MembersBean;

import java.sql.*;

import static com.library.model.DataBase.getConnection;


public class Members implements MemebersDAO {

    private String sqlMembersList="SELECT * FROM members";
    @Override
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

    private String sqlMembersAdd = "INSERT INTO members(member_name) VALUES(?) ";
    @Override
    public void membersAdd(MembersBean member){

        try(Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sqlMembersAdd))
        {
            pstmt.setString(1,member.getMemberName());

            int effectedLines=pstmt.executeUpdate();
            if(effectedLines>0){
                System.out.println("Member added Successfully");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


}
