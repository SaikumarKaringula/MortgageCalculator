package com.codewithsai;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int principal = ( int) ( readNumber("Enter Principle value", 1000, 1_000_000));
        float annualInterest = ( float ) ( readNumber("Enter annualInterest value", 1, 30));
        short period = ( short ) ( readNumber("Enter period value", 1, 30));;

        Double mortgage = calculateMortgage(principal, annualInterest, period);
        String formattedMortage = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Your monthly payment is " +formattedMortage);

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
        final byte PERCENT = 100;
        final byte MONTHS_IN_YEAR = 12;

        double monthlyInterest = ( annaualIntrestRate/PERCENT)/MONTHS_IN_YEAR;
        int noOfPayments = period* MONTHS_IN_YEAR;

        double mortgage = (principal)
                * ( monthlyInterest * Math.pow(1+monthlyInterest, noOfPayments))
                / ((Math.pow(1+monthlyInterest, noOfPayments)-1));
        return mortgage;
    }
}
