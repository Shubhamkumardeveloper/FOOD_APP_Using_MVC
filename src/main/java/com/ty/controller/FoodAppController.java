package com.ty.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.com.ty.service.implementation.EncryptionUtil;
import com.ty.com.ty.service.implementation.FoodProductServiceImplementation;
import com.ty.com.ty.service.implementation.MenuServiceImplementation;
import com.ty.com.ty.service.implementation.UserServiceImplementation;
import com.ty.dao.ItemDao;
import com.ty.dao.implementation.FoodOrderAppDaoImplementation;
import com.ty.dao.implementation.FoodProductDaoImplementaion;
import com.ty.dao.implementation.ItemDaoImplementation;
import com.ty.dao.implementation.MenuDaoImplementation;
import com.ty.dao.implementation.UserDaoImplementation;
import com.ty.dto.FoodOrder;
import com.ty.dto.FoodProducts;
import com.ty.dto.Item;
import com.ty.dto.Menu;
import com.ty.dto.User;

import net.bytebuddy.matcher.ModifierMatcher.Mode;

@Controller
public class FoodAppController {
	
	@Autowired
	private ItemDao itemDao;

	@Autowired
	private MenuDaoImplementation menuDaoImplementation;

	@Autowired
	private UserDaoImplementation implementation;
	@Autowired
	private UserServiceImplementation service;

	@Autowired
	private FoodProductDaoImplementaion foodProductDaoImplementaion;
	@Autowired
	private FoodProductServiceImplementation fp;
	@Autowired
	private MenuServiceImplementation menuServiceImplementation;
	@Autowired
	private FoodOrderAppDaoImplementation foodOrderAppDaoImplementation;
	
	@Autowired
	private ItemDaoImplementation itemDaoImplementation;

	@RequestMapping("/signin")
	public ModelAndView signIn() {
		ModelAndView mv = new ModelAndView("SignIn.jsp");
		mv.addObject("user", new User());
		return mv;
	}

