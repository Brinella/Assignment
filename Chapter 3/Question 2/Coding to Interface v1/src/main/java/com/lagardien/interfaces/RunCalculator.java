package com.lagardien.interfaces;
import java.util.*;
/**
 * Ijaaz Lagardien
 * Group 3A
 * Dr B. Kabaso
 * Date: 12/03/2016
 */
public class RunCalculator
{
    public static void main(String[] args) {
        Calculator calc = new CalculatorImpl();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        float num1 = input.nextInt();
        System.out.println("Enter the first number: ");
        float num2 = input.nextInt();
        input.close();
        System.out.println("Addition Result: " + calc.add(num1, num2));
        try{
            System.out.println("Division Result: " + calc.divide(num1, num2));
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("Multiplication Result: " + calc.multiply(num1, num2));
        if(num1 >= num2)
        {
            System.out.println("Subtraction Result: " + calc.subtract(num1, num2));
        }
        else
        {
            System.out.println("Subtraction Result: Error; second number too large");
        }
    }
}
