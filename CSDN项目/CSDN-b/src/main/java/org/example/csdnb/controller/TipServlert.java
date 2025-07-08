package org.example.csdnb.controller;

import org.example.csdnb.dao.Tip;
import org.example.csdnb.service.TipService;
import org.example.csdnb.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/tip")
public class TipServlert {
    @Autowired
    private TipService tipService;
    @RequestMapping("/getTip/{tid}")
    public Result<Tip> getTip(@PathVariable String tid) {
        Tip tip = tipService.getTip(tid);
        return Result.ok(tip);
    }
    @RequestMapping ("/getTips")
    public Result<List<Tip>> getTips() {
        List<Tip> tips = tipService.getTips();
        return Result.ok(tips);
    }
    @RequestMapping("/addTip")
    public Result<String> addTip(
            @RequestParam String tid,
            @RequestParam String tname,
            @RequestParam String tcontent,
            @RequestParam String ttime,
            @RequestParam String tuser,
            @RequestParam Integer tgood,
            @RequestParam Integer tmessage,
            @RequestParam String tclass,
            @RequestParam MultipartFile file


            ) throws IOException {
        Tip tip = new Tip();
        tip.setTid(tid);
        tip.setTname(tname);
        tip.setTcontent(tcontent);
        tip.setTtime(ttime);
        tip.setTuser(tuser);
        tip.setTgood(tgood);
        tip.setTmessage(tmessage);
        tip.setTclass(tclass);


        tipService.addTip(tip, file);
        return Result.ok();
    }

}
