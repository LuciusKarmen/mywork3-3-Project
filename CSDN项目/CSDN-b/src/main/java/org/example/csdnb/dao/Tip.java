package org.example.csdnb.dao;

public class Tip {


    public String getTcontent() {
        return tcontent;
    }

    public void setTcontent(String tcontent) {
        this.tcontent = tcontent;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTtime() {
        return ttime;
    }

    public void setTtime(String ttime) {
        this.ttime = ttime;
    }

    public String getTuser() {
        return tuser;
    }

    public void setTuser(String tuser) {
        this.tuser = tuser;
    }

    public Integer getTgood() {
        return tgood;
    }

    public void setTgood(Integer tgood) {
        this.tgood = tgood;
    }

    public Integer getTmessage() {
        return tmessage;
    }

    public void setTmessage(Integer tmessage) {
        this.tmessage = tmessage;
    }

    public String getTpic() {
        return tpic;
    }

    public void setTpic(String tpic) {
        this.tpic = tpic;
    }

    private String tid;
    private String tname;
    private String tcontent;
    private String ttime;
    private String tuser;
    private Integer tgood;
    private Integer tmessage;
    private String tpic;

    public String getTclass() {
        return tclass;
    }

    public void setTclass(String tclass) {
        this.tclass = tclass;
    }

    private String tclass;
}