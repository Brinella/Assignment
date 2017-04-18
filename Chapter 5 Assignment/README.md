The domain com.lagardien.elitetakeaways is made up of 21 classes and it is a mixture of concrete classes and interfaces. 
The purpose of this domain is to simulate a takeaway shop. The interface's BurgersInterface,GatsbysInterface, PizzaInterface 
and BeveragesInterface each have one or more solid classes which depends on it. 
The multiplicity of each interface to various classes is 1 and only one interface to 0...* solid classes.
For Example one BurgersInterface can be responsible for 0...* BeefBurgers. 

Some of these interfaces make use of either a factory method, singleton pattern or a builder pattern. 
as seen in the classes PizzaBuilder, BurgerFactory and SingleGatsby.

all of the design classes, interfaces and all of the dependents have some sort of composition between them and the Orders class. 
The orders class handles all of the possible orders the takeaways may recieve. Such as burgers, pizzas or gatsbys. 
In turn the Orders class has a composition in the EliteTakeaways class which houses the main function.
