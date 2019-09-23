package com.baizhi;

public class jiequ {
    public static void main(String[] args) {
        String str = "707a2a9c-c89f-4041-a276-df12611a9363 http://localhost:1211/ShortVideoProject/index.jsp 2019-05-19 22:28:56 115.60.10.225 Chrome Windows Windows-10 zh-CN 河南省郑州市 thisisshortvideoproject'slog";

        String[] s = str.split(" ");

        for(String s1:s){

            System.out.println(s1);
        }
    }
}
