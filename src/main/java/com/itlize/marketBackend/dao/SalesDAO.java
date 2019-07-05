package com.itlize.marketBackend.dao;

import java.util.List;

import com.itlize.marketBackend.domain.Sales;

public interface SalesDAO {
	
	Sales getSale(int id);
	List<Sales> getSale(String saleName);
//	List<Sales> getAllSales(int manufactureID);
//	boolean hasSale(String name);
	
}
