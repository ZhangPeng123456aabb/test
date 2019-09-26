package com.baizhi.entity;

import java.util.Date;
import java.util.List;

public class Comment {
	private Integer CommentId;
	private String CommentContent;
	private Date CommentDate;
	private Integer CommentFloor;
	private Integer ParentId;
	private Integer BookId;
	private Integer UserId;
	private String nickname;
	private Integer status;
	private Book book;
	private List<User> userList;
	private List<Comment> commentList;
	public Comment(Integer commentId, String commentContent, Date commentDate,
			Integer commentFloor, Integer parentId, Integer bookId,
			Integer userId, String nickname, Integer status, Book book,
			List<User> userList, List<Comment> commentList) {
		super();
		CommentId = commentId;
		CommentContent = commentContent;
		CommentDate = commentDate;
		CommentFloor = commentFloor;
		ParentId = parentId;
		BookId = bookId;
		UserId = userId;
		this.nickname = nickname;
		this.status = status;
		this.book = book;
		this.userList = userList;
		this.commentList = commentList;
	}
	public Comment() {
		super();
	}
	public Integer getCommentId() {
		return CommentId;
	}
	public void setCommentId(Integer commentId) {
		CommentId = commentId;
	}
	public String getCommentContent() {
		return CommentContent;
	}
	public void setCommentContent(String commentContent) {
		CommentContent = commentContent;
	}
	public Date getCommentDate() {
		return CommentDate;
	}
	public void setCommentDate(Date commentDate) {
		CommentDate = commentDate;
	}
	public Integer getCommentFloor() {
		return CommentFloor;
	}
	public void setCommentFloor(Integer commentFloor) {
		CommentFloor = commentFloor;
	}
	public Integer getParentId() {
		return ParentId;
	}
	public void setParentId(Integer parentId) {
		ParentId = parentId;
	}
	public Integer getBookId() {
		return BookId;
	}
	public void setBookId(Integer bookId) {
		BookId = bookId;
	}
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer userId) {
		UserId = userId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	@Override
	public String toString() {
		return "Comment [CommentId=" + CommentId + ", CommentContent="
				+ CommentContent + ", CommentDate=" + CommentDate
				+ ", CommentFloor=" + CommentFloor + ", ParentId=" + ParentId
				+ ", BookId=" + BookId + ", UserId=" + UserId + ", nickname="
				+ nickname + ", status=" + status + ", book=" + book
				+ ", userList=" + userList + ", commentList=" + commentList
				+ "]";
	}
	
}
