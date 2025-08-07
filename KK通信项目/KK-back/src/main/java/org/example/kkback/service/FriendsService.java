package org.example.kkback.service;

import org.example.kkback.mapper.FriendsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendsService {
    @Autowired
    private FriendsMapper friendsMapper;
    
    public List<Long> selectFriends(String id) {
        return friendsMapper.selectFriends(id);
    }
    
    // 发送好友申请
    public void sendnew(String id, String friend_id) {
        String requestId = java.util.UUID.randomUUID().toString();
        String createdAt = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
        friendsMapper.sendFriendRequest(requestId, id, friend_id, createdAt, "pending");
    }
    
    // 接受好友申请
    public void acceptnew(String id, String friend_id) {
        String id1 = java.util.UUID.randomUUID().toString();
        String id2 = java.util.UUID.randomUUID().toString();
        String createdAt = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
        
        // 建立双向好友关系
        friendsMapper.acceptFriendRequest(id1, id2, id, friend_id, createdAt);
        
        // 查找对应的好友申请并更新状态
        List<org.example.kkback.dao.Friends> requests = friendsMapper.getFriendRequests(id);
        for (org.example.kkback.dao.Friends request : requests) {
            if (request.getUser_id().equals(friend_id)) {
                friendsMapper.updateFriendRequestStatus(request.getId(), "accepted");
                break;
            }
        }
    }
    
    // 获取好友申请列表
    public List<org.example.kkback.dao.Friends> getFriendRequests(String id) {
        return friendsMapper.getFriendRequests(id);
    }
}
