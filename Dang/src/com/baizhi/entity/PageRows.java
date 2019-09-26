package com.baizhi.entity;

public class PageRows {
	private int page;
	private int rows;
	public PageRows(int page, int rows) {
		super();
		this.page = page;
		this.rows = rows;
	}
	public PageRows() {
		super();
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "PageRows [page=" + page + ", rows=" + rows + "]";
	}
	
	
}
