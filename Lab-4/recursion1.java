package com.company;

import java.util.Scanner;

public class recursion1
{
    public static int factorial(int n)
    {
        if (n == 1)    //making my base case 1 as for factorial the last number ended for every single one is 1
            return (1);
        else
        {
            return n*factorial(n-1); //starting with n and recursing to find all the values of the factorial and multiplying them together
        }
    }

    public static int power(int base, int exponent)
    {
        if (exponent == 1) //another case could be if exponent <= 0 return 1 bc thats what it would be equal
            return base;
        else
        {
            return  base*(power(base,exponent-1));//starting with base and recursing the exponent and the amount of unwinding the exponent does will be the amount of base numbers that will be multiplied together
        }
    }

    public static int summation(int n)
    {
        if (n == 1) //making my base case 1 as the summation always starts out with a value of 1
            return (1);
        else
        {
            return n + summation(n-1); //starting with n and recursing to find all the values of the summation and adding them together
        }
    }

    public static int gcd(int divider, int remainder) //uses Euclid's algorithm
    {
        if (remainder == 0) //the base case is 0 bc when the remainder is 0 euclid's algorithm has reached the base case
            return divider;
        else
        {
            return gcd(remainder, divider%remainder); //when recursively it moves it the previous remainder to be the divider and the new remainder to be the remainder
        }
    }

    public static void main(String[] args)
    {
        int choice1 = 1;
        int choice2 = 2;
        int choice3 = 3;
        int choice4 = 4;
        Scanner userinput = new Scanner(System.in);
        System.out.printf("Please type in the number of the function you want: %n" + "1. Factorial %n"  + "2. Exponential %n" + "3. Summation %n" + "4. Greatest Common Divisor %n");
        int choice = userinput.nextInt();
        if (choice == choice1)
        {
            System.out.println("Please type in the integer to be used to compute the factorial function.");
            int factorialinput = userinput.nextInt();
            System.out.println("Factorial: " + factorial(factorialinput));
        }
        if (choice == choice2)
        {
            System.out.println("Please type in the integer to be used as the base of the exponential function.");
            int baseinput = userinput.nextInt();
            System.out.println("Please type in the integer to be used as the exponent of the exponential function");
            int exponentinput = userinput.nextInt();
            System.out.println("Exponential: " + power(baseinput, exponentinput));
        }
        if (choice == choice3)
        {
            System.out.println("Please type in the integer to be used to compute the summation function.");
            int summationinput = userinput.nextInt();
            System.out.println("Summation: " + summation(summationinput));
        }
        if (choice == choice4)
        {
            System.out.println("Please type in the integer to be used as the dividend of the greatest common divisor function.");
            int dividendinput = userinput.nextInt();
            System.out.println("Please type in the integer to be used as the divisor of the greatest common divisor function");
            int divisorinput = userinput.nextInt();
            System.out.println("Greatest Common Divisor: " + gcd(dividendinput, divisorinput));
        }
    }
}
