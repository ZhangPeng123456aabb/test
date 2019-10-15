package com.baizhi.Job;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.hbase.mapreduce.TableOutputFormat;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.MRJobConfig;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;

import java.io.IOException;
import java.util.UUID;

public class Job01 {
    public static class HDFS2HBASEMapper extends Mapper<LongWritable, Text, NullWritable,Text>{
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            context.write(NullWritable.get(),value);
        }
        public static class HDFS2HBASEReducer extends TableReducer<NullWritable,Text,NullWritable>{
            @Override
            protected void reduce(NullWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
                for(Text value:values){
                    String line =value.toString();
                    String[] lineValue = line.split(" ");
                    String userid = lineValue[0];
                    String fromurl = lineValue[1];
                    String date = lineValue[2];
                    String time = lineValue[3];
                    String ip = lineValue[4];
                    String address = lineValue[9];
                    Put put = new Put(UUID.randomUUID().toString().getBytes());

                    put.addColumn("cf1".getBytes(),"userid".getBytes(),userid.getBytes());
                    put.addColumn("cf1".getBytes(),"fromurl".getBytes(),fromurl.getBytes());
                    put.addColumn("cf1".getBytes(),"date".getBytes(),date.getBytes());
                    put.addColumn("cf1".getBytes(),"time".getBytes(),time.getBytes());
                    put.addColumn("cf1".getBytes(),"ip".getBytes(),ip.getBytes());
                    put.addColumn("cf1".getBytes(),"address".getBytes(),address.getBytes());

                    context.write(NullWritable.get(),put);

                }
            }
        }
        public static void main(String[] args)throws Exception{
            System.setProperty("HADOOP_USER_NAME", "root");
            Configuration configuration = new Configuration();

            configuration.set("hbase.zookeeper.quorum", "HadoopNode00");
            configuration.set("hbase.zookeeper.property.clientPort", "2181");

            configuration.addResource("conf1/core-site.xml");
            configuration.addResource("conf1/hdfs-site.xml");
            configuration.addResource("conf1/mapred-site.xml");
            configuration.addResource("conf1/yarn-site.xml");
            configuration.set(MRJobConfig.JAR, "F:\\study\\IDEA_project\\BigData\\Hbase\\target\\Hbase-1.0-SNAPSHOT.jar");
            configuration.set("mapreduce.app-submission.cross-platform", "true");

            Job job = Job.getInstance(configuration);

            job.setInputFormatClass(TextInputFormat.class);
            job.setOutputFormatClass(TableOutputFormat.class);

            TextInputFormat.setInputPaths(job,new Path("/baizhi/data01"));

            job.setMapperClass(HDFS2HBASEMapper.class);

            job.setMapOutputKeyClass(NullWritable.class);
            job.setMapOutputValueClass(Text.class);

            TableMapReduceUtil.initTableReducerJob(
                    "baizhi:t_result3",
                    HDFS2HBASEReducer.class,
                    job
            );
            job.waitForCompletion(true);
        }
    }
}
