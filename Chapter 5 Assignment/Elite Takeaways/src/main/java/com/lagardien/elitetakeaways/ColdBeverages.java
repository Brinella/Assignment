/*
 * Author: MI Lagardien
 * Group: 3A
 * Subject: Technical Programming 2 (TPG200s)
 * Lecturer: Dr B. Kabaso 
 * Description: This concrete class implements the BeveragesInterface interface
 */
package com.lagardien.elitetakeaways;

public class ColdBeverages implements BeveragesInterface 
{
	private String type;
	private double price;


	@Override
	public void setPrice(double price) {
		// TODO Auto-generated method stub
		this.price = price;
	}

	@Override
	public String getBeverageType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public double getBeveragePrice() {
		// TODO Auto-generated method stub
		return price;
	}

	@Override
	public void setBeverage(String type) {
		// TODO Auto-generated method stub
		this.type = type;
	}


}
