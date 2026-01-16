package com.tss.test;

import java.util.ArrayList;
import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        int x = new Scanner(System.in).nextInt(), sum = 0;
        ArrayList<Integer> al = count(x);
        for (int i = 0; i < al.size(); i++) {
            sum += (int) Math.pow(al.get(i), al.size());
        }
        System.out.print(x);
        System.out.println((sum == x)?" is Armstrong number":"is Not armstrong number");
    }
    public static ArrayList<Integer> count(int n){
        ArrayList<Integer> al = new ArrayList<>();
        while(n>0){
            al.add(n%10);
            n = n/10;
        }
        return al;
    }
}
