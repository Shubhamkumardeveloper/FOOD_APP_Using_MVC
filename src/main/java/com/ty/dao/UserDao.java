package com.ty.dao;

import java.util.List;

import com.ty.dto.User;

public interface UserDao {
	
	public User saveUser(User user);
	public User updateUser(User user);
	public boolean deleteUser(User user);
	public User findUser(int id);
	public List<User> findAllUser();

}
