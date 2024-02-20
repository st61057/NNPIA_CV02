package com.example.NNPIA_CV02.model;

public class User {
    public Integer userId;
    public String userName;
    public String fullName;

    public User(Integer userId, String userName, String fullName) {
        this.userId = userId;
        this.userName = userName;
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
