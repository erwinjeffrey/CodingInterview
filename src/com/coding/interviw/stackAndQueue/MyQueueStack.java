package com.coding.interviw.stackAndQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MyQueueStack<T>{
    Stack<T> stackNewest;
    Stack<T> stackOldest;

    public MyQueueStack(){
        stackNewest = new Stack<>();
        stackOldest = new Stack<>();
    }

    public int size(){
        return stackNewest.size() + stackOldest.size();
    }

    public void add(T value){
        /*
        Push onto stackNewest, which always has the newest elements on top
         */
        stackNewest.push(value);
    }

    /*
    Move elements from stackNewest into stackOldest. This is usually done so that
    We can do operations on stackOldest
     */
    private void shiftStacks(){
        if(stackOldest.isEmpty()){
            while(!stackNewest.isEmpty()){
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T peek(){
        shiftStacks(); // Ensure stackOldest has the current elements
        return stackOldest.peek(); // retrieve the oldest item
    }

    public T remove(){
        shiftStacks();// Ensure stackOldest has the current elements
        return stackOldest.pop(); // pop the oldest item
    }
}
