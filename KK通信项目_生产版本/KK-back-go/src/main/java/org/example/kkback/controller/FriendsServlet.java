package org.example.kkback.controller;

import org.example.kkback.dao.Friends;
import org.example.kkback.dao.User;
import org.example.kkback.service.FriendsService;
import org.example.kkback.service.UserService;
import org.example.kkback.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/friends")
public class FriendsServlet {
    @Autowired
    private FriendsService friendsService;
    @Autowired
    private UserService userService;
    @RequestMapping("/selectFriends")
    public Result<List<User>> selectFriends(String id) {
        List<String> friends = friendsService.selectFriends(id);
        System.out.println(friends);
        //遍历id，获取好友信息，存到列表里
        List<User> friendInfo = new ArrayList<>();
        for (String friendId : friends) {
            User friend = userService.selectById(friendId.toString());
            friendInfo.add(friend);
        }
        System.out.println(friendInfo);
        return Result.ok(friendInfo);
    }
    @RequestMapping("/sendnew")
    public Result<String> sendnew(String user_id, String friend_id) {
        friendsService.sendnew(user_id, friend_id);
        return Result.ok("发送成功");
    }
    @RequestMapping("/getFriendRequests")
    public Result<List<Friends>> getFriendRequests(String id) {
        List<Friends> friendRequests = friendsService.getFriendRequests(id);
        return Result.ok(friendRequests);
    }
    @RequestMapping("/updateFriendRequest")
    public Result<String> updateFriendRequest(String user_id, String status) {
        boolean update = friendsService.updateFriendRequest(user_id, status);
        if (update) {
            return Result.ok("更新成功");
        } else {
            return Result.error(500, "更新失败");
        }
    }


}
