package org.example.csdnb.service;

import org.example.csdnb.dao.Tip;
import org.example.csdnb.mapper.TipMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class TipService {
    @Autowired
    private TipMapper tipMapper;
    private static final String UPLOAD_DIR = "C:/path/to/CSDN";
    public List<Tip> getTips()
    {
        return tipMapper.getTips();
    }
    public void addTip(Tip tip, MultipartFile file) throws IOException {
        String id= UUID.randomUUID().toString() ;
        tip.setTid(id);
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String fileName = id + "_" +file.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);


        String dbPath = "CSDN/" + fileName;

        file.transferTo(filePath.toFile());
        tip.setTpic(dbPath);

        tipMapper.addTip(tip);

    }
    public Tip getTip(String tid)
    {
        return tipMapper.getTip(tid);
    }

}
