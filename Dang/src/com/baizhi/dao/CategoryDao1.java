package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;

public interface CategoryDao1 {
	Category showCategory();
	public List<Book> selectAllBooks(Integer category_id);
	public List<Book> showBooks(Integer category_id);
	Category SelectCategories(Integer parent_id);
	public Integer showCategory1(Integer category_id);
	Category selectByPage(@Param("end")Integer end,@Param("begin")Integer begin,@Param("id")Integer category_id);
	Integer selectByPage1(Integer category_id);
	Category selectCategory(Book b);
	
}
