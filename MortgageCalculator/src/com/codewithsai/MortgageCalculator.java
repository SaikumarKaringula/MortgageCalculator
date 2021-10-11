package com.codewithsai;

import java.text.NumberFormat;

public class MortgageCalculator {
    private int principal;
    private float annualInterestRate;
    private short period;


    public MortgageCalculator(int principal, float annualInterestRate, short period) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.period = period;
    }

    public double calculateMortgage(){

        double monthlyInterest = getMonthlyInterest();
        double noOfPayments = getNoOfPayments(period, Constants.MONTHS_IN_YEAR);

        double mortgage = (principal)
                * (getNoOfPayments(monthlyInterest, Math.pow(1+monthlyInterest, noOfPayments)))
                / ((Math.pow(1+monthlyInterest, noOfPayments)-1));
        return mortgage;
    }

    public double calculateRemainingAmount(){


        double monthlyInterest = getMonthlyInterest();
        double noOfPayments = getNoOfPayments(period, Constants.MONTHS_IN_YEAR);

        int noOfPaymentsMade = 1;

         double balance = principal;
        while(balance > 0 ){
             balance = principal
                    * (Math.pow(1+monthlyInterest, noOfPayments)
                    - Math.pow(1 + monthlyInterest, noOfPaymentsMade))
                    /((Math.pow(1+monthlyInterest, noOfPayments))-1);
            System.out.println(" Balance : " + NumberFormat.getCurrencyInstance().format(balance));
            noOfPaymentsMade += 1;
        }
        return balance;
    }

    private float getMonthlyInterest() {
        return (annualInterestRate / Constants.PERCENT) / Constants.MONTHS_IN_YEAR;
    }

    private double getNoOfPayments(double period, double monthsInYear) {
        return period * monthsInYear;
    }

}
