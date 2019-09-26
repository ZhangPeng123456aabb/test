package com.baizhi.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.baizhi.dao.SearchForCategory;
import com.baizhi.entity.Category;
import com.baizhi.util.MyBatisUtils;

public class TestSearchCategory {
	SqlSession sqlSession = null;
	SearchForCategory s = null;
	@Test
	public void TestSearchForCategory(){
		sqlSession = MyBatisUtils.getSqlSession();
		s = sqlSession.getMapper(SearchForCategory.class);
		List<Category> v = new ArrayList();
		v =s.SelectCategories("Í¯Äê");
		for(Category v1:v){
			System.out.println(v1.getCategory_name());
			v=v1.getCategory();
			for(Category v2:v){
				System.out.println(v2.getCategory_name());
			}
		}
		sqlSession.close();
	}
	@Test
	public void TestSearchCategoryt(){
		sqlSession = MyBatisUtils.getSqlSession();
		s = sqlSession.getMapper(SearchForCategory.class);
		Category ca = new Category();
		ca= s.SelectCategory(6);
		System.out.println(ca);
	}
}
