/*
@name Danielle Gonzalez-Wu
@date 12/4/2020
@course CSC102
 */
package com.company;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Invoice
{
    private String item;
    private int quantity;
    private double unitprice;
    private double subtotal;
    private double tax;
    private double total;

    public String getitem()
    {
        Scanner iteminput = new Scanner(System.in);
        System.out.println("Enter the name of the purchased item.");
        item = iteminput.nextLine();
        return item;
    }

    public Integer getquantity()
    {
        Scanner quantityinput = new Scanner(System.in);
        System.out.println("Enter the number of units purchased.");
        quantity = quantityinput.nextInt();
        return quantity;
    }

    public Double getunitprice()
    {
        Scanner unitpriceinput = new Scanner(System.in);
        System.out.println("Enter the cost for each individual unit.");
        unitprice = unitpriceinput.nextDouble();
        return unitprice;
    }

    public Double getsubtotal()
    {
        subtotal = quantity*unitprice;
        return subtotal;
    }

    public Double gettax()
    {
        tax = 0.10 * subtotal;
        return tax;
    }

    public Double gettotal()
    {
        total = tax + subtotal;
        return total;
    }


    public static void main (String args[])
    {
        Invoice johnsinvoice = new Invoice();
        DecimalFormat formatter = new DecimalFormat("#0.00");

        String item = johnsinvoice.getitem();
        int quantity = johnsinvoice.getquantity();
        String unitprice = formatter.format(johnsinvoice.getunitprice());
        String subtotal = formatter.format(johnsinvoice.getsubtotal());
        String tax = formatter.format(johnsinvoice.gettax());
        String total = formatter.format(johnsinvoice.gettotal());

        System.out.println("Danielle's Fruit Co.");
        System.out.println("Sales Invoice");
        System.out.println("");
        String heading1 = "Item";
        String heading2 = "Quantity";
        String heading3 = "Unit Price";
        String heading4 = "Subtotal";
        String heading5 = "Tax";
        String heading6 ="Total";
        System.out.printf( "%-15s %-15s %-15s %-15s %-15s %-15s %n", heading1, heading2, heading3, heading4, heading5, heading6);
        System.out.println("___________________________________________________________________________________________________________________");
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %n", item, quantity, unitprice, subtotal, tax, total);
        System.out.println("");
        System.out.println("Thank you for shopping with Danielle's Fruit Co.");
    }
}
