package com.baizhi.mr;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;

public class UserMapper extends TableMapper<Text, DoubleWritable> {
    @Override
    protected void map(ImmutableBytesWritable key, Result value, Context context) throws IOException, InterruptedException {


        byte[] bytes = key.get();
        String rowkey = Bytes.toString(bytes);

        String company = rowkey.split(":")[0];

        byte[] salaryByte = value.getValue("cf1".getBytes(), "salary".getBytes());

        double salary = Bytes.toDouble(salaryByte);


        context.write(new Text(company), new DoubleWritable(salary));


    }
}
