package com.baizhi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.service.BookService1;
import com.baizhi.service.SearchBookService;
import com.baizhi.service.SearchCategoryService;
import com.baizhi.service.impl.BookServiceImpl1;
import com.baizhi.service.impl.SearchBookServiceImpl;
import com.baizhi.service.impl.SearchCategoryServiceImpl;

public class SearchBookAction {
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	BookService1 bs = new BookServiceImpl1();
	SearchCategoryService scs = new SearchCategoryServiceImpl();
	SearchBookService ss = new SearchBookServiceImpl();
	private  Book bb;
	private List<Book> bookList;
	private List<Category> ca;
	private Category category;
	private Integer cateId;
	private String cateName;
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public Integer getCateId() {
		return cateId;
	}
	public void setCateId(Integer cateId) {
		this.cateId = cateId;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Category> getCa() {
		return ca;
	}
	public void setCa(List<Category> ca) {
		this.ca = ca;
	}
	public List<Book> getBookList() {
		return bookList;
	}
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	
	public Book getBb() {
		return bb;
	}
	public void setBb(Book bb) {
		this.bb = bb;
	}
	public String PageBySearchOneBook(){
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
		if(cateId==null){
			/*System.out.println(bb);*/
			bookList=bs.showPageSearchBooks(bb.getBookName(),page,rows);
			/*System.out.println(bookList);*/
			ca = scs.SelectCategories(bb.getBookName());
			int totalRows = bs.count(bb.getBookName());
			int totalPage = (totalRows % rows == 0 ? totalRows/rows : totalRows/rows+1);
			request.setAttribute("page", page);
			request.setAttribute("rows", rows);
			request.setAttribute("totalPage", totalPage);
			return "SearchSuccess";
		}else{
			bookList=ss.TestshowPageSearchBook(page, rows, cateId);
			category = scs.SelectCategory(cateId);
			cateName=category.getCategory_name();
			ca = category.getCategory();
			
			int totalRows =ss.TestcountBook(cateId);
			int totalPage = (totalRows % rows == 0 ? totalRows/rows : totalRows/rows+1);
			request.setAttribute("page", page);
			request.setAttribute("rows", rows);
			request.setAttribute("totalPage", totalPage);
			return "SearchSuccess1";
		}
		
	}
}
