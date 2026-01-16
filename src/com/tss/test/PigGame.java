package com.tss.test;

import java.util.Random;
import java.util.Scanner;

public class PigGame {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("PIG GAME");
        int gameCount = 1;
        while (true){
            System.out.println("------------------------------");
            System.out.println("Game count: " + gameCount);
            gamePlayer();
            System.out.println("Do you want to play again? (y/n) : ");
            if(!(scanner.next().charAt(0) == 'y')){
                break;
            }
        }
    }
    private static void gamePlayer(){
        int turn = 1, intermediateScore = 0;
        while (turn <= 5){
            System.out.println("-------");
            System.out.println("TURN " + turn);
            System.out.println("Score till now: " + intermediateScore);
            intermediateScore = dieRoller(intermediateScore);
            if(intermediateScore >= 20){
                System.out.println("You won 20 points in " + turn + " turns.");
                return;
            }
            turn++;
        }
        System.out.println("Limit for turns exceeded. You lose.");
    }
    private static int dieRoller(int intermediateScore){
        System.out.println("Roll or Hold (r/h)?: ");
        char choice = scanner.next().charAt(0);
        int randomNumber, currentScore = intermediateScore;

        while (choice == 'r'){
            randomNumber = new Random().nextInt(6)+1;
            System.out.println("Die: " + randomNumber);
            if(randomNumber ==1){
                return intermediateScore;
            }else
                currentScore+=randomNumber;
            if(currentScore >= 20){
                return currentScore;
            }
            System.out.println("Roll or Hold (r/h)?: ");
            choice = scanner.next().charAt(0);
        }
        if(choice != 'h'){
            System.out.println("Invalid move");
            dieRoller(currentScore);
        }
        return currentScore;
    }
}
