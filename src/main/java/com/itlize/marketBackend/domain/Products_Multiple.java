package com.itlize.marketBackend.domain;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Products_Multiple {
	private int productId;
	private String description;
	private Map<String, String> attributes;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Map<String, String> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
}
