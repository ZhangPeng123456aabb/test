package com.baizhi;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;
@Description(
        name="hello",
        value = "FUNC_(str1)-from the input string"
                +"returns the value that is \"平均年龄为:str1 \" ",
        extended ="Example:\n"
                +">SELECT_FUNC_(str1) FROM src;"
)
public class myavg extends UDF {
    public String evaluate (String str1){
        try {
            return "平均年龄为:"+str1;
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR";
        }
    }
}
