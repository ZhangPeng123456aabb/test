package com.baizhi.kafka.testObject;

import org.apache.commons.lang.SerializationUtils;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

import java.io.Serializable;
import java.util.Map;

public class ObjectCodec implements Serializer, Deserializer {

    @Override
    public Object deserialize(String s, byte[] bytes) {
        return SerializationUtils.deserialize(bytes);
    }

    @Override
    public void configure(Map map, boolean b) {

    }

    @Override
    public byte[] serialize(String s, Object o) {
        return SerializationUtils.serialize((Serializable) o);
    }

    @Override
    public void close() {

    }
}
