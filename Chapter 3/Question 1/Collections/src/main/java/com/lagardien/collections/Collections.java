package com.lagardien.collections;

/**
 * Ijaaz Lagardien
 * Group 3A
 * Dr B. Kabaso
 * Date: 12/03/2016
 */
public class Collections
{
    private String make;
    private String model;
    private int year;

    public void setVehicle(String make,String model, int year)
    {
        this.make = make;
        this.model= model;
        this.year = year;
    }

    public void setMake(String make)
    {
        this.make = make;
    }

    public void setModel(String model)
    {
        this.model= model;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public String getMake()
    {
        return make;
    }

    public String getModel()
    {
        return model;
    }

    public int getYear()
    {
        return year;
    }

    public String toString()
    {
        return "Make: " + getMake() + "\nModel: " + getModel() + "\nYear: " + getYear();
    }
}
