package com.baizhi.流量统计之对象排序分区输出;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlowMapper extends Mapper<LongWritable, Text,FlowBean, NullWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] data = line.split(" ");
        context.write(new FlowBean(data[0],Long.valueOf(data[1]),Long.valueOf(data[2]),(Long.valueOf(data[1])+Long.valueOf(data[2])),data[3]),NullWritable.get());
    }
}
