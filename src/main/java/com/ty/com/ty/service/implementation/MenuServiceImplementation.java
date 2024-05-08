package com.ty.com.ty.service.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.com.ty.service.FoodProduct;
import com.ty.com.ty.service.Menu;

@Component
public class MenuServiceImplementation  implements Menu{
	
	@Autowired
	private EntityManager manager;

	public List<Menu> listOfMenu() {
		Query query=manager.createQuery("select m from Menu m");
		return query.getResultList();
	}

	public Menu findMenuById(int id) {
		// TODO Auto-generated method stub
		return manager.find(Menu.class, id);
	}

}
