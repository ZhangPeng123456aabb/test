package com.baizhi.partitioner;

import org.apache.hadoop.mapreduce.Partitioner;

import java.util.HashMap;

public class OwnPartitioner<KEY,VALUE> extends Partitioner<KEY,VALUE> {
    private static HashMap<String, Integer> areaMap = new HashMap<String, Integer>();
    static{
        areaMap.put("hn", 0);
        areaMap.put("henna", 0);

        areaMap.put("bj", 1);
        areaMap.put("tj", 2);
        areaMap.put("hb", 3);
    }
    @Override
    public int getPartition(KEY key, VALUE value, int i) {
        return areaMap.get(key.toString()) == null ? 5 : areaMap.get(key.toString());
    }
}
