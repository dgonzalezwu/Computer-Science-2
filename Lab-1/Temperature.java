/*
@name Danielle Gonzalez-Wu
@date 12/4/2020
@course CSC102
 */

package com.company;
import java.util.Scanner;

public class Temperature
{
    private double fahrenheit;
    private double celsius;

    public void getfahrenheit(double amount)
    {
        fahrenheit = amount;
    }

    public double converttocelsius()
    {
        celsius = (fahrenheit-32)*(5d/9d);
        return celsius;
    }

    public static void main (String args[])
    {
        Temperature newconversion = new Temperature();

        Scanner userinput = new Scanner(System.in);
        System.out.println("Enter temperature value in Fahrenheit:");

        Double fahrenheit = userinput.nextDouble();

        newconversion.getfahrenheit(fahrenheit);
        newconversion.converttocelsius();

        System.out.println("Converted Temperature:" + newconversion.converttocelsius() + " °C");

    }
}
