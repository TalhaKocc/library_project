package com.library.model;


import com.library.dao.MembersDAO;
import com.library.pojo.MembersBean;

import java.sql.*;

import static com.library.model.DataBase.getConnection;


public class Members implements MembersDAO {

    private String sqlListMembers="SELECT * FROM members";
    @Override
    public void listMembers(){
        try(Connection connection = getConnection();
            PreparedStatement pstmt =connection.prepareStatement(sqlListMembers);
            ResultSet rs=pstmt.executeQuery(); ) {
            while(rs.next()){
                MembersBean member = new MembersBean();
                member.setId(rs.getLong("member_id"));
                member.setName(rs.getString("member_name"));
                System.out.println("Üye " +member.getId() +" "+ member.getName());
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private String sqlMembersAdd = "INSERT INTO members(member_name) VALUES(?) ";
    @Override
    public void addMembers(MembersBean member){

        try(Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sqlMembersAdd))
        {
            pstmt.setString(1,member.getName());

            int effectedLines=pstmt.executeUpdate();
            if(effectedLines>0){
                System.out.println("Member added Successfully");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


}
