package com.project.loginservice.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.loginservice.pojo.BuyerPojo;
import com.project.loginservice.service.BuyerService;

@CrossOrigin
@RestController
@RequestMapping("emart")
public class BuyerController {
	
	static Logger LOG = Logger.getLogger(BuyerController.class.getClass());
	
	@Autowired 
	BuyerService buyerService;
	
	@GetMapping("validate")
	BuyerPojo validateBuyer(@RequestHeader("Authorization") String uData) {
		LOG.info("Entered end point \'emart/validate \' ");
		
		String token[] = uData.split(":");
		BuyerPojo buyerPojo = new BuyerPojo();
		buyerPojo.setBuyerUsername(token[0]);
		buyerPojo.setBuyerPassword(token[1]);
		
		LOG.info("Exited end point \'emart/validate \' ");
		return buyerService.validateBuyer(buyerPojo);
	}
	
	@GetMapping("/buyer/{buyerId}")
	BuyerPojo getBuyer(@PathVariable("buyerId") Integer buyerId) {
		
		
		return buyerService.getBuyer(buyerId);
	}
	

}
