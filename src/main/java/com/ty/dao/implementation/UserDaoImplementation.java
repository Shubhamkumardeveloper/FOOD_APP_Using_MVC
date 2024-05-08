package com.ty.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dao.UserDao;
import com.ty.dto.User;

@Component
public class UserDaoImplementation implements UserDao{
	
	@Autowired
	private EntityManager manager;

	@Override
	public User saveUser(User user) {
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(user);
		transaction.commit();
		return user;
	}

	@Override
	public User updateUser(User user) {
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.merge(user);
		transaction.commit();
		return user;
	}

	@Override
	public boolean deleteUser(User user) {
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.remove(user);
		transaction.commit();
		return true;
	}

	@Override
	public User findUser(int id) {
		// TODO Auto-generated method stub
		return manager.find(User.class, id);
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		Query query=manager.createQuery("select u from User u");
		return query.getResultList();
	}

}
