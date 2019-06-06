package com.coding.interviw.stackAndQueue;
import java.util.*;
public class SetOfStacks {
    int capacity;
    List<Integer> stacks;
    List<Integer> sizes;
    int top = -1;
    int numberOfStack = 0;

    public SetOfStacks(int capacity){
        this.capacity = capacity;
        this.stacks = new ArrayList<>();
        this.sizes = new ArrayList<>();
    }

    public void push(int value){
        top++;
        if(sizes.isEmpty()){
            sizes.add(0);
        }
        if(isFull()){
            numberOfStack++;
            sizes.add(0);
        }
        stacks.add(value);
        sizes.set(numberOfStack,sizes.get(numberOfStack)+1);
    }

    public int pop(){
       int  value = stacks.get(top);
        top--;
        return value;
    }

    public int peek(){
        return stacks.get(top);
    }

    public boolean isFull(){
        if(sizes.get(numberOfStack) == capacity){
            return true;
        }
        return false;
    }

    public int popAt(int index){
        int offset =  index * capacity;
        int size = sizes.get(index);
        int topPosition = offset + size -1;
        int topValue = stacks.get(topPosition);
        sizes.set(index,sizes.get(index)-1);
        stacks.remove(topPosition);
        top--;
        return topValue;
    }
}
