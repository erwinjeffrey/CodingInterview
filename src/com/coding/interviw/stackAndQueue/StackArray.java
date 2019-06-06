package com.coding.interviw.stackAndQueue;

public class StackArray {

    private int maxSize;
    private int[] stackArray;
    private int top;

    // to keep min values
    private int[] minStack;
    int previous;
    int count = -1;
    int min;
    int countStackMin = 0;


    public StackArray(int size){
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1;
    }

    public void push(int item){
        top++;
        stackArray[top] = item;
    }

    public int pop(){
        int old_top = top;
        top--;
        return stackArray[old_top];
    }

    public int peek(){
        return stackArray[top];
    }


    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
        return (maxSize -1) == top;
    }

    public int[] increaseStackSize(){
        int newSize = maxSize * 2;
        int[] newStack = new int[newSize];
        for(int i =0 ; i< maxSize; i++){
            newStack[i] = stackArray[i];
        }
        maxSize = newSize;
        return newStack;
    }

    public int getSize(){
        return this.maxSize;
    }

    public int getMin(){
        return min;
    }
}
