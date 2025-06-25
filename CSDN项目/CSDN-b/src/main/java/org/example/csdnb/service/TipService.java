package org.example.csdnb.service;

import org.example.csdnb.dao.Tip;
import org.example.csdnb.mapper.TipMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TipService {
    @Autowired
    private TipMapper tipMapper;
    public List<Tip> getTips()
    {
        return tipMapper.getTips();
    }
    public void addTip(Tip tip)
    {
        tip.setTid(UUID.randomUUID().toString());
        tip.setTtime(java.time.LocalDateTime.now().toString());
        tip.setTgood(0);
        tip.setTmessage(0);
        tipMapper.addTip(tip);
    }
}
