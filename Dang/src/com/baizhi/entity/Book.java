package com.baizhi.entity;

import java.util.Date;

public class Book {
	private Integer BookId;
	private String BookName;
	private String Author;
	private String Press;
	private Date date;
	private Double BookPrice;
	private Double DangPrice;
	private String BookImg;
	private Integer CategoryId;
	private String  Describe;
	private Integer BookSale;
	private Integer parent_id;
	private Category category;
	public Integer getBookId() {
		return BookId;
	}
	public void setBookId(Integer bookId) {
		BookId = bookId;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getPress() {
		return Press;
	}
	public void setPress(String press) {
		Press = press;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getBookPrice() {
		return BookPrice;
	}
	public void setBookPrice(Double bookPrice) {
		BookPrice = bookPrice;
	}
	public Double getDangPrice() {
		return DangPrice;
	}
	public void setDangPrice(Double dangPrice) {
		DangPrice = dangPrice;
	}
	public String getBookImg() {
		return BookImg;
	}
	public void setBookImg(String bookImg) {
		BookImg = bookImg;
	}
	public Integer getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(Integer categoryId) {
		CategoryId = categoryId;
	}
	public String getDescribe() {
		return Describe;
	}
	public void setDescribe(String describe) {
		Describe = describe;
	}
	public Integer getBookSale() {
		return BookSale;
	}
	public void setBookSale(Integer bookSale) {
		BookSale = bookSale;
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Book(Integer bookId, String bookName, String author, String press,
			Date date, Double bookPrice, Double dangPrice, String bookImg,
			Integer categoryId, String describe, Integer bookSale,
			Integer parent_id, Category category) {
		super();
		BookId = bookId;
		BookName = bookName;
		Author = author;
		Press = press;
		this.date = date;
		BookPrice = bookPrice;
		DangPrice = dangPrice;
		BookImg = bookImg;
		CategoryId = categoryId;
		Describe = describe;
		BookSale = bookSale;
		this.parent_id = parent_id;
		this.category = category;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [BookId=" + BookId + ", BookName=" + BookName
				+ ", Author=" + Author + ", Press=" + Press + ", date=" + date
				+ ", BookPrice=" + BookPrice + ", DangPrice=" + DangPrice
				+ ", BookImg=" + BookImg + ", CategoryId=" + CategoryId
				+ ", Describe=" + Describe + ", BookSale=" + BookSale
				+ ", parent_id=" + parent_id + ", category=" + category + "]";
	}
	
	
	
}
