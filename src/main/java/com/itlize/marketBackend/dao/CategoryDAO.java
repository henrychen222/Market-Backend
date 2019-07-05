package com.itlize.marketBackend.dao;

import java.util.List;

import com.itlize.marketBackend.domain.Category;
import com.itlize.marketBackend.domain.SubCategory;

public interface CategoryDAO {

//	Map<String, String> getAllSubCateNames(String cateName); // -> subCate list

	List<SubCategory> getSubCate(String Category) throws Throwable;

	Category hasCategory(String category);
	
//	List<AttributeType> getAllAttributeTypes();

}
