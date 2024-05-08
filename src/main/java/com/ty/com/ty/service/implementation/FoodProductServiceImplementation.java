package com.ty.com.ty.service.implementation;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.com.ty.service.FoodProduct;
import com.ty.dao.FoodProductDao;

@Component
public class FoodProductServiceImplementation implements FoodProduct{
	
	@Autowired
	private EntityManager manager;
	
	@Autowired
	private FoodProductDao dao;

	@Override
	public boolean deleteFoodProductById(int id) {
		FoodProduct fp=(FoodProduct) dao.findFoodProduct(id);
		if(fp!=null)
		{
			manager.remove(fp);
			return true;
		}
		return false;
	}

}
