package com.baizhi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public static void main(String[] args)throws Exception {
        /**
         * 获取连接
         */
        Class.forName("org.apache.hive.jdbc.HiveDriver");
        Connection connection = DriverManager.getConnection("jdbc:hive2://HadoopNode00:10000/baizhi", "root", null);
        Statement statement = connection.createStatement();
      /*  ResultSet resultSet = statement.executeQuery("select count(*) pv from t_log where accesstime='2019/10/10-13:58:16'");*/
        ResultSet resultSet1 = statement.executeQuery("select count(distinct ip) uv from t_log");
        int pv = 0;
        int uv = 0;
       /* while(resultSet.next()){
            pv = resultSet.getInt("pv");

        }*/
        while (resultSet1.next()){
            uv = resultSet1.getInt("uv");
        }
        System.out.println("pv数值为"+pv);
        System.out.println("uv数值为"+uv);
        /*resultSet.close();*/
        resultSet1.close();
        statement.close();
        connection.close();
    }
}
