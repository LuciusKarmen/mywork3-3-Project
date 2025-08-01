package org.example.kkback.service;

import org.example.kkback.dao.Friends;
import org.example.kkback.mapper.FriendsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendsService {
    @Autowired
    private FriendsMapper friendsMapper;
    public List<Friends> selectFriends(String id) {
        return friendsMapper.selectFriends(id);
    }
}
