package com.baizhi.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.baizhi.dao.AddressDao;
import com.baizhi.entity.Address;
import com.baizhi.service.AddressService;
import com.baizhi.service.impl.AddressServiceImpl;
import com.baizhi.util.MyBatisUtils;

public class TestAddress {
		SqlSession sqlSession = null;
		AddressDao address = null;
		@Test
		public void TestAddress(){
			sqlSession = MyBatisUtils.getSqlSession();
			address = sqlSession.getMapper(AddressDao.class);
			List<Address> a = new ArrayList();
			a = address.showAllAddress(1);
			for(Address a1:a){
				System.out.println(a1);
			}
			sqlSession.close();
		}
		@Test
		public void TestUpdate(){
			AddressService as = new AddressServiceImpl();
			Address a = new Address();
			a.setId(11);
			a.setUserId(1);
			as.updatestatus(a);
		}
		@Test
		public void TestDelete(){
			sqlSession = MyBatisUtils.getSqlSession();
			address = sqlSession.getMapper(AddressDao.class);
			address.deleteAddress(2);
			sqlSession.commit();
			sqlSession.close();
		}
		@Test
		public void TestSelecctOne(){
			sqlSession = MyBatisUtils.getSqlSession();
			address = sqlSession.getMapper(AddressDao.class);
			Address add = new Address();
			add = address.selectOneAddress(6);
			System.out.println(add);
			sqlSession.close();
		}
		@Test
		public void TestInsert(){
			sqlSession = MyBatisUtils.getSqlSession();
			address = sqlSession.getMapper(AddressDao.class);
			Address add = new Address();
			add.setAddress("北京市中南海");
			add.setReceive_name("习大大");
			add.setTelphone("1145789636");
			add.setUserId(5);
			address.insertAddress(add);
			sqlSession.commit();
			sqlSession.close();
		}
		@Test
		public void TestInsert1(){
			AddressService as = new AddressServiceImpl();
			Address add = new Address();
			add.setAddress("北京市中南海");
			add.setReceive_name("彭麻麻");
			add.setTelphone("1145789636");
			add.setUserId(6);
			as.insertAddress(add);
		}
}
