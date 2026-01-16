package com.tss.test;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {
    public static void main(String[] args) {
        boolean play = true;
        Scanner scanner = new Scanner(System.in);
        while (play){
            int randomNumber = new Random().nextInt(100)+1;
//            System.out.println(randomNumber);
            int number, attempts = 0;
            for (int i = 0; i < 5; i++) {
                attempts++;
                System.out.println("Guess a number (attempt " + attempts + "): ");
                number = scanner.nextInt();
                if(number<randomNumber){
                    System.out.println("Sorry, Too low");
                } else if (number>randomNumber) {
                    System.out.println("Sorry, Too high");
                }else {
                    System.out.println("Correct! You guessed number in " + attempts + " attempts.");
                    break;
                }
                if(attempts == 5){
                    System.out.println("Attempts exhausted. The number is " + randomNumber);
                }

            }
            System.out.println("Do you want to play again? (Y/N)?: ");
            play = !(scanner.next().charAt(0) == 'N');
        }
        System.out.println("Game end.");
    }
}
