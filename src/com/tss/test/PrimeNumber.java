package com.tss.test;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        int x = new Scanner(System.in).nextInt();
        System.out.print(x);
        if(x%2 == 0){
            System.out.println(" is Not prime");
            return;
        }
        for (int i = 3; i < x; i++) {
            if(x%i == 0){
                System.out.println(" is Not prime");
                return;
            }
        }
        System.out.println(" is Prime number");
    }
}
