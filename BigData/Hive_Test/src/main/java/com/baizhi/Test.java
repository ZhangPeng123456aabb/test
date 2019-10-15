package com.baizhi;

import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Jedis jedis = JedisUtil.getJedis();
        /*String status = jedis.get("status");*/
        String pv = jedis.get("pv");
        String uv = jedis.get("uv");
        System.out.println("pv值为"+pv+"uv值为"+uv);
        /*Map map = JSON.parseObject(status, Map.class);
        Set<Map.Entry<Integer,Integer>> set = map.entrySet();
        for(Map.Entry<Integer,Integer> entry:set){
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+"------"+value);
        }*/

    }
}
