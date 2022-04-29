/*
@name Danielle Gonzalez-Wu
@date 12/4/2020
@course CSC102
 */

package com.company;

import java.util.Scanner;

public class AlteredTemperature
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

        String choice1 = "Fahrenheit to Celsius";
        String choice2 = "Celsius to Fahrenheit";

        Scanner chooseuserinput = new Scanner(System.in);
        System.out.println("Which conversion would you like to make: Celsius to Fahrenheit or Fahrenheit to Celsius?");
        String choice = chooseuserinput.nextLine();

        if (choice.equals(choice1))
        {
            Scanner userinput = new Scanner(System.in);
            System.out.println("Enter temperature value in Fahrenheit:");

            Double fahrenheit = userinput.nextDouble();

            newconversion.getfahrenheit(fahrenheit);
            newconversion.converttocelsius();

            System.out.println("Converted Temperature:" + newconversion.converttocelsius() + " °C");
        }

        else if (choice.equals(choice2))
        {
            Scanner userinput = new Scanner(System.in);
            System.out.println("Enter temperature value in Celsius:");

            Double celsius = userinput.nextDouble();

            Double fahrenheitconversion = ((9d/5d)*celsius) + 32;

            System.out.println("Converted Temperature:" + fahrenheitconversion + " °F");

        }
    }
}
