/*
 * Author: MI Lagardien
 * Group: 3A
 * Subject: Technical Programming 2 (TPG200s)
 * Lecturer: Dr B. Kabaso 
 * Description: This concrete class implements the BurgersInterface interface
 */
package com.lagardien.elitetakeaways;

public class BeefBurger implements BurgersInterface 
{
	private final String BURGERTYPE = "Beef Burger";
	private final double BURGERPRICE = 45.00;

	public String getBurgerType() {
		// TODO Auto-generated method stub
		return BURGERTYPE;
	}

	public double getBurgerPrice() {
		// TODO Auto-generated method stub
		return BURGERPRICE;
	}

}
