package com.visa.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.visa.prj.entity.Menu;

public interface MenuDao extends JpaRepository<Menu, Integer> {
	
	
	
	@Query("from Menu m where m.veg = :veg")
	List<Menu> getAvailableVegItems(@Param("veg") boolean veg);
	
	
	
//	@Query("select * from menu")
	//List<Menu> getAvailableMenuItems();
	
	
	
	
	
	
	
	

}
