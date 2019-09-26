package com.baizhi.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Category;

public interface SearchCategoryService {
	List<Category> SelectCategories(String BookName);
	Category  SelectCategory(Integer category_id);
}
