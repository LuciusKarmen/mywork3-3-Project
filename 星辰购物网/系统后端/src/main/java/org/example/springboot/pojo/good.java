package org.example.springboot.pojo;

public class good {
    public String getGoodpath() {
        return goodpath;
    }

    public void setGoodpath(String goodpath) {
        this.goodpath = goodpath;
    }

    public String getGoodid() {
        return goodid;
    }

    public void setGoodid(String goodid) {
        this.goodid = goodid;
    }

    public String getGoodshop() {
        return goodshop;
    }

    public void setGoodshop(String goodshop) {
        this.goodshop = goodshop;
    }

    public String getGoodprice() {
        return goodprice;
    }

    public void setGoodprice(String goodprice) {
        this.goodprice = goodprice;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    @Override
    public String toString() {
        return "order{" +
                "goodname='" + goodname + '\'' +
                ", goodprice='" + goodprice + '\'' +
                ", goodshop='" + goodshop + '\'' +
                ", goodid='" + goodid + '\'' +
                ", goodpath='" + goodpath + '\'' +
                '}';
    }

    private String goodname;
    private String goodprice;
    private String goodshop;
    private String goodid;
    private String goodpath;

}
