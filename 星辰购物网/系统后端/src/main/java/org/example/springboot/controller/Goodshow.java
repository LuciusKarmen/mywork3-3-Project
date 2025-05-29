package org.example.springboot.controller;

import org.example.springboot.mapper.GoodMapper;
import org.example.springboot.pojo.Good;
import org.example.springboot.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/good")
public class Goodshow {
    @Autowired
    private GoodMapper goodMapper;


    private static final String UPLOAD_DIR = "C:/path/to/uploads";

    @RequestMapping("/showgood")
    public List<Good> getAll() {
        return goodMapper.getAll();
    }

    @PostMapping("/add")
    public String insert(
            @RequestParam("goodid") String goodid,
            @RequestParam("goodname") String goodname,
            @RequestParam("goodprice") String goodprice,
            @RequestParam("goodclass") String goodclass,
            @RequestParam("goodshop") String goodshop,
            @RequestParam("goodpath") MultipartFile file

    ) throws IOException {

        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

        Path filePath = uploadPath.resolve(fileName);

        String goodpath = "uploads/"+ fileName;



        if (goodMapper.insert(goodid,goodname,goodprice,goodclass,goodpath,goodshop)) {
            file.transferTo(filePath.toFile());
            return "success";
        } else {
            return "error";
        }

    }
    @PostMapping("/delete")
    public String delete(@RequestBody Good good)
            {
                String goodid = good.getGoodid();
                if (goodMapper.delete(goodid)) {
                    goodMapper.delete(goodid);
                    return "success";
                } else {
                    return "error";
                }
            }




}
