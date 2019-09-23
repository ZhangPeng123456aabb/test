package com.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class App {
    private Configuration configuration;
    private FileSystem fileSystem;
    @Before
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
    @Test
    public void testUpload01()throws Exception{
        fileSystem.copyFromLocalFile(new Path("E:\\A.docx"),new Path("/hadoop/2.docx"));
    }
    @Test
    public void testUpload02()throws Exception{
        FileInputStream inputStream = new FileInputStream("E:\\A.docx");
        FSDataOutputStream outputStream = fileSystem.create(new Path("/hadoop/3.docx"));
        IOUtils.copyBytes(inputStream,outputStream,1024,true);
    }
    @Test
    public void testDownload01()throws Exception{
        fileSystem.copyToLocalFile(false,new Path("/hadoop/1.docx"),new Path("E:\\66.txt"),true);
    }
    @Test
    public void testDownloads()throws Exception{
        FileOutputStream outputStream = new FileOutputStream("E:\\A.docx");
        FSDataInputStream inputStream = fileSystem.open(new Path("/1.txt"));
        IOUtils.copyBytes(inputStream,outputStream,1024,true);
    }
    @Test

    public void test011()throws Exception{
        RemoteIterator<LocatedFileStatus> list = fileSystem.listFiles(new Path("/"),true);
        while(list.hasNext()){
            LocatedFileStatus locatedFileStatus = list.next();
            Path path = locatedFileStatus.getPath();
            System.out.println(path.toString());

        }
    }
    @Test
    public void test02()throws Exception{
        fileSystem.delete(new Path("/6.txt"),false);
    }
    @Test
    public void test03()throws Exception{
        boolean exists = fileSystem.exists(new Path("/6.txt"));
        if(exists){
            System.out.println("文件存在");
        }else{
            System.out.println("文件不存在");
        }
    }
    @Test
    public void testy04()throws Exception{
        fileSystem.mkdirs(new Path("/baizhi1234"));
    }

}
