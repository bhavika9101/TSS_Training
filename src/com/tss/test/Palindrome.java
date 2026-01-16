package com.tss.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        int x = new Scanner(System.in).nextInt();
        System.out.print(x);
        System.out.println((rev(x)==x)?" is Palindrome number.":" is Not a palindrome number");
    }
    public static int rev(int n){
        int res = 0;

        while(n>0){
            res = (res*10)+n%10;
            n = n/10;
        }
        return res;
    }
}
