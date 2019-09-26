package com.baizhi.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;

public interface CategoryService {
	List<Category> showAllCategory();
	List<Book> showBooks(Integer category_id);
	Category  SelectCategories(Integer parent_id);
	Category  selectByPage(int page, int rows,Integer category_id);
	 Integer showCategory1(Integer category_id);
    List<Book> selectAllBooks(int page, int rows,Integer category_id);
	Integer selectByPage1(Integer category_id);
	Category  selectCategory(Book b);
	Category selectCategory1(Integer BookId);
}
