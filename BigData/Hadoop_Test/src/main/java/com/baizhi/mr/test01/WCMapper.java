package com.baizhi.mr.test01;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
   keyIn  LongWritable (Long) 输入文本字节偏移量
 * valueIn Text (String)      输入文本行
 *  keyOut Text(String)
 *  valueOut IntWritable(Int)
 */
public class WCMapper extends Mapper<LongWritable,Text, Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] names = value.toString().split(" ");
        for(String name : names){
            context.write(new Text(name),new IntWritable(1));
        }
    }
}

