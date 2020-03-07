package com.project.loginservice.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.loginservice.controller.BuyerController;
import com.project.loginservice.dao.BuyerDao;
import com.project.loginservice.entity.BillDetailsEntity;
import com.project.loginservice.entity.BillEntity;
import com.project.loginservice.entity.BuyerEntity;
import com.project.loginservice.entity.CategoryEntity;
import com.project.loginservice.entity.ItemEntity;
import com.project.loginservice.entity.SellerEntity;
import com.project.loginservice.entity.SubCategoryEntity;
import com.project.loginservice.pojo.BillDetailsPojo;
import com.project.loginservice.pojo.BillPojo;
import com.project.loginservice.pojo.BuyerPojo;
import com.project.loginservice.pojo.CategoryPojo;
import com.project.loginservice.pojo.ItemPojo;
import com.project.loginservice.pojo.SellerPojo;
import com.project.loginservice.pojo.SubCategoryPojo;

@Service
public class BuyerServiceImpl implements BuyerService{
  
	static Logger LOG = Logger.getLogger(BuyerServiceImpl.class.getClass());
	
	@Autowired
	BuyerDao buyerDao;
	
	@Override
	public BuyerPojo validateBuyer(BuyerPojo buyerPojo) {
		BasicConfigurator.configure();
		LOG.info("Entered validateBuyer()");
		
		
		BuyerEntity buyerEntity = buyerDao.findByBuyerUsernameAndBuyerPassword(buyerPojo.getBuyerUsername(), buyerPojo.getBuyerPassword());

				
		if(buyerEntity!=null) {
		Set<BillEntity> allBillsEntity = buyerEntity.getAllBills();
				
		Set<BillPojo> allBillPojo = new HashSet<BillPojo>();
	
		
		for(BillEntity billEntity : allBillsEntity) {
			Set<BillDetailsEntity> allBillDetailsEntity = billEntity.getAllBillDetails();
			Set<BillDetailsPojo> allBillDetailsPojo = new HashSet<BillDetailsPojo>();

			
			for(BillDetailsEntity billDetailsEntity : allBillDetailsEntity) {
				
				ItemEntity itemEntity = billDetailsEntity.getItem();
				SubCategoryEntity subCategoryEntity = itemEntity.getSubCategory();
				CategoryEntity categoryEntity = subCategoryEntity.getCategory();
				SellerEntity sellerEntity = itemEntity.getSeller(); 
				
				SellerPojo sellerPojo = new SellerPojo(sellerEntity.getSellerId(), 
													   sellerEntity.getSellerUsername(), 
													   sellerEntity.getSellerPassword(), 
													   sellerEntity.getSellerCompany(), 
													   sellerEntity.getSellerBrief(), 
													   sellerEntity.getSellerGst(), 
													   sellerEntity.getSellerAddress(), 
													   sellerEntity.getSellerEmail(), 
													   sellerEntity.getSellerWebsite(), 
													   sellerEntity.getSellerContact());	
				CategoryPojo categoryPojo = new CategoryPojo(categoryEntity.getCategoryId(), categoryEntity.getCategoryName(), categoryEntity.getCategoryBrief());
				SubCategoryPojo subCategoryPojo = new SubCategoryPojo(subCategoryEntity.getSubCategoryId(),
													  subCategoryEntity.getSubCategoryName(), 
													  subCategoryEntity.getSubCategoryBrief(), 
													  subCategoryEntity.getSubCategoryGst(), 
													  categoryPojo);
				ItemPojo itemPojo = new ItemPojo(itemEntity.getItemId(),
										itemEntity.getItemName(),
										itemEntity.getItemImage(),
										itemEntity.getItemPrice(),
										itemEntity.getItemDescription(),
										itemEntity.getItemRemarks(),
										itemEntity.getItemStock(),
										sellerPojo,
										subCategoryPojo);
						
				BillDetailsPojo billDetailsPojo = new BillDetailsPojo(billDetailsEntity.getBillDetailsId(), null, itemPojo);
				allBillDetailsPojo.add(billDetailsPojo);
			}
			BillPojo billPojo = new BillPojo(billEntity.getBillId(), 
											 billEntity.getBillType(), 
											 billEntity.getBillDate(), 
											 billEntity.getBillRemarks(), 
											 billEntity.getBillAmount(), 
											 null,
											 allBillDetailsPojo);
			allBillPojo.add(billPojo);
		}
		buyerPojo = new BuyerPojo(buyerEntity.getBuyerId(),
								  buyerEntity.getBuyerUsername(),
								  buyerEntity.getBuyerPassword(),
								  buyerEntity.getBuyerEmail(),
								  buyerEntity.getBuyerMobile(),
								  buyerEntity.getBuyerDate(),
								  allBillPojo);
		}
		BasicConfigurator.configure();
		LOG.info("Exited validateBuyer()");
		return buyerPojo;
	}



