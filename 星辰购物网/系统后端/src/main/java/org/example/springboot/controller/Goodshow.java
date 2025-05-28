package org.example.springboot.controller;

import org.example.springboot.mapper.GoodMapper;
import org.example.springboot.pojo.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/good")
public class Goodshow {
    @Autowired
    private GoodMapper goodMapper;

    @RequestMapping("/showgood")
    public List<Good> getAll() {
        return goodMapper.getAll();
    }

    @GetMapping("/test-file")
    public ResponseEntity<FileSystemResource> testFile() {
        String filePath = "C:/path/to/uploads/37923bfb-28a7-4280-99ac-e90b09d9fa63_3216494093b8573fd9.jpg";
        File file = new File(filePath);

        System.out.println("文件路径: " + file.getAbsolutePath());
        System.out.println("文件是否存在: " + file.exists());
        System.out.println("是否可读: " + file.canRead());

        if (!file.exists()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE)
                .body(new FileSystemResource(file));
    }
}
