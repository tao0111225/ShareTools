package com.shareTools.entity;

import java.util.Date;

public class UserEntity {

    private Long UserId;
    private String UserName;
    private String password;
    private Date  createTime;
    private Date UpdateTime;

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(Date updateTime) {
        UpdateTime = updateTime;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + UserId +
                ", UserName='" + UserName + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", UpdateTime=" + UpdateTime +
                '}';
    }
}
