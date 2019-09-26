package com.baizhi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Address;
import com.baizhi.entity.User;
import com.baizhi.service.AddressService;
import com.baizhi.service.impl.AddressServiceImpl;

public class AddressAction {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		AddressService Adds = new AddressServiceImpl();
		private List<Address> add;
		private Address ddr;
		public Address getDdr() {
			return ddr;
		}
		public void setDdr(Address ddr) {
			this.ddr = ddr;
		}
		private Integer id;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public List<Address> getAdd() {
			return add;
		}
		public void setAdd(List<Address> add) {
			this.add = add;
		}
		public String showAllAddress(){
			User user = (User)session.getAttribute("user");
			System.out.println(user);
			add = Adds.showAllAddress(user.getId());
			if(user==null){
				return "showFail";
			}else{
				return "showSuccess";
			}
		}
		public String selectAllAddress(){
			User user = (User)session.getAttribute("user");
			add = Adds.showAllAddress(user.getId());
			return "selectSuccess";
		}
		public String deleteAddress(){
			System.out.println(id);
			Adds.deleteAddress(id);
			return "deleteSuccess";
		}
		public String insertAddress(){
			User user = (User)session.getAttribute("user");
			System.out.println(user);
			ddr.setUserId(user.getId());
			System.out.println(ddr);
			Adds.insertAddress(ddr);
			return "insertSuccess";
		}
		public String updateAddress(){
			ddr.setId(id);
			Adds.updatestatus(ddr);
			return "updateSuccess";
		}
		public String selectAllAddress1(){
			User user = (User)session.getAttribute("user");
			add = Adds.showAllAddress(user.getId());
			return "selectSuccess1";
		}
		
}
