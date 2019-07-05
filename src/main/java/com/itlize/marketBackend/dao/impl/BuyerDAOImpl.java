package com.itlize.marketBackend.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itlize.marketBackend.dao.BuyerDAO;
import com.itlize.marketBackend.domain.Buyer;

@Repository
public class BuyerDAOImpl implements BuyerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addBuyer(Buyer buyer) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(buyer);
	}

	@Override
	// Yipeng
	public Buyer getBuyer(int buyerId) {
		// TODO Auto-generated method stub
		return (Buyer) sessionFactory.getCurrentSession().get(Buyer.class, buyerId);
	}
	
	@Override
	// Yipeng
	public Buyer getBuyer(String username) {
		// TODO Auto-generated method stub
		return (Buyer) sessionFactory.getCurrentSession()
				.createCriteria(Buyer.class, "b")
				.add(Restrictions.eq("b.username", username))
				.uniqueResult();
	}

//	@Override
//	public boolean isBuyerExist(String username) {
//		// TODO Auto-generated method stub
//		if (getBuyer(username) != null) {
//			return true;
//		}
//		return false;
//	}

}


