package com.baizhi.entity;

public class BeginEnd {
	private int begin;
	private int end;
	public BeginEnd(int begin, int end) {
		super();
		this.begin = begin;
		this.end = end;
	}
	public BeginEnd() {
		super();
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return "BeginEnd [begin=" + begin + ", end=" + end + "]";
	}
	
	
}
