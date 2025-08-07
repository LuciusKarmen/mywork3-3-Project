package org.example.kkback.controller;

import org.example.kkback.dao.User;
import org.example.kkback.service.FriendsService;
import org.example.kkback.service.UserService;
import org.example.kkback.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/friends")
public class FriendsServlet {
    @Autowired
    private FriendsService friendsService;
    @Autowired
    private UserService userService;
    @RequestMapping("/selectFriends")
    public Result<List<User>> selectFriends(String id) {
        List<Long> friends = friendsService.selectFriends(id);
        System.out.println(friends);
        //遍历id，获取好友信息，存到列表里
        List<User> friendInfo = new ArrayList<>();
        for (Long friendId : friends) {
            User friend = userService.selectById(friendId.toString());
            friendInfo.add(friend);
        }
        System.out.println(friendInfo);
        return Result.ok(friendInfo);
    }
    @RequestMapping("/sendnew")
    public Result<String> sendnew(String id, String friend_id) {
        friendsService.sendnew(id, friend_id);
        return Result.ok("发送成功");
    }
    @RequestMapping("/acceptnew")
    public Result<String> acceptnew(String id, String friend_id) {
        friendsService.acceptnew(id, friend_id);
        return Result.ok("接受成功");
    }

}
