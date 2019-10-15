package com.baizhi.mr;


import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;

public class UserReducer extends TableReducer<Text, DoubleWritable, NullWritable> {

    @Override
    protected void reduce(Text key, Iterable<DoubleWritable> values, Context context) throws IOException, InterruptedException {
        double totalSalary = 0.0;

        int count = 0;


        for (DoubleWritable value : values) {
            totalSalary += value.get();
            count++;

        }

        Put put = new Put(key.getBytes());

        put.addColumn("cf1".getBytes(), "avgSalary".getBytes(), (totalSalary / count + "").getBytes());


        context.write(NullWritable.get(), put);


    }
}

