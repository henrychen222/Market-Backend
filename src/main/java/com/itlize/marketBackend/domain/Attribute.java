package com.itlize.marketBackend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Attribute")
public class Attribute {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int AttributeID;
	@Column
	private String AttributeName;
	@Column
	private byte isRange;
	@Column
	private Integer minValue;
	@Column
	private Integer maxValue;
	@Column
	private int attributeTypeId;
	@Column
	private int subCategoryId;

	public int getAttributeID() {
		return AttributeID;
	}

	public void setAttributeID(int attributeID) {
		AttributeID = attributeID;
	}

	public String getAttributeName() {
		return AttributeName;
	}

	public void setAttributeName(String attributeName) {
		AttributeName = attributeName;
	}

	public byte getIsRange() {
		return isRange;
	}

	public void setIsRange(byte isRange) {
		this.isRange = isRange;
	}

	public Integer getMinValue() {
		return minValue;
	}

	public void setMinValue(Integer minValue) {
		this.minValue = minValue;
	}

	public Integer getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Integer maxValue) {
		this.maxValue = maxValue;
	}

	public int getAttributeTypeId() {
		return attributeTypeId;
	}

	public void setAttributeTypeId(int attributeTypeId) {
		this.attributeTypeId = attributeTypeId;
	}

	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

}
