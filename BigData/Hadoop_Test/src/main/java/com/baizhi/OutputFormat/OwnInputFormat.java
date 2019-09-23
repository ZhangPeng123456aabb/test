package com.baizhi.OutputFormat;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.ByteWritable;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.JobContext;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

import java.io.IOException;

public class OwnInputFormat extends FileInputFormat<Text, BytesWritable> {
    public RecordReader<Text, BytesWritable> createRecordReader(InputSplit inputSplit, TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
        OwnRecordReader ownRecordReader = new OwnRecordReader();
        ownRecordReader.initialize(inputSplit, taskAttemptContext);
        return ownRecordReader;
    }

    @Override
    protected boolean isSplitable(JobContext context, Path filename) {

        return false;
    }

}
