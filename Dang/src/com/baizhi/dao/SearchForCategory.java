package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Category;

public interface SearchForCategory {
	List<Category> SelectCategories(@Param("name")String BookName);
	Category  SelectCategory(@Param("id")Integer category_id);
}
