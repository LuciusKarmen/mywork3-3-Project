package org.example.csdnb.service;

import org.example.csdnb.dao.Tip;
import org.example.csdnb.mapper.TipMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipService {
    @Autowired
    private TipMapper tipMapper;
    public List<Tip> getTips()
    {
        return tipMapper.getTips();
    }
}
