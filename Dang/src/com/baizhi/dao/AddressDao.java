package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Address;

public interface AddressDao {
	List<Address> showAllAddress(Integer UserId); 
	void insertAddress(Address add);
	
	void updatestatus(Integer id);
	void updateDefault(Integer UserId);
	
	void deleteAddress(Integer id);
	Address selectOneAddress(Integer id);
}
