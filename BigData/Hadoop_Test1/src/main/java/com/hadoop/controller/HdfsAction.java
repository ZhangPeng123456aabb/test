package com.hadoop.controller;
import com.hadoop.service.HdfsService;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HdfsAction {
    private Configuration configuration;
    private FileSystem fileSystem;
    @Autowired
    private HdfsService hdfsService;
    @RequestMapping("/showAll")
    public Map showAll(Map map)throws Exception {
            map.put("file", hdfsService.showAll());
        return map;
    }
}