package com.codewithsai;

import java.text.NumberFormat;

public class MortgageReport {

    private  MortgageCalculator mortgageCalculator;

    public MortgageReport(MortgageCalculator mortgageCalculator) {
        this.mortgageCalculator = mortgageCalculator;
    }

    public void printMortgage() {

        Double mortgage = mortgageCalculator.calculateMortgage();
        String formattedMortage = NumberFormat.getCurrencyInstance().format(mortgage);


        System.out.println(" Mortgage ");
        System.out.println("-------------------");

        System.out.println("Your monthly payment is " + formattedMortage);

        System.out.println("-------------------");

        mortgageCalculator.calculateRemainingAmount();
    }
}
