package com.visa.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.visa.prj.entity.Restaurant;

public interface RestaurantDao extends JpaRepository<Restaurant, Integer> {
	@Query("from Restaurant r where r.pureveg = 1")
	List<Restaurant> getVegRestaurants();
	

	@Query("from Restaurant r where r.cuisine = :cuisine")
	List<Restaurant> getResByCuisine(@Param ("cuisine")String cuisine);
}
