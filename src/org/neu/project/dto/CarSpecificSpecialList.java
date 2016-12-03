package org.neu.project.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class CarSpecificSpecialList {
	private Special special;
	private Double specialledPrice;
	private Date expiry;

	public CarSpecificSpecialList(Special special, double specialledPrice, Date expiry) {
		this.special = special;
		this.specialledPrice = Double.valueOf(specialledPrice);
		this.expiry = expiry;
		ArrayList<Object> al = new ArrayList<Object>();
		al.add(this.specialledPrice);
		al.add(this.expiry);
		HashMap<Special, ArrayList<Object>> hm = new HashMap<Special, ArrayList<Object>>();
		hm.put(this.special, al);
	}

	CarSpecificSpecialList() {

	}

	public Special getSpecial() {
		return special;
	}

	public void setSpecial(Special special) {
		this.special = special;
	}

	public Double getSpecialledPrice() {
		return specialledPrice;
	}

	public void setSpecialledPrice(Double specialledPrice) {
		this.specialledPrice = specialledPrice;
	}

	public Date getExpiry() {
		return expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}
	
	
	
}
