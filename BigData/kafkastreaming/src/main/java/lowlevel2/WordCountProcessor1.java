package lowlevel2;

import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.processor.PunctuationType;
import org.apache.kafka.streams.processor.Punctuator;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class WordCountProcessor1 implements Processor<String,String> {
    private Map<String,Long> pairs;

    /**
     *
     * @param processorContext  处理器的上下文对象
     */
    @Override
    public void init(ProcessorContext processorContext) {
        pairs = new HashMap<>();
        //周期性将处理器的处理结果发送给下游的处理器
        //第三个参数代表周期性要进行的操作
        processorContext.schedule(Duration.ofSeconds(5), PunctuationType.STREAM_TIME, new Punctuator() {
            //指定周期性要执行的方法
            @Override
            public void punctuate(long l) {
                pairs.forEach((k,v)->{
                    //转发：将当前处理器的处理结果转发给下游的处理器(会发送Map集合中的所有数据)
                    processorContext.forward(k,v);
                });
                processorContext.commit();
            }
        });
    }

    @Override
    public void process(String key, String value) {
        String[] words = value.split(" ");
        for (String word : words) {

            //如果key存在，value的值为word的值，如果不存在，赋值默认值
            Long num = pairs.getOrDefault(word, 0L);
            System.out.println(word+"\t"+num);
            //当前num的值+1
            num++;
            //把当前累计的结果存到map集合中
            pairs.put(word,num);
        }
    }

    /**
     * 统计的结果需要发送给下游的sink组件，发送到外部的主题当中，进行结果的存储
     */

    @Override
    public void close() {

    }

}
