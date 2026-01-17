package com.tss.test;

import java.util.Arrays;
import java.util.Scanner;

public class ArraySquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        int[] resultArray = doSquare(array);
        for (int i = 0; i < size; i++) {
            System.out.print(resultArray[i] + " ");
        }
    }
    private static int[] doSquare(int[] array){
        int size = array.length, left = 0, right = size-1, index = right;
        int[] resultArray = new int[size];
        while (left<=right){
            int leftSquare = array[left]*array[left], rightSquare = array[right]*array[right];
            if(leftSquare>rightSquare){
                resultArray[index--] = leftSquare;
                left++;
            }else{
                resultArray[index--] = rightSquare;
                right--;
            }
        }
        return resultArray;
    }

}
