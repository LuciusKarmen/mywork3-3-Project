package org.example.kkback.controller;

import org.example.kkback.dao.Message;
import org.example.kkback.service.MessageService;
import org.example.kkback.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageServlet {
    @Autowired
    private MessageService messageService;
    @RequestMapping("/select")
    public Result<List<Message>>  select(String user_id, String friend_id)
    {
        return Result.ok(messageService.select(user_id, friend_id));
    }
}
