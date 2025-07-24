package org.example.csdnb.service;

import org.example.csdnb.dao.Message;
import org.example.csdnb.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private TipService tipService;
    public List<Message> getMessage(String name){
        return messageMapper.getMessage(name);
    }
    public List<Message> getTipMessages(String tid){
        return messageMapper.getTipMessages(tid);
    }
    public void addMessage(Message message){
        String mid= UUID.randomUUID().toString();
        message.setMid(mid);
        String mtipid=message.getMtipid();
        String mget=tipService.getTip(mtipid).getTname();
        message.setMget(mget);
        messageMapper.addMessage(message);

    }

}
