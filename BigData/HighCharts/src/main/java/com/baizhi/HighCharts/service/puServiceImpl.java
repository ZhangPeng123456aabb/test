package com.baizhi.HighCharts.service;

import com.baizhi.HighCharts.dao.puDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class puServiceImpl implements puService {
    @Autowired
    private puDao pudao;
    @Override
    public Map<String, String> findPU() {
        return pudao.findPU();
    }
}
