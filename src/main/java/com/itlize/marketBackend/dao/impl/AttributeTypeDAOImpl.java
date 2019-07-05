package com.itlize.marketBackend.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itlize.marketBackend.dao.AttributeTypeDAO;
import com.itlize.marketBackend.domain.AttributeType;

@Repository
public class AttributeTypeDAOImpl implements AttributeTypeDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<AttributeType> getAttributeType() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From AttributeType").list();
	}

}
