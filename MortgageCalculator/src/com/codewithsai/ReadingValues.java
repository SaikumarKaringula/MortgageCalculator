package com.codewithsai;

import java.util.Scanner;

public class ReadingValues {
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
}
