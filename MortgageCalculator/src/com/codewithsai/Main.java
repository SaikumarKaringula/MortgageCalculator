package com.codewithsai;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal = 0;
        float annualInterest = 0.0F;
        int period = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Principle : ");
        while(true) {
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter Principal value between 1000 and 1,000,000: ");
        }

        System.out.println("Annual Interest Rate : ");
        while(true) {
            annualInterest = scanner.nextFloat();
            if(annualInterest > 0 && annualInterest <= 30 )
                break;
            System.out.println("Enter annual interest rate between 0 and 30 : ");
        }
        System.out.println("Period (Years) :");
        while (true) {
            period = scanner.nextInt();
            if (period > 0 && period <= 30 )
                break;
            System.out.println(" Enter Period (Years) between 0 and 30:");
        }
        int totalMonths = period* MONTHS_IN_YEAR;
        double monthlyInterest = (annualInterest/PERCENT)/MONTHS_IN_YEAR;

        //Added comment
        double mortgage = (principal)
                            * ( monthlyInterest * Math.pow(1+monthlyInterest, totalMonths))
                            / ((Math.pow(1+monthlyInterest, totalMonths)-1));

        String mortgaeFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage : " + mortgaeFormatted);

    }
}
