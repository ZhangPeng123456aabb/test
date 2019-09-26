package com.baizhi.test;

import org.junit.Test;

import redis.clients.jedis.Jedis;

import com.alibaba.fastjson.JSON;
import com.baizhi.entity.Student;

public class TestRedis {
	public static void main (String[] args){
		String s = "{\"id\":1,\"name\":\"уехЩ\"}";
		
		Student student = JSON.parseObject(s,Student.class);
		System.out.println(student);
		System.out.println(s);
		Jedis jedis = new Jedis();
		jedis.set("age", "10");
		System.out.println(jedis.get("age"));
	}
	@Test
	public void Test1(){
		Jedis jedis = new Jedis();
		/*String string = JSON.toJSONString(new Student(id:1,name:"уе"));*/
	}
}
