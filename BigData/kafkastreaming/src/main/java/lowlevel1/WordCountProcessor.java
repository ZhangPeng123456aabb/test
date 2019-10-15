package lowlevel1;

import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.processor.PunctuationType;
import org.apache.kafka.streams.processor.Punctuator;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.KeyValueStore;

import java.time.Duration;

public class WordCountProcessor implements Processor<String,String> {
    private ProcessorContext processorContext;
    private KeyValueStore<String,Long> state;

    /**
     * 初始化方法
     * @param processorContext 处理器的上下文对象
     */
    @Override
    public void init(ProcessorContext processorContext) {
        this.state = (KeyValueStore<String, Long>) processorContext.getStateStore("Counts");
        this.processorContext = processorContext;
        //周期性将处理器的处理结果 发送给下游的处理器
        processorContext.schedule(Duration.ofSeconds(1), PunctuationType.STREAM_TIME, new Punctuator() {
            /**
             * 指定方法
             * @param l
             */
            @Override
            public void punctuate(long l) {
                KeyValueIterator<String, Long> iterator = state.all();
                while (iterator.hasNext()){
                    KeyValue<String, Long> keyValue = iterator.next();
                    processorContext.forward(keyValue.key,keyValue.value);
                }
                iterator.close();
            }
        });//第三个参数：周期性执行的内容
        processorContext.commit();
    }

    @Override
    public void process(String key, String value) {
        String[] words = value.split(" ");
        for(String word:words){
            Long num = state.get(word);
            System.out.println(word+"\t"+num);
            if(num==null){
                state.put(word,1L);
            }else{
                state.put(word,num+1L);
            }
        }

    }

    /**
     * 关闭
     */
    @Override
    public void close() {

    }
}
