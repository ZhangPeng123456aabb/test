package com.baizhi;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PV {
    public static void main(String[] args)throws Exception {
        /**
         * 获取连接
         */
        Class.forName("org.apache.hive.jdbc.HiveDriver");
        Connection connection = DriverManager.getConnection("jdbc:hive2://HadoopNode00:10000/baizhi", "root", null);
        Statement statement = connection.createStatement();
          ResultSet resultSet = statement.executeQuery("select count(*) pv,count(distinct ip) uv from t_log");
        int pv = 0;
        int uv = 0;
        while(resultSet.next()){
            pv = resultSet.getInt("pv");
            uv = resultSet.getInt("uv");
        }
        //System.out.println("pv数值为"+pv);
        /*Jedis jedis = new Jedis("192.168.182.9");*/
        Jedis jedis = JedisUtil.getJedis();
        String s = JSONObject.toJSONString(pv);
        String s1 = JSONObject.toJSONString(uv);
        jedis.set("pv",s);
        jedis.set("uv",s1);
        JedisUtil.closeJedis(jedis);
        resultSet.close();
        statement.close();
        connection.close();
    }
}
