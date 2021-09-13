package com.codewithsai;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Principal : ");
        long principal = scanner.nextLong();

        System.out.println("Annual Intrest Rate : ");
        float annualInterest  = scanner.nextFloat();

        System.out.println(" Period (Years) :");
        int period = scanner.nextInt();
        int totalMonths = period* MONTHS_IN_YEAR;
        double monthlyInterest = (annualInterest/PERCENT)/MONTHS_IN_YEAR;

        double mortgage = (principal)
                            * ( monthlyInterest * Math.pow(1+monthlyInterest, totalMonths))
                            / ((Math.pow(1+monthlyInterest, totalMonths)-1));

        String mortgaeFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage : " + mortgaeFormatted);

    }
}
