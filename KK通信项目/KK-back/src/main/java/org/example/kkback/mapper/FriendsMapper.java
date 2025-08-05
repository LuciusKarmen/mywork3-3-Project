package org.example.kkback.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.kkback.dao.Friends;

import java.util.List;

@Mapper
public interface FriendsMapper {

    @Select("SELECT friend_id AS id " +
            "FROM friends WHERE user_id = #{userId} " +
            "UNION " +
            "SELECT user_id AS id " +
            "FROM friends WHERE friend_id = #{userId}")
    List<Long> selectFriends(@Param("userId") String id);
}
