package org.example.kkback.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.kkback.dao.Friends;

import java.util.List;

@Mapper
public interface FriendsMapper {

    // 查询用户所有好友
    @Select("SELECT friend_id AS id " +
            "FROM friends WHERE user_id = #{userId} AND status = 'accepted' " +
            "UNION " +
            "SELECT user_id AS id " +
            "FROM friends WHERE friend_id = #{userId} AND status = 'accepted'")
    List<String> selectFriends(@Param("userId") String id);
    //查询用户收到的所有申请
// FriendsMapper.java
    @Select("SELECT id, user_id, friend_id, created_at, status " +
            "FROM friends " +
            "WHERE friend_id = #{userId} AND status = 'pending'")
    List<Friends> selectPendingRequests(@Param("userId") String userId);
    
    // 发送好友申请
    @Insert("INSERT INTO friends (id, user_id, friend_id, created_at, status) " +
            "VALUES (#{id}, #{userId}, #{friendId}, #{createdAt},#{status})")
    boolean sendFriendRequest(@Param("id") String id,
                             @Param("userId") String userId,
                             @Param("friendId") String friendId,
                             @Param("createdAt") String createdAt,
                             @Param("status") String status);
    //接受和拒绝申请
    //传进来的是申请人的ID
    @Update("UPDATE friends SET status = #{status} WHERE user_id = #{user_id}")
    boolean updateFriendRequest(@Param("user_id") String user_id,
                               @Param("status") String status);


}
