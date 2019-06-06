package com.coding.interviw.stackAndQueue.animalshelter2;

import java.util.LinkedList;

public class AnimalQueue {
    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    private  int order; // acts as timestamp

    public void enqueue(Animal animal){
        /*Order is used as sort of timestamp, so that we can compare the insertion
        order of a dog to a cat
         */
        animal.setOrder(order);
        order++;

        if(animal instanceof Dog){
            dogs.addLast((Dog) animal);
        }else if(animal instanceof Cat){
            cats.addLast((Cat)animal);
        }
    }

    public Animal dequeueAny(){
        /* Look at tops of dog and cat queues, and pop the queue with the oldest value

         */
        if(dogs.size() == 0){
            return dequeueCats();
        }else if(cats.size() == 0){
            return dequeueDogs();
        }

        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if(dog.isOlderThan(cat)){
            return dequeueDogs();
        }else{
            return dequeueCats();
        }
    }

    public Dog dequeueDogs(){
        return dogs.poll();
    }

    public Cat dequeueCats(){
        return cats.poll();
    }
}
