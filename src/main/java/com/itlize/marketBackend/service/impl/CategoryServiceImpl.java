package com.itlize.marketBackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itlize.marketBackend.dao.CategoryDAO;
import com.itlize.marketBackend.dao.SubCategoryDAO;
import com.itlize.marketBackend.domain.SubCategory;
import com.itlize.marketBackend.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	SubCategoryDAO subCategoryDao;
	
	@Override
	public boolean hasSubCategory(String subCateName) {
		// TODO Auto-generated method stub
		return subCategoryDao.hasSubCate(subCateName);
	}
	
	@Autowired
	CategoryDAO categoryDAO;

	@Override
	public List<SubCategory> getSubCate(String Category) throws Throwable {
		// TODO Auto-generated method stub
		return categoryDAO.getSubCate(Category);
	}

	@Override
	public Boolean hasCategory(String category) {
		// TODO Auto-generated method stub
		return categoryDAO.hasCategory(category) != null;
	}

}
