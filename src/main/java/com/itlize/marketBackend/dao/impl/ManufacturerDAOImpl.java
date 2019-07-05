package com.itlize.marketBackend.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itlize.marketBackend.dao.ManufacturerDAO;
import com.itlize.marketBackend.domain.Buyer;
import com.itlize.marketBackend.domain.Manufacturer;

@Repository
public class ManufacturerDAOImpl implements ManufacturerDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Manufacturer getManufacturer(int id) {
		// TODO Auto-generated method stub
		return (Manufacturer) sessionFactory.getCurrentSession().get(Manufacturer.class, id);
	}
	
	@Override
	public Manufacturer getManufacturer(String department) {
		// TODO Auto-generated method stub
		return (Manufacturer) sessionFactory.getCurrentSession()
								.createCriteria(Buyer.class, "m")
								.add(Restrictions.eq("m.department", department)).uniqueResult();
	}

}
