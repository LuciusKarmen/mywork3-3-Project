package org.example.s9.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.s9.pojo.tip;

@Mapper
public interface TipSearchMapper {
    @Select("select * from tipdoro")
    tip getTip();
}
