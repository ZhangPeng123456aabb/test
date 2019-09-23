package com.com.baizhi.DBInputFormat;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class DBMapper extends Mapper<LongWritable, User,LongWritable,Text> {
    @Override
    protected void map(LongWritable key, User value, Context context) throws IOException, InterruptedException {
        context.write(key,new Text(value.toString()));
    }
}
