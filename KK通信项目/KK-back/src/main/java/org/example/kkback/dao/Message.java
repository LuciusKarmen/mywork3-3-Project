package org.example.kkback.dao;

import lombok.Data;

@Data
public class Message {
    private String id;
    private String from_id;
    private String to_id;
    private String content;
    private String time;
    private Boolean read;
}
