package org.example.kkback.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.kkback.dao.Message;

import java.util.List;

@Mapper
public interface MessageMapper {
    //查找两个用户的对话,并区分我的消息和好友的消息
    @Select("select * from message where (from_id=#{from_id} and to_id=#{to_id}) or (from_id=#{to_id} and to_id=#{from_id})")
    List<Message> select(String from_id, String to_id);



}
