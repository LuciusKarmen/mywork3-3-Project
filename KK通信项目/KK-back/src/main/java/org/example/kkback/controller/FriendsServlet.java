package org.example.kkback.controller;

import org.example.kkback.dao.Friends;
import org.example.kkback.service.FriendsService;
import org.example.kkback.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/friends")
public class FriendsServlet {
    @Autowired
    private FriendsService friendsService;
    @RequestMapping("/selectFriends")
    public Result<List<Friends>> selectFriends(String id) {
        List<Friends> friends = friendsService.selectFriends(id);
        return Result.ok(friends);
    }
}
