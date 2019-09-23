package com.baizhi.OutputFormat;



import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;

public class JobRunner {
    public static void main(String[] args) throws Exception {
        /**
         * 获取配置对象
         */
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);
        //设置类加载器，否则MapReduce框架找不到Map和Reduce
        job.setJarByClass(JobRunner.class);
        /**
         * 设置数据输入输出组件
         */

        job.setInputFormatClass(OwnInputFormat.class);
        job.setOutputFormatClass(SequenceFileOutputFormat.class);
        /**
         * 设置输入输出路径
         */

        OwnInputFormat.setInputPaths(job, new Path("I:\\飞秋文件\\文件包\\feiq\\Recv Files\\data"));
        SequenceFileOutputFormat.setOutputPath(job, new Path("I:\\飞秋文件\\文件包\\feiq\\Recv Files\\out123"));

        /**
         * 设置MAP 和 REDUCE 处理逻辑
         */

        job.setMapperClass(FileMapper.class);
        job.setReducerClass(FileReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(BytesWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(BytesWritable.class);

        //提交
        job.waitForCompletion(true);
    }
}