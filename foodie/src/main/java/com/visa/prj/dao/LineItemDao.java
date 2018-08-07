package com.visa.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visa.prj.entity.LineItem;

public interface LineItemDao extends JpaRepository<LineItem, Integer> {

}
