package com.coding.interviw.sorting;

public class Listy {

    int count;
    private int size;
    private  int [] array = null;

    public Listy(int size){
        this.size = size;
        array = new int[size];
    }
    public void add(int value){
        array[count] = value;
        count++;
    }

    public int elementAt(int index){
        if(index > size-1){
            return -1;
        }

        return array[index];
    }
}
