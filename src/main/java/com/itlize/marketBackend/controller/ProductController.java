package com.itlize.marketBackend.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.itlize.marketBackend.domain.Manufacturer;
import com.itlize.marketBackend.domain.Product;
import com.itlize.marketBackend.domain.Products_Multiple;
import com.itlize.marketBackend.domain.Sales;
import com.itlize.marketBackend.service.ProductService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ProductController {

	
	@Autowired
	ProductService productService;



	public ProductController() {
		// TODO Auto-generated constructor stub
		System.out.println("ProductController initialization...");
	}

	@RequestMapping(value = "/manufacturer/{id}", method = RequestMethod.GET)
	public Manufacturer getManufacturerInfo(@PathVariable("id") String manuId) {
		return productService.getManufacturer(Integer.parseInt(manuId));
	}

	@RequestMapping(value = "/sale/{id}", method = RequestMethod.GET)
	public Sales getSaleInfo(@PathVariable("id") String saleId) {
		return productService.getSale(Integer.parseInt(saleId));
	}

	
	//get products by sub category
	// may not need to poplulate the xml columns
	@RequestMapping(value="/subcate/{subid}/products", method = RequestMethod.GET)
	public List<Products_Multiple> getProductsBySubCategory(@PathVariable("subid")int subCategoryID) {
		return productService.getAllSubCateProducts(subCategoryID);
	}
	
	//get single product
	//get all the fields from product table
	@RequestMapping(value="products/{productId}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable("productId")int productId) {
		return productService.getProduct(productId);
	}

	@ModelAttribute
	public void setVaryResponseHeader(HttpServletResponse response) {
	    response.setHeader("Access-Control-Allow-Origin", "*");
	}

}
