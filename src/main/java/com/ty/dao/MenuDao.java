package com.ty.dao;

import java.util.List;

import com.ty.dto.Menu;

public interface MenuDao {
	
	public Menu saveMenu(Menu menu);
	public Menu updateMenu(Menu menu);
	public boolean deleteMenu(Menu menu);
	public Menu findMenu(int id);
	public List<Menu> findAllMenu();
	

}
