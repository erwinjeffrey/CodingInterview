package com.coding.interviw.javaeight;

public class DefaultMethod {

    public static void main(String[] args) {
        Vehicule vehicule = new Car();
        vehicule.print();
    }

}

interface  Vehicule{
    default void print(){
        System.out.println("I  am a vehicule !");
    }

    static void blowHorn(){
        System.out.println("Blowing horn!!!");
    }
}

interface FourWheeler{
    default void print(){
        System.out.println("I am a four wheeler!");
    }
}

class Car implements Vehicule, FourWheeler{
    public void print(){
        Vehicule.super.print();
        FourWheeler.super.print();
        Vehicule.blowHorn();
        System.out.println("I am a car");
    }
}