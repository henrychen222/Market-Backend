package com.itlize.marketBackend.service;

import java.util.List;

import com.itlize.marketBackend.domain.Attribute;
import com.itlize.marketBackend.domain.AttributeType;

public interface FilterService {
	
	List<Attribute> getFilterAttributes(int subCategoryId);
	List<AttributeType> getAllAttributeTypes();
	
}
