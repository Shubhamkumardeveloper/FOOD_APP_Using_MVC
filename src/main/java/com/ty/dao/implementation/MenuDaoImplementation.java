package com.ty.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dao.MenuDao;
import com.ty.dto.Menu;

@Component
public class MenuDaoImplementation implements MenuDao{
	
	@Autowired
	private EntityManager manager;

	@Override
	public Menu saveMenu(Menu menu) {
		// TODO Auto-generated method stub
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(menu);
		transaction.commit();
		return menu;
	}

	@Override
	public Menu updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.merge(menu);
		transaction.commit();
		return menu;
	}

	@Override
	public boolean deleteMenu(Menu menu) {
		// TODO Auto-generated method stub
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.remove(menu);
		transaction.commit();
		return true;
	}

	@Override
	public Menu findMenu(int id) {
		// TODO Auto-generated method stub
		return manager.find(Menu.class, id);
	}

	@Override
	public List<Menu> findAllMenu() {
		// TODO Auto-generated method stub
		Query query=manager.createQuery("select f from FoodProducts f");
		return query.getResultList();
	}

}
