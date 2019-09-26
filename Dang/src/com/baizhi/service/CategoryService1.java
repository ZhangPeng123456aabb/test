package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;

public interface CategoryService1 {
	Category selectByPage(int page, int rows,Integer category_id);
	public Integer showCategory1(Integer category_id);
	List<Book> selectAllBooks(int page, int rows,Integer category_id);
	Integer selectByPage1(Integer category_id);
}
