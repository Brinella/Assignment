/*
 * Author: MI Lagardien
 * Group: 3A
 * Subject: Technical Programming 2 (TPG200s)
 * Lecturer: Dr B. Kabaso 
 * Description: This class handles all of the order methods
 */
package com.lagardien.elitetakeaways;
import java.util.ArrayList;
import java.util.List;

public class Orders 
{
	private BurgerFactory burgerFactory = new BurgerFactory();
	private PizzaBuilder pizzaBuilder = new PizzaBuilder();
	private float total = 0;
	List<String> orders = new ArrayList<String>();

	public void gatsbyOrders(String item)
	{
		if(item.equalsIgnoreCase("STEAK GATSBY"))
		{
			GatsbysInterface steakGatsby = SingleGatsby.getGatsby(item);
			orders.add(steakGatsby.getGatsbyType());
			total += steakGatsby.getGatsbyPrice();
		}
		else if(item.equalsIgnoreCase("CHICKEN GATSBY"))
		{
			GatsbysInterface ChickenGatsby = SingleGatsby.getGatsby(item);
			orders.add(ChickenGatsby.getGatsbyType());
			total += ChickenGatsby.getGatsbyPrice();
		}
		else if(item.equalsIgnoreCase("FULLHOUSE GATSBY"))
		{
			GatsbysInterface fullhouseGatsby = SingleGatsby.getGatsby(item);
			orders.add(fullhouseGatsby.getGatsbyType());
			total += fullhouseGatsby.getGatsbyPrice();
		}
	}
	
	public void burgerOrders(String item)
	{
		if(item.equalsIgnoreCase("BEEF BURGER"))
		{
			BurgersInterface beef = burgerFactory.getBurger(item);
			orders.add(beef.getBurgerType());
			total += beef.getBurgerPrice();
		}
		else if(item.equalsIgnoreCase("CHICKEN BURGER"))
		{
			BurgersInterface chicken = burgerFactory.getBurger(item);
			orders.add(chicken.getBurgerType());
			total += chicken.getBurgerPrice();
		}
		else if(item.equalsIgnoreCase("HALFPOUNDER BURGER"))
		{
			BurgersInterface halfpounder = burgerFactory.getBurger(item);
			orders.add(halfpounder.getBurgerType());
			total += halfpounder.getBurgerPrice();
		}
		else if(item.equalsIgnoreCase("QUARTERPOUNDER BURGER"))
		{
			BurgersInterface quarterpounder = burgerFactory.getBurger(item);
			orders.add(quarterpounder.getBurgerType());
			total += quarterpounder.getBurgerPrice();
		}
		else if(item.equalsIgnoreCase("VEGGY BURGER"))
		{
			BurgersInterface veggy = burgerFactory.getBurger(item);
			orders.add(veggy.getBurgerType());
			total += veggy.getBurgerPrice();
		}
	}
	
	public void pizzaOrders(String item)
	{
		if(item.equalsIgnoreCase("STEAK PIZZA"))
		{
			PizzaInterface steak = pizzaBuilder.prepareSteakPizza();
			orders.add(steak.getPizzaType());
			total += steak.getPizzaPrice();
		}
		else if(item.equalsIgnoreCase("CHICKEN PIZZA"))
		{
			PizzaInterface chicken = pizzaBuilder.prepareChickenPizza();
			orders.add(chicken.getPizzaType());
			total += chicken.getPizzaPrice();
		}
	}
	
	public void coldDrinkOrders(String item)
	{
		if(item.equalsIgnoreCase("SPRITE"))
		{
			BeveragesInterface sprite = new ColdBeverages();
			sprite.setBeverage("Sprite");
			sprite.setPrice(10.00);
			orders.add(sprite.getBeverageType());
			total += sprite.getBeveragePrice();
		}
		else if(item.equalsIgnoreCase("COKE"))
		{
			BeveragesInterface coke = new ColdBeverages();
			coke.setBeverage("Coke");
			coke.setPrice(10.00);
			orders.add(coke.getBeverageType());
			total += coke.getBeveragePrice();
		}
		else if(item.equalsIgnoreCase("FANTA"))
		{
			BeveragesInterface fanta = new ColdBeverages();
			fanta.setBeverage("Fanta");
			fanta.setPrice(10.00);
			orders.add(fanta.getBeverageType());
			total += fanta.getBeveragePrice();
		}
		else if(item.equalsIgnoreCase("PEPSI"))
		{
			BeveragesInterface pepsi = new ColdBeverages();
			pepsi.setBeverage("Pepsi");
			pepsi.setPrice(10.00);
			orders.add(pepsi.getBeverageType());
			total += pepsi.getBeveragePrice();
		}
	}
	
	public void hotDrinkOrders(String item)
	{
		if(item.equalsIgnoreCase("TEA"))
		{
			BeveragesInterface tea = new HotBeverages();
			tea.setBeverage("Tea");
			tea.setPrice(12.50);
			orders.add(tea.getBeverageType());
			total += tea.getBeveragePrice();
		}
		else if(item.equalsIgnoreCase("COFFEE"))
		{
			BeveragesInterface coffee = new HotBeverages();
			coffee.setBeverage("Coffee");
			coffee.setPrice(12.50);
			orders.add(coffee.getBeverageType());
			total += coffee.getBeveragePrice();
		}
	}
	
	public void milkshakeOrders(String item)
	{
		if(item.equalsIgnoreCase("STRAWBERRY MILKSHAKE"))
		{
			BeveragesInterface strawberry = new MilkshakeBeverages();
			strawberry.setBeverage("Strawberry Milkshake");
			strawberry.setPrice(20.00);
			orders.add(strawberry.getBeverageType());
			total += strawberry.getBeveragePrice();
		}
		else if(item.equalsIgnoreCase("CHOCOLATE MILKSHAKE"))
		{
			BeveragesInterface chocolate = new MilkshakeBeverages();
			chocolate.setBeverage("Choclate Milkshake");
			chocolate.setPrice(20.00);
			orders.add(chocolate.getBeverageType());
			total += chocolate.getBeveragePrice();
		}
		else if(item.equalsIgnoreCase("BUBBLEGUM MILKSHAKE"))
		{
			BeveragesInterface bubblegum = new MilkshakeBeverages();
			bubblegum.setBeverage("Bubblegum Milkshake");
			bubblegum.setPrice(20.00);
			orders.add(bubblegum.getBeverageType());
			total += bubblegum.getBeveragePrice();
		}
	}
	public double getTotal()
	{
		return total;
	}
	
	public List<String> getOrders()
	{
		return orders;
	}

}
