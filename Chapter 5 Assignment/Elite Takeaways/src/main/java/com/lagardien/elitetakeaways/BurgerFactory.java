/*
 * Author: MI Lagardien
 * Group: 3A
 * Subject: Technical Programming 2 (TPG200s)
 * Lecturer: Dr B. Kabaso 
 * Description: This class uses the Factory Method to create the needed BurgerInterface object
 */
package com.lagardien.elitetakeaways;

public class BurgerFactory 
{
	public BurgersInterface getBurger(String burgerType)
	{
		if(burgerType == null)
		{
			return null;
		}
		if(burgerType.equalsIgnoreCase("Beef Burger"))
		{
			return new BeefBurger();
		}
		else if(burgerType.equalsIgnoreCase("Chicken Burger"))
		{
			return new ChickenBurger();
		}
		else if(burgerType.equalsIgnoreCase("Veggie Burger"))
		{
			return new VegBurger();
		}
		else if(burgerType.equalsIgnoreCase("Quarterpounder Burger"))
		{
			return new QuarterPounderBurger();
		}
		else if(burgerType.equalsIgnoreCase("Halfpounder Burger"))
		{
			return new HalfPounderBurger();
		}
		return null;
	}
}
