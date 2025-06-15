package org.example.springboot.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.springboot.pojo.Good;

import java.util.List;

@Mapper
public interface GoodMapper {
    @Select("select * from good where goodclass=#{goodclass}")
    List<Good> getClass(String goodclass);

    @Select("select * from good")
    List<Good> getAll();

    @Insert("insert into good(goodid,goodname,goodprice,goodclass,goodpath,goodshop) values(#{goodid},#{goodname},#{goodprice},#{goodclass},#{goodpath},#{goodshop})")
    boolean insert(String goodid,String goodname,String goodprice,String goodclass,String goodpath,String goodshop);

    @Delete("delete from good where goodid=#{goodid}")
    boolean delete(String goodid);
}