	@Override
	public BuyerPojo getBuyer(int BuyerId) {
		BuyerPojo buyerPojo = null;
		BuyerEntity buyerEntity = buyerDao.findById(BuyerId).get();
		if(buyerEntity!=null) {
			Set<BillEntity> allBillsEntity = buyerEntity.getAllBills();
					
			Set<BillPojo> allBillPojo = new HashSet<BillPojo>();
		
			
			for(BillEntity billEntity : allBillsEntity) {
				Set<BillDetailsEntity> allBillDetailsEntity = billEntity.getAllBillDetails();
				Set<BillDetailsPojo> allBillDetailsPojo = new HashSet<BillDetailsPojo>();

				
				for(BillDetailsEntity billDetailsEntity : allBillDetailsEntity) {
					
					ItemEntity itemEntity = billDetailsEntity.getItem();
					SubCategoryEntity subCategoryEntity = itemEntity.getSubCategory();
					CategoryEntity categoryEntity = subCategoryEntity.getCategory();
					SellerEntity sellerEntity = itemEntity.getSeller(); 
					
					SellerPojo sellerPojo = new SellerPojo(sellerEntity.getSellerId(), 
														   sellerEntity.getSellerUsername(), 
														   sellerEntity.getSellerPassword(), 
														   sellerEntity.getSellerCompany(), 
														   sellerEntity.getSellerBrief(), 
														   sellerEntity.getSellerGst(), 
														   sellerEntity.getSellerAddress(), 
														   sellerEntity.getSellerEmail(), 
														   sellerEntity.getSellerWebsite(), 
														   sellerEntity.getSellerContact());	
					CategoryPojo categoryPojo = new CategoryPojo(categoryEntity.getCategoryId(), categoryEntity.getCategoryName(), categoryEntity.getCategoryBrief());
					SubCategoryPojo subCategoryPojo = new SubCategoryPojo(subCategoryEntity.getSubCategoryId(),
														  subCategoryEntity.getSubCategoryName(), 
														  subCategoryEntity.getSubCategoryBrief(), 
														  subCategoryEntity.getSubCategoryGst(), 
														  categoryPojo);
					ItemPojo itemPojo = new ItemPojo(itemEntity.getItemId(),
											itemEntity.getItemName(),
											itemEntity.getItemImage(),
											itemEntity.getItemPrice(),
											itemEntity.getItemDescription(),
											itemEntity.getItemRemarks(),
											itemEntity.getItemStock(),
											sellerPojo,
											subCategoryPojo);
							
					BillDetailsPojo billDetailsPojo = new BillDetailsPojo(billDetailsEntity.getBillDetailsId(), null, itemPojo);
					allBillDetailsPojo.add(billDetailsPojo);
				}
				BillPojo billPojo = new BillPojo(billEntity.getBillId(), 
												 billEntity.getBillType(), 
												 billEntity.getBillDate(), 
												 billEntity.getBillRemarks(), 
												 billEntity.getBillAmount(), 
												 null,
												 allBillDetailsPojo);
				allBillPojo.add(billPojo);
			}
			buyerPojo = new BuyerPojo(buyerEntity.getBuyerId(),
									  buyerEntity.getBuyerUsername(),
									  buyerEntity.getBuyerPassword(),
									  buyerEntity.getBuyerEmail(),
									  buyerEntity.getBuyerMobile(),
									  buyerEntity.getBuyerDate(),
									  allBillPojo);
			}
			BasicConfigurator.configure();
			LOG.info("Exited validateBuyer()");
			return buyerPojo;
		
	}
}
