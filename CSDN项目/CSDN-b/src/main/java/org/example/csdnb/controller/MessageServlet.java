package org.example.csdnb.controller;

import org.example.csdnb.dao.Message;
import org.example.csdnb.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageServlet {
    @Autowired
    private MessageService messageService;

    @RequestMapping("/getMessages")
    public List<Message> getMessage()
    {
        return messageService.getMessage();
    }
}
