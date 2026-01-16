package com.tss.test;

import java.util.Scanner;

public class Denominations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxAmount = 50000;
        System.out.println("Enter amount under 50000: ");
        int amount = scanner.nextInt();
        if(amount>maxAmount || amount%100 != 0 || amount<0){
            System.out.println("Amount invalid.");
            return;
        }
        int[] currency = new int[]{2000, 500, 200, 100};
        int[] result = new int[4];
        int index = 0;
        while(amount>0){
            result[index] = amount/currency[index];
            amount %= currency[index++];
//            System.out.println(amount);
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println("denominations of " + currency[i] + " : " + result[i]);
        }
    }
}
