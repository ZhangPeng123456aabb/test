package com.baizhi.partitioner;

public class App {
    public static void main(String[] args) {
        String hn = "hn";
        String bj = "bj";
        String tj = "tj";
        String hb = "hb";


        System.out.println((hn.hashCode() & 2147483647) % 4);
        System.out.println((bj.hashCode() & 2147483647) % 4);
        System.out.println((tj.hashCode() & 2147483647) % 4);
        System.out.println((hb.hashCode() & 2147483647) % 4);
    }
}
