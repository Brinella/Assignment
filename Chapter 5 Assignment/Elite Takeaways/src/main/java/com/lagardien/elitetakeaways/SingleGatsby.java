/*
 * Author: MI Lagardien
 * Group: 3A
 * Subject: Technical Programming 2 (TPG200s)
 * Lecturer: Dr B. Kabaso 
 * Description: This class is responsible for creating a single GatsbyInterface instance as needed and returns it to main
 */
package com.lagardien.elitetakeaways;

public class SingleGatsby 
{
	private static GatsbysInterface steakGatsbyObject = new SteakGatsby();
	private static GatsbysInterface chickenGatsbyObject = new ChickenGatsby();
	private static GatsbysInterface fullhouseGatsbyObject = new FullHouseGatsby();
	
	private SingleGatsby()
	{}
	
	public static GatsbysInterface getGatsby(String gatsby)
	{
		if(gatsby == null)
		{
			return null;
		}
		if(gatsby.equalsIgnoreCase("Steak Gatsby"))
		{
			return steakGatsbyObject;
		}
		else if(gatsby.equalsIgnoreCase("Chicken Gatsby"))
		{
			return chickenGatsbyObject;
		}
		else if(gatsby.equalsIgnoreCase("Fullhouse Gatsby"))
		{
			return fullhouseGatsbyObject;
		}
		return null;
	}
}
