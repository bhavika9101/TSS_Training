package com.tss.test;

import java.util.Scanner;

public class ArrayProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        int product = 1;
        int zeroCount = 0;
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
            if(array[i] == 0){
                zeroCount++;
                if (zeroCount>1){
                    product *= array[i];

                }
                continue;
            }
            product *= array[i];
        }
        int[] prod  = doProduct(array, product, zeroCount);

        for (int i = 0; i < size; i++) {
            System.out.print(prod[i] + " ");
        }
    }
    private static int[] doProduct(int[] array, int product, int zeroCount){
        int size = array.length;
        int[] prod= new int[size];
        for (int i = 0; i < size; i++) {
            if(array[i] != 0){
                if(zeroCount > 0){
                    continue;
                }
                prod[i] = product/array[i];
            }else {
                prod[i] = product;
            }
        }
        return prod;
    }
}
