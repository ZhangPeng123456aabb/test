package com.baizhi.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.service.BookService;
import com.baizhi.service.CategoryService;
import com.baizhi.service.impl.BookServiceImpl;
import com.baizhi.service.impl.CategoryServiceImpl;

public class CategoryAction {
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	CategoryService cs = new CategoryServiceImpl();
	BookService bs  = new BookServiceImpl();
	private Category c;
	private List<Category> CategoryList;
	private List<Book> bookList;
	private Integer Id;
	private Integer parent_id;
	private Integer category_id;
	
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public List<Category> getCategoryList() {
		return CategoryList;
	}
	public void setCategoryList(List<Category> categoryList) {
		CategoryList = categoryList;
	}
	public List<Book> getBookList() {
		return bookList;
	}
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	public Category getC() {
		return c;
	}
	public void setC(Category c) {
		this.c = c;
	}
	public String showCategory(){
		CategoryList = cs.showAllCategory();

		return "showSuccess";
	}
	public String showCategoryBooks(){
		int i= cs.selectByPage1(c.getCategory_id());
		c.setCategory_id(i);
		
		return "showCategoryBooksSuccess";
	}
	public String TestshowPageCategory(){
		String pageStr = request.getParameter("page");
		String rowsStr = request.getParameter("rows");
		if(pageStr == null || pageStr.trim().isEmpty()){
			pageStr = "1";
		}
		if(rowsStr == null || rowsStr.trim().isEmpty()){
			rowsStr = "3";
		}
		int page = Integer.parseInt(pageStr);
		int rows = Integer.parseInt(rowsStr);
		if(parent_id==null){
		System.out.println(c.getCategory_id());
		c=cs.SelectCategories(c.getCategory_id());
		bookList=bs.selectAllBooks(page,rows,c.getCategory_id());
		int totalRows = bs.CountBooks(c.getCategory_id());
		int totalPage = (totalRows % rows == 0 ? totalRows/rows : totalRows/rows+1);
		request.setAttribute("category_name", c.getCategory_name());
		request.setAttribute("category_id", c.getCategory_id());
		request.setAttribute("page", page);
		request.setAttribute("rows", rows);
		request.setAttribute("totalPage", totalPage);
		return "showPageSuccess";
		}else{
			System.out.println(Id);
			c=cs.SelectCategories(parent_id);
			System.out.println(parent_id);
			/*System.out.println(c.getCategory_id());
			System.out.println(c.getParent_id());*/
			bookList=bs.selectAllBook(page,rows,Id);
			System.out.println(bookList);
			int totalRows = bs.CountSecondBook(Id);
			int totalPage = (totalRows % rows == 0 ? totalRows/rows : totalRows/rows+1);
			request.setAttribute("category_name", c.getCategory_name());
		    request.setAttribute("category_id",Id);
			request.setAttribute("parent_id",parent_id);
			request.setAttribute("page", page);
			request.setAttribute("rows", rows);
			request.setAttribute("totalPage", totalPage);
			return "showPageSuccess";
		}
	}
}
