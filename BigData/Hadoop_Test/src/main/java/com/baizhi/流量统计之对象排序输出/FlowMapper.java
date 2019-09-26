package com.baizhi.流量统计之对象排序输出;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlowMapper extends Mapper<LongWritable, Text,FlowBean, NullWritable> {
    /*
     * 18611781163 700000 10000 hn
     * 18611781163 700000 10000 hn
     * 18611781163 700000 10000 hn
     * */

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] data = line.split(" ");
        context.write(new FlowBean(data[0],Long.valueOf(data[1]),Long.valueOf(data[2]),(Long.valueOf(data[1])+Long.valueOf(data[2]))),NullWritable.get());
    }
}
