/*
@name Danielle Gonzalez-Wu
@date 12/4/2020
@course CSC102
 */

package com.company;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class SortedList {
    public ArrayList<Integer> list = new ArrayList<>();

    public void ListInput() {
        Scanner input = new Scanner(System.in);
        Boolean arrayinput;
        System.out.println("Please enter as many numbers as desired. When finished, type something other than a number to terminate input.");
        while (arrayinput = true) //allows user to input as many numbers as they want and have them sorted
        {
            if ((input.hasNextInt()))
            {
                list.add(input.nextInt());
                int elements = list.size();
                for (int a = 0; a < (elements - 1); a++)  //selection sort is used to sort the numbers from the user input into the right place
                {
                    int minimum_index = a;
                    for (int b = a + 1; b < elements; b++)
                    {
                        if (list.get(b) < list.get(minimum_index))
                        {
                            minimum_index = b;
                        }
                    }
                    //swapping elements to get the sorted list
                    int temp = list.get(minimum_index);
                    list.set(minimum_index, list.get(a));
                    list.set(a, temp);
                    //System.out.println(Arrays.toString(list.toArray())); USED THIS FUNCTION TO ENSURE THAT SELECTION SORT WAS INSERTING THE NEWLY INPUTTED NUMBERS IN THE RIGHT PLACE
                }
            }
            else
            {
                break;
            }
        }
    }

    public ArrayList<Integer> getSortedList()  //return the list formed from the user input
    {
        return list;
    }

    public static void main(String[] args)
    {
        SortedList initialize = new SortedList();
        initialize.ListInput();
        System.out.println("Sorted List:" + initialize.getSortedList()); //printing out the sorted user-inputted list
    }
}
