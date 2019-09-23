package com.com.baizhi.DBInputFormat;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.lib.db.DBConfiguration;
import org.apache.hadoop.mapred.lib.db.DBInputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.MRJobConfig;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class JobRunner {
    public static void main(String[] args)throws Exception {
        Configuration conf = new Configuration();
        DBConfiguration.configureDB(conf,"com.mysql.jdbc.Driver","jdbc:mysql://hadoopnode00:3306/hadoop","root","123456");
        System.setProperty("HADOOP_USER_NAME","root");
        conf.addResource("conf1/core-site.xml");
        conf.addResource("conf1/hdfs-site.xml");
        conf.addResource("conf1/mapred-site.xml");
        conf.addResource("conf1/yarn-site.xml");
        conf.set(MRJobConfig.JAR, "F:\\study\\IDEA_project\\BigData\\Hadoop_Test\\target\\Hadoop_Test-1.0-SNAPSHOT.jar");
        conf.set("mapreduce.app-submission.cross-platform", "true");
        Job job = Job.getInstance(conf);
        job.setJarByClass(JobRunner.class);

        job.setInputFormatClass(DBInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        DBInputFormat.setInput(job,User.class,"select id,name from user","select count(1) from user");
       /* FileOutputFormat.setOutputPath(job,new Path("file:///F:\\study\\IDEA_project\\BigData\\Hadoop_Test\\src\\main\\java\\com\\com\\baizhi\\DBInputFormat\\out12"));*/
        FileOutputFormat.setOutputPath(job,new Path("/baizhi/outdb02"));
        job.setMapperClass(DBMapper.class);
        job.setReducerClass(DBReducer.class);

        job.setMapOutputKeyClass(LongWritable.class);
        job.setMapOutputValueClass(Text.class);
        job.setOutputKeyClass(NullWritable.class);
        job.setOutputKeyClass(Text.class);

        job.waitForCompletion(true);
    }
}
