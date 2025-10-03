package com.talhakoc.DAO;

import com.talhakoc.model.Books;
import com.talhakoc.pojo.BooksBean;
import com.talhakoc.pojo.MembersBean;

public interface BooksDAO {
    void booksList();
    void booksAdd (BooksBean booksBean);
    void booksBorrow(BooksBean booksBean, MembersBean membersBean);
    void booksReturn(BooksBean booksBean, MembersBean membersBean);

}
