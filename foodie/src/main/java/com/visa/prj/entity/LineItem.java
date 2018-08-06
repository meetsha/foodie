package com.visa.prj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="lineitems")
public class LineItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="item_id")
	private int itemId;
	
	private int quantity;
	
	private double price;
	
	@ManyToOne
	@JoinColumn(name="menu_item")
	private Menu menuItem;

	public LineItem() {
		
	}
	
	public LineItem(int itemId, int quantity, double price, Menu menuItem) {
		super();
		this.itemId = itemId;
		this.quantity = quantity;
		this.price = price;
		this.menuItem = menuItem;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Menu getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(Menu menuItem) {
		this.menuItem = menuItem;
	}

	@Override
	public String toString() {
		return "LineItem [itemId=" + itemId + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
}
