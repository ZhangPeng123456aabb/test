package com.baizhi.outformat;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class OwnOutputFormat extends FileOutputFormat<NullWritable, Text> {
    @Override
    public RecordWriter<NullWritable, Text> getRecordWriter(TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
        try {
            return new OwnRecorderWriter(taskAttemptContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
}
