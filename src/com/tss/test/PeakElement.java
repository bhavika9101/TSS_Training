package com.tss.test;

public class PeakElement {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 4, 2};
        int peak = array[0];
        for (int i = 1; i < array.length-1; i++) {
            if(array[i] >= array[i-1] && array[i]>= array[i+1])
                peak = array[i];
        }
        System.out.println(peak);
    }
}
