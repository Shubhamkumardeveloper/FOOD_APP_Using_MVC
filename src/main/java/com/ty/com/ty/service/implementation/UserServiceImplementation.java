package com.ty.com.ty.service.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.com.ty.service.UserService;
import com.ty.dto.User;

@Component
public class UserServiceImplementation implements UserService{
	
	@Autowired
	private EntityManager manager;

	public User verify(String email,String password) {
//		Query query= manager.createQuery("select u from User u where u.email=?1 and password=?2");
		Query query= manager.createQuery("select u from User u where u.email=?1");
		query.setParameter(1, email);
		User u=(User)query.getSingleResult();
		String pass=EncryptionUtil.decrypt(u.getPassword());
		if(password.equalsIgnoreCase(pass))                                       
		{
			return(User)query.getSingleResult();
		}
		else
			return null;
//		query.setParameter(2, password);
	}

	@Override
	public User fetchBranchManager() {
		Query query=manager.createQuery("select u from User u where u.role='BranchManager'");
		return (User)query.getSingleResult();
	}

	@Override
	public List<User> findStaff() {
		Query query=manager.createQuery("select s from User s where s.role='Staff'");
		return query.getResultList();
	}

	@Override
	public List<User> findCustomer() {
		Query query=manager.createQuery("select s from User s where s.role='Customer'");
		return query.getResultList();
	}
}
