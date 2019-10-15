import com.alibaba.fastjson.JSON;
import com.baizhi.HighCharts.HighChartsApplication;
import com.baizhi.HighCharts.JedisUtil;
import com.baizhi.HighCharts.entity.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HighChartsApplication.class)
public class test {
    @Test
    public void Ff(){
        ArrayList<status> statuses = new ArrayList<>();
        status status1 = new status();
        Jedis jedis = JedisUtil.getJedis();
        String status = jedis.get("status");
        Map map = JSON.parseObject(status, Map.class);
        Set<Map.Entry<Integer,Integer>> set = map.entrySet();
        for(Map.Entry<Integer,Integer> entry:set){
            status1.setStatusCode(entry.getKey());
            status1.setStatusNums(entry.getValue());
            System.out.println(status1);
        }
    }
}
