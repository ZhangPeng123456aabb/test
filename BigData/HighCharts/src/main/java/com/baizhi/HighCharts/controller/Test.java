package com.baizhi.HighCharts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("你好世界！");
        return "redirect:/index.jsp";
    }
}
