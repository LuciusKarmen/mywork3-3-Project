package org.example.springboot.controller;

import org.apache.ibatis.annotations.Mapper;
import org.example.springboot.mapper.OrderMapper;
import org.example.springboot.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public class Ordershow {

    @Autowired
    private OrderMapper orderMapper;
    @RequestMapping("/showorder")
    public List<Order> getAll(
            @RequestParam("orderid") String orderid,
            @RequestParam("orderuser") String orderuser,
            @RequestParam("ordershop") String ordershop,
            @RequestParam("ordername") String ordername,
            @RequestParam("ordernumber") int ordernumber,
            @RequestParam("orderCar") Boolean orderCar,
            @RequestParam("orderSend") Boolean orderSend,
            @RequestParam("orderOk") Boolean orderOk
    ){

            return orderMapper.getAll();



    }
}
