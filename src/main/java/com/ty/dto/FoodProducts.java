package com.ty.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Entity
@Scope(value = "prototype")
public class FoodProducts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int foodProductId;
	private String name;
	private String type;
	private String about;
	private String availability;
	private double price;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE })
	@JoinColumn
	private Menu menu;

	
	public int getFoodProductId() {
		return foodProductId;
	}

	public void setFoodProductId(int foodProductId) {
		this.foodProductId = foodProductId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
