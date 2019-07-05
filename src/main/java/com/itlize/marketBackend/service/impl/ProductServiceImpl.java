package com.itlize.marketBackend.service.impl;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itlize.marketBackend.Util.XmlDetailsParser;
import com.itlize.marketBackend.dao.ManufacturerDAO;
import com.itlize.marketBackend.dao.ProductDAO;
import com.itlize.marketBackend.dao.SalesDAO;
import com.itlize.marketBackend.domain.Manufacturer;
import com.itlize.marketBackend.domain.Product;
import com.itlize.marketBackend.domain.Products_Multiple;
import com.itlize.marketBackend.domain.Sales;
import com.itlize.marketBackend.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO productDao;

	@Override
	public List<Products_Multiple> getAllSubCateProducts(int subCategoryID) {
		// TODO Auto-generated method stub
		List<Object[]> rs = productDao.getAllSubCateProducts(subCategoryID);
		List<Products_Multiple> ret = new LinkedList<>();
		
		for(Object[] p: rs) {
			System.out.println(p);
			Products_Multiple pdt = new Products_Multiple();
			pdt.setDescription((String) p[0]);
			Map<String, Map<String, String>> map = (Map<String, Map<String, String>>)XmlDetailsParser.operation_inputXmlString((String)p[1]);
			pdt.setAttributes(map.get("attribute"));
			pdt.setProductId((int) p[2]);
			ret.add(pdt);
		}
		return ret;
	}

	@Override
	public Product getProduct(int ProductID) {
		// TODO Auto-generated method stub
		return productDao.getProduct(ProductID); 
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public List<Products_Multiple> filter(Map<String, Object> filterParams, int subCategoryID) {
		// TODO Auto-generated method stub
		List<Products_Multiple> originProducts = (List<Products_Multiple>) this.getAllSubCateProducts(subCategoryID);
		List<Products_Multiple> res = new ArrayList<>();
		Map<String, String> attributes = null;
		final String ATTRIBUTE = "attribute";
		//testing
//		List<Map<String, Integer>> dummyAttr = new ArrayList<>();
//		Map<String, Integer> map1 = new HashMap<>();
//		Map<String, Integer> map2 = new HashMap<>();
//		map1.put("power", 5);
//		map1.put("speed", 5);
//		map2.put("power", 3);
//		map2.put("speed", 10);
//		dummyAttr.add(map1);
//		dummyAttr.add(map2);
		
		
		for(int i = 0; i < originProducts.size(); i++) {
			Products_Multiple p = originProducts.get(i);
//			attributes = ParseXml.parseAttributes(p.getAttributes());
//			attributes = dummyAttr.get(i % 2);
//			Map<String, Map<String, String>> attributesMap = (Map<String, Map<String, String>>)XmlDetailsParser.operation_inputXmlString(p.getAttributes());
			attributes = p.getAttributes();
			boolean flag = true;
			for(String key: filterParams.keySet()) {
				if(!attributes.containsKey(key)) {
					flag = false;
					break;
				}
				
				int value = Integer.parseInt(attributes.get(key));
				//can generate exceptions if json data is wrong
				Map<String, Integer> range = (Map<String, Integer>) filterParams.get(key);
				if(value <= range.get("max") && value >= range.get("min")) {
					continue;
				} else {
					flag = false;
					break;
				}
					//Range range = filterParams.get(key);	
					//if(value <= range.getMaxValue() && value >= range.getMinValue()) res.add(p); 
				
			}
			if(flag) res.add(p);
		}
		return res;
	}

	@Override
	public List<Product> compare(List<Product> productIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product createProduct(Product product) {
		productDao.createProduct(product);
		return null;
	}
	
	@Autowired
	ManufacturerDAO manufaturerDao;

	@Override
	public Manufacturer getManufacturer(int id) {
		// TODO Auto-generated method stub
		return manufaturerDao.getManufacturer(id);
	}
	
	@Autowired
	SalesDAO salesDao;

	@Override
	public Sales getSale(int id) {
		// TODO Auto-generated method stub
		return salesDao.getSale(id);
	}
	
	

}
