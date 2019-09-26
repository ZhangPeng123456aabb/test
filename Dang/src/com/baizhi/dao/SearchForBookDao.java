package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;

public interface SearchForBookDao {
	//模糊分页查询所有图书
	List<Book> showPageSearchBooks(@Param("name")String BookName,@Param("begin")Integer begin,@Param("end")Integer end);
	//查询所有图书的二级类别
	List<Category> selectCategory1(Book b);
	//查询所有图书数量
	Integer count(@Param("name")String BookName);
	//二级类别的分页
	List<Book> showPageSearchBook(@Param("id")Integer CategoryId,@Param("begin")Integer begin,@Param("end")Integer end);
	//查询二级类别的图书数量
	Integer count1(@Param("id")Integer CategoryId);
}
