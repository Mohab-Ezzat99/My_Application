package com.example.myapplication.model;

public class UserModel {
    String name , username , emaill , password ;


    public UserModel(String name, String username, String password) {
    }

    public UserModel(String name, String username, String emaill, String password) {
        this.name = name;
        this.username = username;
        this.emaill = emaill;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmaill() {
        return emaill;
    }

    public void setEmaill(String emaill) {
        this.emaill = emaill;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
