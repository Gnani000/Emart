package com.project.loginservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.loginservice.entity.BuyerEntity;

@Repository
public interface BuyerDao extends JpaRepository<BuyerEntity, Integer> {
	
	BuyerEntity findByBuyerUsernameAndBuyerPassword(String username, String password);
	
}
