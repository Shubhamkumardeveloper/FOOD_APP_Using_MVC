package com.ty.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dao.ItemDao;
import com.ty.dto.Item;

@Component
public class ItemDaoImplementation implements ItemDao{
	
	@Autowired
	private EntityManager manager;

	@Override
	public Item saveItem(Item item) {
		// TODO Auto-generated method stub
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(item);
		transaction.commit();
		return item;
	}

	@Override
	public Item updateItem(Item item) {
		// TODO Auto-generated method stub
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.merge(item);
		transaction.commit();
		return item;
	}

	@Override
	public Item findItem(int id) {
		// TODO Auto-generated method stub
		return manager.find(Item.class,id);
	}

	@Override
	public boolean deleteItem(Item item) {
		// TODO Auto-generated method stub
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.remove(item);
		transaction.commit();
		return true;
	}

	@Override
	public List<Item> findAllItem() {
		// TODO Auto-generated method stub
		Query query=manager.createQuery("select i from Item i");
		return query.getResultList();
	}
	

}
