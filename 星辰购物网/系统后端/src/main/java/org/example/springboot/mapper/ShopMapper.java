package org.example.springboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.springboot.pojo.shop;


@Mapper
public interface ShopMapper {
    @Select("select * from shop where shopname=#{shopname} AND shoppassword=#{shoppassword}")
    shop  login(String shopname, String shoppassword);

    @Insert("insert into shop(shopid,shopname,shoppassword,shoppath) values(#{shopid},#{shopname},#{shoppassword},#{shoppath})")
    boolean insert(String shopid,String shopname,String shoppassword,String shoppath);
}
