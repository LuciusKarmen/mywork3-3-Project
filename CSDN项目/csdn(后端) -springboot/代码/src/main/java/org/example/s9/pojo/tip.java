package org.example.s9.pojo;

public class tip {
    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTcontent() {
        return tcontent;
    }

    public void setTcontent(String tcontent) {
        this.tcontent = tcontent;
    }

    public Integer getTlike() {
        return tlike;
    }

    public void setTlike(Integer tlike) {
        this.tlike = tlike;
    }

    @Override
    public String toString() {
        return "tip{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", tcontent='" + tcontent + '\'' +
                ", tlike=" + tlike +
                '}';
    }

    private Integer tid;
    private String tname;
    private String tcontent;
    private Integer tlike;

}
