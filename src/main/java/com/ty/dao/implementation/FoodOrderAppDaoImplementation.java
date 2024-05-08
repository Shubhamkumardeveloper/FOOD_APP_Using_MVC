package com.ty.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dao.FoodOrderDao;
import com.ty.dto.FoodOrder;

@Component
public class FoodOrderAppDaoImplementation implements FoodOrderDao{
	
	@Autowired
	private EntityManager manager;

	@Override
	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(foodOrder);
		transaction.commit();
		
		return foodOrder;
	}

	@Override
	public FoodOrder updateFoodOrder(FoodOrder foodOrder) {
		// TODO Auto-generated method stub
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.merge(foodOrder);
		transaction.commit();
		return foodOrder;
	}

	@Override
	public boolean deleteFoodOrder(FoodOrder foodOrder) {
		// TODO Auto-generated method stub
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.remove(foodOrder);
		transaction.commit();
		return true;
	}

	@Override
	public FoodOrder findFoodOrder(int id) {
		// TODO Auto-generated method stub
		return manager.find(FoodOrder.class, id);
	}

	@Override
	public List<FoodOrder> findAllFoodOrder() {
		// TODO Auto-generated method stub
		Query query=manager.createQuery("select b from FoodOrder b");
		return query.getResultList();
	}
}
