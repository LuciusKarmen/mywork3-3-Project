package org.example.springboot.service;

import org.example.springboot.mapper.GoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodService {
    @Autowired
    private GoodMapper goodMapper;
    public boolean insertorder(String goodid,String goodname,String goodprice,String goodclass,String goodpath,String goodshop)
    {
        return goodMapper.insert(goodid,goodname,goodprice,goodclass,goodpath,goodshop);
    }
}
