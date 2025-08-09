package org.example.kkback.service;

import org.example.kkback.dao.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private org.example.kkback.mapper.MessageMapper messageMapper;

    //查找我和一个好友的聊天消息
    public List<Message> select(String user_id, String friend_id) {
        //区分哪个是我发的
        return messageMapper.select(user_id, friend_id);
    }
    public boolean add(Message message) {
        String id=java.util.UUID.randomUUID().toString();
        message.setId(id);

        message.setTime(new java.util.Date().toString());
        message.setRead(false);
        return messageMapper.add(message);
    }


}
