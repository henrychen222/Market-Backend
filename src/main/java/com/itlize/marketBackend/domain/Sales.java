package com.itlize.marketBackend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Sales")
public class Sales {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int SalesID;
	@Column
	private String name;
	@Column
	private String phone;
	@Column
	private String email;
	@Column
	private String webUrl;
	@Column
	private int ManufacturerID;

	public int getSalesID() {
		return SalesID;
	}

	public void setSalesID(int salesID) {
		SalesID = salesID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public int getManufacturerID() {
		return ManufacturerID;
	}

	public void setManufacturerID(int manufacturerID) {
		ManufacturerID = manufacturerID;
	}
}
