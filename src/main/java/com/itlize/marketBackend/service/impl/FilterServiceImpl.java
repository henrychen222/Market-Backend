package com.itlize.marketBackend.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itlize.marketBackend.dao.AttributeDAO;
import com.itlize.marketBackend.dao.AttributeTypeDAO;
import com.itlize.marketBackend.domain.Attribute;
import com.itlize.marketBackend.domain.AttributeType;
import com.itlize.marketBackend.service.FilterService;

@Service
@Transactional
public class FilterServiceImpl implements FilterService {
	
	@Autowired
	AttributeDAO attrDAO;
	
	@Override
	public List<Attribute> getFilterAttributes(int subCategoryId) {
		// TODO Auto-generated method stub
		return attrDAO.getFilterAttributes(subCategoryId);
	}
	
	@Autowired
	AttributeTypeDAO attributeTypeDao;

	@Override
	public List<AttributeType> getAllAttributeTypes() {
		// TODO Auto-generated method stub
		return attributeTypeDao.getAttributeType();
	}

}
