package com.baizhi.HighCharts.dao;

import com.alibaba.fastjson.JSON;
import com.baizhi.HighCharts.JedisUtil;
import com.baizhi.HighCharts.entity.status;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

import java.util.*;
@Repository
public class StatusDaoImpl implements StatusDao {
    @Override
    public HashMap<Integer, Integer> finAllStatus() {
        /*ArrayList<status> statuses = new ArrayList<>();*/
        HashMap<Integer, Integer> map1 = new HashMap<>();
        status status1 = new status();
        Jedis jedis = JedisUtil.getJedis();
        String status = jedis.get("status");
        Map map = JSON.parseObject(status, Map.class);
        Set<Map.Entry<Integer,Integer>> set = map.entrySet();
        for(Map.Entry<Integer,Integer> entry:set){
            /*status1.setStatusCode(entry.getKey());
            status1.setStatusNums(entry.getValue());*/
            /*statuses.add(status1);*/
            map1.put(entry.getKey(),entry.getValue());
        }
        return map1;
    }
}
