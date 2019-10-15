package lowlevel;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import java.util.Properties;

//实时的单词计数
public class wordCountApplication {
    public static void main(String[] args) {
        //创建一个配置对象
        Properties properties=new Properties();
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,"HadoopNode01:9092,HadoopNode02:9092,HadoopNode03:9092");
        //key的序列化器和反序列化器
        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG,Serdes.Integer().getClass());
        //value的序列化器和反序列化器
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG,Serdes.String().getClass());
        //应用的id=拉取数据是消费组的id
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG,"wordcount-lowlevel-api");
        //流处理时应用开启的线程数
        properties.put(StreamsConfig.NUM_STREAM_THREADS_CONFIG,2);
        //手动编制topology
        Topology topology = new Topology();
        topology.addSource("s1","t5");
        //处理器  代表topology
        topology.addProcessor("p1",()->new LineSplitProcessor(),"s1");
        topology.addProcessor("p2",()->new wordCountProcessor(),"p1");

        topology.addSink("k1","t6",new StringSerializer(), new LongSerializer(),"p2");

        //初始化kafka流处理的应用
        KafkaStreams kafkaStreams = new KafkaStreams(topology, properties);
        //运行流处理程序
        kafkaStreams.start();

    }
}
