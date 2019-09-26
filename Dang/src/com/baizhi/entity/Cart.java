package com.baizhi.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Cart implements Serializable {
	private Map<Integer,Item> addMap=new HashMap<Integer,Item>();
	private Map<Integer,Item> removeMap=new HashMap<Integer,Item>();
	private double totalPrice;//总金额
	private double savePrice;//节省金额
	public Map<Integer, Item> getAddMap() {
		return addMap;
	}
	public void setAddMap(Map<Integer, Item> addMap) {
		this.addMap = addMap;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double getSavePrice() {
		return savePrice;
	}
	public void setSavePrice(double savePrice) {
		this.savePrice = savePrice;
	}
	public Map<Integer, Item> getRemoveMap() {
		return removeMap;
	}
	public void setRemoveMap(Map<Integer, Item> removeMap) {
		this.removeMap = removeMap;
	}
	
}
