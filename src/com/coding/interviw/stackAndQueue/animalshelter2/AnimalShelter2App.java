package com.coding.interviw.stackAndQueue.animalshelter2;

public class AnimalShelter2App {

    public static void main(String...args){

        AnimalQueue queue = new AnimalQueue();
        Animal animal1 = new Dog("firulay");
        Animal animal2 = new Cat("miaou");
        Animal animal3 = new Dog("desuis");
        Animal animal4 = new Cat("michou");

        queue.enqueue(animal1);
        queue.enqueue(animal2);
        queue.enqueue(animal3);
        queue.enqueue(animal4);

        Animal  animal5 = queue.dequeueAny();
        Animal  animal6 = queue.dequeueCats();
        Animal  animal7 = queue.dequeueDogs();
    }
}
