package com.tss.test;

import java.util.Scanner;

public class WaterBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long units = sc.nextLong(), meter_charge = 75L, charge;
        if(units <= 100){
            charge = units*5;
        }else if(units <= 250){
            charge = units*10;
        }else {
            charge = units*20;
        }
        System.out.println("Water bill: " + (charge+meter_charge));

    }
}
