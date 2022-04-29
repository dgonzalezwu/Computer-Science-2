/*
@name Danielle Gonzalez-Wu
@date 12/4/2020
@course CSC102
 */

package com.company;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame
{
    private int randomnumber;
    private int guess;

    public int getrandomnumber()
    {
        Random random = new Random();
        randomnumber = random.ints(1,100).findFirst().getAsInt();
        return randomnumber;
    }

    public void playgame()
    {
        Scanner userinput1 = new Scanner(System.in);
        int guessestaken = 0;
        int generatednumber = getrandomnumber();

        while (guessestaken>=0)
        {
            System.out.println("Guess a number between 1 and 100.");
            int guess = userinput1.nextInt();
            guessestaken++;

            if (guess == generatednumber)
            {
                System.out.println("Congratulations, you guessed my number correctly!" + " You guessed it in " + guessestaken + " guesses.");
                break;
            }

            else if (guess < generatednumber)
            {
                System.out.println("Your guess is too low. Try again!");
            }

            else if (guess > generatednumber)
            {
                System.out.println("Your guess is too high. Try again!");
            }

        }

    }

    public static void main(String args[])
    {
        GuessingGame game = new GuessingGame();
        Scanner userinput2 = new Scanner(System.in);
        String choiceyes = "Yes";
        String choiceno = "No";
        int timesplayed = 0;

        System.out.println("Rules of the game: Guess a number between 1 and 100. The game will give you hints to help you get closer to the correct number. When you guess it correctly, you win!");
        System.out.println("");
        game.playgame();

        while (timesplayed >= 0)
        {
            System.out.println("Would you like to play again? Enter Yes or No.");
            String choice = userinput2.nextLine();
            if (choice.equals(choiceyes))
            {
                System.out.println("Rules of the game: Guess a number between 1 and 100. The game will give you hints to help you get closer to the correct number. When you guess it correctly, you win!");
                System.out.println("");
                game.playgame();
            }

            if (choice.equals(choiceno))
            {
                System.out.println("Thank you for playing!");
                break;
            }
        }

    }

}
