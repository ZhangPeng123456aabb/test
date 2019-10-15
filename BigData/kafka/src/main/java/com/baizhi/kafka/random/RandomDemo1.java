package com.baizhi.kafka.random;

import java.awt.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
 
public class RandomDemo1 {
 
	//定义数组随机集合：
	static String[] arr= {"a","b","c","d","e","f","h","i","j","k","l","m","n","o","p","q",
			"r","s","t","x","w","y","z","v","u","1","2","3","4","5","6","7","8","9","0"};
	static String[] list=new String[4]; 
	public static void random() {
		Random rdm=new Random();
		System.out.println("随机数：");
		for(int i=0;i<list.length;i++) {
			//循环抽取随机数
		int index=rdm.nextInt(arr.length);
		 list[i]=arr[index];
		//随机得到数组中的下标，利用数组下标读取数组中的数据
		 System.out.print(list[i]);
		}
		comparable();
		
	}
	public static void comparable() {
		Scanner scan=new Scanner(System.in);
		//从控制台输入验证码
		System.out.println("\n请输入验证码：以'/'隔开");
		String[] input=scan.nextLine().split("/");
		for(int j=0;j<list.length;j++){
			if(Objects.equals(list[j], input[j])) {
				//利用Objects的equals方法对两组字符进行比对
				System.out.println("验证成功！！！");
			}else {
				System.out.println("验证失败！！！");
			}
		}
	}
	public static void main(String[] args) {
		random();
 
	}
 
}