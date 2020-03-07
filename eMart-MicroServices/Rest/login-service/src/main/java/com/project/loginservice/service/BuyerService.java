package com.project.loginservice.service;

import com.project.loginservice.pojo.BuyerPojo;


public interface BuyerService {
	
	BuyerPojo validateBuyer(BuyerPojo buyerPojo);
	
	BuyerPojo getBuyer(int buyerId);
}
