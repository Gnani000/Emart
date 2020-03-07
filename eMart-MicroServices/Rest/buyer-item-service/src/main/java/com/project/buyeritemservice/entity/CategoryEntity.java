package com.project.buyeritemservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category_table")
public class CategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private int categoryId;
	
	@Column(name = "category_name")
	private String categoryName;
	
	@Column(name = "category_brief")
	private String categoryBrief;
	
	public CategoryEntity() {
		super();
	}

	public CategoryEntity(int categoryId, String categoryName, String categoryBrief) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryBrief = categoryBrief;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryBrief() {
		return categoryBrief;
	}

	public void setCategoryBrief(String categoryBrief) {
		this.categoryBrief = categoryBrief;
	}

	@Override
	public String toString() {
		return "CategoryEntity [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryBrief="
				+ categoryBrief + "]";
	}
}
