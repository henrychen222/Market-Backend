package com.itlize.marketBackend.dao;

import java.util.List;
import java.util.Map;

import com.itlize.marketBackend.domain.Product;

public interface ProductDAO {

	List<Object[]> getAllSubCateProducts(int subCategoryID);

	//List<String> getSubCate(String Cate);

	Product getProduct(int productID);// get all the information of one single product

	List<Product> filter(Map<String, String> filterParams);

	List<Product> search(String suffix); // what is this for?

	List<Product> compare(List<String> productIds);

	void createProduct(Product product);

}
