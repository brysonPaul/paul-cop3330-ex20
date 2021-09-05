/*
 *  UCF COP3330 Fall 2021 Assignment 20 Solution
 *  Copyright 2021 Bryson Paul
 */
package org.example;
import java.text.DecimalFormat;
import java.util.Scanner;
public class App {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat d= new DecimalFormat("0.00");
        float taxAmt = 0,subtotal = 0,taxFromOrder = 0;
        float orderPrice = Float.parseFloat(strIO("What is the order amount? ",sc));
        String state = strIO("What state do you live in? ",sc);
        String taxString = "";//used to make this a single output
        if(state.equalsIgnoreCase("Wisconsin") || state.equalsIgnoreCase("WI")){
            taxAmt = (float).05;
            String county = strIO("What county do you live in? ",sc);
            if(county.equalsIgnoreCase("Eau Claire")){
                taxAmt+=.005;
            }
            else if(county.equalsIgnoreCase("Dunn")){
                taxAmt+=.004;
            }
            taxFromOrder = orderPrice*taxAmt;
            taxString = "The tax is $" + d.format(taxFromOrder)+ ".\n";
            subtotal = orderPrice+taxFromOrder;
        }
        else if (state.equalsIgnoreCase("Illinois") || state.equalsIgnoreCase("IL")){
            taxAmt = (float).08;
            taxFromOrder = orderPrice*taxAmt;
            taxString = "The tax is $" + d.format(taxFromOrder)+ ".\n";
            subtotal = orderPrice+taxFromOrder;
        }
        else {
            subtotal=orderPrice;
        }
        System.out.println(taxString + "The total is $"+d.format(subtotal)+".");


    }
    public static String strIO(String input, Scanner sc) {
        System.out.print(input);
        String output = sc.nextLine();
        return output;
    }
}
