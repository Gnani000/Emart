package com.project.buyeritemservice.service;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.buyeritemservice.dao.BillDao;
import com.project.buyeritemservice.dao.BillDetailsDao;
import com.project.buyeritemservice.entity.BillDetailsEntity;
import com.project.buyeritemservice.entity.BillEntity;
import com.project.buyeritemservice.entity.BuyerEntity;
import com.project.buyeritemservice.entity.CategoryEntity;
import com.project.buyeritemservice.entity.ItemEntity;
import com.project.buyeritemservice.entity.SellerEntity;
import com.project.buyeritemservice.entity.SubCategoryEntity;
import com.project.buyeritemservice.pojo.BillDetailsPojo;
import com.project.buyeritemservice.pojo.BillPojo;
import com.project.buyeritemservice.pojo.BuyerPojo;
import com.project.buyeritemservice.pojo.CategoryPojo;
import com.project.buyeritemservice.pojo.ItemPojo;
import com.project.buyeritemservice.pojo.SellerPojo;
import com.project.buyeritemservice.pojo.SubCategoryPojo;


@Service
public class BillServiceImpl implements BillService{
	
	static Logger LOG = Logger.getLogger(BillServiceImpl.class.getClass());
	
	@Autowired
	BillDao billDao;
	
	@Autowired
	BillDetailsDao billDetailsDao;

	@Override
	@Transactional
	public BillPojo addBill(BillPojo billPojo) {
		
		BasicConfigurator.configure();
		LOG.info("Entered addBill()");
		
		
		 BuyerPojo buyerPojo = billPojo.getBuyer();
		 BuyerEntity buyerEntity = new BuyerEntity(
				 									buyerPojo.getBuyerId(),
				 									buyerPojo.getBuyerUsername(),
				 									buyerPojo.getBuyerPassword(),
				 									buyerPojo.getBuyerEmail(),
				 									buyerPojo.getBuyerMobile(),
				 									buyerPojo.getBuyerDate(),
				 									null 
				 								  );
		
		 
		 BillEntity billEntity = new BillEntity();
		 billEntity.setBillId(0);
		 billEntity.setBillAmount(billPojo.getBillAmount());
		 billEntity.setBillType(billPojo.getBillType());
		 billEntity.setBillDate(billPojo.getBillDate());
		 billEntity.setBillRemarks(billPojo.getBillRemarks());
		 billEntity.setBuyer(buyerEntity);
		
		
		 billEntity = billDao.saveAndFlush(billEntity);  
		
		 
		 billPojo.setBillId(billEntity.getBillId());
		 

		 
		
		 Set<BillDetailsEntity> allBillDetailsEntity = new HashSet<BillDetailsEntity>();
		 
		 Set<BillDetailsPojo> allBillDetailsPojo = billPojo.getAllBillDetails();
		 Set<BillDetailsPojo> allBillDetailsPojo2 = new HashSet<BillDetailsPojo>();
		 
		 for(BillDetailsPojo billDetailsPojoitr : allBillDetailsPojo) 
		 {
			 ItemPojo itemPojo = billDetailsPojoitr.getItem();
			 SellerPojo SellerEntity  = itemPojo.getSeller();
			 SubCategoryPojo subCategoryPojo = itemPojo.getSubCategory();
			 CategoryPojo categoryPojo = subCategoryPojo.getCategory();
			 
			 
			 CategoryEntity categoryEntity = new CategoryEntity(
					 											categoryPojo.getCategoryId(), 
					 											categoryPojo.getCategoryName(), 
					 											categoryPojo.getCategoryBrief()
					 										   );
			 
			 
			 SubCategoryEntity subCategoryEntity = new SubCategoryEntity(
					 													 subCategoryPojo.getSubCategoryId(),
					 													 subCategoryPojo.getSubCategoryName(),
					 													 subCategoryPojo.getSubCategoryBrief(),
					 													 subCategoryPojo.getSubCategoryGst(),
					 													 categoryEntity
					 													); 
			 
			 
			 SellerEntity sellerEntity = new SellerEntity(
					 										SellerEntity.getSellerId(),
					 										SellerEntity.getSellerUsername(),
					 										null,
					 										SellerEntity.getSellerCompany(),
					 										SellerEntity.getSellerBrief(),
					 										SellerEntity.getSellerGst(),
					 										SellerEntity.getSellerAddress(),
					 										SellerEntity.getSellerEmail(),
					 										SellerEntity.getSellerWebsite(),
					 										SellerEntity.getSellerContact()
					 									 ); 
			 
			 
			 ItemEntity itemEntity = new ItemEntity(
					 								itemPojo.getItemId(),
					 								itemPojo.getItemName(),
					 								itemPojo.getItemImage(),
					 								itemPojo.getItemPrice(),
					 								itemPojo.getItemDescription(),
					 								itemPojo.getItemRemarks(),
					 								itemPojo.getItemStock(),
					 								sellerEntity,
					 								subCategoryEntity
					 							   );
			 
			 BillDetailsEntity billDetailsEntity = new BillDetailsEntity(
					 													 0,
					 													 billEntity,
					 													 itemEntity
					 													);
			 
			 billDetailsEntity = billDetailsDao.saveAndFlush(billDetailsEntity);
			 allBillDetailsEntity.add(billDetailsEntity);
			 
			 
			 billDetailsPojoitr.setBillDetailsId(billDetailsEntity.getBillDetailsId());
			 allBillDetailsPojo2.add(billDetailsPojoitr);
		 } 
		
		 billEntity.setAllBillDetails(allBillDetailsEntity);
		 
		 billPojo = new BillPojo(
				 				  billEntity.getBillId(),
				 				  billEntity.getBillType(),
				 				  billEntity.getBillDate(),
				 				  billEntity.getBillRemarks(),
				 				  billEntity.getBillAmount(),
				 				  buyerPojo,
				 				  allBillDetailsPojo2
				 				);
		 BasicConfigurator.configure();
		 LOG.info("Exited addBill()");
		 return billPojo;
	} 
	
}