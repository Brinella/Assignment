/*
 * Author: MI Lagardien
 * Group: 3A
 * Subject: Technical Programming 2 (TPG200s)
 * Lecturer: Dr B. Kabaso 
 * Description: This PizzaBuilder is resposible for building one of two pizza objects
 */
package com.lagardien.elitetakeaways;

public class PizzaBuilder 
{
	public PizzaInterface prepareSteakPizza()
	{
		PizzaInterface steakPizzaObject = new SteakPizza();
		return steakPizzaObject;
	}
	
	public PizzaInterface prepareChickenPizza()
	{
		PizzaInterface chickenPizzaObject = new ChickenPizza();
		return chickenPizzaObject;
	}
}
