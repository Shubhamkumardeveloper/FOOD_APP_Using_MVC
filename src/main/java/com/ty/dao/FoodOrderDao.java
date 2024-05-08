package com.ty.dao;

import java.util.List;

import com.ty.dto.FoodOrder;

public interface FoodOrderDao {
	public FoodOrder saveFoodOrder(FoodOrder foodOrder);
	public FoodOrder updateFoodOrder(FoodOrder foodOrder);
	public boolean deleteFoodOrder(FoodOrder foodOrder);
	public FoodOrder findFoodOrder(int id);
	public List<FoodOrder> findAllFoodOrder();

}
