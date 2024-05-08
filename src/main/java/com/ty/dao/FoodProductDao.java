package com.ty.dao;

import java.util.List;

import com.ty.dto.FoodProducts;

public interface FoodProductDao {
	
	public FoodProducts saveFoodProduct(FoodProducts foodProducts);
	public FoodProducts updateFoodProduct(FoodProducts foodProducts);
	public boolean deleteFoodProduct(FoodProducts foodProducts);
	public FoodProducts findFoodProduct(int id);
	public List<FoodProducts> findAllFoodProduct();

}
