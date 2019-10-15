package com.baizhi.HighCharts.dao;

import com.baizhi.HighCharts.entity.status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

public interface StatusDao {
    public HashMap<Integer, Integer> finAllStatus();
}
