package com.codewithsai;

public class Main {

    public static void main(String[] args) {

        int principal = (int) (ReadingValues.readNumber("Enter Principle value between 1000 and 1_000_000", 1000, 1_000_000));

        //Interest Per Year need to convert to Monthly interest Rate
        float annualInterest = (float) (ReadingValues.readNumber("Enter annualInterest value between 1 and 30", 1, 30));

        //In years
        short period = (short) (ReadingValues.readNumber("Enter period value between 1 and 30", 1, 30));

        MortgageCalculator mortgageCalculator = new MortgageCalculator(principal,annualInterest,period);
        MortgageReport mortgageReport = new MortgageReport(mortgageCalculator);
        mortgageReport.printMortgage();
    }

}
