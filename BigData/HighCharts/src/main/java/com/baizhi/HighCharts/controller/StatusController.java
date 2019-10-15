package com.baizhi.HighCharts.controller;

import com.baizhi.HighCharts.entity.status;
import com.baizhi.HighCharts.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class StatusController {
    @Autowired
    private StatusService statusService;
    @GetMapping("/status")
    public List<Map<String,Object>> querySystemStatus() {
        HashMap<Integer, Integer> statuses = statusService.finAllStatus();
        List<Map<String, Object>> result = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> entries = statuses.entrySet();
        for (Map.Entry<Integer, Integer> status : entries) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("name",status. getKey());
            map.put("y",status.getValue());
            //如果 如果饼图的扇区为200，默认选中
            if(status.getKey()==200){
                map.put("selected",true);
                map.put("sliced",true);
            }
            result.add(map);
        }
        return  result;
    }
}
