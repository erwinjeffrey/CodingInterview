package com.coding.interviw.stackAndQueue.animalshelter;

import java.util.LinkedList;

public class AnimalShelterApp {

    public static void main(String...args){
        AnimalShelterList animalShelterList = new AnimalShelterList();

        Animal cat = new Cat("miaou");
        animalShelterList.enqueue(cat);
        Animal cat2 = new Cat("michou");
        animalShelterList.enqueue(cat2);


        Animal dog = new Dog("Desuis");
        animalShelterList.enqueue(dog);
        Animal dog2 = new Dog("Puti");
        animalShelterList.enqueue(dog2);
        Animal dog3 = new Dog("Suni");
        animalShelterList.enqueue(dog3);


       Animal animal = animalShelterList.dequeueAny();

        Dog  dog1 = animalShelterList.dequeueDog();

        Cat cat3 = animalShelterList.dequeueCat();

    }
}
