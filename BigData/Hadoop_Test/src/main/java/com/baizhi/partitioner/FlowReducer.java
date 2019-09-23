package com.baizhi.partitioner;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/*
 * 18611781163  FlowBean[]
 *
 * */
public class FlowReducer extends Reducer<Text, FlowBean, Text, FlowBean> {

    @Override
    protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {

        Long up = 0L;
        Long down = 0L;
        Long sum = 0L;
        String phone = "";


        for (FlowBean flowBean : values) {

            up += flowBean.getUpFlow();
            down += flowBean.getDownFlow();
            sum += flowBean.getSumFlow();
            phone = flowBean.getPhone();

        }

        context.write(key, new FlowBean(phone, up, down, sum));

    }
}
