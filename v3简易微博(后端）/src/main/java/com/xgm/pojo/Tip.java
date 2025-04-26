package com.xgm.pojo;

public class Tip {


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

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

    @Override
    public String toString() {
        return "Tip{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", pic='" + img + '\'' +
                '}';
    }

    private Integer id;
    private String name;
    private String content;
    private String time;
    private String img;
    private  Integer like;


    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }





}
