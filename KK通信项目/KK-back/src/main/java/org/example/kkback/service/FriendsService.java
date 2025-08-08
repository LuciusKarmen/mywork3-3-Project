package org.example.kkback.service;

import org.example.kkback.dao.Friends;
import org.example.kkback.dao.User;
import org.example.kkback.mapper.FriendsMapper;
import org.example.kkback.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FriendsService {
    @Autowired
    private FriendsMapper friendsMapper;
    @Autowired
    private UserMapper userMapper;
    
    public List<Long> selectFriends(String id) {
        return friendsMapper.selectFriends(id);
    }
    
    // 发送好友申请
    public void sendnew(String user_id, String friend_id) {
        String id = java.util.UUID.randomUUID().toString();
        String createdAt = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
        friendsMapper.sendFriendRequest(id, user_id, friend_id, createdAt, "pending");
    }

    // 获取申请列表
    public List<Friends> getFriendRequests(String id) {
        return friendsMapper.selectPendingRequests(id);
    }
    public boolean updateFriendRequest(String user_id, String status) {
        return friendsMapper.updateFriendRequest(user_id, status);
    }


}
