package com.baizhi;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class status {
    public static void main(String[] args)throws Exception {
        /**
         * 获取连接
         */
        Class.forName("org.apache.hive.jdbc.HiveDriver");
        Connection connection = DriverManager.getConnection("jdbc:hive2://HadoopNode00:10000/baizhi", "root", null);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select status,count(*) StatusNums from t_log group by status");
        int status = 0;
        int StatusNums = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (resultSet.next()){
            status = resultSet.getInt("status");
            StatusNums = resultSet.getInt("StatusNums");
            map.put(status,StatusNums);
        }
        //System.out.println("状态值为"+status+" "+"该状态值的数量为"+count);
        /*Jedis jedis = new Jedis("192.168.182.9");*/
        Jedis jedis = JedisUtil.getJedis();

        jedis.set("status",JSONObject.toJSONString(map));
        /*jedis.set("StatusNums",s1);*/
        JedisUtil.closeJedis(jedis);
        resultSet.close();
        statement.close();
        connection.close();
    }
}
