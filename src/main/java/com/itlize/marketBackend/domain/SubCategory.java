package com.itlize.marketBackend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SubCategory")
public class SubCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int SubCategoryID;
	@Column
	private String subCategoryName;
	@Column
	private int CategoryID;

	public int getSubCategoryID() {
		return SubCategoryID;
	}

	public void setSubCategoryID(int subCategoryID) {
		SubCategoryID = subCategoryID;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public int getCategoryID() {
		return CategoryID;
	}

	public void setCategoryID(int categoryID) {
		this.CategoryID = categoryID;
	}

}
