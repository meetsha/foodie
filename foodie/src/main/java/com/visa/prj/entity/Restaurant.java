package com.visa.prj.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="restaurants")
public class Restaurant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="r_id")
	private int restaurantId;
	
	@Column(name="r_name")
	private String restaurantName;
	
	private int rating;
	
	@Column(name="r_address")
	private String restaurantAddress;
	
	private String cuisine;
	
	private String description;
	
	private boolean pureveg;
	
	@OneToMany(cascade=CascadeType.ALL)	
	@JoinColumn(name="restaurant_fk")	
	private List<Menu> menu_items = new ArrayList<>();
	 
	public Restaurant() {
		super();
	}

	public Restaurant(int restaurantId, String restaurantName, int rating, String restaurantAddress, String cuisine,
			String description, boolean pureveg, List<Menu> menu_items) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.rating = rating;
		this.restaurantAddress = restaurantAddress;
		this.cuisine = cuisine;
		this.description = description;
		this.pureveg = pureveg;
		this.menu_items = menu_items;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getRestaurantAddress() {
		return restaurantAddress;
	}

	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPureveg() {
		return pureveg;
	}

	public void setPureveg(boolean pureveg) {
		this.pureveg = pureveg;
	}

	public List<Menu> getMenu_items() {
		return menu_items;
	}

	public void setMenu_items(List<Menu> menu_items) {
		this.menu_items = menu_items;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", rating=" + rating
				+ ", restaurantAddress=" + restaurantAddress + ", cuisine=" + cuisine + ", description=" + description
				+ ", pureveg=" + pureveg + ", menu_items=" + menu_items + "]";
	}
	
	
	
	
}
