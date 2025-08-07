package org.example.kkback.dao;

import lombok.Data;


public class Friends {
    public String getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(String friend_id) {
        this.friend_id = friend_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Friends{" +
                "id='" + id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", friend_id='" + friend_id + '\'' +
                ", created_at='" + created_at + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    private String id;
    private String user_id;
    private String friend_id;
    private String created_at;
    private String status;


}
