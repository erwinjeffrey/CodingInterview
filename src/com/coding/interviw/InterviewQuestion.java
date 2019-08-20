package com.coding.interviw;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InterviewQuestion {

    public static void main(String[] args) {

        //System.out.println(isBalanced2("()("));

       // Object [] objects = {1, new String[]{"erwin","mabel"}, new Object[]{ 4, new Integer[]{5,6}},"[10,11]",new Integer[]{3}};
       // System.out.println(flattenArray(objects));


        // (a[0]+b[2c[6]]){24+53}
        //f(e(d))
        //[()]{}([])
        //((b)
       // (c]
       // {(a[])
        //([)]

        System.out.println(isBalanced(""));
    }

    /*
    Write a code to verify parenthesis balancing
    ()
     */
    static boolean isBalanced3(String input){

        char [] characters = input.toCharArray();
        Stack<Character> parentesis = new Stack<>();
        for (int i = 0; i < characters.length; i++) {
            if(characters[i] =='('){
                parentesis.push(characters[i]);
            }else if(parentesis.size() > 0){
               if(characters[i]== ')'){
                   parentesis.pop();
               }
            }else{
                parentesis.push(characters[i]);
            }
        }
        if(parentesis.size() == 0){
            return true;
        }
        return false;
    }

    static boolean isBalanced2(String input){

        char [] characters = input.toCharArray();
        Stack<Character> parentesis = new Stack<>();
        for (int i = 0; i < characters.length; i++) {
            if(characters[i] =='('){
                parentesis.push(characters[i]);
            }else if(parentesis.size() > 0){
                if(characters[i]== ')'){
                   if(parentesis.peek() != '('){
                       return false;
                   }
                }
                parentesis.pop();
                if(parentesis.size() == 0 && i == characters.length-1){
                    return true;
                }
            }

        }


        return false;
    }

  static Object[] flattenArray(Object [] objects){
      List<Object> objectList = new ArrayList<>();

        for(Object ob : objects){
            findPlainObjet(ob, objectList);
        }
        return objectList.toArray();
    }

   static void  findPlainObjet(Object ob, List<Object> objectList){

        if(ob instanceof Object[]){
            Object [] io = (Object[])ob;
            for (Object object : (Object[]) io){
                findPlainObjet(object,objectList);
            }
        }else{
            objectList.add(ob);
        }
    }

    private static boolean isBalanced(String input) {

        char[] characters = getCharacters(input);


        Stack<Character> chars = new Stack<Character>();
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == '(' || characters[i] == '{'
                    || characters[i] == '[') {
                chars.push(characters[i]);
            } else if (chars.size() > 0) {

                switch (characters[i]) {

                    case ')':
                        if (chars.peek() != '(') {
                            return false;
                        }
                        break;

                    case '}':
                        if (chars.peek() != '{') {
                            return false;
                        }
                        break;

                    case ']':
                        if (chars.peek() != '[') {
                            return false;
                        }
                        break;

                }
                chars.pop();
                if (chars.size() == 0 && i == characters.length -1 ) {
                    return true;
                }

            }

        }

        return false;
    }

    private static char [] getCharacters(String input){

        StringBuilder charactersInput = new StringBuilder();
        for (int i = 0; i <input.length() ; i++) {
            switch (input.charAt(i)){

                case '[':
                    charactersInput.append('[');
                    break;
                case ']':
                    charactersInput.append(']');
                    break;

                case '(':
                    charactersInput.append('(');
                    break;

                case ')':
                    charactersInput.append(')');
                    break;

                case '{':
                    charactersInput.append('{');
                    break;

                case '}':
                    charactersInput.append('}');
                    break;

            }
        }

        return charactersInput.toString().toCharArray();

    }
}
