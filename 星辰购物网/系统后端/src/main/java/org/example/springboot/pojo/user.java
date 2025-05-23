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

    public String getSuserpath() {
        return suserpath;
    }

    public void setSuserpath(String suserpath) {
        this.suserpath = suserpath;
    }

    @Override
    public String toString() {
        return "user{" +
                "username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", userid='" + userid + '\'' +
                ", suserpath='" + suserpath + '\'' +
                '}';
    }

    private String username;
    private String userpassword;
    private String userid;
    private String suserpath;



}
