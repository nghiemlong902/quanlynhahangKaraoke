package com.dmt.model;

import java.math.BigDecimal;
import java.sql.Date;

public class InvoiceDetail {

	private String roomNumber;
	private String roomType;
	private BigDecimal price;
	private String fullName;
	private Date startDate;

	public InvoiceDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvoiceDetail(String roomNumber, String roomType, BigDecimal price, String fullName, Date startDate) {
		super();
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.price = price;
		this.fullName = fullName;
		this.startDate = startDate;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}
