package com.visa.prj.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderId;
	
	private double total;
	
	@Column(name="order_date")
	@Temporal(TemporalType.DATE)
	private Date orderDate = new Date();
	
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@ManyToOne
	@JoinColumn(name="restaurant_fk")
	private Restaurant restaurant;
	
	@ManyToOne
	@JoinColumn(name="user_fk")
	private User user;
	
	@OneToMany(cascade=CascadeType.ALL)	
	@JoinColumn(name="order_fk")	
	private List<LineItem> items = new ArrayList<>();

	public Order() {
		
	}
	
	

	public Order(int orderId, double total, Date orderDate, Restaurant restaurant, User user, List<LineItem> items) {
		super();
		this.orderId = orderId;
		this.total = total;
		this.orderDate = orderDate;
		this.restaurant = restaurant;
		this.user = user;
		this.items = items;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<LineItem> getItems() {
		return items;
	}

	public void setItems(List<LineItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", total=" + total + ", restaurant=" + restaurant + ", user=" + user
				+ ", items=" + items + "]";
	}
	
	
}
