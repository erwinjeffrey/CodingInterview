package com.coding.interviw.bitmanipulation;

public class BitManipulationApp {

    public static void main(String[] args) {

        System.out.println(shiftingLeft(10));
        countOnes(5);
    }

    private static int countOnes(int x){

        // just for testing
        String binary = Integer.toBinaryString(x);
        int sum = 0;

        while(x > 0){
            sum += x % 2;
            x >>= 1;
        }
        return sum;
    }

    // by shifting left we are essencially multiplying our original number by 2
    private static int shiftingLeft(int x){
        return x<<1;
    }
}
