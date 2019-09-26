package com.baizhi.action;

import java.util.List;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.service.BookService;
import com.baizhi.service.CategoryService;
import com.baizhi.service.impl.BookServiceImpl;
import com.baizhi.service.impl.CategoryServiceImpl;

public class BookAction {
	BookService bs = new BookServiceImpl();
	CategoryService cs = new CategoryServiceImpl();
	private List<Book> BookList;
	private Category ca; 
	public Category getCa() {
		return ca;
	}

	public void setCa(Category ca) {
		this.ca = ca;
	}
	private List<Book> AuthorList;
	private List<Book> BookTimeList;
	private List<Category> CategoryList;
	private List<Book> BookCount; 
	private Book b;
	
	public Book getB() {
		return b;
	}

	public void setB(Book b) {
		this.b = b;
	}

	public List<Book> getBookCount() {
		return BookCount;
	}

	public void setBookCount(List<Book> bookCount) {
		BookCount = bookCount;
	}

	public List<Book> getBookTimeList() {
		return BookTimeList;
	}

	public void setBookTimeList(List<Book> bookTimeList) {
		BookTimeList = bookTimeList;
	}

	public List<Category> getCategoryList() {
		return CategoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		CategoryList = categoryList;
	}

	public List<Book> getAuthorList() {
		return AuthorList;
	}

	public void setAuthorList(List<Book> authorList) {
		AuthorList = authorList;
	}

	public List<Book> getBookList() {
		return BookList;
	}

	public void setBookList(List<Book> bookList) {
		BookList = bookList;
	}

	public String showAll(){
		BookList = bs.selectSales();
		BookCount = bs.selectCount(10);
		AuthorList=bs.selectAuthor("Àî¸Ú");
		CategoryList=cs.showAllCategory();
		BookTimeList=bs.selectTime();
		return "showSalesSuccess";
	}
	public String SelectOneBook(){
		b = bs.SelectOneBook(b.getBookId());
		ca = cs.selectCategory1(b.getBookId());
		return "selectOneSuccess";
	}
}
