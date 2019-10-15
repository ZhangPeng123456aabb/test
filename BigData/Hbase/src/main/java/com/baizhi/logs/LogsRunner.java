package com.baizhi.logs;

import com.baizhi.mr.JobRunner;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.hbase.mapreduce.TableOutputFormat;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.MRJobConfig;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;

public class LogsRunner {
    public static void main(String[] args)throws Exception {
        System.setProperty("HADOOP_USER_NAME", "root");
        Configuration configuration = new Configuration();
       /* configuration.set("hbase.zookeeper.quorum", "192.168.182.21,192.168.182.22,192.168.182.23");*/
        configuration.set("hbase.zookeeper.quorum", "HadoopNode00");
        configuration.set("hbase.zookeeper.property.clientPort", "2181");

        configuration.addResource("conf2/core-site.xml");
        configuration.addResource("conf2/hdfs-site.xml");
        configuration.addResource("conf2/mapred-site.xml");
        configuration.addResource("conf2/yarn-site.xml");
        configuration.set(MRJobConfig.JAR, "F:\\study\\IDEA_project\\BigData\\Hbase\\target\\Hbase-1.0-SNAPSHOT.jar");
        configuration.set("mapreduce.app-submission.cross-platform", "true");

        Job job = Job.getInstance(configuration);
        job.setJarByClass(JobRunner.class);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TableOutputFormat.class);

        /**
         * 设置mapper相关
         */
        TextInputFormat.setInputPaths(job,"/logs.txt");
        job.setMapperClass(LogsMapper.class);

        job.setMapOutputKeyClass(NullWritable.class);
        job.setMapOutputValueClass(Text.class);

        TableMapReduceUtil.initTableReducerJob(
                "baizhi:t_user1",
                LogsReducer.class,
                job
        );
        job.waitForCompletion(true);
    }
}

