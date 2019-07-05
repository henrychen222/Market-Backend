package com.itlize.marketBackend.dao;

import com.itlize.marketBackend.domain.Buyer;

public interface BuyerDAO {
	void addBuyer(Buyer buyer);

	Buyer getBuyer(int id);

	Buyer getBuyer(String userName);

//	boolean isBuyerExist(String username);
}
