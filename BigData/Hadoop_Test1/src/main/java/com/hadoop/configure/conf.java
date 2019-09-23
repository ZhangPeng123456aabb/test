package com.hadoop.configure;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
public class conf {
    private Configuration configuration;
    private FileSystem fileSystem;
    public void getClient()throws Exception{
        System.setProperty("HADOOP_USER_NAME","root");

        /**
         * 准备对象
         */
        configuration = new Configuration();
        /**
         * 添加相应的配置文件
         */
        configuration.addResource("core-site.xml");
        configuration.addResource("hdfs-site.xml");
        /**
         * 通过FileSystem.newInstance获取到客户端对象
         */
        fileSystem = FileSystem.newInstance(configuration);

    }
}
