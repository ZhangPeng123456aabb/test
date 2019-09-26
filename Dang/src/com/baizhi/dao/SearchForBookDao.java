package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;

public interface SearchForBookDao {
	//ģ����ҳ��ѯ����ͼ��
	List<Book> showPageSearchBooks(@Param("name")String BookName,@Param("begin")Integer begin,@Param("end")Integer end);
	//��ѯ����ͼ��Ķ������
	List<Category> selectCategory1(Book b);
	//��ѯ����ͼ������
	Integer count(@Param("name")String BookName);
	//�������ķ�ҳ
	List<Book> showPageSearchBook(@Param("id")Integer CategoryId,@Param("begin")Integer begin,@Param("end")Integer end);
	//��ѯ��������ͼ������
	Integer count1(@Param("id")Integer CategoryId);
}
