package com.baizhi.HighCharts.service;

import com.baizhi.HighCharts.dao.StatusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusDao statusDao;
    @Override
    public HashMap<Integer, Integer> finAllStatus() {
        System.out.println(statusDao.finAllStatus());
        return statusDao.finAllStatus();
    }
}
