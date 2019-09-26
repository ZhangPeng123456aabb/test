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
public class CartAction {
	BookService bs = new BookServiceImpl();
	private int bookId;
	private int buyCount;
	private Double totalPricing;
	private Double savePrice;
	private Double totalPrice;
	private int number;
	private Cart cart;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
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
		System.out.println("hello");
		Jedis jedis = new Jedis();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		String jsonCart = jedis.get(String.valueOf(u.getId()));
	    cart = JSONObject.parseObject(jsonCart,Cart.class);
	    System.out.println("hello1"+cart);
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
			 System.out.println(i.getBook());
		  }
		  double savePrice = totalPricing - totalPrice;
		  cart.setSavePrice(savePrice);
		  cart.setTotalPrice(totalPrice);
		  //cart.setAddMap(addMap);
		//将购物车对象存储在session中
		  session.setAttribute("cart",cart);
		  jedis.set(String.valueOf(u.getId()),JSONObject.toJSONString(cart));
		  jedis.close();
		  
	}
	//更新购物车
	public String updateCart(){
		Jedis jedis = new Jedis();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		String jsonCart = jedis.get(String.valueOf(u.getId()));
		cart = JSONObject.parseObject(jsonCart,Cart.class);
		Map<Integer, Item> addMap = cart.getAddMap();
			System.out.println(bookId);
			Item item = addMap.get(bookId);
			item.setBuyCount(buyCount);
			addMap.put(bookId, item);
		//遍历出addMap集合，计算总价
		 Set<Entry<Integer, Item>> set = addMap.entrySet();
		 Double totalPrice=0.0;
		 Double totalPricing=0.0;
		  for(Map.Entry<Integer, Item> entry:set){
			 Item i=entry.getValue();
			 totalPricing+=i.getBook().getBookPrice()*i.getBuyCount();
			 totalPrice+=i.getBook().getDangPrice()*i.getBuyCount();
		  }
		  savePrice=totalPricing-totalPrice;
		  cart.setSavePrice(savePrice);
		  cart.setTotalPrice(totalPrice);
		  cart.setAddMap(addMap);
		  System.out.println(savePrice);
		  System.out.println(totalPricing);
		  System.out.println(totalPrice);
		  session.setAttribute("cart",cart);
		  jedis.set(String.valueOf(u.getId()),JSONObject.toJSONString(cart));
		  jedis.close();
		  return "success";
	}
	//删除购物车
		public String deleteCart(){
			Jedis jedis = new Jedis();
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			User u = (User)session.getAttribute("user");
			String jsonCart = jedis.get(String.valueOf(u.getId()));
			cart = JSONObject.parseObject(jsonCart,Cart.class);
			Map<Integer,Item> addMap = cart.getAddMap();
			Item item = addMap.get(bookId);
			Map<Integer,Item> removeMap = cart.getRemoveMap();
			removeMap.put(bookId, item);
			addMap.remove(bookId);
			//遍历addMap集合，计算总价
					Double totalPrice =0.0;
					Double savePrice =0.0;
					Double totalPricing=0.0;
					Set<Map.Entry<Integer,Item>>set=addMap.entrySet();
					for(Map.Entry<Integer, Item> addmap:set){
						totalPricing += addmap.getValue().getBook().getBookPrice()*addmap.getValue().getBuyCount();
						totalPrice += addmap.getValue().getBook().getDangPrice()*addmap.getValue().getBuyCount();
					}
					savePrice = totalPricing-totalPrice;
					cart.setSavePrice(savePrice);
					cart.setTotalPrice(totalPrice);
					session.setAttribute("cart",cart);
					jedis.set(String.valueOf(u.getId()),JSONObject.toJSONString(cart));
					jedis.close();
			        return "DeleteSuccess";
		}
		
		//恢复购物车
		public String recoverCart(){
			Jedis jedis = new Jedis();
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			User u = (User)session.getAttribute("user");
			String jsonCart = jedis.get(String.valueOf(u.getId()));
			cart = JSONObject.parseObject(jsonCart,Cart.class);
			Map<Integer,Item> removeMap = cart.getRemoveMap();
			Map<Integer,Item> addMap = cart.getAddMap();
			Item item = removeMap.get(bookId);
			System.out.println(bookId);
			//先判断addMap集合中是否包含此对象，如果包含在原先对象的数量上加上此对象的数量
			if(addMap.containsKey(bookId)){
				Item item2 = addMap.get(bookId);
				Integer bookCount = item2.getBuyCount()+item.getBuyCount();
				item2.setBuyCount(bookCount);
				addMap.put(bookId, item2);
			}else{
				Item ite = new Item();
				BookService bs = new BookServiceImpl();
				Book book = bs.SelectOneBook(bookId);
				ite.setBook(book);
				ite.setBuyCount(item.getBuyCount());
				addMap.put(bookId, ite);
			}
			removeMap.remove(bookId);
			//遍历addMap集合，计算总价
					Double totalPrice =0.0;
					Double savePrice =0.0;
					Double totalPricing=0.0;
					Set<Map.Entry<Integer,Item>>set=addMap.entrySet();
					for(Map.Entry<Integer, Item> addmap:set){
						totalPricing += addmap.getValue().getBook().getBookPrice()*addmap.getValue().getBuyCount();
						totalPrice += addmap.getValue().getBook().getDangPrice()*addmap.getValue().getBuyCount();
					}
					savePrice = totalPricing-totalPrice;
					cart.setSavePrice(savePrice);
					cart.setTotalPrice(totalPrice);
					session.setAttribute("cart",cart);
					jedis.set(String.valueOf(u.getId()),JSONObject.toJSONString(cart));
					jedis.close();
			        return"RecoverSuccess";
		}
}
