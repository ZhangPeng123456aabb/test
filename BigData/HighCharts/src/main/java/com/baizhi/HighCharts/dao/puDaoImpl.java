package com.baizhi.HighCharts.dao;

import com.baizhi.HighCharts.JedisUtil;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
@Repository
public class puDaoImpl implements puDao {
    @Override
    public Map<String,String> findPU() {
        Jedis jedis = JedisUtil.getJedis();
        String pv = jedis.get("pv");
        String uv = jedis.get("uv");
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("pv",pv);
        map.put("uv",uv);
        System.out.println(map);
        return  map;
    }
}
