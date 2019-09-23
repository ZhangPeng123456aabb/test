package com.com.baizhi.word;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.MRJobConfig;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class WordRunner {
    public static void main(String[] args)throws Exception {
        System.setProperty("HADOOP_USER_NAME","root");
        Configuration conf = new Configuration();
        conf.addResource("conf1/core-site.xml");
        conf.addResource("conf1/hdfs-site.xml");
        conf.addResource("conf1/mapred-site.xml");
        conf.addResource("conf1/yarn-site.xml");
        conf.set(MRJobConfig.JAR,"F:\\study\\IDEA_project\\BigData\\Hadoop_Test\\target\\Hadoop_Test-1.0-SNAPSHOT.jar");
        conf.set("mapreduce.app-submission.cross-platform","true");
        Job job = Job.getInstance();
        job.setJarByClass(WordRunner.class);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        TextInputFormat.setInputPaths(job,new Path("hdfs://hadoopnode00:9000/word.txt"));
        TextOutputFormat.setOutputPath(job,new Path("hdfs://hadoopnode00:9000/baizhi/out11"));

        job.setMapperClass(WordMapper.class);
        job.setReducerClass(WordReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(NullWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);

        job.waitForCompletion(true);
    }
}
