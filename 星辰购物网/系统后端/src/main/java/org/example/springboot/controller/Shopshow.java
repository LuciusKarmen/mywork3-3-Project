package org.example.springboot.controller;



import org.example.springboot.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.UUID;

@RestController
@RequestMapping("/shop")

public class Shopshow {
    @Autowired
    private ShopMapper shopa;
    
    private static final String UPLOAD_DIR = "./uploads/";

    @PostMapping("/register")
    public String registerShop(

            @RequestParam("shopid") String shopid,
            @RequestParam("shopname") String shopname,
            @RequestParam("shoppassword") String shoppassword,
            @RequestParam("shopfile") MultipartFile file) throws IOException {




        // 创建上传目录
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        //name
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);

        // Save
        file.transferTo(filePath.toFile());



        // Insert the shop into the database
        shopa.insert(shopid,shopname,shoppassword,filePath.toString());

        return "success";
    }


}
