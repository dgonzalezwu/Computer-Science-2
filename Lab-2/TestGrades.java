/*
@name Danielle Gonzalez-Wu
@date 12/4/2020
@course CSC102
 */

package com.company;
import javax.swing.*;
import java.util.Arrays;

public class TestGrades
{

    public static void main(String [] args)
    {
        double[] testgrades = new double[10]; //setting a fixed array of 10
        double testgrade;

        for (int numberoftestgrades = 0; numberoftestgrades <= 9; numberoftestgrades++) //having a for loop that will let the person enter 10 test grades in
        {
            String testgraderesponse = JOptionPane.showInputDialog("Input Test Grade #" + (numberoftestgrades + 1)); //message box prompting input
            testgrade = Double.parseDouble(testgraderesponse);
            testgrades[numberoftestgrades] = testgrade; //adding the test grade input response to the array
        }

        //System.out.println(Arrays.toString(testgrades)); USED THIS TO MAKE SURE THAT ALL OF THE FILE CONTENTS WERE ADDED INTO THE ARRAY LIST

        double maximumgrade = testgrades[0]; //setting the maximum grade initially to the first index (index 0) on the array list

        for (int count = 1; count < testgrades.length; count++)
        {
            if (testgrades[count] > maximumgrade) //if a value on the array list is larger than the current maximum grade
            {
                maximumgrade = testgrades[count]; //set the maximum grade to the value larger on the array list
            }
        }

        double minimumgrade = testgrades[0]; //setting the minimum grade initially to the first index (index 0) on the array list

        for (int count = 1; count < testgrades.length; count++)
        {
            if (testgrades[count] < minimumgrade) //if a value on the array list is smaller than the current minimum grade
            {
                minimumgrade = testgrades[count]; //set the minimum grade to the value that is smaller on the array list
            }
        }


        double sum = 0;
        double average;

        for (int count = 0; count < testgrades.length; count++) //summing together grades so the average can be computed
        {
            sum += testgrades[count];
        }

        average = (sum)/(testgrades.length); //computing the average using the average equation

        JOptionPane.showMessageDialog(null, "The highest grade is " + maximumgrade + "." + "\nThe lowest grade is " + minimumgrade + "." + "\nThe average grade was " + average +".");
    }

}
