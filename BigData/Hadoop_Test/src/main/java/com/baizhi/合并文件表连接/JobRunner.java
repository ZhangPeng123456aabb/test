package com.baizhi.合并文件表连接;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.MRJobConfig;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class JobRunner {
    public static void main(String[] args)throws Exception {
        /*System.setProperty("HADOOP_USER_NAME", "root");*/
        Configuration conf = new Configuration();

        /*conf.addResource("conf1/core-site.xml");
        conf.addResource("conf1/hdfs-site.xml");
        conf.addResource("conf1/mapred-site.xml");
        conf.addResource("conf1/yarn-site.xml");
        conf.set(MRJobConfig.JAR, "F:\\study\\IDEA_project\\BigData\\Hadoop_Test\\target\\Hadoop_Test-1.0-SNAPSHOT.jar");
        conf.set("mapreduce.app-submission.cross-platform", "true");*/

        Job job = Job.getInstance(conf);

        job.setJarByClass(JobRunner.class);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        /*TextInputFormat.setInputPaths(job,new Path("/student"));*/
        TextInputFormat.setInputPaths(job,new Path("I:\\数据文件\\student"));
        TextOutputFormat.setOutputPath(job,new Path("I:\\数据文件\\student\\out1"));
        /*TextOutputFormat.setOutputPath(job,new Path("/baizhi/out14"));*/
        job.setMapperClass(StuMapper.class);
        job.setReducerClass(StuReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);

        job.setNumReduceTasks(1);

        job.waitForCompletion(true);

    }
}
