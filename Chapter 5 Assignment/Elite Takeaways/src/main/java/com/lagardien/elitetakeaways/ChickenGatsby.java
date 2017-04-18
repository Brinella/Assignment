/*
 * Author: MI Lagardien
 * Group: 3A
 * Subject: Technical Programming 2 (TPG200s)
 * Lecturer: Dr B. Kabaso 
 * Description: This concrete class implements the GatsbysInterface
 */
package com.lagardien.elitetakeaways;

public class ChickenGatsby implements GatsbysInterface 
{
	private final String GATSBYTYPE ="Chicken Gatsby";
	private final double GATSBYPRICE = 75.00;

	public String getGatsbyType() {
		// TODO Auto-generated method stub
		return GATSBYTYPE;
	}

	public double getGatsbyPrice() {
		// TODO Auto-generated method stub
		return GATSBYPRICE;
	}

}
