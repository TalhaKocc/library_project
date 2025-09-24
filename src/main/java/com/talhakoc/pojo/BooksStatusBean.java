package com.talhakoc.pojo;

import java.util.Date;

public class BooksStatusBean {
    private Long status_id;
    private Long memberId;
    private Long bookId;
    private Date statusDate;

    public BooksStatusBean() {
    }

    public BooksStatusBean(Long status_id, Long memberId, Long bookId, Date statusDate) {
        this.status_id = status_id;
        this.memberId = memberId;
        this.bookId = bookId;
        this.statusDate = statusDate;
    }

    public Long getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Long status_id) {
        this.status_id = status_id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }
}
