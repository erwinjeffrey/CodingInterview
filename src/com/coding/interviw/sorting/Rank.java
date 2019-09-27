package com.coding.interviw.sorting;


public class Rank {

    int [] numbers = null;
    int count = 0;

    public Rank(int size){
        numbers = new int[size+1];
    }

    public void add(int x){
        track(x);
    }

    public void track(int x){
        numbers[count] = x;
        count++;
    }

    public int getRankOfNumber(int item){

        sort(numbers, 0, numbers.length -1);
        int numberOfValue = search(numbers,item, 0,numbers.length -1);
        return numberOfValue;
    }

    private void sort(int [] array, int start, int end){

        if(start < end){

            int pivot = partition(array,start, end);

            sort(array, start, pivot -1);
            sort(array, pivot + 1, end);
        }
    }

    private int partition(int [] array, int begin, int end){
        int pivot = end;
        int counter = begin;

        for (int i = begin; i <= end; i++) {
            if(array[i] < array[pivot]){
                int temp = array[counter];
                array[counter] = array[i];
                array[i]= temp;
                counter++;
            }
        }

        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;

        return  counter;
    }

    int search(int[]array, int item, int start, int end){
        if(start > end){
            return -1;
        }

        int mid = (start + end) / 2;

        if(array[mid] == item){
            while(array[mid]==array[mid+1]){
                mid++;
            }
            return mid;
        }else if(array[mid] < item){
            return search(array, item, mid +1, end);
        }else{
            return search(array, item, start, mid -1);
        }
    }

}
