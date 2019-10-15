package com.baizhi.Flume.redis;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;

public class LogAction {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost",6379);
        /*String usr = "username";
        String s = jedis.get(usr);
        System.out.println(s);*/
        log log = new log("1","2019/10/10-13:58:16","GET","/",304);
        String s = JSONObject.toJSONString(log);
        jedis.set("log",s);
    }
}
