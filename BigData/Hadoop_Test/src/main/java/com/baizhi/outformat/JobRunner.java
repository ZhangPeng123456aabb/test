package com.baizhi.outformat;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;

public class JobRunner {
    public static void main(String[] args)throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);
        job.setJarByClass(JobRunner.class);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(OwnOutputFormat.class);

        TextInputFormat.setInputPaths(job, new Path("I:\\数据文件\\flow.txt"));
        OwnOutputFormat.setOutputPath(job, new Path("I:\\数据文件\\outbaizhi"));

        job.setMapperClass(FileMapper.class);
        job.setReducerClass(FileReducer.class);

        job.setMapOutputKeyClass(NullWritable.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(Text.class);

        job.waitForCompletion(true);
    }
}
