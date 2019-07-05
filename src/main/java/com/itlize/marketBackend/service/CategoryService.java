package com.itlize.marketBackend.service;

import java.util.List;

import com.itlize.marketBackend.domain.SubCategory;

public interface CategoryService {
	
//	Map<String, String> getAllSubCateNames(String cateName); // -> subCate list

	List<SubCategory> getSubCate(String Category) throws Throwable;

	Boolean hasCategory(String category);
	
	boolean hasSubCategory(String subCateName);
	
//	List<AttributeType>  getAttributeType();
//	List<Attribute> getAttribute();

}
