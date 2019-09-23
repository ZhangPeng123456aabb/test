package com.com.baizhi.mr.test02;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.MRJobConfig;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class FlowRunner {
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
        job.setJarByClass(FlowRunner.class);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        TextInputFormat.setInputPaths(job,new Path("hdfs://hadoopnode00:9000/flow.txt"));
        TextOutputFormat.setOutputPath(job,new Path("hdfs://hadoopnode00:9000/baizhi/out6"));

        job.setMapperClass(FlowMapper.class);
        job.setReducerClass(FlowReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);

        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(FlowBean.class);

        job.waitForCompletion(true);
    }
}
