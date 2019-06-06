package com.coding.interviw.stackAndQueue;

import java.util.NoSuchElementException;

public class MyQueue<T> {
    private QueueNode<T>  first;
    private QueueNode<T> last;

    public void add(T item){
        QueueNode<T> newItem = new QueueNode<>(item);
        if(last != null){
            last.next = newItem;
        }
        last = newItem;
        if(first == null){
            first = last;
        }
    }

    public T remove(){
        if(first == null) throw new NoSuchElementException();
        T data = first.data;
        first = first.next;
        if(first == null){
            last = null;
        }
        return data;
    }

    public T peek(){
        if(first == null) throw new NoSuchElementException();
        return first.data;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public QueueNode<T> getFirst() {
        return first;
    }

}
