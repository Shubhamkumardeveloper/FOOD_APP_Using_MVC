package com.ty.dao;

import java.util.List;

import com.ty.dto.Item;

public interface ItemDao {
	public Item saveItem(Item item);
	public Item updateItem(Item item);
	public Item findItem(int id);
	public boolean deleteItem(Item item);
	public List<Item> findAllItem();
}
