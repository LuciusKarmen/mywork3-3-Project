package org.example.kkback.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.kkback.dao.Friends;

import java.util.List;

@Mapper
public interface FriendsMapper {
    @Select("SELECT friend_id AS id FROM friend WHERE user_id = #{id} " +
            "UNION " +
            "SELECT user_id AS id FROM friend WHERE friend_id = #{id}")
    List<Friends> selectFriends(String id);

}
