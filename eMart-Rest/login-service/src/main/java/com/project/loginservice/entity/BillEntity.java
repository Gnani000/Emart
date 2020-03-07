package com.project.loginservice.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="bill_table")
public class BillEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bill_id")
	int billId;
	
	@Column(name = "bill_type")
	String billType;
	
	@Column(name = "bill_date")
	Date billDate;
	
	@Column(name = "bill_remarks")
	String billRemarks;
	
	@Column(name = "bill_amount")
	int billAmount;
	
	@ManyToOne
	@JoinColumn(name = "buyer_id")
	BuyerEntity buyer;
	
	@OneToMany(mappedBy = "bill")
	Set<BillDetailsEntity> allBillDetails;
		
	public BillEntity() {
		super();
	}

	public BillEntity(int billId, String billType, Date billDate, String billRemarks, int billAmount, BuyerEntity buyer,
			Set<BillDetailsEntity> allBillDetails) {
		super();
		this.billId = billId;
		this.billType = billType;
		this.billDate = billDate;
		this.billRemarks = billRemarks;
		this.billAmount = billAmount;
		this.buyer = buyer;
		this.allBillDetails = allBillDetails;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public String getBillRemarks() {
		return billRemarks;
	}

	public void setBillRemarks(String billRemarks) {
		this.billRemarks = billRemarks;
	}

	public int getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}

	public BuyerEntity getBuyer() {
		return buyer;
	}

	public void setBuyer(BuyerEntity buyer) {
		this.buyer = buyer;
	}

	
	public Set<BillDetailsEntity> getAllBillDetails() {
		return allBillDetails;
	}

	public void setAllBillDetails(Set<BillDetailsEntity> allBillDetails) {
		this.allBillDetails = allBillDetails;
	}

	

		
	
}
