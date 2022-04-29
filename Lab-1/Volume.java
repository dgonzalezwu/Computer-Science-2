/*
@name Danielle Gonzalez-Wu
@date 12/4/2020
@course CSC102
 */

package com.company;
import java.util.Scanner;

public class Volume
{
private double volumeofbox;
public double length;
public double width;
public double height;

public void getlength()
{
    Scanner lengthinput = new Scanner(System.in);
    System.out.println("Enter the length of the box.");
    length = lengthinput.nextDouble();
}

public void getwidth()
{
    Scanner widthinput = new Scanner(System.in);
    System.out.println("Enter the width of the box.");
    width = widthinput.nextDouble();
}

public void getheight()
{
    Scanner heightinput = new Scanner(System.in);
    System.out.println("Enter the height of the box.");
    height = heightinput.nextDouble();
}

public Double getvolume()
{
    volumeofbox = length*width*height;
    return volumeofbox;
}

public static void main(String args[])
{
    Volume box = new Volume();
    Scanner userinput = new Scanner(System.in);

    int timescalculated = 0;
    String choiceyes = "Yes";
    String choiceno = "No";

    box.getlength();
    box.getwidth();
    box.getheight();
    box.getvolume();
    System.out.println("Volume of the box:" + box.getvolume());

    while (timescalculated >= 0)
    {
        System.out.println("Would you like to calculate another box? Enter Yes to continue and No to stop.");
        String choice = userinput.nextLine();

        if (choice.equals(choiceyes))
        {
            box.getlength();
            box.getwidth();
            box.getheight();
            box.getvolume();
            System.out.println("Volume of the box:" + box.getvolume());
        }

        if (choice.equals(choiceno))
        {
            break;
        }
    }
}

}
