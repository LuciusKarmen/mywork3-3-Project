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
            "FROM friends WHERE user_id = #{userId} " +
            "UNION " +
            "SELECT user_id AS id " +
            "FROM friends WHERE friend_id = #{userId}")
    List<Long> selectFriends(@Param("userId") String id);
    
    // 发送好友申请
    @Insert("INSERT INTO friends (id, user_id, friend_id, created_at, status) " +
            "VALUES (#{id}, #{userId}, #{friendId}, #{createdAt}, #{status})")
    boolean sendFriendRequest(@Param("id") String id,
                             @Param("userId") String userId,
                             @Param("friendId") String friendId,
                             @Param("createdAt") String createdAt,
                             @Param("status") String status);
    
    // 接受好友申请（建立双向好友关系）
    @Insert("INSERT INTO friends (id, user_id, friend_id, created_at, status) " +
            "VALUES (#{id1}, #{userId}, #{friendId}, #{createdAt}, 'accepted'), " +
            "(#{id2}, #{friendId}, #{userId}, #{createdAt}, 'accepted')")
    boolean acceptFriendRequest(@Param("id1") String id1,
                                @Param("id2") String id2,
                                @Param("userId") String userId,
                                @Param("friendId") String friendId,
                                @Param("createdAt") String createdAt);
    
    // 更新好友申请状态
    @Update("UPDATE friends SET status = #{status} WHERE id = #{id}")
    boolean updateFriendRequestStatus(@Param("id") String id,
                                     @Param("status") String status);
    
    // 获取好友申请列表
    @Select("SELECT * FROM friends WHERE friend_id = #{userId} AND status = 'pending'")
    List<Friends> getFriendRequests(@Param("userId") String userId);
}
