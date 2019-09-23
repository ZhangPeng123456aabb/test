package com.baizhi.mr.test01;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class WCReducer extends Reducer<Text, LongWritable,Text,NullWritable> {

    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        /*int sum = 0;
        for(IntWritable value : values){
            sum += value.get();
        }*/
        context.write(key,NullWritable.get());
    }
}
