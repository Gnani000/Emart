package com.project.buyeritemservice.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.buyeritemservice.pojo.ItemPojo;
import com.project.buyeritemservice.service.ItemService;


@CrossOrigin
@RestController
@RequestMapping("emart")
public class ItemController {
	
	static Logger LOG = Logger.getLogger(ItemController.class.getClass());
	
	@Autowired
	ItemService itemService;
	
	@GetMapping("/item/{itemId}")
	ItemPojo getItem(@PathVariable("itemId") int itemId) {
		LOG.info("Entered end point \'emart/item/{itemId}\' ");
		
		LOG.info("Exited end point \'emart/item/{itemId}\' ");
		return itemService.getItem(itemId);
	}
	
	@GetMapping("/item/all")
	List<ItemPojo> getAllItems() {
		LOG.info("Entered end point \'emart/item/all \' ");
		
		LOG.info("Exited end point \'emart/item/all \' ");
		return itemService.getAllItems();
	}
	

}

