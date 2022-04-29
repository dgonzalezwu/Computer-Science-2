/*
@name Danielle Gonzalez-Wu
@date 12/4/2020
@course CSC102
 */

package com.company;
import java.io.File;
import java.util.Objects;
import java.util.Scanner;
import java.io.PrintWriter;

public class lab9
{
    static void clearnameslist() throws java.io.FileNotFoundException //saving the updated names list to the same file by clearing out initial content and then adding in new ones
    {
        PrintWriter clearer = new PrintWriter("bankaccounts.txt");
        clearer.print("");
        clearer.close();
    }

    interface TransactionsInterface
    {
        void deposit();
        void withdrawal();
        void checkBalance();
    }

    public class node
    {
        //Linked List pointer node
        public node next;
        //Bank Account Records Data
        public String username;
        public String password;
        public String savingsaccounttype;
        public String checkingaccounttype;
        public Double savingsbalance;
        public Double checkingbalance;

        node()
        {
            next = null;
        }

        node(String a, String b, String c, Double d, String e, Double f)
        {
            username = a;
            password = b;
            savingsaccounttype = c;
            savingsbalance = d;
            checkingaccounttype = e;
            checkingbalance = f;
            next = null;
        }

    }

    //Variables to be used by all classes for memory and login verifications
    node first = new node();
    node userbankaccount;
    Boolean check1;
    Boolean check2;

    //Data Structure to hold the Bank Account information and add new accounts with exceptions if needed
    public class LinkedList
    {

        void addFirst(String a, String b, String c, Double d, String e, Double f)
        {
            if (first.next == null) //case: list is empty
            {
                first.next = new node(a, b, c, d, e, f);
            }
            else //case: list is not empty at least one node on the list
            {
                node newnode = new node(a, b, c, d, e, f); //allocating memory for the new node
                newnode.next = first.next; //changing new node pointer from null to what the first.next is pointing to
                first.next = newnode; //changing what the first node pointer is pointing to previously to where the new node information is pointing to
            }
        }

        void addLast(String a, String b, String c, Double d, String e, Double f)
        {
            if (first.next == null)
            {
                first.next = new node(a, b, c, d, e, f);
            }
            else
            {
                node temp = first.next;
                while (temp.next != null)
                {
                    temp = temp.next;
                }
                node newnode = new node(a, b, c, d, e, f);
                newnode.next = temp.next;
                temp.next = newnode;
            }
        }

        void removeFirst()
        {
            try
            {
                if (first.next == null) //case: list is empty
                {
                    //Making exception here to let the user know no accounts exist according to file
                    throw new NullPointerException();

                }
                else //case: list is not empty at least one node on the list
                {
                    node temp = first.next; //creating a temporary node that points to where the first node is also pointing to
                    first.next = temp.next; //moving the first node's pointer to the next node pointer effectively removing the original head from the list
                }
            }
            catch(NullPointerException exception)
            {
                System.out.println(exception + ":" + " The list is empty, so there is nothing to remove.");
            }
        }

        void getFirst() //custom exception
        {
            try
            {
                if (first.next == null) //case: list is empty
                {
                    //Making exception here to let the user know no accounts exist according to file
                    throw new NullPointerException();

                }
                else //case: list is not empty at least one node on the list
                {
                    System.out.println("Username: " + first.next.username); //printing out the data for the element in the first node (accompanying train car on list)
                    System.out.println("Password: " + first.next.password);
                    System.out.println("Account Type: " + first.next.savingsaccounttype);
                    System.out.println(first.next.savingsaccounttype + " Balance: " + first.next.savingsbalance);
                    System.out.println("Account Type: " + first.next.checkingaccounttype);
                    System.out.println(first.next.checkingaccounttype + " Balance: " + first.next.checkingbalance);
                }
                return;
            }
            catch(NullPointerException exception)
            {
                System.out.println(exception + ":" + " The list is empty, so there is nothing to return.");
            }
        }

        void FindUsername(String usernametobesearchedfor) //way to initiate a log in process
        {
            String userfound;
            try
            {
                if (first.next == null) //case: list is empty
                {
                    //Making exception here to let the user know no accounts exist according to file
                    throw new NullPointerException();
                }
                else //case: list is not empty at least one node on the list
                {
                    node temp = first.next; //creating a temporary node that points to where the first node is also pointing to
                    while (temp != null && !Objects.equals(temp.username, usernametobesearchedfor))
                    {
                        temp = temp.next;
                    }
                    if (temp == null)
                    {
                        System.out.println("The username is not present on the list.");
                        check1 = false;
                    }
                    else
                    {
                        userfound = temp.username;
                        userbankaccount = temp; //setting the user bank account node to the area where the data for this bank account is located
                        System.out.println("The username " + userfound + " is present on the list.");
                        check1 = true;
                    }
                }
            }
            catch(NullPointerException exception)
            {
                System.out.println(exception + ":" + " The list is empty, so there are not usernames present on the list.");
            }
        }

