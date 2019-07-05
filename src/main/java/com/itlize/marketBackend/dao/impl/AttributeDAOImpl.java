package com.itlize.marketBackend.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itlize.marketBackend.dao.AttributeDAO;
import com.itlize.marketBackend.domain.Attribute;

@Repository
public class AttributeDAOImpl implements AttributeDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<Attribute> getFilterAttributes(int subCategoryId) {
		// TODO Auto-generated method stub
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Attribute.class);
		List<Attribute> rs = cr.add(Restrictions.eq("subCategoryId", subCategoryId)).list();
		return rs;
	}

}
