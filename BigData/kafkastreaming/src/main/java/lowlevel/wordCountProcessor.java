package lowlevel;

import org.apache.kafka.connect.data.Timestamp;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.processor.PunctuationType;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * 单词计数
 */
public class wordCountProcessor implements Processor<String,String[]> {
    private Map<String,Long> wordCount = null;
    private ProcessorContext context = null;
    @Override
    public void init(ProcessorContext context) {
        wordCount = new HashMap<>();
        this.context = context;
        //将单词统计的结果发送给下游的输出单元
        this.context.schedule(Duration.ofSeconds(1), PunctuationType.STREAM_TIME,(Timestamp->{
            wordCount.forEach((word,num)->{
                context.forward(word,num);
            });
        }));

    }

    @Override
    public void process(String key, String[] words) {
       /* String[]  words= value.split(" ");*/
        for(String word:words){
            Long num = wordCount.getOrDefault(word, 0L);
            num++;
            wordCount.put(word,num);
        }
        context.commit();
    }

    @Override
    public void close() {

    }
}
