package com.coding.interviw.stackAndQueue;

public class MyStack<T> {

    private StackNode<T> top;

    public T pop(){
        if(top == null) throw new RuntimeException("Stack is empty");

        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item){
        StackNode<T> newItem = new StackNode<>(item);
        newItem.next = top;
        top = newItem;
    }

    public T peek(){
        if(top == null) throw new RuntimeException("Stack is empty");
        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public StackNode<T> getTop() {
        return top;
    }
}
