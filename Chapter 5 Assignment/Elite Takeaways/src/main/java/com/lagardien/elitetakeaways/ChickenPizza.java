/*
 * Author: MI Lagardien
 * Group: 3A
 * Subject: Technical Programming 2 (TPG200s)
 * Lecturer: Dr B. Kabaso 
 * Description: This concrete class implements the PizzaInterface interface
 */
package com.lagardien.elitetakeaways;

public class ChickenPizza implements PizzaInterface 
{
	private final String PIZZATYPE ="Chicken Pizza";
	private final double PIZZAPRICE = 76.00;

	public String getPizzaType() {
		// TODO Auto-generated method stub
		return PIZZATYPE;
	}

	public double getPizzaPrice() {
		// TODO Auto-generated method stub
		return PIZZAPRICE;
	}

}
