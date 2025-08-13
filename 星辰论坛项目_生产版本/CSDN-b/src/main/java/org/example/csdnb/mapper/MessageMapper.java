package org.example.csdnb.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.csdnb.dao.Message;

import java.util.List;

@Mapper
public interface  MessageMapper {

    @Select("SELECT * FROM message WHERE mget=#{name}")
    List<Message> getMessage(String name);

    @Select("SELECT * FROM message WHERE mtipid= #{tid}")
    List<Message> getTipMessages(String tid);

    @Insert("INSERT INTO message(mid,mname,mget,msend,mtime,mcontent,mread,mtipid) VALUES(#{mid},#{mname},#{mget},#{msend},#{mtime},#{mcontent},#{mread},#{mtipid})")
    void addMessage(Message message);

}
