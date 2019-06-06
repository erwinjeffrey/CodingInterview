package com.coding.interviw.stackAndQueue;

public class QueueArray {

    private int maxSize;
    private  char[] queueArray;
    private int front; // index position for the element in the front
    private int rear; //position for the element at the back of the line
    private int nItems; // counter to maintain the number of items in our queue

    public QueueArray(int size){
        this.maxSize = size;
        this.queueArray = new char[size];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(char item){
        /* this make this queue circular
        if the queue is full it will erase element
        at the top to make more space and add element
         */
        if(rear == maxSize -1 ){
            rear -= 1;
        }

        rear++;
        queueArray[rear] = item;
        nItems++;
    }

    public char remove(){
        char temp = queueArray[front];
        front++;
        if(front == maxSize){
            front = 0;
        }
        nItems--;
        return temp;
    }

    public char peekFront(){
        return queueArray[front];
    }

    public boolean isEmpty(){
        return nItems == 0;
    }
    public boolean isFull(){
        return nItems == maxSize;
    }
}

