package com.lagardien.elitetakeaways;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
 * Author: MI Lagardien
 * Group: 3A
 * Subject: Technical Programming 2 (TPG200s)
 * Lecturer: Dr B. Kabaso
 * Description: This concrete class handles the testing
 */
public class EliteTakeawaysTest
{
    private BurgerFactory burgerFactory = new BurgerFactory();
    private PizzaBuilder pizzaBuilder = new PizzaBuilder();
    private GatsbysInterface steakGatsby;
    private GatsbysInterface chickenGatsby;
    private GatsbysInterface fullhouseGatsby;
    private BurgersInterface beefBurger;
    private BurgersInterface chickenBurger;
    private BurgersInterface veggyBurger;
    private BurgersInterface quarterpounderBurger;
    private BurgersInterface halfpounderBurger;
    private PizzaInterface steakPizza;
    private PizzaInterface chickenPizza;
    private BeveragesInterface coldDrinks;
    private BeveragesInterface hotDrinks;
    private BeveragesInterface milkshakes;
    private Boolean changesMade = false;

    @Before
    public void setUp() throws Exception {
        try{
            steakGatsby = SingleGatsby.getGatsby("STEAK GATSBY");
            chickenGatsby = SingleGatsby.getGatsby("CHICKEN GATSBY");
            fullhouseGatsby = SingleGatsby.getGatsby("FULLHOUSE GATSBY");

            beefBurger = burgerFactory.getBurger("BEEF BURGER");
            chickenBurger = burgerFactory.getBurger("CHICKEN BURGER");
            veggyBurger = burgerFactory.getBurger("VEGGY CHICKEN");
            quarterpounderBurger = burgerFactory.getBurger("QUARTERPOUNDER BURGER");
            halfpounderBurger = burgerFactory.getBurger("HALFPOUNDER BURGER");

            steakPizza = pizzaBuilder.prepareSteakPizza();
            chickenPizza = pizzaBuilder.prepareChickenPizza();

            coldDrinks = new ColdBeverages();
            hotDrinks = new HotBeverages();
            milkshakes = new MilkshakeBeverages();


        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    @Test
    public void testForObjectCreation() throws Exception {
        try{
            Assert.assertSame(steakGatsby,steakGatsby);
            Assert.assertSame(chickenGatsby, chickenGatsby);
            Assert.assertSame(fullhouseGatsby, fullhouseGatsby);
            Assert.assertSame(beefBurger, beefBurger);
            Assert.assertSame(chickenBurger, chickenBurger);
            Assert.assertSame(veggyBurger, veggyBurger);
            Assert.assertSame(quarterpounderBurger, quarterpounderBurger);
            Assert.assertSame(halfpounderBurger, halfpounderBurger);
            Assert.assertSame(steakPizza, steakPizza);
            Assert.assertSame(chickenPizza, chickenPizza);
            Assert.assertSame(milkshakes, milkshakes);
            Assert.assertSame(coldDrinks,coldDrinks);
            Assert.assertSame(hotDrinks,hotDrinks);
        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    @Test
    public void testForChanges() throws Exception {
        try{
            coldDrinks.setBeverage("Coke");
            hotDrinks.setBeverage("Coffee");
            milkshakes.setBeverage("Strawberry Milkshake");
            Assert.assertEquals("Coke",coldDrinks.getBeverageType());
            Assert.assertEquals("Coffee",hotDrinks.getBeverageType());
            Assert.assertEquals("Strawberry Milkshake",milkshakes.getBeverageType());
            changesMade = true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            Assert.assertTrue(changesMade);
        }

    }
}
