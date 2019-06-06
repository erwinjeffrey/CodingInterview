package com.coding.interviw.stackAndQueue;

import java.util.ArrayList;
import java.util.List;

public class SetOfStacks2 {
    List<Stack> stacks = new ArrayList<>();
    public int capacity;
    public SetOfStacks2(int capacity){
        this.capacity = capacity;
    }

    public Stack getLastStack(){
        if(stacks.size() == 0){
            return null;
        }
        return stacks.get(stacks.size() - 1);
    }

    public void push(int value){
        Stack last = getLastStack();
        if(last != null && !last.isFull()){ //add to last stack
            last.push(value);
        }else{
            Stack stack = new Stack(capacity);
            stack.push(value);
            stacks.add(stack);
        }
    }

    public int pop(){
        Stack last = getLastStack();
        if(last == null) throw new NullPointerException();
        int value = last.pop();
        if(last.size == 0) stacks.remove(stacks.size() - 1);
        return value;
    }

    public boolean isEmpty(){
        Stack last = getLastStack();
        return last == null || last.isEmpty();
    }

    public int popAt(int index){
        return leftShift(index, true);
    }

    public int leftShift(int index, boolean removeTop){
        Stack stack = stacks.get(index);
        int removed_item = 0;
        if(removeTop){
            removed_item = stack.pop();
        }else{
            removed_item = stack.removeBottom();
        }

        if(stack.isEmpty()){
            stacks.remove(index);
        }else if(stacks.size() > index + 1){
            int value = leftShift(index+1, false);
            stack.push(value);
        }
        return removed_item;
    }
}
