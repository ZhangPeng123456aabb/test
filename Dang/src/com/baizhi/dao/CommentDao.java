package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Comment;

public interface CommentDao {
	void insertComment(Comment com);
	List<Comment> selectComment(Integer BookId);
}
