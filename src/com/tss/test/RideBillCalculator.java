package com.tss.test;

import java.util.Scanner;

public class RideBillCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minHeight = 120;
        System.out.println("Enter height over 120: ");
        int height = scanner.nextInt(), age, billAmount = 0;
        if(height<120){
            System.out.println("Too short.");
            return;
        }
        System.out.println("Enter age: ");
        age = scanner.nextInt();
        if(age<0){
            System.out.println("Invalid age.");
            return;
        }
        if(age<12){
            billAmount +=5;
        }else if(age>=12 && age<18){
            billAmount += 7;
        }else if (age>=18 && age<45){
            billAmount +=12;
        }
        System.out.println("Do you want photos?(Y/N): ");
        boolean iFphoto = scanner.next().charAt(0) == 'Y';
        if(iFphoto){
            billAmount += 3;
        }
        System.out.println("Your bill is: " + billAmount + "$");
    }
}
