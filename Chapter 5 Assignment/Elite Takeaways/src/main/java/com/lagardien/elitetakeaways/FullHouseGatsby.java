/*
 * Author: MI Lagardien
 * Group: 3A
 * Subject: Technical Programming 2 (TPG200s)
 * Lecturer: Dr B. Kabaso 
 * Description: This concrete class implements the GatsbysInterface
 */
package com.lagardien.elitetakeaways;

public class FullHouseGatsby implements GatsbysInterface 
{
	private final String GATSBYTYPE ="Full-House Gatsby";
	private final double GATSBYPRICE = 120.00;

	public String getGatsbyType() {
		// TODO Auto-generated method stub
		return GATSBYTYPE;
	}

	public double getGatsbyPrice() {
		// TODO Auto-generated method stub
		return GATSBYPRICE;
	}

}
