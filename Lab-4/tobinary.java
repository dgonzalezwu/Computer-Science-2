package com.company;

import java.util.Scanner;

public class tobinary
{
  public static int decimaltobinary(int n)
  {
      if (n==0)    //making base case 0 because to convert to decimal to binary you must divide by 2 until the quotient is 0
          return 0;
      else
      {
          return (n % 2 + 10 * decimaltobinary(n/ 2)); //multiplies by 10 to increment the bit by one way each time to form the whole bit list
      }
  }

  public static void main(String[] args)
  {
      Scanner userinput = new Scanner(System.in);
      System.out.println("Please type in the integer to be converted to binary.");
      int integerinput = userinput.nextInt();
      System.out.println("Binary: " + decimaltobinary(integerinput));
  }
}