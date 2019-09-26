package com.baizhi.合并文件表连接;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;
public class StuReducer extends Reducer<Text,Text, Text, NullWritable> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        String classList = "";
        String name = "";
        for(Text value:values){
            String[] data = value.toString().split(" ");
            if(data[0].equals("a")){
                name=data[1];
            }
            if(data[0].equals("b")){
                classList+=" "+data[1];
            }
        }
        context.write(new Text(key.toString()+" "+name+classList),NullWritable.get());
    }
}
