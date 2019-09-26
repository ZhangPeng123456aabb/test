package com.baizhi.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.entity.Comment;
import com.baizhi.entity.User;
import com.baizhi.service.BookService;
import com.baizhi.service.CategoryService;
import com.baizhi.service.CommentService;
import com.baizhi.service.impl.BookServiceImpl;
import com.baizhi.service.impl.CategoryServiceImpl;
import com.baizhi.service.impl.CommentServiceImpl;

public class CommentAction {
	CommentService com = new CommentServiceImpl();
	CategoryService cs = new CategoryServiceImpl();
	BookService book = new BookServiceImpl();
	private Comment comment1;
	private Integer BookId;
	private Book b;
	private Category ca; 
	private List<User> userList;
	private User u1;
	
	public User getU1() {
		return u1;
	}
	public void setU1(User u1) {
		this.u1 = u1;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public Category getCa() {
		return ca;
	}
	public void setCa(Category ca) {
		this.ca = ca;
	}
	private List<Comment> comment;
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	public Book getB() {
		return b;
	}
	public void setB(Book b) {
		this.b = b;
	}
	public Integer getBookId() {
		return BookId;
	}
	public void setBookId(Integer bookId) {
		BookId = bookId;
	}
	public String showComment(){
		System.out.println(b.getBookId());
		List<Comment> comment4 = new ArrayList();
		comment = com.selectComment(b.getBookId());
		System.out.println(com.selectComment(b.getBookId()));
		System.out.println(comment);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("comment",comment);
		b = book.SelectOneBook(b.getBookId());
		ca = cs.selectCategory1(b.getBookId());
		return "showCommentSuccess";
	}
	public String addComment(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User u = new User();
		Comment comment2 = new Comment();
		u = (User)session.getAttribute("user");
		/*System.out.println(u.getId());*/
		b.setBookId(b.getBookId());
		comment2.setNickname(u.getNickname());
		comment2.setUserId(u.getId());
		comment2.setBookId(b.getBookId());
		comment2.setCommentFloor(1);
		comment2.setCommentContent(comment1.getCommentContent());
		com.insertComment(comment2);
		return "addCommentSuccess";
	}
	public Comment getComment1() {
		return comment1;
	}
	public void setComment1(Comment comment1) {
		this.comment1 = comment1;
	}
}
