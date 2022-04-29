/*
@name Danielle Gonzalez-Wu
@date 12/4/2020
@course CSC102
 */

package com.company;

import javax.swing.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class AlteredTestGrades
{

    public static void main(String [] args) throws java.io.FileNotFoundException
    {
        ArrayList<Double> testgrades = new ArrayList<>();

        Scanner testgradetxtfile = new Scanner(new File("testgrades.txt")); //reading in the file with the test grades

        while (testgradetxtfile.hasNext())
        {
            testgrades.add(testgradetxtfile.nextDouble()); //reading in the test grades from the file
        }

        //System.out.println(Arrays.toString(testgrades.toArray())); USED THIS TO MAKE SURE THAT ALL OF THE FILE CONTENTS WERE ADDED INTO THE ARRAY LIST

        double maximumgrade = testgrades.get(0); //setting the maximum grade initially to the first index (index 0) on the array list

        for (int count = 1; count < testgrades.size(); count++)
        {
            if (testgrades.get(count) > maximumgrade) //if a value on the array list is larger than the current maximum grade
            {
                maximumgrade = testgrades.get(count); //set the maximum grade to the value larger on the array list
            }
        }

        double minimumgrade = testgrades.get(0);  //setting the minimum grade initially to the first index (index 0) on the array list

        for (int count = 1; count < testgrades.size(); count++)
        {
            if (testgrades.get(count) < minimumgrade) //if a value on the array list is smaller than the current minimum grade
            {
                minimumgrade = testgrades.get(count); //set the minimum grade to the value that is smaller on the array list
            }
        }

        double sum = 0;
        double average;

        for (int count = 0; count < testgrades.size(); count++) //summing together grades so the average can be computed
        {
            sum += testgrades.get(count);
        }

        average = (sum)/(testgrades.size()); //computing the average using the average equation

        JOptionPane.showMessageDialog(null, "The highest grade is " + maximumgrade + "." + "\nThe lowest grade is " + minimumgrade + "." + "\nThe average grade was " + average +".");
    }
}

