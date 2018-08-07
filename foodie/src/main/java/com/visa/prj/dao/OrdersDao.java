package com.visa.prj.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.visa.prj.entity.Order;

public interface OrdersDao extends JpaRepository<Order, Integer> {
	
	@Query("from Order o where o.orderDate = :date")
	List<Order> getOrdersByDate(@Param("date") Date date);
	
	@Query("from Order o where o.orderDate BETWEEN :date1 AND :date2")
	List<Order> getOrdersByRange(@Param("date1") Date date1, @Param("date2") Date date2);
}