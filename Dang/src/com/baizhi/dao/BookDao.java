package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Book;

public interface BookDao {
	 List<Book> selectSales();
	 List<Book> selectTime();
	 List<Book> selectCount(int i);
     List<Book> selectAuthor(String Author);
	 List<Book> selectAll(@Param("order")String OrderBy,@Param("i")Integer i);
	 Integer countBook(Integer category_id);
	 Integer countSecondBook(Integer category_id);
	 List<Book> selectAllBook(@Param("begin")Integer begin,@Param("end")Integer end,@Param("id1")Integer OrderById);
	 Book selectOneBook(Integer BookId);
	 List<Book> selectAllBooks(@Param("begin")Integer begin,@Param("end")Integer end,@Param("id1")Integer OrderById);
}
