/*
@name Danielle Gonzalez-Wu
@date 12/4/2020
@course CSC102
 */

package com.company;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class lab5
{
    //I am choosing an Array List to read the strings and store them, as an Array Lists is not a fixed size and can accomodate for adding/deleting new strings and other adjustments much easier than an array would
    static ArrayList<String> names = new ArrayList<>();
    static int index;


    //Reading file in with original String information in
    public static void readfile() throws java.io.FileNotFoundException
    {
        System.out.println(new File("").getAbsolutePath());

        Scanner namestxtfile = new Scanner(new File("lab5.txt"));

        while (namestxtfile.hasNext())
        {
            names.add(namestxtfile.next());
        }

    }

    public static void alphanumericbubblesort(ArrayList<String> list)
    {
        //This is where the sorting starts in this case we are using Bubble Sort
        int elements = list.size();
        for (int a = 0; a < (elements - 1); a++)
        {
            for (int b = 0; b < (elements - a - 1); b++)
            {
                if ((list.get(b)).compareToIgnoreCase(list.get(b+1)) > 0) //part where we change so it can process alphanumeric numbers. I flipped the comparator around as alphabet sorts in ascending order due to the way ASCII processes it to numerical values.
                {
                    //If they are bigger, it will swap
                    String temp = list.get(b);
                    list.set(b, list.get(b+1));
                    list.set(b+1, temp);
                }
            }
        }
    }

    //Allowing the user to add in additional strings to the list if they want to
    public static void addtolist(ArrayList<String> list)
    {
        Scanner input = new Scanner(System.in);
        Boolean arrayinput;
        System.out.println("Please enter as many names as desired. When finished, type in any integer number to terminate input.");
        while (arrayinput = true)
        {
            if (input.hasNextInt())
            {
                break;
            }

            if ((input.hasNext()))
            {
                list.add(input.next());
                //this is where sorting starts in this case we are using a Bubble Sort
                //Decided to use bubble sort as the list that is being read in has less than 15 elements. For lists with less than 100 elements, searching iteratively such as with bubble sort is best time-wise and memory efficient. For lists over 100 elements, recursively is quicker such as merge sort but more memory intensive.
                int elements = list.size();
                for (int a = 0; a < (elements - 1); a++)
                {
                    for (int b = 0; b < (elements - a - 1); b++)
                    {
                        if ((list.get(b)).compareToIgnoreCase(list.get(b+1)) > 0)
                        {
                            //swapping if they are bigger here
                            String temp = list.get(b);
                            list.set(b, list.get(b+1));
                            list.set(b+1, temp);
                        }
                    }
                    //System.out.println(Arrays.toString(list.toArray()));
                }
            }
        }
    }

    //Allowing the user to search for a String in the list
    public static int searchlist(ArrayList <String> list, String key, int low, int high)//binary search iteratively as to not take up too much memory. The key is what we're searching for
    {
        index = -1; //return this if they can't find the value as this index can not exist in an array

        while (low <= high)
        {
            int mid = (low+high) / 2;
            if ((list.get(mid)).compareToIgnoreCase(key) < 0)      //adjusting comparisons to ASCII Strings so it searches correctly with the way it assigns numerical values to the String
            {
                low = mid + 1;
            }
            else if ((list.get(mid)).compareToIgnoreCase(key) > 0) //adjusting comparisons to ASCII Strings so it searches correctly with the way it assigns numerical values to the String
            {
                high = mid-1;
            }
            else if ((list.get(mid)).compareToIgnoreCase(key) == 0) //adjusting comparisons to ASCII Strings so it searches correctly with the way it assigns numerical values to the String
            {
                index = mid;
                break;
            }
        }
        return index;
    }

    //Allowing the user to edit Strings present on the list by changing it
    public static void replacename(String original, String replacement)
    {
        if (searchlist(names, original,0, names.size()) >= 0)
        {
            names.set(index,replacement);
            alphanumericbubblesort(names); //sorting list back to alphanumeric order after it is set to the new name
        }
        else
        {
            System.out.println("That name does not exist in this list, please add to list instead.");
        }
    }

    //Allowing the user to remove names off the list
    public static void removename(String deletename)
    {
        if (searchlist(names, deletename,0, names.size()) >= 0)
        {
            names.remove(index);
        }
        else
        {
            System.out.println("That name does not exist in this list, please add to list instead.");
        }
    }

    public static void clearnameslist() throws java.io.FileNotFoundException //saving the updated names list to the same file by clearing out initial content and then adding in new ones
    {
        PrintWriter clearer = new PrintWriter("lab5.txt");
        clearer.print("");
        clearer.close();
    }

    public static void savenameslist() throws java.io.FileNotFoundException //way to save the names list after user edits it back to file for next use
    {
        clearnameslist();
        PrintWriter saver = new PrintWriter("lab5.txt");
        for (int d = 0; d < (names.size()); d++)
        {
            saver.println(names.get(d));
        }

        saver.close();
    }

    public static void main(String [] args) throws java.io.FileNotFoundException
    {
       readfile();
       alphanumericbubblesort(names);

       Boolean menu;
       Scanner userinput = new Scanner(System.in);
       int choice1 = 1;
       int choice2 = 2;
       int choice3 = 3;
       int choice4 = 4;
       int choice5 = 5;
       int choice6 = 6;

       while (menu = true)
        {
            System.out.printf("Please type in the number of the option you want: %n" + "1. Enter Additional Names %n"  + "2. Search for a name %n" + "3. Remove a name from list %n" + "4. Replace an original name with new name %n" + "5. Save Modified Data to File %n" + "6. Terminate Process %n");
            int choice = userinput.nextInt();

            if (choice == choice1) //Enter additional names
            {
                addtolist(names);
            }

            if (choice == choice2) // Search for a name in the list
            {
                Scanner userinput2 = new Scanner(System.in);
                System.out.println("Please type in the name to be searched for.");
                String nametbs = userinput2.next(); //to be searched
                if (searchlist(names, nametbs, 0, names.size()) >= 0)
                {
                    System.out.println(nametbs + " is present.");
                }
                else
                {
                    System.out.println(nametbs + " is not present.");
                }
            }

            if (choice == choice3) //Remove a name from the list
            {
                Scanner userinput3 = new Scanner(System.in);
                System.out.println("Please type the name to be removed in.");
                String nametbd = userinput3.next();  //to be deleted
                removename(nametbd);
            }

            if (choice == choice4) //Replace a name in the list with a different name
            {
                Scanner userinput4 = new Scanner(System.in);
                System.out.println("Please type in the original name that you want to be replaced.");
                String nametbr = userinput4.next(); //to be replaced
                System.out.println("Please type in the new name to replace the original.");
                String nametro = userinput4.next(); //to replace the original
                replacename(nametbr, nametro);
                //System.out.println(Arrays.toString(names.toArray())); //testing to make sure this is okay
            }

            if (choice == choice5) //Save modified data to file
            {
                savenameslist();
            }

            if (choice == choice6) //Terminate the program
            {
                break;
            }
        }
    }
}
