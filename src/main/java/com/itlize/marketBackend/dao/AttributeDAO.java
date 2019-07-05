package com.itlize.marketBackend.dao;

import java.util.List;

import com.itlize.marketBackend.domain.Attribute;

public interface AttributeDAO {
	
	List<Attribute> getFilterAttributes(int subCategoryId);
	
}