        void validatepassword(String passwordtobevalidated) //way to validate the log in process and allow for transactions
        {
            if (userbankaccount.password.equals(passwordtobevalidated))
            {
                System.out.println("The password is correct, you are authorized to perform transactions on this bank account.");
                check2 = true;
            }
            else
            {
                System.out.println("The password is incorrect, you are unauthorized to perform transactions on this bank account.");
                check2 = false;
            }
        }

        void savefile() throws java.io.FileNotFoundException
        {
            clearnameslist();
            PrintWriter saver = new PrintWriter("bankaccounts.txt");

            try
            {
                if (first.next == null) //case: list is empty
                {
                    //MAKE EXCEPTION HERE TO LET THEM KNOW THERE IS NOTHING ON THE LIST
                    throw new NullPointerException();
                }
                else //case: list is not empty at least one node on the list
                {
                    node temp = first.next; //creating a temporary node that points to where the first node is also pointing to
                    while (temp != null)
                    {
                        //this is where we will save our data
                        saver.println(temp.username);
                        saver.println(temp.password);
                        saver.println(temp.savingsaccounttype);
                        saver.println(temp.savingsbalance);
                        saver.println(temp.checkingaccounttype);
                        saver.println(temp.checkingbalance);
                        saver.println();
                        temp = temp.next;
                    }
                    System.out.println("The data has been successfully saved to the file.");
                }
            }
            catch(NullPointerException exception)
            {
                System.out.println(exception + ":" + " The list is empty, so there is nothing to save.");
            }
            saver.close();
        }
    }

    public class CheckingAccounts implements TransactionsInterface
    {
        public void deposit()
        {
            Scanner checkingdepositinput = new Scanner(System.in);
            System.out.println("Please input the amount you would like to deposit into your checking account. For example, if inputting $10, put 10.00.");
            Double tobeadded = checkingdepositinput.nextDouble();
            Double initial = userbankaccount.checkingbalance;
            Double amountpostdeposit = initial + tobeadded;
            userbankaccount.checkingbalance = amountpostdeposit;
        }

        public void withdrawal()
        {
            Scanner checkingwithdrawalinput = new Scanner(System.in);
            System.out.println("Please input the amount you would like to withdraw from your checking account. For example, if inputting $10, put 10.00.");
            Double tobesubtracted = checkingwithdrawalinput.nextDouble();
            Double initial = userbankaccount.checkingbalance;
            Double amountpostwithdrawal = initial - tobesubtracted;
            userbankaccount.checkingbalance = amountpostwithdrawal;
        }

        public void checkBalance()
        {
            System.out.println("Your Checking Account Balance is: " + userbankaccount.checkingbalance);
        }
    }

    public class SavingsAccounts implements TransactionsInterface
    {
        public void deposit()
        {
            Scanner savingsdepositinput = new Scanner(System.in);
            System.out.println("Please input the amount you would like to deposit into your savings account. For example, if inputting $10, put 10.00.");
            Double tobeadded = savingsdepositinput.nextDouble();
            Double initial = userbankaccount.savingsbalance;
            Double amountpostdeposit = initial + tobeadded;
            userbankaccount.savingsbalance = amountpostdeposit;
        }

        public void withdrawal()
        {
            Scanner savingswithdrawalinput = new Scanner(System.in);
            System.out.println("Please input the amount you would like to withdraw from your savings account. For example, if inputting $10, put 10.00.");
            Double tobesubtracted = savingswithdrawalinput.nextDouble();
            Double initial = userbankaccount.savingsbalance;
            Double amountpostwithdrawal = initial - tobesubtracted;
            userbankaccount.savingsbalance = amountpostwithdrawal;
        }

        public void checkBalance()
        {
            System.out.println("Your Savings Account Balance is: " + userbankaccount.savingsbalance);
        }
    }

