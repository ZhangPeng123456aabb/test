package com.baizhi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.AddressDao;
import com.baizhi.entity.Address;
import com.baizhi.service.AddressService;
import com.baizhi.util.MyBatisUtils;

public class AddressServiceImpl implements AddressService {
	SqlSession sqlSession = null;
	AddressDao dao = null;
	@Override
	public List<Address> showAllAddress(Integer UserId) {
		List<Address> add = new ArrayList();
		try{
			sqlSession = MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(AddressDao.class);
			add = dao.showAllAddress(UserId);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally{
			MyBatisUtils.close(sqlSession);
		}
		return add;
	}
	@Override
	public void insertAddress(Address add) {
		try{
			sqlSession = MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(AddressDao.class);
			dao.insertAddress(add);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally{
			MyBatisUtils.close(sqlSession);
		}
	}
	@Override
	public void updatestatus(Address add) {
		try{
			sqlSession = MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(AddressDao.class);
			dao.updateDefault(add.getUserId());
			dao.updatestatus(add.getId());
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally{
			MyBatisUtils.close(sqlSession);
		}
	}
	@Override
	public void deleteAddress(Integer id) {
		try{
			sqlSession = MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(AddressDao.class);
			dao.deleteAddress(id);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally{
			MyBatisUtils.close(sqlSession);
		}
		
	}
	@Override
	public Address selectOneAddress(Integer id) {
		Address add = new Address();
		try{
			sqlSession = MyBatisUtils.getSqlSession();
			dao = sqlSession.getMapper(AddressDao.class);
			add = dao.selectOneAddress(id);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally{
			MyBatisUtils.close(sqlSession);
		}
		return add;
	}

}
