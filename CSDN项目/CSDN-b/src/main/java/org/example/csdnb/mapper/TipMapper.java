package org.example.csdnb.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.csdnb.dao.Tip;

import java.util.List;

@Mapper
public interface TipMapper {

    @Select("select * from tip")
    List<Tip> getTips();
    @Insert("insert into tip(tid,tname,tcontent,tpic,tclass,tuser,ttime,tgood,tmessage) values(#{tid},#{tname},#{tcontent},#{tpic},#{tclass},#{tuser},#{ttime},#{tgood},#{tmessage})")
    void addTip(Tip tip);
    @Select("select * from tip where tid=#{tid}")
    Tip getTip(String tid);
}
