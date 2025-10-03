package com.library.dao;

import com.library.pojo.MembersBean;

import java.lang.reflect.Member;
import java.sql.SQLException;

public interface MembersDAO {
    void listMembers();
    void addMembers(MembersBean membersBean);
}
