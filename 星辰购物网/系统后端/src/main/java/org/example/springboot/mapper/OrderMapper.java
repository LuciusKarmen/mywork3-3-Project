package org.example.springboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.springboot.pojo.Order;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Select("select * from orders")
    List<Order> getAll();

    @Insert("INSERT INTO orders(orderid, orderuser, ordershop, ordername, ordernumber, orderCar,orderBuy, orderSend, orderOk) " +
            "VALUES (#{orderid}, #{orderuser}, #{ordershop}, #{ordername}, #{ordernumber}, #{orderCar},#{orderBuy}, #{orderSend}, #{orderOk})")
    boolean insert(
            String orderid,
            String orderuser,
            String ordershop,
            String ordername,
            int ordernumber,
            Boolean orderCar,
            Boolean orderBuy,
            Boolean orderSend,
            Boolean orderOk
    );
    @Update("update orders set orderCar=#{orderCar},orderOk=#{orderOk} ,orderSend=#{orderSend},orderBuy=#{orderBuy},orderuser=#{orderuser} where orderid=#{orderid}")
    boolean update(

            Boolean orderCar,
            Boolean  orderSend,
            Boolean orderOk,
            Boolean orderBuy,
            String orderuser,
            String orderid

    );
    @Update("update orders set orderSend=#{orderSend} where orderid=#{orderid}")
    boolean updateSend(
            Boolean orderSend,
            String orderid
    );
}

