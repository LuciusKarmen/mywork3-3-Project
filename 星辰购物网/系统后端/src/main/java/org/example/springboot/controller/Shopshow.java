package org.example.springboot.controller;



import org.apache.catalina.connector.Response;
import org.example.springboot.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.springboot.pojo.shop;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/shop")

public class Shopshow {
    @Autowired
    private ShopMapper shopa;
    private shop shop = new shop();
    private static final String UPLOAD_DIR = "./uploads/";

    @PostMapping("/register")
    public Object registerShop(

            @RequestParam("shopid") String shopid,
            @RequestParam("shopname") String shopname,
            @RequestParam("shoppassword") String shoppassword,
            @RequestParam("shopfile") MultipartFile file) throws IOException {




        // Create uploads directory if it doesn't exist
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Generate unique file name
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);

        // Save the file
        file.transferTo(filePath.toFile());

        shop.setShopid(shopid);
        shop.setShopname(shopname);
        shop.setShoppassword(shoppassword);
        shop.setShoppath(filePath.toString());

        // Insert the shop into the database
        shopa.insert(shopid,shopname,shoppassword,filePath.toString());

        return "success";
    }


}
