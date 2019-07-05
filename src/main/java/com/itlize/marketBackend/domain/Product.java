package com.itlize.marketBackend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ProductID;

	@Column(name = "ProductName")
	private String name;
	
	@Column(name = "ProductDescription")
	private String description;
	
//	@Column(name = "date")
//	private Date date;
	
	@Column(name = "ManufacturerID")
	private int manufacturerId;

	
	@Column(name = "SalesID")
	private int saleId;
	
	@Column(name = "AttributeXML")

	private String attributes; // Map<String, String> later
	
	@Column(name = "Details")
	private String details; // List<String> later
	
	@Column(name = "DocumentXML")
	private String documentUrl; // List<String> later

	
	@Column(name = "SubCategoryID")
	private int subCategoryID;
	

	public int getProductID() {
		return ProductID;
	}

	public void setProductID(int productID) {
		ProductID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String productName) {
		this.name = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public Date getDate() {
//		return date;
//	}
//
//	public void setDate(Date date) {
//		this.date = date;
//	}

	public int getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public int getSaleId() {
		return saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getDocumentUrl() {
		return documentUrl;
	}

	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
	}
	

	public int getSubCategoryID() {
		return this.subCategoryID;
	}

	public void setSubCategoryID(int subCategoryID) {
		this.subCategoryID = subCategoryID;
	}
	
	@Override
	public String toString() {
		return "id: " + this.getProductID() + " name: " + this.getName();
	}

}
