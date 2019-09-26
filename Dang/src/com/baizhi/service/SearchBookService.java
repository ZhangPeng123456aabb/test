package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Book;

public interface SearchBookService {
	List<Book> TestshowPageSearchBook(int page, int rows,Integer category_id);
	Integer TestcountBook(Integer categoryId);
}
