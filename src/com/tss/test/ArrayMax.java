package com.tss.test;

public class ArrayMax {
    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 10, 5, 1, 10};
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE, maxIndex = -1, secondMaxIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if(max < array[i]){
                max = array[i];
                maxIndex = i;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if(array[i] <= max && array[i] > secondMax && i!=maxIndex){
                secondMax = array[i];
                secondMaxIndex = i;
            }
        }
        System.out.println("Max at index " + maxIndex + " : " + max);
        System.out.println("Second max at index " + secondMaxIndex + " : " +  secondMax);
    }
}
