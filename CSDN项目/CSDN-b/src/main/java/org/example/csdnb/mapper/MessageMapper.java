package org.example.csdnb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.csdnb.dao.Message;

import java.util.List;

@Mapper
public interface  MessageMapper {

    @Select("SELECT * FROM message")
    List<Message> getMessage();

}
