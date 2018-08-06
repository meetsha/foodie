package com.visa.prj.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class Menu {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="menu_id")
	private int menuId;
	
	@ManyToOne
	@JoinColumn(name="restaurant_fk")
	private Restaurant rId;
	
	@Column(name="item_name")
	private String itemName;
	
	private String type;
	
	@Column(name="veg_nonveg")
	private String vegNonVeg;
	
	private double price;

	public Menu() {
		super();
	}

	public Menu(int menuId, Restaurant rId, String itemName, String type, String vegNonVeg, double price) {
		super();
		this.menuId = menuId;
		this.rId = rId;
		this.itemName = itemName;
		this.type = type;
		this.vegNonVeg = vegNonVeg;
		this.price = price;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public Restaurant getrId() {
		return rId;
	}

	public void setrId(Restaurant rId) {
		this.rId = rId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVegNonVeg() {
		return vegNonVeg;
	}

	public void setVegNonVeg(String vegNonVeg) {
		this.vegNonVeg = vegNonVeg;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "menu [menuId=" + menuId + ", rId=" + rId + ", itemName=" + itemName + ", type=" + type + ", vegNonVeg="
				+ vegNonVeg + ", price=" + price + "]";
	}

	
	
	
	
	
	

}
