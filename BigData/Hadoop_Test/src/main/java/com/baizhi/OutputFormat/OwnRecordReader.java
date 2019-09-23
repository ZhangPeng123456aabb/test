package com.baizhi.OutputFormat;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;


import java.io.IOException;

public class OwnRecordReader extends RecordReader<Text, BytesWritable>{
    FileSplit fileSplit;
    Configuration conf;
    BytesWritable value = new BytesWritable();
    Text key = new Text();
    boolean isProgress=true;
    @Override
    public void initialize(InputSplit inputSplit, TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
        fileSplit = (FileSplit)inputSplit;
        conf=taskAttemptContext.getConfiguration();

    }

    @Override
    public boolean nextKeyValue() throws IOException, InterruptedException {
        if(isProgress){
            byte[] bytes = new byte[(int)fileSplit.getLength()];
            //获取fs对象
            //当前文件路径
            Path path = fileSplit.getPath();
            FileSystem fileSystem = path.getFileSystem(conf);
            //获取到文件的数据流
            FSDataInputStream inputStream = fileSystem.open(path);
            IOUtils.readFully(inputStream,bytes,0,bytes.length);
            //封装value
            value.set(bytes,0,bytes.length);
            key.set(path.toString());
            IOUtils.closeStream(inputStream);
            isProgress=false;
            return true;

        }
        return false;
    }

    @Override
    public Text getCurrentKey() throws IOException, InterruptedException {
        return this.key;
    }

    @Override
    public BytesWritable getCurrentValue() throws IOException, InterruptedException {
        return this.value;
    }

    @Override
    public float getProgress() throws IOException, InterruptedException {
        return 0;
    }

    @Override
    public void close() throws IOException {

    }
}

