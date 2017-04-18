/*
 * Author: MI Lagardien
 * Group: 3A
 * Subject: Technical Programming 2 (TPG200s)
 * Lecturer: Dr B. Kabaso 
 * Description: This class is home to the main function
 */
package com.lagardien.elitetakeaways;
import javax.swing.JOptionPane;

public class EliteTakeaways {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//Declare local variables
		String item;
		int reply = 0;
		Orders orderHandler = new Orders();
		boolean run = true;
		//Statements
		JOptionPane.showMessageDialog(null, "Welcome to Elite Takeaways");
		item = JOptionPane.showInputDialog("What would you like?\n\nGatsbys\nSteak Gatsby\nChicken Gatsby\nFullhouse Gatsby\nBurgers\nBeef Burger\nChicken Burger\nQuarterpounder Burger\nHalfpounder Burger\nVeggy Burger\nPizza's\nSteak Pizza\nChicken Pizza\nBeverages\nCold Drinks [Sprite,Coke, Fanta, Pepsi]\nHot Drinks [Tea, Coffee]\nMilkshakes [Strawberry,Chocolate, Bubblegum]");
		do{
			if(item == null)
			{
				System.exit(0);
			}
			if((item.contains("Gatsby")) || (item.contains("GATSBY")))
			{
				orderHandler.gatsbyOrders(item);
				reply = JOptionPane.showConfirmDialog(null, "Do you want anything else?", "Confirm Choice",JOptionPane.YES_NO_OPTION);
			}
			else if(item.contains("Burger"))
			{
				orderHandler.burgerOrders(item);
				reply = JOptionPane.showConfirmDialog(null, "Do you want anything else?", "Confirm Choice",JOptionPane.YES_NO_OPTION);
			}
			else if(item.contains("Pizza"))
			{
				orderHandler.pizzaOrders(item);
				reply = JOptionPane.showConfirmDialog(null, "Do you want anything else?", "Confirm Choice",JOptionPane.YES_NO_OPTION);
			}
			else if((item.equalsIgnoreCase("COFFEE")) || (item.equalsIgnoreCase("TEA")) ||(item.equalsIgnoreCase("HOT CHOCLOATE")))
			{
				orderHandler.hotDrinkOrders(item);
				reply = JOptionPane.showConfirmDialog(null, "Do you want anything else?", "Confirm Choice",JOptionPane.YES_NO_OPTION);
			}
			else if((item.equalsIgnoreCase("SPRITE")) || (item.equalsIgnoreCase("COKE")) ||(item.equalsIgnoreCase("FANTA")) || (item.equalsIgnoreCase("PEPSI")))
			{
				orderHandler.coldDrinkOrders(item);
				reply = JOptionPane.showConfirmDialog(null, "Do you want anything else?", "Confirm Choice",JOptionPane.YES_NO_OPTION);
			}
			else if((item.equalsIgnoreCase("STRAWBERRY MILKSHAKE")) || (item.equalsIgnoreCase("CHOCOLATE MILKSHAKE")) ||(item.equalsIgnoreCase("BUBBLEGUM MILKSHAKE")))
			{
				orderHandler.milkshakeOrders(item);
				reply = JOptionPane.showConfirmDialog(null, "Do you want anything else?", "Confirm Choice",JOptionPane.YES_NO_OPTION);
			}
			if(reply == JOptionPane.YES_OPTION)
			{
				item = JOptionPane.showInputDialog("What would you like?\n\nGatsbys\nSteak Gatsby\nChicken Gatsby\nFullhouse Gatsby\nBurgers\nBeef Burger\nChicken Burger\nQuarterpounder Burger\nHalfpounder Burger\nVeggy Burger\nPizza's\nSteak Pizza\nChicken Pizza\nBeverages\nCold Drinks [Sprite,Coke, Fanta, Pepsi]\nHot Drinks [Tea, Coffee]\nMilkshakes [Strawberry,Chocolate, Bubblegum]");
			}
			else if(reply ==JOptionPane.NO_OPTION)
			{
				JOptionPane.showMessageDialog(null, "You ordered the following: \n\n" + orderHandler.getOrders() +"\n\nTotal: R " + orderHandler.getTotal() );
				System.exit(0);
				run = false;
			}
		}while(run);
		
	}	
}