    public static void main(String [] args) throws java.io.FileNotFoundException
    {
        //Initializing the classes to be used
        lab9 outer = new lab9();
        lab9.LinkedList innerll = outer.new LinkedList();
        lab9.CheckingAccounts innerca = outer.new CheckingAccounts();
        lab9.SavingsAccounts innersa = outer.new SavingsAccounts();


        //Initializing variables
        String usernamefromfile = null;
        String passwordfromfile = null;
        String savingsaccounttypefromfile = null;
        Double savingsbalancefromfile = null;
        String checkingaccounttypefromfile = null;
        Double checkingbalancefromfile = null;


        //This is where it will read in the file for the bank accounts
        Scanner bankaccountstxtfile = new Scanner(new File("bankaccounts.txt"));
        int x = 0;
        while (bankaccountstxtfile.hasNext())
        {
            while (x < 6)
            {
                if (bankaccountstxtfile.hasNextDouble())
                {
                    if (x == 3)
                    {
                        savingsbalancefromfile = bankaccountstxtfile.nextDouble();
                    }
                    if (x == 5)
                    {
                        checkingbalancefromfile = bankaccountstxtfile.nextDouble();
                    }
                }

                if (bankaccountstxtfile.hasNext())
                {
                    if (x == 0)
                    {
                        usernamefromfile = bankaccountstxtfile.next();
                    }

                    if (x == 1)
                    {
                        passwordfromfile = bankaccountstxtfile.next();
                    }

                    if (x == 2)
                    {
                        savingsaccounttypefromfile = bankaccountstxtfile.next();
                    }

                    if (x == 4)
                    {
                        checkingaccounttypefromfile = bankaccountstxtfile.next();
                    }
                }
                x++;
            }
            innerll.addLast(usernamefromfile, passwordfromfile, savingsaccounttypefromfile, savingsbalancefromfile, checkingaccounttypefromfile, checkingbalancefromfile);
            x = 0; //resetting for loop for next account items
        }

        Boolean loginmenu;
        Boolean selectionmenu;
        Scanner userinput = new Scanner(System.in);
        int choice1 = 1;
        int choice2 = 2;
        int choice3 = 3;
        int choice4 = 4;
        int checking = 1;
        int savings = 2;
        boolean logoff = false;
        //This is where the menu for customers to log in and execute transactions will be
        //Ask for the username
        while (loginmenu = true)
        {
            if (logoff == false)
            {
                System.out.println("Please input your username.");
                String inputtedusername = userinput.next();
                innerll.FindUsername(inputtedusername);
            }
            if (logoff == true)
            {
                break;
            }
            if (outer.check1 == true )
            {
                //Ask for the password
                System.out.println("Please input your password.");
                String inputtedpassword = userinput.next();
                innerll.validatepassword(inputtedpassword);
                if (outer.check2 == true)
                {
                    //Give them the options (1. deposit, 2. withdraw, 3. check Balance, 4. Exit Menu and Log off)
                    while (selectionmenu = true)
                    {
                        System.out.printf("Please type in the number of the option you want: %n" + "1. Deposit Money %n"  + "2. Withdraw Money %n" + "3. Check Balance %n" + "4. Exit Menu and Log off %n");

                        Integer choice = userinput.nextInt();
                        if (choice == choice1)
                        {
                            System.out.printf("Please type in the number of the bank account you want to perform this action on: %n" + "1. Checking %n"  + "2. Savings %n");
                            Integer cc1 = userinput.nextInt();
                            if (cc1 == checking)
                            {
                                innerca.deposit();
                                innerca.checkBalance();
                            }
                            if (cc1 == savings)
                            {
                                innersa.deposit();
                                innersa.checkBalance();
                            }
                        }
                        if (choice == choice2)
                        {
                            System.out.printf("Please type in the number of the bank account you want to perform this action on: %n" + "1. Checking %n"  + "2. Savings %n");
                            Integer cc2 = userinput.nextInt();
                            if (cc2 == checking)
                            {
                                innerca.withdrawal();
                                innerca.checkBalance();
                            }
                            if (cc2 == savings)
                            {
                                innersa.withdrawal();
                                innersa.checkBalance();
                            }
                        }
                        if (choice == choice3)
                        {
                            System.out.printf("Please type in the number of the bank account you want to perform this action on: %n" + "1. Checking %n"  + "2. Savings %n");
                            Integer cc3 = userinput.nextInt();
                            if (cc3 == checking)
                            {
                                innerca.checkBalance();
                            }
                            if (cc3 == savings)
                            {
                                innersa.checkBalance();
                            }
                        }
                        if (choice == choice4)
                        {
                            logoff = true;
                            break;
                        }

                    }
                }
                if (outer.check2 == false)
                {
                }

            }
            if(outer.check1 == false)
            {
            }
        }
        //This is where the saving of the files will be
        innerll.savefile();
    }
}
