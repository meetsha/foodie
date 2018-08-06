package com.visa.prj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class Menu {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="menu_id")
	private int menuId;
	
	@Column(name="item_name")
	private String itemName;
	
	private String type;
	
	
	private boolean veg;
	
	private double price;

	public Menu() {
		super();
	}

	public Menu(int menuId, String itemName, String type, boolean veg, double price) {
		super();
		this.menuId = menuId;
		this.itemName = itemName;
		this.type = type;
		this.veg = veg;
		this.price = price;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
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

	public boolean getVeg() {
		return veg;
	}

	public void setVeg(boolean veg) {
		this.veg = veg;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "menu [menuId=" + menuId + ", itemName=" + itemName + ", type=" + type + ", veg="
				+ veg + ", price=" + price + "]";
	}

	
	
	
	
	
	

}
