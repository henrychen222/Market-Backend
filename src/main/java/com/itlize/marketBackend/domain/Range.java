package com.itlize.marketBackend.domain;

public class Range {
	private int minValue;
	private int maxValue;
	
	public Range(int min, int max) {
		minValue = min;
		maxValue = max;
	}
	public int getMinValue() {
		return minValue;
	}
	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}
	public int getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}
}
