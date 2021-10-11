package com.codewithsai;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte PERCENT = 100;
    final static byte MONTHS_IN_YEAR = 12;

    public static void main(String[] args) {

        int principal = ( int) ( readNumber("Enter Principle value between 1000 and 1_000_000", 1000, 1_000_000));

        //Intrest Per Year need to convert to Monthly intrest Rate
        float annualInterest = ( float ) ( readNumber("Enter annualInterest value between 1 and 30", 1, 30));

        //In years
        short period = ( short ) ( readNumber("Enter period value between 1 and 30", 1, 30));;


        Double mortgage = calculateMortgage(principal, annualInterest, period);
        String formattedMortage = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println(" Mortgage ");
        System.out.println("-------------------");

        System.out.println("Your monthly payment is " +formattedMortage);

        System.out.println("-------------------");

        calculateRemainingAmount(principal, annualInterest, period );

    }
    public static double readNumber(String prompt, int min, int max){
        double value = 0;
        System.out.println(prompt);
        while(true) {
            Scanner scanner = new Scanner(System.in);
            value = scanner.nextDouble();
            if (value > min && value <= max)
                break;
          System.out.println("Enter the value between  " +min +" and " +max);
        }

        return value;
    }
    public static double calculateMortgage(int principal, float annaualIntrestRate, short period){

        double monthlyInterest = ( annaualIntrestRate/PERCENT)/MONTHS_IN_YEAR;
        int noOfPayments = period * MONTHS_IN_YEAR;

        double mortgage = (principal)
                * ( monthlyInterest * Math.pow(1+monthlyInterest, noOfPayments))
                / ((Math.pow(1+monthlyInterest, noOfPayments)-1));
        return mortgage;
    }
    public static void calculateRemainingAmount(int principal, double annaualIntrestRate,int period ){


        double monthlyInterest = ( annaualIntrestRate/PERCENT)/MONTHS_IN_YEAR;
        int noOfPayments = period * MONTHS_IN_YEAR;

        int noOfPaymentsMade = 1;

        double balance = principal;
        while(balance > 0 ){
            balance = principal
                    * (Math.pow(1+monthlyInterest, noOfPayments)
                    - Math.pow(1 + monthlyInterest, noOfPaymentsMade))
                    /((Math.pow(1+monthlyInterest, noOfPayments))-1);
            System.out.println(" Balance : " +NumberFormat.getCurrencyInstance().format(balance));
            noOfPaymentsMade += 1;
        }
    }
}
