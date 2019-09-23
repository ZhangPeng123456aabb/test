package com.hadoop.service.impl;

import com.hadoop.service.HdfsService;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class HdfsServiceImpl implements HdfsService {
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
    @Override
    public String showAll() throws IOException {
        RemoteIterator<LocatedFileStatus> list = fileSystem.listFiles(new Path("/"), true);
        Path path = null;
        while (list.hasNext()) {
            LocatedFileStatus locatedFileStatus = list.next();
            path = locatedFileStatus.getPath();
        }
        return path.toString();
    }
}
