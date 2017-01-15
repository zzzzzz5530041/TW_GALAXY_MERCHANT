package com.tw.interview.homework.model;

import java.math.BigDecimal;

public class Metal {
	public static final String[] METALS = { "Gold", "Iron", "Silver" };
	/* name */
	private String name;
	/* unit name eg:Credits */
	private String unitName;
	/* how many will cost per one metal */
	private BigDecimal unitCost;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public BigDecimal getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(BigDecimal unitCost) {
		this.unitCost = unitCost;
	}

	

}