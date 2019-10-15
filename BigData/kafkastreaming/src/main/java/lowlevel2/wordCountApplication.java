package lowlevel2;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorSupplier;

import java.util.Properties;

public class wordCountApplication {
    public static void main(String[] args) {
        //指定配置信息
        Properties properties = new Properties();
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,"HadoopNode01:9092,HadoopNode02:9092,HadoopNode03:9092");
        //生命key和value的序列化和反序列化
        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG,Serdes.String().getClass());
        //流处理应用程序的名称 默认会成为消费组的名称
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG,"wordcount-application");
        properties.put(StreamsConfig.NUM_STREAM_THREADS_CONFIG,3);
        //手动编织拓扑任务
        Topology topology = new Topology();
        topology.addSource("s1","t5");
        //添加计算逻辑
        topology.addProcessor("p1", new ProcessorSupplier() {
            @Override
            public Processor get() {
                return new WordCountProcessor1();
            }
        },"s1");
        //s1--->p1-->k1
        //注意：此时结果输出类型不匹配默认类型，需要手动只盯住输出类型
        topology.addSink("k1","t6",new StringSerializer(),new LongSerializer(),"p1");
        //初始化kafkaStreaming应用
        KafkaStreams kafkaStreams = new KafkaStreams(topology, properties);
        //启动流处理应用
        kafkaStreams.start();
    }
}
