/*
@name Danielle Gonzalez-Wu
@date 12/4/2020
@course CSC102
 */

package com.company;

import java.util.Scanner;

public class Summation
{
    private int integer;

    public void getinteger()
    {
        Scanner integerinput = new Scanner(System.in);
        System.out.println("Input an integer please.");
        integer = integerinput.nextInt();
    }

    public void getsummation()
    {
        int sum = 0;

        for (int i =0; i<= integer; i++)
        {
            sum = sum + i;
        }

        System.out.println("Summation of the integer: " + sum);
    }

    public static void main(String args[])
    {
        Summation someinteger = new Summation();
        String choiceyes = "Yes";
        String choiceno = "No";
        int timescalculated = 0;
        Scanner userinput = new Scanner(System.in);

        someinteger.getinteger();
        someinteger.getsummation();

        while (timescalculated >= 0)
        {
            System.out.println("Would you like to calculate another summation? Enter Yes to continue and No to stop.");
            String choice = userinput.nextLine();

            if (choice.equals(choiceyes))
            {
                someinteger.getinteger();
                someinteger.getsummation();
            }

            if (choice.equals(choiceno))
            {
                break;
            }
        }
    }
}
