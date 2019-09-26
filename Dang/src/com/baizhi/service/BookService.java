package com.baizhi.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Book;

public interface BookService {
    List<Book> selectSales();
	List<Book> selectTime();
	List<Book> selectCount(int i);
    List<Book> selectAuthor(String Author);
	List<Book> showAll(@Param("order")String OrderBy,@Param("i")Integer i);
	List<Book> selectAllBooks(@Param("page")Integer page,@Param("rows")Integer rows,Integer category_id);
	Book SelectOneBook(Integer BookId);
	Integer CountBooks(Integer category_id);
	List<Book> selectAllBook(@Param("page")Integer page,@Param("rows")Integer rows,Integer category_id);
	Integer CountSecondBook(Integer category_id);
}
