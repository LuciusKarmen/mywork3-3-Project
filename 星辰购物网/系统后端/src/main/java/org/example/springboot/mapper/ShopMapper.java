package org.example.springboot.mapper;

import org.apache.ibatis.annotations.Select;
import org.example.springboot.pojo.shop;


public interface ShopMapper {
    @Select("select * from shop where shopname=#{shopname} AND shoppassword=#{shoppassword}")
    shop  login(String shopname, String shoppassword);
}
