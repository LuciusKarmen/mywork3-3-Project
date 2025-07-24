package org.example.csdnb.dao;

public class Message {

    public String getMget() {
        return mget;
    }

    public void setMget(String mget) {
        this.mget = mget;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMsend() {
        return msend;
    }

    public void setMsend(String msend) {
        this.msend = msend;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public String getMcontent() {
        return mcontent;
    }

    public void setMcontent(String mcontent) {
        this.mcontent = mcontent;
    }

    public Boolean getMread() {
        return mread;
    }

    public void setMread(Boolean mread) {
        this.mread = mread;
    }

    public String getMtipid() {
        return mtipid;
    }

    public void setMtipid(String mtipid) {
        this.mtipid = mtipid;
    }

    private String  mid      ;
    private String  mname    ;
    private String  mget     ;
    private String  msend    ;
    private String  mtime    ;
    private String  mcontent ;
    private  Boolean mread    ;
    private String  mtipid   ;
}
