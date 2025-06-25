package org.example.csdnb.controller;

import org.example.csdnb.dao.Tip;
import org.example.csdnb.service.TipService;
import org.example.csdnb.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tip")
public class TipServlert {
    @Autowired
    private TipService tipService;
    @RequestMapping ("/getTips")
    public Result<List<Tip>> getTips() {
        List<Tip> tips = tipService.getTips();
        return Result.ok(tips);
    }
    @RequestMapping("/addTip")
    public Result<String> addTip(Tip tip) {
        tipService.addTip(tip);
        return Result.ok();
    }

}
