package com.project.buyeritemservice.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.buyeritemservice.pojo.BillPojo;
import com.project.buyeritemservice.service.BillService;



@CrossOrigin
@RestController
@RequestMapping("emart")
public class BillController {
	 
	static Logger LOG = Logger.getLogger(BillController.class.getClass());
	
	@Autowired
	BillService billService;
	
	@PostMapping("addBill")
	BillPojo addBill(@RequestBody BillPojo billPojo) {
		LOG.info("Entered end point \'emart/addBill \\' ");
		
		LOG.info("Exited end point \'emart/addBill \' ");
		return billService.addBill(billPojo);
	}
}