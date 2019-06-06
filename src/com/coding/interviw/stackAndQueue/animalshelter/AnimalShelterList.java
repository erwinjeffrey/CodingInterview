package com.coding.interviw.stackAndQueue.animalshelter;

public class AnimalShelterList {

    private AnimalNode first;
    private  AnimalNode last;

    int position = 0;

    public void enqueue(Animal animal){
        AnimalNode newNode = new AnimalNode(animal);
        if(last != null) {
            last.next = newNode;
        }
        last = newNode;
        if(first == null){
            first = last;
        }
    }

    public Animal dequeueAny(){
        Animal animal = first.animal;
        first = first.next;
        return animal;
    }

    public Dog dequeueDog(){
        AnimalNode currentAnimal = first;


        while(currentAnimal != null){
            if(currentAnimal.animal instanceof  Dog){
                deleteNode(position);

                position = 0;
                return (Dog) currentAnimal.animal;
            }
            currentAnimal = currentAnimal.next;
            position++;
        }
        return null;
    }

    public Cat dequeueCat(){
        AnimalNode currentAnimal = first;
        while(currentAnimal != null){
            if(currentAnimal.animal instanceof  Cat){
                deleteNode(position);

                position = 0;
                return (Cat) currentAnimal.animal;
            }
            currentAnimal = currentAnimal.next;
            position++;
        }
        return null;
    }

    private void deleteNode(int position){
        // If linked list is empty
       if(first == null){
           return;
       }
       // Store head node
       AnimalNode temp = first;

       // if head needs to be removed
       if(position == 0){
           first = temp.next;
           return;
       }

       // find previous node of the node to be deleted
        for (int i = 0; temp != null &&  i < position -1; i++) {
            temp = temp.next;
        }

        // If position is more than number of ndoes
        if(temp == null || temp.next == null){
           return;
        }

        // Node temp -> next is the node to be deleted
        // Store pointer to the next of node to be deleted
        AnimalNode next = temp.next.next;

        temp.next = next;//Unlink the deleted node from list

    }

    public AnimalNode getFirst() {
        return first;
    }
}
