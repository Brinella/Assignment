/*
 * Author: MI Lagardien
 * Group: 3A
 * Subject: Technical Programming 2 (TPG200s)
 * Lecturer: Dr B. Kabaso 
 * Description: This interface makes use of the chain of responsibility pattern when creating different beverages 
 */
package com.lagardien.elitetakeaways;

public interface BeveragesInterface 
{
	public void setBeverage(String type);
	public void setPrice(double price);
	public String getBeverageType();
	public double getBeveragePrice(); 
}
