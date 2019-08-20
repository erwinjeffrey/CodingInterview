package com.coding.interviw.mathandlogicpuzzle;

public class MathAndLogicPuzzle {

    public static void main(String[] args) {
        boolean[] result = sieveOfEratosthenes(10);
    }

    //Generating a List of Primes: The Sieve of Eratosthenes
    private static boolean [] sieveOfEratosthenes(int max){
        boolean [] flags = new boolean[max + 1];
        int count = 0;

        init(flags); //Set all flags to true other than 0 and 1
        int prime = 2;
         while(prime <= Math.sqrt(max)){

             //Cross off remaining multiples of prime
             crossOff(flags,prime);

             //Find next value which is true
             prime = getNextPrime(flags, prime);
         }
         return flags;
    }

    static void crossOff(boolean[] flags, int prime){
        /* Cross off remaining multiples of prime. We can start with (prime*prime),
        * because if we have a k * prime, where k < prime, this value would have
        * already been crossed off in a prior iteration. */
        for (int i = prime * prime; i < flags.length; i+= prime) {
            flags[i] = false;
        }
    }

    static int getNextPrime(boolean[] flags, int prime){
        int next = prime + 1;
        while (next < flags.length  && !flags[next]){
            next++;
        }
        return next;
    }
    static void init(boolean [] flags){
        for (int i = 2; i < flags.length ; i++) {
            flags[i] = true;
        }
    }
}
