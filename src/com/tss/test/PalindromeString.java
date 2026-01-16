package com.tss.test;

import java.util.Scanner;

public class PalindromeString {
    public static void main(String[] args) {
        String s = new Scanner(System.in).next();
        StringBuilder sb = new StringBuilder("");
        for (int i = s.length()-1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        System.out.println((s.equals(sb.toString()))?"String is palindrome.":"String is not palindrome.");

    }
}
