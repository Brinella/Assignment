package com.lagardien.collections;
import java.util.*;
/**
 * Ijaaz Lagardien
 * Group 3A
 * Dr B. Kabaso
 * Date: 12/03/2016
 */
public class RunCollections
{
    public static void main(String[] args) {
        //Define collections
        ArrayList<String> cars = new ArrayList<String>(); //List
        HashSet<String> setA = new HashSet<String>(); //Set
        HashMap<String, String> mapA = new HashMap<String, String>(); //Map
        Collection<String> vehicles = new HashSet<String>();

        //Car Collection
        Collections carsObject = new Collections();
        Collections carsObject2 = new Collections();
        Collections carsObject3= new Collections();
        Collections carsObject4 = new Collections();
        Collections carsObject5 = new Collections();
        carsObject.setVehicle("Ferrari", "458 Italia", 2013);
        carsObject2.setVehicle("Lexus", "LFA", 2012);
        carsObject3.setVehicle("Lamborghini", "Hurcan", 2014);
        carsObject4.setVehicle("Nissan", "GTR", 2015);
        carsObject5.setVehicle("Mercedes", "C63s AMG", 2016);
        cars.add(carsObject.toString());
        cars.add(carsObject2.toString());
        cars.add(carsObject3.toString());
        cars.add(carsObject4.toString());
        cars.add(carsObject5.toString());

        //Motorcycle Collection
        Collections bikeObject1 = new Collections();
        Collections bikeObject2 = new Collections();
        Collections bikeObject3 = new Collections();
        Collections bikeObject4 = new Collections();
        bikeObject1.setVehicle("Honda", "Fireblade", 2015);
        bikeObject2.setVehicle("BMW", "S1000rr", 2014);
        bikeObject3.setVehicle("Yamaha", "R1", 2014);
        bikeObject4.setVehicle("Kawasaki", "Ninja ZX-10", 2015);
        setA.add(bikeObject1.toString());
        setA.add(bikeObject2.toString());
        setA.add(bikeObject3.toString());
        setA.add(bikeObject4.toString());

        //Map Collection
        mapA.put("1",bikeObject1.toString());
        mapA.put("2", carsObject.toString());
        mapA.put("3", bikeObject2.toString());
        mapA.put("4", carsObject5.toString());
        String[] mapElements = new String[4];
        mapElements[0] = (String) mapA.get("1");
        mapElements[1] = (String) mapA.get("2");
        mapElements[2] = (String) mapA.get("3");
        mapElements[3] = (String) mapA.get("4");

        //Generic Collection
        vehicles.add(carsObject2.toString());
        vehicles.add(bikeObject3.toString());
        vehicles.add(carsObject3.toString());
        vehicles.add(bikeObject4.toString());
        vehicles.add(carsObject4.toString());
        vehicles.toArray();
        System.out.println("This is an ArrayList collection");
        for( int i = 0; i < cars.size(); i++)
        {
            System.out.println(cars.get(i));
        }
        System.out.println("\n\nThis is a HashSet collection");
        for(int j = 0; j < setA.size(); j++)
        {
            System.out.println(setA);
        }
        System.out.println("\n\nThis is a Map collection");
        for(int k = 0; k < mapElements.length; k++)
        {
            System.out.println(mapElements[k]);
        }

        System.out.println("\n\nThis is a generic Collection");
        for(int k = 0; k < mapElements.length; k++)
        {
            System.out.println(vehicles);
        }
    }
}
