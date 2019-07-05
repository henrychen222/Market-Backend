package com.itlize.marketBackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itlize.marketBackend.Util.exceptions.AuthenticationException;
import com.itlize.marketBackend.Util.exceptions.UserExistsException;
import com.itlize.marketBackend.dao.BuyerDAO;
import com.itlize.marketBackend.domain.Buyer;
import com.itlize.marketBackend.service.BuyerService;

@Service
@Transactional
public class BuyerServiceImpl implements BuyerService {
	
	@Autowired
	BuyerDAO buyerDao;

	@Override
//	Yipeng
	public Buyer getBuyer(int buyerId) {
		// TODO Auto-generated method stub
		return buyerDao.getBuyer(buyerId);
	}
	
	@Override
//	Yipeng
	public Buyer getBuyer(Buyer buyer) throws Throwable {
		// TODO Auto-generated method stub
		String buyerName = buyer.getUsername();
		String password = buyer.getPassword();
		if (buyerName == null || buyerName.length() == 0 || password == null || password.length() == 0) {
			throw new Exception("Please enter the username and password");
		}
		
		return buyerDao.getBuyer(buyerName);
	}

	@Override
	public boolean addBuyer(Buyer buyer) throws Throwable {
		// TODO Auto-generated method stub
		if (buyer.getUsername() == null
				|| buyer.getPassword() == null
				|| buyer.getFirstname() == null
				|| buyer.getLastname() == null
				|| buyer.getEmail() == null) {
			throw new Exception("Please fill the required information!!!");
		}
		if (this.isBuyerExist(buyer.getUsername())) {
			throw new UserExistsException();
		}
		buyerDao.addBuyer(buyer);
		return true;
	}
	

	@Override
	public boolean isBuyerExist(String username) {
		// TODO Auto-generated method stub
		return buyerDao.getBuyer(username) != null;
	}

	@Override
	public Buyer validation(String username, String password) throws Exception{
		// TODO Auto-generated method stub
		Buyer buyer = buyerDao.getBuyer(username);
		if(buyer != null) {
			if(buyer.getPassword().equals(password)) return buyer;
			
//			else throw new Exception("bad credentials!");
		}
//		else throw new Exception("User not found!");
		throw new AuthenticationException();
	}


}
