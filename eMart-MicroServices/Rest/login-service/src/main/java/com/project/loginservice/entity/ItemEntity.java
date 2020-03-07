package com.project.loginservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "item_table")
public class ItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "item_image")
	private String itemImage;
	
	@Column(name = "item_price")
	private int itemPrice;
	
	@Column(name = "item_description")
	private String itemDescription;
	
	@Column(name = "item_remarks")
	private String itemRemarks;
	
	@Column(name = "item_stock")
	private int itemStock;
	
	@ManyToOne
	@JoinColumn(name = "seller_id")
	private SellerEntity seller;
	
	@ManyToOne
	@JoinColumn(name = "subcategory_id")
	private SubCategoryEntity subCategory;
	
	public ItemEntity() {
		super();
	}

	public ItemEntity(int itemId, String itemName, String itemImage, int itemPrice, String itemDescription,
			String itemRemarks, int itemStock, SellerEntity seller, SubCategoryEntity subCategory) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemImage = itemImage;
		this.itemPrice = itemPrice;
		this.itemDescription = itemDescription;
		this.itemRemarks = itemRemarks;
		this.itemStock = itemStock;
		this.seller = seller;
		this.subCategory = subCategory;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getItemRemarks() {
		return itemRemarks;
	}

	public void setItemRemarks(String itemRemarks) {
		this.itemRemarks = itemRemarks;
	}

	public int getItemStock() {
		return itemStock;
	}

	public void setItemStock(int itemStock) {
		this.itemStock = itemStock;
	}

	public SellerEntity getSeller() {
		return seller;
	}

	public void setSeller(SellerEntity seller) {
		this.seller = seller;
	}

	public SubCategoryEntity getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategoryEntity subCategory) {
		this.subCategory = subCategory;
	}

	@Override
	public String toString() {
		return "ItemPojo [itemId=" + itemId + ", itemName=" + itemName + ", itemImage=" + itemImage + ", itemPrice="
				+ itemPrice + ", itemDescription=" + itemDescription + ", itemRemarks=" + itemRemarks + ", itemStock="
				+ itemStock + ", sellerId=" + seller + ", subCategoryId=" + subCategory + "]";
	}
	
	
}
