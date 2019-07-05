package com.itlize.marketBackend.service;

import com.itlize.marketBackend.domain.Buyer;

public interface BuyerService {
//	Yipeng 
	Buyer getBuyer(int buyerId);
	Buyer getBuyer(Buyer buyer) throws Throwable;
	Buyer validation(String username, String password) throws Exception;
	boolean addBuyer(Buyer buyer) throws Throwable;
	boolean isBuyerExist(String username);
}
