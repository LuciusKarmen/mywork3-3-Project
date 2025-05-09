package com.xgm.mapper;

import com.xgm.pojo.Tip;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TipMapper {
    List<Tip> selectTip();

    @Insert("insert into  xlist(`id`,`name`,`content`,`time`,`img`,`like`) VALUES(#{id},#{name},#{content},#{time},#{img},#{like})")
    void insertTip(Tip tip);

    @Delete("delete from xlist where id=#{id}")
    void deleteTip(String id);

    @Update("update xlist set `like`=`like`+1 where id=#{id}")
    void updateLike(String id);
}
