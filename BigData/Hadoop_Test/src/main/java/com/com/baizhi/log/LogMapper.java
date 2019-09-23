package com.com.baizhi.log;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class LogMapper extends Mapper<LongWritable,Text, Text, NullWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        if(line.contains("thisisshortvideoproject'slog")){
            String[] name = line.split("thisisshortvideoproject'slog");
            for(String str:name){
                context.write(new Text(str),NullWritable.get());
            }
        }

    }
}
