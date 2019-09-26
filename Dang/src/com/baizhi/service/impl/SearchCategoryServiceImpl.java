package com.baizhi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.SearchForCategory;
import com.baizhi.entity.Category;
import com.baizhi.service.SearchCategoryService;
import com.baizhi.util.MyBatisUtils;

public class SearchCategoryServiceImpl implements SearchCategoryService {
	SqlSession sqlSession = null;
	SearchForCategory s = null;
	@Override
	public List<Category> SelectCategories(String BookName) {
		List<Category> v = new ArrayList();
		try{
			sqlSession = MyBatisUtils.getSqlSession();
			s = sqlSession.getMapper(SearchForCategory.class);
			v = s.SelectCategories(BookName);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally{
			MyBatisUtils.close(sqlSession);
		}
		return v;
	}
	@Override
	public Category SelectCategory(Integer category_id) {
		Category ca = new Category();
		try{
			sqlSession = MyBatisUtils.getSqlSession();
			s = sqlSession.getMapper(SearchForCategory.class);
			ca = s.SelectCategory(category_id);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			throw new RuntimeException(e);
		}finally{
			MyBatisUtils.close(sqlSession);
		}
		return ca;
	}

}
