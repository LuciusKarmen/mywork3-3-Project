package org.example.springboot.pojo;

public class Good {
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
        return "Good{" +
                "goodname='" + goodname + '\'' +
                ", goodprice='" + goodprice + '\'' +
                ", goodshop='" + goodshop + '\'' +
                ", goodid='" + goodid + '\'' +
                ", goodpath='" + goodpath + '\'' +
                ", goodclass='" + goodclass + '\'' +
                '}';
    }

    private String goodname;
    private String goodprice;
    private String goodshop;
    private String goodid;
    private String goodpath;

    public String getGoodclass() {
        return goodclass;
    }

    public void setGoodclass(String goodclass) {
        this.goodclass = goodclass;
    }

    private String goodclass;

}
