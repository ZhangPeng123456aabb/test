package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Address;

public interface AddressService {
	List<Address> showAllAddress(Integer UserId); 
	void insertAddress(Address add);
	
	void deleteAddress(Integer id);
	Address selectOneAddress(Integer id);
	void updatestatus(Address add);
}
