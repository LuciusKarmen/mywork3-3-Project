package com.xgm.pojo;

public class Tip {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    private Integer id;
    private String tip;
    private String name;
    private Integer like;

    @Override
    public String toString() {
        return "Tip{" +
                "id=" + id +
                ", tip='" + tip + '\'' +
                ", name='" + name + '\'' +
                ", like=" + like +
                '}';
    }

}
