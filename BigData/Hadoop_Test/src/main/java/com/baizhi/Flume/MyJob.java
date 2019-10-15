package com.baizhi.Flume;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.MRJobConfig;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyJob {
    public static void main(String[] args)throws Exception {
        Configuration conf = new Configuration();
        System.setProperty("HADOOP_USER_NAME", "root");
        conf.addResource("conf1/core-site.xml");
        conf.addResource("conf1/hdfs-site.xml");
        conf.addResource("conf1/mapred-site.xml");
        conf.addResource("conf1/yarn-site.xml");
        conf.set(MRJobConfig.JAR, "F:\\study\\IDEA_project\\BigData\\Hadoop_Test\\target\\Hadoop_Test-1.0-SNAPSHOT.jar");
        conf.set("mapreduce.app-submission.cross-platform", "true");
        Job job = Job.getInstance(conf, "nginx");
        job.setJarByClass(MyJob.class);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yy-MM-dd-HHmm");
        String format = simpleDateFormat.format(new Date());
        String format1 = simpleDateFormat1.format(new Date());
        TextInputFormat.setInputPaths(job,new Path("/flume/events/"+format));
        TextOutputFormat.setOutputPath(job,new Path("/flume/result1"+format1));

        job.setMapperClass(MyMapper.class);

        job.setNumReduceTasks(0);

        job.setMapOutputKeyClass(NullWritable.class);
        job.setMapOutputValueClass(Text.class);

        job.waitForCompletion(true);
    }
}
