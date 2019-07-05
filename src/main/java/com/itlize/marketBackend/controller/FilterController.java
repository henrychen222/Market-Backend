package com.itlize.marketBackend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itlize.marketBackend.domain.Attribute;
import com.itlize.marketBackend.domain.AttributeType;
import com.itlize.marketBackend.domain.Product;
import com.itlize.marketBackend.domain.Products_Multiple;
import com.itlize.marketBackend.domain.Range;
import com.itlize.marketBackend.service.FilterService;
import com.itlize.marketBackend.service.ProductService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class FilterController {
	
	@Autowired
	private FilterService filterService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/filter/{subCateId}", method = RequestMethod.GET)
	public List<Attribute> getFilter(@PathVariable("subCateId")int subCategoryId) {
		System.out.println("filter controller!!!");
		return filterService.getFilterAttributes(subCategoryId);
	}
	
	@RequestMapping(value = "/attributePart", method = RequestMethod.GET)
	public List<AttributeType> getAllAttributeTypes() {
		return filterService.getAllAttributeTypes();
	}
	
	@RequestMapping(value = "/filter/{subCateId}", method = RequestMethod.POST)
	public List<Products_Multiple> filterResult(@PathVariable("subCateId")int subCateId,
									@RequestBody Map<String, Object> payload) {
		Map<String, Range> filterParams = new HashMap<String, Range>();
		Range r1 = new Range(0, 10);
		filterParams.put("max power", r1);
		//System.out.println(payload);
		//Map<String, Integer> attr = (Map<String, Integer>) payload.get("attributes");
		//System.out.println(attr + attr.get("min").getClass().getName());
		return productService.filter(payload, subCateId);
//				productService.filter(filterParams, subCateId);
	}
	
}
