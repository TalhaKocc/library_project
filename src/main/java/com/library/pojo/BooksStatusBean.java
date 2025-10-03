package com.library.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class BooksStatusBean {
    private Long id;
    private BooksBean book;
    private MembersBean member;
    private Date date;

}
