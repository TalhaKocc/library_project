package com.talhakoc.pojo;

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
    private Long statusId;
    private BooksBean book;
    private MembersBean member;
    private Date statusDate;

}
