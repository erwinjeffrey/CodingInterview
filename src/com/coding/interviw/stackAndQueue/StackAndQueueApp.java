package com.coding.interviw.stackAndQueue;

import java.util.Set;
import java.util.Stack;

public class StackAndQueueApp {

    public static void main(String...args){

        /*
        Three in One: Describe how you could use a single array to implement three stacks.
         */
        FixedMultiStack multiStack = new FixedMultiStack(2);
        multiStack.push(0,1);
        multiStack.push(1,1);
        multiStack.push(0,2);
        multiStack.push(1,2);
        multiStack.push(2,5);
        multiStack.push(2,6);

        System.out.println(multiStack.pop(2));


        /*
        Stack Min: How would you design a stack which, in addition to push and pop, has a function min
which returns the minimum element? Push, pop and min should all operate in 0(1) time.
         */

        System.out.println("Stack min======================================");
        StackWithMin stackArray = new StackWithMin();
        stackArray.push(5);
        stackArray.push(6);
        stackArray.push(3);
        stackArray.push(7);

        System.out.println(stackArray.min());
        System.out.println(stackArray.pop().value);
        System.out.println(stackArray.min());

        System.out.println("Stack min 2======================================");
       StackWithMin2 stackWithMin2 = new StackWithMin2();
        stackWithMin2.push(5);
        stackWithMin2.push(6);
        stackWithMin2.push(3);
        stackWithMin2.push(7);
        System.out.println(stackWithMin2.min());
        System.out.println(stackWithMin2.pop());
        System.out.println(stackWithMin2.min());
        System.out.println(stackWithMin2.min());
        System.out.println(stackWithMin2.pop());
        System.out.println(stackWithMin2.min());

        /*
        Stack of Plates:
         */

        SetOfStacks setOfStacks = new SetOfStacks(3);
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        int peek = setOfStacks.peek();
        setOfStacks.push(4);
        setOfStacks.push(5);
        setOfStacks.push(6);
        int peek2 = setOfStacks.peek();
        int pop1 = setOfStacks.popAt(0);
        setOfStacks.push(7);
        setOfStacks.push(8);
        setOfStacks.push(9);
        int peek3 = setOfStacks.peek();
        int pop2 = setOfStacks.popAt(1);

        /*
         Stack of Plates: Code Book
         */
        SetOfStacks2 setOfStacks2 = new SetOfStacks2(3);
        setOfStacks2.push(1);
        setOfStacks2.push(2);
        setOfStacks2.push(3);

        setOfStacks2.push(4);
        setOfStacks2.push(5);
        setOfStacks2.push(6);

        int pop3 = setOfStacks2.popAt(0);
        setOfStacks2.push(7);
        setOfStacks2.push(8);
        setOfStacks2.push(9);

        /*
        Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.
         */

        MyQueueStack<Integer> myQueue = new MyQueueStack<>();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        myQueue.add(5);

        int peek5 = myQueue.peek();
        int pop5 = myQueue.remove();

        Stack<Integer> stacks = new Stack<>();
        stacks.push(10);
        stacks.push(7);
        stacks.push(8);
        stacks.push(12);
        stacks.push(19);
        sortStack(stacks);

    }

    /*
    Sort Stack: Write a program to sort a stack such that the smallest items are on the top.
     */
    public static Stack sortStack(Stack<Integer> original){
        Stack<Integer> result = new Stack();

        while(!original.isEmpty()){
            //  Insert each element in s in sorted order into r.
            int tmp = original.pop();
            while(!result.isEmpty() && result.peek() > tmp){
                original.push(result.pop());
            }
            result.push(tmp);
        }

        /*
        Copy the elements from result back into original
         */
        while(!result.isEmpty()){
            original.push(result.pop());
        }
        return original;
    }
}
