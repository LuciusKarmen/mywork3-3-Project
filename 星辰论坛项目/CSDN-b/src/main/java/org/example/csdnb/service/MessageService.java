package org.example.csdnb.service;

import org.example.csdnb.dao.Message;
import org.example.csdnb.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;
    public List<Message> getMessage(){
        return messageMapper.getMessage();
    }

}
