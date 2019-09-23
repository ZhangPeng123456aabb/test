package com.baizhi.partitioner;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlowMapper extends Mapper<LongWritable, Text, Text, FlowBean> {

    /*
     * 18611781163 700000 10000 hn
     * 18611781163 700000 10000 hn
     * 18611781163 700000 10000 hn
     * */

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String line = value.toString();

        String[] data = line.split(" ");

        /*
         *  phone
         * */
        context.write(new Text(data[3]), new FlowBean(data[0], Long.valueOf(data[1]), Long.valueOf(data[2]), (Long.valueOf(data[1]) + Long.valueOf(data[2]))));



    }
}


