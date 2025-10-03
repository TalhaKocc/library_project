package com.library.dao;

import com.library.pojo.BooksBean;
import com.library.pojo.MembersBean;

public interface BooksDAO {
    void listBooks();
    void addBooks(BooksBean booksBean);
    void borrowBooks(BooksBean booksBean, MembersBean membersBean);
    void returnBooks(BooksBean booksBean, MembersBean membersBean);

}
