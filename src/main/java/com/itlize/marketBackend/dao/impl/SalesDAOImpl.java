package com.itlize.marketBackend.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itlize.marketBackend.dao.SalesDAO;
import com.itlize.marketBackend.domain.Sales;

@Repository
public class SalesDAOImpl implements SalesDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Sales getSale(int id) {
		// TODO Auto-generated method stub
		return (Sales) sessionFactory.getCurrentSession().get(Sales.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Sales> getSale(String saleName) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession()
				.createCriteria(Sales.class, "s")
				.add(Restrictions.eq("s.name", saleName)).list();
	}

}
