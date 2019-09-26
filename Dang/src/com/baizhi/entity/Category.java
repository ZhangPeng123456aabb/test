package com.baizhi.entity;

import java.util.List;

public class Category {
	private Integer category_id;
	private Integer parent_id;
	private String category_name;
	private Integer count;
	private List<Category> category;
	private List<Book> booklist;
	public Category(Integer category_id, Integer parent_id,
			String category_name, Integer count, List<Category> category,
			List<Book> booklist) {
		super();
		this.category_id = category_id;
		this.parent_id = parent_id;
		this.category_name = category_name;
		this.count = count;
		this.category = category;
		this.booklist = booklist;
	}
	public Category() {
		super();
	}
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
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<Category> getCategory() {
		return category;
	}
	public void setCategory(List<Category> category) {
		this.category = category;
	}
	public List<Book> getBooklist() {
		return booklist;
	}
	public void setBooklist(List<Book> booklist) {
		this.booklist = booklist;
	}
	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", parent_id="
				+ parent_id + ", category_name=" + category_name + ", count="
				+ count + ", category=" + category + ", booklist=" + booklist
				+ "]";
	}
}
