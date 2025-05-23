package org.example.springboot.pojo;

public class user {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getuserpath() {
        return userpath;
    }

    public void setuserpath(String suserpath) {
        this.userpath = suserpath;
    }

    @Override
    public String toString() {
        return "user{" +
                "username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", userid='" + userid + '\'' +
                ", userpath='" + userpath + '\'' +
                '}';
    }

    private String username;
    private String userpassword;
    private String userid;
    private String userpath;



}
