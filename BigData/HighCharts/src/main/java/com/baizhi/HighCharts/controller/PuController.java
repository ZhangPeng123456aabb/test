package com.baizhi.HighCharts.controller;

import com.baizhi.HighCharts.JedisUtil;
import com.baizhi.HighCharts.entity.log;
import com.baizhi.HighCharts.service.puService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class PuController {
    @Autowired
    private puService puservice;
    @GetMapping("/pu")
    public String  findAll(log log, ModelMap map){
        Map<String, String> pu = puservice.findPU();
        Set<Map.Entry<String, String>> entries = pu.entrySet();
        for(Map.Entry<String, String> entry:entries){
            log.setPv(Integer.parseInt(entry.getKey()));
            log.setUv(Integer.parseInt(entry.getValue()));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss");
        String format = simpleDateFormat.format(new Date());
        log.setShowTime(format);
        map.addAttribute("pv",log.getPv());
        map.addAttribute("uv",log.getUv());
        map.addAttribute("showTime",log.getShowTime());
       /* Set<Map.Entry<String, String>> entries = pu.entrySet();
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Map<String,ArrayList>> result = new ArrayList<>();
        for(Map.Entry<String, String> entry:entries){
            ArrayList<Integer> list = new ArrayList<>();
            HashMap<String,ArrayList> map = new HashMap<>();
            *//*map.put("name",entry.getKey())
            map.put("data",entry.getValue());*//*

            *//*result.add(map);*//*
        }*/
       /* System.out.println(result);*/

        return "redirect:/Hello.html";
    }
}
