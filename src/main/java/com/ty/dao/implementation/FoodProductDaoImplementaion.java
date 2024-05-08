package com.ty.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.ty.dao.FoodProductDao;
import com.ty.dto.FoodProducts;

@Component
public class FoodProductDaoImplementaion implements FoodProductDao {
	
	@Autowired
	private EntityManager manager;

	@Override
	public FoodProducts saveFoodProduct(FoodProducts foodProducts) {
		// TODO Auto-generated method stub
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(foodProducts);
		transaction.commit();
		return foodProducts;
	}

	@Override
	public FoodProducts updateFoodProduct(FoodProducts foodProducts) {
		// TODO Auto-generated method stub
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.merge(foodProducts);
		transaction.commit();
		return foodProducts;
	}

	@Override
	public boolean deleteFoodProduct(FoodProducts foodProducts) {
		// TODO Auto-generated method stub
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.remove(foodProducts);
		transaction.commit();
		return true;
	}

	@Override
	public FoodProducts findFoodProduct(int id) {
		// TODO Auto-generated method stub
		return manager.find(FoodProducts.class,id);
	}

	@Override
	public List<FoodProducts> findAllFoodProduct() {
		// TODO Auto-generated method stub
		Query query=manager.createQuery("select f from FoodProducts f");
		return query.getResultList();
	}
	
	

}
