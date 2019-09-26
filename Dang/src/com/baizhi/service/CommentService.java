package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Comment;

public interface CommentService {
	void insertComment(Comment com);
	List<Comment> selectComment(Integer BookId);
}
