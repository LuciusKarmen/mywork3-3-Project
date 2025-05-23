package org.example.springboot.pojo;

public class shop {
    public String getShopid() {
        return shopid;
    }

    public void setShopid(String shopid) {
        this.shopid = shopid;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getShoppassword() {
        return shoppassword;
    }

    public void setShoppassword(String shoppassword) {
        this.shoppassword = shoppassword;
    }

    public String getShoppath() {
        return shoppath;
    }

    public void setShoppath(String shoppath) {
        this.shoppath = shoppath;
    }

    @Override
    public String toString() {
        return "shop{" +
                "shopname='" + shopname + '\'' +
                ", shoppassword='" + shoppassword + '\'' +
                ", shopid='" + shopid + '\'' +
                ", shoppath='" + shoppath + '\'' +
                '}';
    }

    private String shopname;
    private String shoppassword;
    private String shopid;
    private String shoppath;



}
