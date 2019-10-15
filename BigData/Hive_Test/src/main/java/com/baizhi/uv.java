package com.baizhi;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class uv {
    public static void main(String[] args)throws Exception {
        Class.forName("org.apache.hive.jdbc.HiveDriver");
        Connection connection = DriverManager.getConnection("jdbc:hive2://HadoopNode00:10000/baizhi", "root", null);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select count(distinct ip) uv from t_log");
        int uv = 0;
        while (resultSet.next()){
            uv = resultSet.getInt("uv");
        }
        //System.out.println("uv数值为"+uv);
        /*Jedis jedis = new Jedis("192.168.182.9");*/
        Jedis jedis = JedisUtil.getJedis();
        String s = JSONObject.toJSONString(uv);
        jedis.set("uv",s);
        JedisUtil.closeJedis(jedis);
        resultSet.close();
        statement.close();
        connection.close();
    }
}
