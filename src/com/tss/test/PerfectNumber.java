package com.tss.test;

import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
        int x = new Scanner(System.in).nextInt(), s = 0;
        for(int i = 1; i<x; i++){
            if(x%i == 0)
                s += i;
        }
        System.out.print(x);
        System.out.print((s==x)?" is a perfect number.":" is not a perfect number.");
    }
}
