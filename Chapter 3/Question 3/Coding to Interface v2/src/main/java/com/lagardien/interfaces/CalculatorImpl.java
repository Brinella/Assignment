package com.lagardien.interfaces;

/**
 * Ijaaz Lagardien
 * Group 3A
 * Dr B. Kabaso
 * Date: 12/03/2016
 */
public class CalculatorImpl implements Calculator
{
    public float add(float a, float b) {
        return a+b;
    }

    public float multiply(float a, float b) {
        return a*b;
    }

    public float divide(float a, float b) {
        return a/b;
    }

    public float subtract(float a, float b) {
        return a-b;
    }
}
