package org.example.springboot.controller;

import org.apache.ibatis.annotations.Mapper;
import org.example.springboot.mapper.OrderMapper;
import org.example.springboot.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class Ordershow {

    @Autowired
    private OrderMapper orderMapper;
    @RequestMapping("/showorder")
    public List<Order> getAll(){
            return orderMapper.getAll();
    }

    @RequestMapping("/add")
    public String insert(
            @RequestBody  Order order
    )
    {
       if(orderMapper.insert(order.getOrderid(),order.getOrderuser(),order.getOrdershop(),order.getOrdername(),order.getOrdernumber(),order.getOrderCar(),order.getOrderBuy(),order.getOrderSend(),order.getOrderOk())){
           return "success";
       }else{
           return "fail";
       }
    }
    @RequestMapping("/update")
    public String update(
            @RequestBody Order order
    ){
        if(orderMapper.update(order.getOrderCar() ,order.getOrderSend(),order.getOrderOk(),order.getOrderBuy(), order.getOrderuser(),order.getOrderid())){
            return "success";
        }else{
            return "fail";
        }


    }
    @RequestMapping("/send")
    public String updateSend(
            @RequestBody Order order
    ){
        if(orderMapper.updateSend(order.getOrderSend(),order.getOrderid())){
            return "success";
        }else{
            return "fail";
        }


    }

}