	@RequestMapping("/saveUser")
	public ModelAndView saveUser(@ModelAttribute User user) {
		try {
			user.setPassword(EncryptionUtil.encrypt(user.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (user.getRole().equalsIgnoreCase("BranchManager")) {
			Menu menu = new Menu();
			user.setMenu(menu);
		}
		User user2 = implementation.saveUser(user);
		ModelAndView mv = new ModelAndView("login.jsp");
		if (user2 != null)
			return mv;
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView logIn() {
		ModelAndView mv = new ModelAndView("login.jsp");
		mv.addObject("user", new User());
		return mv;
	}

	@RequestMapping("/createmenu")
	public ModelAndView createMenu(HttpServletRequest res) {
		String id = res.getParameter("id");
		Menu menu = menuDaoImplementation.findMenu(Integer.parseInt(id));
		System.out.println(menu.getId());
		ModelAndView mv = new ModelAndView("createMenu.jsp");
		mv.addObject("foodProduct", new FoodProducts());
		mv.addObject("menu", menu);
		return mv;
	}

	@RequestMapping("/saveFoodProduct")
	public ModelAndView saveFoodProduct(@ModelAttribute FoodProducts foodProducts, HttpServletRequest res) {
		String id = res.getParameter("id");
		Menu menu = menuDaoImplementation.findMenu(Integer.parseInt(id));
		List<FoodProducts> list = menu.getFoodProducts();
		list.add(foodProducts);
		foodProductDaoImplementaion.saveFoodProduct(foodProducts);
		menu.setFoodProducts(list);
		foodProducts.setMenu(menu);
		Menu menu2= menuDaoImplementation.updateMenu(menu);
		ModelAndView mv = new ModelAndView("dashboard.jsp");
		if(menu2!=null)
		{
			return findAllFoodProduct();
		}
		
		mv.addObject("msg", "product saved..");
		return mv;
	}

	@RequestMapping("/validate")
	public ModelAndView ValidateUser(@ModelAttribute User user) {
//		System.out.println(user.getEmail()+" "+user.getPassword());
		User user2 = service.verify(user.getEmail(), user.getPassword());
		ModelAndView mv = new ModelAndView("SignIn.jsp");
		System.out.println(user2.getRole());
		if (user2 != null) {
			if (user2.getRole().equalsIgnoreCase("BranchManager")) {
				ModelAndView mv1 = new ModelAndView("branchManager.jsp");
				mv1.addObject("branchManager", user2);
				return mv1;
			} else if (user2.getRole().equalsIgnoreCase("Staff")) {
				ModelAndView mv2 = new ModelAndView("staff.jsp");
				return mv2;
			} else if (user2.getRole().equalsIgnoreCase("customer")) {
				ModelAndView mv3 = new ModelAndView("customer.jsp");
				return mv3;
			}
		}
		
		return mv;
	}
	
	@RequestMapping("/veiwFoodOrder")
	public ModelAndView veiwFoodOrder()
	{
		return findAllFoodOrder();
	}
	
	@RequestMapping("/findall")
	public ModelAndView findAllFoodProduct() {
		List<FoodProducts> list = foodProductDaoImplementaion.findAllFoodProduct();
//		System.out.println(list.get(0));
		ModelAndView mv = new ModelAndView("displaymenu.jsp");
		mv.addObject("listofproduct", list);
		return mv;
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteFoodProduct(int id)
	{
		FoodProducts fp= foodProductDaoImplementaion.findFoodProduct(id);
		boolean b=  foodProductDaoImplementaion.deleteFoodProduct(fp);
		ModelAndView mv=new ModelAndView("dashboard.jsp");
		if(b)
			{
				return findAllFoodProduct();
			}
		mv.addObject("msg", "product saved..");
		return mv;
	}
	
	@RequestMapping("/edit")
	public ModelAndView editUser(int id)
	{
		FoodProducts foodProducts= foodProductDaoImplementaion.findFoodProduct(id);
		ModelAndView mv=new ModelAndView("editFoodProduct.jsp");
		mv.addObject("foodProducts", foodProducts);
		return mv;
	}
	
	@RequestMapping("/updateUser")
	public ModelAndView updateEmployee(@ModelAttribute FoodProducts foodProducts)
	{
		foodProductDaoImplementaion.updateFoodProduct(foodProducts);
		return findAllFoodProduct();
	}
	
	@RequestMapping("/createsaff")
	public ModelAndView createStaff()
	{
		ModelAndView mv=new ModelAndView("createStaff.jsp");
		mv.addObject("user", new User());
		return mv;
		
	}
	
//	@RequestMapping("/saveStaff")
//	public ModelAndView saveStaff(@ModelAttribute User user) {
//		User user2 = implementation.saveUser(user);
////		ModelAndView mv = new ModelAndView("displayStaff.jsp");
//		ModelAndView mv=new ModelAndView("dashboard.jsp");
//		mv.addObject("msg", "saved...");
//		return mv;
//	}
//	
	@RequestMapping("/displayAllSatff")
	public ModelAndView findAllStaff()
	{
		List<User> user= service.findStaff();
		ModelAndView mv=new ModelAndView("displayStaff.jsp");
		mv.addObject("staff",user);
		return mv;
	}
	
	@RequestMapping("/deleteStaff")
	public ModelAndView deleteStaff(int id)
	{
		User u=implementation.findUser(id);
		ModelAndView mv=new ModelAndView("dashboard.jsp");
		if(u!=null)
		{
			implementation.deleteUser(u);
			return findAllStaff();
		}
		mv.addObject("msg", "product saved..");
		return mv;
	}
	
	@RequestMapping("/editStaff")
	public ModelAndView editStaff(int id)
	{
//		FoodProducts foodProducts= foodProductDaoImplementaion.findFoodProduct(id);
		User user= implementation.findUser(id);
		ModelAndView mv=new ModelAndView("editStaff.jsp");
		mv.addObject("user", user);
		return mv;
	}
	
	@RequestMapping("/updateStaff")
	public ModelAndView updateEmployee(@ModelAttribute User user)
	{
//		foodProductDaoImplementaion.updateFoodProduct(foodProducts);
		implementation.updateUser(user);
		return findAllStaff();
	}
	
	@RequestMapping("/addItem")
	public ModelAndView addItem()
	{
		ModelAndView mv=new ModelAndView("createItem.jsp");
		Item item=new Item();
		mv.addObject("item",item );
		return mv;
	}
	
	@RequestMapping("/saveItem")
	public ModelAndView saveUser(@ModelAttribute Item item) {

		itemDao.saveItem(item);
		ModelAndView mv = new ModelAndView("displayItem.jsp");
		return findallItem();
	}
	
	
	@RequestMapping("/findAllItem")
	public ModelAndView findallItem() {
		List<Item> lItems=itemDaoImplementation.findAllItem();
		ModelAndView mv = new ModelAndView("displayItem.jsp");
		mv.addObject("listOfItem", lItems);
		return mv;
	}
	
	@RequestMapping("/editItem")
	public ModelAndView editItem(int id)
	{
//		 FoodOrder foodOrder= foodOrderAppDaoImplementation.findFoodOrder(id);
		Item item =itemDaoImplementation.findItem(id);
		ModelAndView mv=new ModelAndView("editItem.jsp");
		mv.addObject("item", item);
		return mv;
	}
	
	
	@RequestMapping("/updateItem")
	public ModelAndView updateItem(@ModelAttribute Item item)
	{
//		foodOrderAppDaoImplementation.updateFoodOrder(foodOrder);
//		itemDaoImplementation.deleteItem(item);
		itemDaoImplementation.updateItem(item);
		return findallItem();
	}
	
	@RequestMapping("/deleteItem")
	public ModelAndView deleteItem(int id)
	{
		Item item= itemDaoImplementation.findItem(id);
		itemDaoImplementation.deleteItem(item);
		return findallItem();
	}
	
	@RequestMapping("/createFoodOrder")
	public ModelAndView createFoodOrder()
	{
		ModelAndView mv=new ModelAndView("createFoodOrder.jsp");
		mv.addObject("foodorder", new FoodOrder());
		return mv;
	}
	
	@RequestMapping("/saveFoodOrder")
	public ModelAndView saveFoodOrder(@ModelAttribute FoodOrder foodOrder) {
		FoodOrder fo= foodOrderAppDaoImplementation.saveFoodOrder(foodOrder);
		ModelAndView mv=new ModelAndView("dashboard.jsp");
		if(fo!=null)
		{
			return findAllFoodOrder();
		}
		mv.addObject("msg","foodorder saved...");
		return mv;
	}
	
	@RequestMapping("/findallFoodOrder")
	public ModelAndView findAllFoodOrder() {
		List<FoodOrder> list= foodOrderAppDaoImplementation.findAllFoodOrder();
		ModelAndView mv = new ModelAndView("displayFoodOrder.jsp");
		mv.addObject("listofFoodOrder", list);
		return mv;
	}
	
	@RequestMapping("/editFoodOrder")
	public ModelAndView editFoodOrder(int id)
	{
//		FoodProducts foodProducts= foodProductDaoImplementaion.findFoodProduct(id);
		 FoodOrder foodOrder= foodOrderAppDaoImplementation.findFoodOrder(id);
		ModelAndView mv=new ModelAndView("editFoodOrder.jsp");
		mv.addObject("foodOrder", foodOrder);
		return mv;
	}
	
	
	@RequestMapping("/updateFoodOrder")
	public ModelAndView updateEmployee(@ModelAttribute FoodOrder foodOrder)
	{
		foodOrderAppDaoImplementation.updateFoodOrder(foodOrder);
		return findAllFoodOrder();
	}
	
	@RequestMapping("/deleteFoodOrder")
	public ModelAndView deleteFoodOrder(int id)
	{
		FoodOrder foodOrder= foodOrderAppDaoImplementation.findFoodOrder(id);
		if(foodOrder!=null)
		{
			foodOrderAppDaoImplementation.deleteFoodOrder(foodOrder);
			return findAllFoodOrder();
		}
		ModelAndView mv=new ModelAndView("dashboard.jsp");
		mv.addObject("msg", "product not deleted..");
		return mv;
	}
	
	@RequestMapping("/viewItem")
	public ModelAndView viewItem()
	{
		List<Item> lItems=itemDaoImplementation.findAllItem();
		ModelAndView mv=new ModelAndView("viewItem.jsp");
		mv.addObject("item",lItems);
		return mv;
	}
	
	@RequestMapping("/adddItemByCustomer")
	public ModelAndView adddItemByCustomer(@RequestParam List<String> selectedItems )
	{
		List<Item> items=new ArrayList<>();
		for(String id:selectedItems)
		{
			Item item =itemDaoImplementation.findItem(Integer.parseInt(id));
			items.add(item);
		}
		
		FoodOrder foodOrder=new FoodOrder();
//		System.out.println(items);
		foodOrder.setItems(items);
		foodOrderAppDaoImplementation.updateFoodOrder(foodOrder);
//		System.out.println("saved");
//		return veiwFoodOrder();
		ModelAndView mv=new ModelAndView("dashboard.jsp");
		mv.addObject("msg","succesfull");
		return mv;
	}
	
	@RequestMapping("/createCustomer")
	public ModelAndView createCustomer()
	{
		ModelAndView mv=new ModelAndView("createCustomerByStaff.jsp");
		mv.addObject("customer", new User());
		return mv;
	}
	
	@RequestMapping("/savecustomer")
	public ModelAndView saveCustomer(@ModelAttribute User user)
	{
		implementation.saveUser(user);
//		ModelAndView mv=new ModelAndView("dashboard.jsp");
//		mv.addObject("msg","saved");
		return findAllCustomer();
	}
	
	@RequestMapping("/findAllCustomer")
	public ModelAndView findAllCustomer()
	{
		List<User> customer= service.findCustomer();
		ModelAndView mv=new ModelAndView("displayCustomer.jsp");
		mv.addObject("customer",customer);
		return mv;
	}
	
	@RequestMapping("/deleteCustomer")
	public ModelAndView deleteCustomer(int id)
	{
		User u=implementation.findUser(id);
		ModelAndView mv=new ModelAndView("dashboard.jsp");
		if(u!=null)
		{
			implementation.deleteUser(u);
			return findAllCustomer();
		}
		mv.addObject("msg", "product saved..");
		return mv;
	}
	
	@RequestMapping("/editCustomer")
	public ModelAndView editCustomer(int id)
	{
		User customer= implementation.findUser(id);
		ModelAndView mv=new ModelAndView("editCustomer.jsp");
		mv.addObject("customer", customer);
		return mv;
	}
	
	@RequestMapping("/updateCustomer")
	public ModelAndView updateCustomer(@ModelAttribute User user)
	{
		implementation.updateUser(user);
		return findAllCustomer();
	}
	
	

}
