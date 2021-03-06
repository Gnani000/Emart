package com.project.buyeritemservice.pojo;

import java.util.Locale.Category;

public class SubCategoryPojo {

	private int subCategoryId;
	private String subCategoryName;
	private String subCategoryBrief;
	private int subCategoryGst;
	private CategoryPojo category;
	
	public SubCategoryPojo() {
		super();
	}

	public SubCategoryPojo(int subCategoryId, String subCategoryName, String subCategoryBrief, int subCategoryGst,
			CategoryPojo category) {
		super();
		this.subCategoryId = subCategoryId;
		this.subCategoryName = subCategoryName;
		this.subCategoryBrief = subCategoryBrief;
		this.subCategoryGst = subCategoryGst;
		this.category = category;
	}
 
	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public String getSubCategoryBrief() {
		return subCategoryBrief;
	}

	public void setSubCategoryBrief(String subCategoryBrief) {
		this.subCategoryBrief = subCategoryBrief;
	}

	public int getSubCategoryGst() {
		return subCategoryGst;
	}

	public void setSubCategoryGst(int subCategoryGst) {
		this.subCategoryGst = subCategoryGst;
	}
	
	public CategoryPojo getCategory() {
		return category;
	}

	public void setCategory(CategoryPojo category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "SubCategoryPojo [subCategoryId=" + subCategoryId + ", subCategoryName=" + subCategoryName
				+ ", subCategoryBrief=" + subCategoryBrief + ", subCategoryGst=" + subCategoryGst + "]";
	}
	
	
}
