package com.baizhi.logs;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;

public class LogsReducer extends TableReducer<NullWritable,Text,NullWritable> {
    @Override
    protected void reduce(NullWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        /*Put put = new Put(key.getBytes());*/
        Put put = new Put(values.toString().getBytes());
        int num = 0;
        for(Text value : values){
            num++;
        }
        put.addColumn("cf1".getBytes(), "info".getBytes(),"values+num".getBytes());


        context.write(NullWritable.get(), put);
    }
}
