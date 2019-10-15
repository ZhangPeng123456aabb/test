package com.baizhi.Flume;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;

public class MyMapper extends Mapper<LongWritable,Text, NullWritable, Text> {
    /**
     * @param
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        final String regex = "^(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}).*\\[(.*)\\]\\s\"(\\w*)\\s(.*)\\sHTTP\\/1\\.1\"\\s(\\d{3}).*$";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(value.toString());
        while (matcher.find()){
            String ip = matcher.group(1);
            String accessTime = matcher.group(2);
            String method = matcher.group(3);
            String resource = matcher.group(4);
            String status = matcher.group(5);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", Locale.ENGLISH);
            Date date = null;
            try {
                date = sdf.parse(accessTime);
                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
                String formatAccessTime = sdf2.format(date);
                context.write(null,new Text(ip+" "+formatAccessTime+" "+method+" "+resource+" "+status));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
