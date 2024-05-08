package com.ty.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dao.implementation.UserDaoImplementation;
import com.ty.dto.User;

public class Test {
	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		User user=new User();
		user.setName("shubham");
		user.setEmail("shubham@gmail.com");
		user.setPassword("1234");
		user.setRole("BranchManager");
		
		UserDaoImplementation implementation=new UserDaoImplementation();
		transaction.begin();
		manager.persist(user);
		transaction.commit();
	}

}
