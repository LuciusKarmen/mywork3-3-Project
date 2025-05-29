package org.example.springboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.springboot.pojo.Order;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Select("select * from order")
    List<Order> getAll();

    @Insert("insert into order(orderid,orderuser,ordershop,ordername,ordernumber,orderCar,orderSend,orderOk) values(#{orderid},#{orderuser},#{ordershop},#{ordername},#{orderCar},#{orderSend},#{orderOk})")
    boolean insert(String orderid,String orderuser,String ordershop,String ordername,int ordernumber,Boolean orderCar,Boolean orderSend,Boolean orderOk);

}
