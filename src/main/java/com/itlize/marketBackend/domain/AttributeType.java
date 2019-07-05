package com.itlize.marketBackend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AttributeType")
public class AttributeType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int AttributeTypeID;
	@Column
	private String AttributeTypeName;

	public int getAttributeTypeID() {
		return AttributeTypeID;
	}

	public void setAttributeTypeID(int attributeTypeID) {
		AttributeTypeID = attributeTypeID;
	}

	public String getAttributeTypeName() {
		return AttributeTypeName;
	}

	public void setAttributeTypeName(String attributeTypeName) {
		AttributeTypeName = attributeTypeName;
	}

}
