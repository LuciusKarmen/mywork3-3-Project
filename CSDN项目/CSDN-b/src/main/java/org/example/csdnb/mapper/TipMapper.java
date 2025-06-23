package org.example.csdnb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.csdnb.dao.Tip;

import java.util.List;

@Mapper
public interface TipMapper {

    @Select("select * from tip")
    List<Tip> getTips();

}
