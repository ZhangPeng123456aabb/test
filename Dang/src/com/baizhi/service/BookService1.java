package com.baizhi.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Book;

public interface BookService1 {
	List<Book> showPageSearchBooks(String BookName,Integer page,Integer rows);
	Integer count(String BookName);
}
