package com.ty.com.ty.service;

import java.util.List;

import com.ty.dto.User;

public interface UserService {
	
	public User verify(String email,String password);
	public User fetchBranchManager();
	public List<User> findStaff();
	public List<User> findCustomer();

}
