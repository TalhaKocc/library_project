package com.talhakoc.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class BooksBean {
    private Long bookId;
    private String bookName;
    private String bookAuthor;
    private String bookStatus;
}


