package com.visa.prj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	public Restaurant() {
		super();
	}
	public Restaurant(int restaurantId, String restaurantName, int rating, String restaurantAddress, String cuisine,
			String description, boolean pureveg) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.rating = rating;
		this.restaurantAddress = restaurantAddress;
		this.cuisine = cuisine;
		this.description = description;
		this.pureveg = pureveg;
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
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", rating=" + rating
				+ ", restaurantAddress=" + restaurantAddress + ", cuisine=" + cuisine + ", desc=" + description + ", pureveg="
				+ pureveg + "]";
	}
	
	
	
}
