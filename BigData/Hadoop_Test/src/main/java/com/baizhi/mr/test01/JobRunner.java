package com.baizhi.mr.test01;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.MRJobConfig;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class JobRunner {
    public static void main(String[] args)throws Exception {
        /**
         * 获取配置对象
         */
        System.setProperty("HADOOP_USER_NAME","root");
        Configuration conf = new Configuration();
        conf.addResource("conf2/core-site.xml");
        conf.addResource("conf2/hdfs-site.xml");
        conf.addResource("conf2/mapred-site.xml");
        conf.addResource("conf2/yarn-site.xml");
        conf.set(MRJobConfig.JAR,"F:\\study\\IDEA_project\\BigData\\Hadoop_Test\\target\\Hadoop_Test-1.0-SNAPSHOT.jar");
        conf.set("mapreduce.app-submission.cross-platform","true");
        /**
         * F:\study\IDEA_project\BigData\Hadoop_Test\target\Hadoop_Test-1.0-SNAPSHOT.jar
         * 获取job对象
         */
        Job job = Job.getInstance(conf);
        job.setJarByClass(JobRunner.class);
        /**
         *
         * 设置数据输入输出组件
         */
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
       /* TextInputFormat.setInputPaths(job,new Path("file:///I:\\飞秋文件\\文件包\\feiq\\Recv Files\\wordcount.txt"));*/
        TextInputFormat.setInputPaths(job,new Path("/install.log.syslog"));
        /**
         * 注意：此输出路径不能存在
         */
       /* TextOutputFormat.setOutputPath(job,new Path("file:///I:\\飞秋文件\\文件包\\feiq\\Recv Files\\out4"));*/
        TextOutputFormat.setOutputPath(job,new Path("/out2"));
        /**
         * 设置MAP和Reduce处理逻辑
         */
        job.setMapperClass(WCMapper.class);
        job.setReducerClass(WCReducer.class);
        /**
         * 设置map任务reduce任务的输出泛型
         */
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);

        //提交

        job.waitForCompletion(true);
    }
}
