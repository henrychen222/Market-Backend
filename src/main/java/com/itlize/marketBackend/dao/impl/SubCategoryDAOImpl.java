package com.itlize.marketBackend.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itlize.marketBackend.dao.SubCategoryDAO;
import com.itlize.marketBackend.domain.SubCategory;

@Repository
public class SubCategoryDAOImpl implements SubCategoryDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Boolean hasSubCate(String subCateName) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession()
				.createCriteria(SubCategory.class, "sc")
				.add(Restrictions.eq("sc.subCategoryName", subCateName)) != null;
	}

}
