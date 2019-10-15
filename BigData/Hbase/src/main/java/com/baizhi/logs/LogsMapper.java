package com.baizhi.logs;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class LogsMapper extends Mapper<LongWritable,Text,NullWritable,Text> {
    private Integer count = 0;
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();

        if (line.contains("河南省郑州市")) {
            count++;
            String cleanLog = line.split(" ")[0].trim();
            context.write(NullWritable.get(), new Text(cleanLog+count));
        }
    }
}

