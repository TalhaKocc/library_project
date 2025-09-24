package com.talhakoc.pojo;

public class MembersBean {
    private Long memberId;
    private String memberName;

    public MembersBean() {
    }

    public MembersBean(Long memberId, String memberName) {
        this.memberId = memberId;
        this.memberName = memberName;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}
