package com.com.baizhi.mr.test02;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 18611781163  FlowBean[]
 */
public class FlowReducer extends Reducer<Text,FlowBean, NullWritable,FlowBean> {
    @Override
    protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {
        Long up = 0L;
        Long down = 0L;
        Long sum = 0L;
        for(FlowBean flowBean : values){
            up+=flowBean.getUpFlow();
            down+=flowBean.getDownFlow();
            sum+=flowBean.getSumFlow();
        }
        context.write(NullWritable.get(),new FlowBean(key.toString(),up,down,sum));
    }
}
