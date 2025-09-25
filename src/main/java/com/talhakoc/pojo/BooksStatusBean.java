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

public class BooksStatusBean extends BooksBean {
    private Long status_id;
    private Date statusDate;

}
