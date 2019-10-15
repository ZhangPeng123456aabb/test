package com.baizhi;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Create by GuoJF on 2019/6/19
 */
@Description(
        name="hello",
        value = "FUNC_(str1,str2)-from the input string"
                +"returns the value that is \"你好$str1,$str2好玩吗? \" ",
        extended ="Example:\n"
                    +">SELECT_FUNC_(str1,str2) FROM src;"
)
public class HelloUDF  extends UDF {
    public String evaluate (String str1,String str2){
        try {
            return "Hello"+str1+","+str2+"好玩吗?";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR";
        }
    }
}
