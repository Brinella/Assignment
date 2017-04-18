/*
 * Author: MI Lagardien
 * Group: 3A
 * Subject: Technical Programming 2 (TPG200s)
 * Lecturer: Dr B. Kabaso 
 * Description: This concrete class implements the burgersInterface interface
 */
package com.lagardien.elitetakeaways;

public class VegBurger implements BurgersInterface 
{
	private final String BURGERTYPE = "Veggy Burger";
	private final double BURGERPRICE = 35.99;

	public String getBurgerType() {
		// TODO Auto-generated method stub
		return BURGERTYPE;
	}

	public double getBurgerPrice() {
		// TODO Auto-generated method stub
		return BURGERPRICE;
	}

}
