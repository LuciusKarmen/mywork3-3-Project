package org.example.springboot.service;

import org.example.springboot.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
    @Autowired
    private ShopMapper shopMapper;
    public boolean checkShop(String shopname, String shoppassword) {
        return shopMapper.login(shopname,shoppassword)!=null;
    }
}
