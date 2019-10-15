package lowlevel;

import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.processor.PunctuationType;
import org.apache.kafka.streams.processor.Punctuator;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * 按英文短语切割单词
 */
public class LineSplitProcessor implements Processor<Integer,String> {
   private ProcessorContext context=null;
   private Map<String,String[]> kvPairs = null;
    /**
     * 初始化方法
     * @param context 上下文环境
     */
    @Override
    public void init(ProcessorContext context) {
        this.context=context;
        this.kvPairs=new HashMap<>();
        this.context.schedule(Duration.ofSeconds(1), PunctuationType.STREAM_TIME, new Punctuator() {
            @Override
            public void punctuate(long l) {
                kvPairs.forEach((k,v)->{
                    context.forward(k,v);
                });
            }
        });
    }

    /**
     * 处理方法
     * @param integer
     * @param s
     */
    @Override
    public void process(Integer integer, String s) {
        String[] words = s.split(" ");
        kvPairs.put(s,words);
        context.commit();

    }

    public void close() {

    }
}
