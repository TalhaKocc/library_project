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
    private Long status_id;
    private Long memberId;
    private Long bookId;
    private Date statusDate;

}
