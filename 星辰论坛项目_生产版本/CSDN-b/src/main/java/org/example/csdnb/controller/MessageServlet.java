package org.example.csdnb.controller;

import org.example.csdnb.dao.Message;
import org.example.csdnb.service.MessageService;
import org.example.csdnb.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageServlet {
    @Autowired
    private MessageService messageService;

    @RequestMapping ("/getMessages/{name}")
    public Result<List<Message>> getTips(@PathVariable String name) {

        List<Message> messages =messageService.getMessage(name);
        return Result.ok(messages);
    }
    @RequestMapping ("/getTipMessages/{tid}")
    public Result<List<Message>> getTipMessages (@PathVariable String tid) {

        List<Message> messages =messageService.getTipMessages(tid);
        return Result.ok(messages);
    }
    @RequestMapping("/addMessage")
    public Result<String> addMessage(@RequestBody Message message){
        messageService.addMessage(message);
        return Result.ok();
    }
}
