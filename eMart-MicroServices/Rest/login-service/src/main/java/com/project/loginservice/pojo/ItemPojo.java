package com.project.loginservice.pojo;


public class ItemPojo {

	private int itemId;
	private String itemName;
	private String itemImage;
	private int itemPrice;
	private String itemDescription;
	private String itemRemarks;
	private int itemStock;
	private SellerPojo seller;
	private SubCategoryPojo subCategory;
	
	public ItemPojo() {
		super();
	}

	public ItemPojo(int itemId, String itemName, String itemImage, int itemPrice, String itemDescription,
			String itemRemarks, int itemStock, SellerPojo seller, SubCategoryPojo subCategory) {
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

	public SellerPojo getSeller() {
		return seller;
	}

	public void setSeller(SellerPojo seller) {
		this.seller = seller;
	}

	public SubCategoryPojo getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategoryPojo subCategory) {
		this.subCategory = subCategory;
	}

	@Override
	public String toString() {
		return "ItemPojo [itemId=" + itemId + ", itemName=" + itemName + ", itemImage=" + itemImage + ", itemPrice="
				+ itemPrice + ", itemDescription=" + itemDescription + ", itemRemarks=" + itemRemarks + ", itemStock="
				+ itemStock + ", sellerId=" + seller + ", subCategory=" + subCategory + "]";
	}

	
	
	
	
	
}
