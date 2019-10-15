package com.baizhi.HighCharts;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisUtil {
    private static JedisPool jedisPool = null;
    static{
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        //连接池配置
        poolConfig.setMaxIdle(100);
        String host = "192.168.182.9";
        jedisPool = new JedisPool(poolConfig,host);
    }
    /**
     * 获取jedis对象
     */
    public static Jedis getJedis(){
        if(jedisPool!=null){
            Jedis jedis = jedisPool.getResource();
            return jedis;
        }
        return null;
    }
    public static void closeJedis(Jedis jedis){
        if(jedis!=null){
            jedis.close();
        }
    }
}
