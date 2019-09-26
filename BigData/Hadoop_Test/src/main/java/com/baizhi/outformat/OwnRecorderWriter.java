package com.baizhi.outformat;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

import java.io.IOException;

public class OwnRecorderWriter extends RecordWriter<NullWritable, Text> {
    FileSystem fileSystem;
    FSDataOutputStream outputStream;

    public OwnRecorderWriter(TaskAttemptContext taskAttemptContext)throws Exception {
       fileSystem = FileSystem.get(taskAttemptContext.getConfiguration());
        outputStream = fileSystem.create(new Path("I:\\数据文件\\testoutputforamt.txt"));
    }

    @Override
    public void write(NullWritable nullWritable, Text text) throws IOException, InterruptedException {
        outputStream.write(text.getBytes());
    }

    @Override
    public void close(TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
        IOUtils.closeStream(outputStream);
        fileSystem.close();
    }
}
