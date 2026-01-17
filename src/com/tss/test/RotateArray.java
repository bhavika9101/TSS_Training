package com.tss.test;

import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        int p = scanner.nextInt(); //3
        int[] rotatedArray = doRotate(array, p);
        System.out.println(Arrays.toString(rotatedArray));
    }
    private static int[] doRotate(int[] array, int p){
        int size = array.length;
        int[] rotatedArray = new int[size];
        for (int i = 0; i < size; i++) {
            rotatedArray[(i+p)%size] = array[i];
        }
        return rotatedArray;
    }
}
