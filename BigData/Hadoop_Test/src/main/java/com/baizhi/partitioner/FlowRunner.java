package com.baizhi.partitioner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.MRJobConfig;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class FlowRunner {
    public static void main(String[] args) throws Exception {
        //System.setProperty("HADOOP_USER_NAME", "root");

        Configuration conf = new Configuration();
       /* conf.addResource("conf2/core-site.xml");
        conf.addResource("conf2/hdfs-site.xml");
        conf.addResource("conf2/mapred-site.xml");
        conf.addResource("conf2/yarn-site.xml");
        conf.set(MRJobConfig.JAR, "G:\\IDEA_WorkSpace\\BigData\\Hadoop_Test\\target\\Hadoop_Test-1.0-SNAPSHOT.jar");
        conf.set("mapreduce.app-submission.cross-platform", "true");
*/
        Job job = Job.getInstance(conf);


        job.setJarByClass(FlowRunner.class);
        job.setPartitionerClass(OwnPartitioner.class);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);



        TextInputFormat.setInputPaths(job, new Path("I:\\飞秋文件\\文件包\\feiq\\Recv Files\\data1\\flow.txt"));

        TextOutputFormat.setOutputPath(job, new Path("I:\\飞秋文件\\文件包\\feiq\\Recv Files\\data1\\out131"));
        job.setMapperClass(FlowMapper.class);
        job.setReducerClass(FlowReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);


        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(FlowBean.class);

        job.setNumReduceTasks(4);

        job.waitForCompletion(true);

    }
}
