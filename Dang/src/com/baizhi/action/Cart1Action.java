package com.baizhi.action;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import redis.clients.jedis.Jedis;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Book;
import com.baizhi.entity.Cart;
import com.baizhi.entity.Item;
import com.baizhi.entity.User;
import com.baizhi.service.BookService;
import com.baizhi.service.impl.BookServiceImpl;
import com.opensymphony.xwork2.ActionContext;

public class Cart1Action {
	BookService bs = new BookServiceImpl();
	private int bookId;
	private int buyCount;
	private Double totalPricing;
	private Double savePrice;
	private Double totalPrice;
	private int number;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	Map<String,Object>session = ActionContext.getContext().getSession();
	Cart cart =(Cart)session.get("cart");
	
	public Double getSavePrice() {
		return savePrice;
	}
	public void setSavePrice(Double savePrice) {
		this.savePrice = savePrice;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Double getTotalPricing() {
		return totalPricing;
	}
	public void setTotalPricing(Double totalPricing) {
		this.totalPricing = totalPricing;
	}
	public int getBuyCount() {
		return buyCount;
	}
	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	} 
	public void addCart(){
		/*System.out.println("添加成功");*/
		Map<String,Object> session = ActionContext.getContext().getSession();
		Cart cart=(Cart) session.get("cart");
		if(cart==null){
		cart= new Cart();
		}
		Map<Integer, Item> addMap = cart.getAddMap();
		
		if(addMap.containsKey(bookId)){
			Item item = addMap.get(bookId);
			int m=item.getBuyCount();
			m++;
			item.setBuyCount(m);
			addMap.put(bookId,item);
			cart.setAddMap(addMap);
		}else{
			Book book = bs.SelectOneBook(bookId);
			Item item = new Item();
			item.setBook(book);
			item.setBuyCount(1);
			addMap.put(bookId, item);
			cart.setAddMap(addMap);
		}
		//遍历出addMap集合，计算总价
		 Set<Entry<Integer, Item>> set = addMap.entrySet();
		 Double totalPrice=0.0;
		 Double totalPricing=0.0;
		  for(Map.Entry<Integer, Item> entry:set){
			 Item i=entry.getValue();
			 totalPricing+=i.getBook().getBookPrice()*i.getBuyCount();
			 totalPrice+=i.getBook().getDangPrice()*i.getBuyCount();
		  }
		  double savePrice = totalPricing - totalPrice;
		  cart.setSavePrice(savePrice);
		  cart.setTotalPrice(totalPrice);
		  //cart.setAddMap(addMap);
		//将购物车对象存储在session中
		  session.put("cart", cart);
		  
	}
}
