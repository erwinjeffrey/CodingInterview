package com.coding.interviw.recursionAndDanamicProg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecursionAndDanamicApp {

    public static void main(String[] args) {
        System.out.println(fibonacci(5));

        System.out.println(tripleStep(new int[]{1,2,3,4,5,6,7,8,9}));

        System.out.println(threeStepsBetter(3));

        System.out.println(threeStepsBetterMemo(6));

        char [][] paths ={

                {'1','2','3','*'},
                {'5','6','7','8'},
                {'9','a','b','c'},
                {'c','e','f','g'}
        };
        System.out.println(robotPathInAgrid(paths));

        boolean [][] pathBool = {
                {true, false,false,false},
                {false, false,false,false},
                {false, false,false,false},
                {false, false,false,true}
        };
        /*List<Point> points = getPath(pathBool);
        for(Point point : points){
            System.out.println(point);
        }*/

        System.out.println(countSets(new int[]{2,4,6,10},6));

        //those values are base case
        int [][] ways =totalWayTogetToEachCell(new int[][]{{1,1,1,1},{1,0,0,0},{1,0,0,0},{1,0,0,0}});
        for (int i = 0; i < ways.length ; i++) {
            for (int j = 0; j < ways[0].length; j++) {
                System.out.print(ways[i][j] + ",");
            }
            System.out.println();
        }

        System.out.println(findMagicIndex(new int[]{-40,-20,-1,1,2,3,5,7,9,12,13}));
        System.out.println(findMagicIndex(new int[]{-40,-20,-1,1,2,3,5,7,9,12,13},0,10));
        System.out.println(magicFast(new int[]{-10,-5,2,2,2,3,4,7,9,12,13},0,10));

        System.out.println(recursiveMultiply(3,2));
        System.out.println(minProduct(8,5));

        System.out.println(generateParensBetter(2));
    }
    static int fibonacci(int n){
        return fibonacci(n, new int[n+1]);
    }
    static int fibonacci(int i, int [] memo){
         if(i == 0 || i == 1){
             return i;
         }

         if(memo[i] == 0){
             memo[i] = fibonacci(i-1,memo) + fibonacci(i-2,memo);
         }
         return memo[i];
     }

     public static int tripleStep(int[] stairs){
        int count = 0;
        // for one step
        if(stairs.length > 0){
            count++;
        }
        if(twoSteps(stairs)){
            count++;
        }
        if(threeSteps(stairs)){
           count++;
        }
        return count;
     }
     private static boolean twoSteps(int [] stairs){
         for (int i = 0; i < stairs.length ; i+=2) {
             if(i == stairs.length-1){
                 return true;
             }
         }
         return false;
     }

    private static boolean threeSteps(int [] stairs){
        for (int i = 0; i < stairs.length ; i+=3) {
            if(i == stairs.length-1){
                return true;
            }
        }
        return false;
    }

    private static int threeStepsBetter(int numberOfStairs){

        if(numberOfStairs < 0 ){
            return 0;
        }else if(numberOfStairs ==  0){
            return 1;
        }else{

            return threeStepsBetter(numberOfStairs -1) + threeStepsBetter(numberOfStairs-2) +threeStepsBetter(numberOfStairs-3);

        }
    }

    private static int threeStepsBetterMemo(int numberOfStairs){
       return threeStepsBetterMemo(numberOfStairs, new int[numberOfStairs+1]);
    }
    private static int threeStepsBetterMemo(int numberOfStairs, int [] memo){

        if(numberOfStairs < 0){
            return 0;
        }else if(numberOfStairs == 0){
            return 1;
        }

        if(memo[numberOfStairs] == 0){
            memo[numberOfStairs]= threeStepsBetter(numberOfStairs -1) + threeStepsBetter(numberOfStairs-2) +threeStepsBetter(numberOfStairs-3);

        }
        return memo[numberOfStairs];
    }

    private static  String robotPathInAgrid(char [][] paths){
        StringBuilder pathsResult = new StringBuilder();
        int row =0;
        int col= 0;

        // top

        for (int i = 0; i < paths[0].length ; i++) {
            if(paths[row][i]== '*'){
                col = i-1;
                break;
            }else{
                col = i;
            }

            pathsResult.append(paths[row][i] + " ,");
        }
        row++;

        for (int i = row; i < paths.length; i++) {
            pathsResult.append(paths[i][col] + " ,");
            row++;
        }
        col++;


        // Bottom
        for (int i = col; i < paths[0].length; i++) {
            System.out.println("row " + row);
            pathsResult.append(paths[row-1][i] + " ,");
        }

        return  pathsResult.toString();
    }

    private static  List<Point> getPath(boolean [][] maze){
        if(maze == null || maze.length == 0){
            return null;
        }

        List<Point> path = new ArrayList<>();
        if(getPath(maze,maze.length -1,maze[0].length -1, path)){
            return path;
        }
        return null;
    }

    static boolean getPath(boolean [][] maze, int row, int col, List<Point> path){
        // If out of bounds or not available, return.
        if(col < 0 || row < 0 || !maze[row][col]){
            return false;
        }

        boolean isAtOrigin = (row == 0) && (col == 0);

        // If there's a path from the start to here, add my location
        if(isAtOrigin || getPath(maze,row,col -1,path) || getPath(maze,row -1,col,path)){
            Point p = new Point(row,col);
            path.add(p);
            return true;
        }
        return false;
    }

    // find set of numbers that add up to a given number in an array, just return the count of set
    static int countSets(int arr[], int total){
        return rec(arr, total,arr.length - 1);
    }
    static int rec(int arr[], int total,int i){
        if(total == 0){ // {}
            return 1;
        }else if(total < 0){ // if we are given a negative value. just return 0
            return 0;
        }else if(i < 0){ //if our index go down negative , just return 0
            return 0;
        }else if(total < arr[i]){ // if the given value is less than the actual index of the array, we skip this element
            return rec(arr,total, i-1);
        }
        else{
            return rec(arr, total - arr[i],i-1) + rec(arr,total,i-1);
        }
    }

    static int [][] totalWayTogetToEachCell(int [][] arr){
        for (int i = 1; i <arr.length ; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        return arr;
    }

    static int findMagicIndex(int []arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==i){
                return i;
            }
        }
        return -1;
    }

    static int findMagicIndex(int []arr, int start,int end){
        if(end < start){
            return -1;
        }
        int mid = (end + start) / 2;
        if(arr[mid]==mid){
            return  mid;
        }
        if(arr[mid] > mid ){
            return findMagicIndex(arr,start,mid-1);
        }else {
          return findMagicIndex(arr,mid+1,end);
        }

    }

    // what if the elements are distinct
    static int magicFast(int[] array, int start, int end){
        if(end < start){
            return -1;
        }
        int midIndex = (start + end) / 2;
        int midValue = array[midIndex];
        if(midValue == midIndex){
           return midIndex;
        }

        //Search left
        int leftIndex = Math.min(midIndex -1,midValue);
        int left = magicFast(array,start,leftIndex);
        if(left >= 0){
            return left;
        }

        // search right
        int rightIndex = Math.max(midIndex +1,midValue);
        int right = magicFast(array, rightIndex, end);

        return right;
    }

    private static int recursiveMultiply(int x, int y){
         if(y==0){
             return 0;
         }
        return x + recursiveMultiply(x,y-1);
    }

    static int minProduct(int a, int b){
        int bigger = a < b ? b: a;
        int smaller = a < b ? a : b;
        return minProductHelper(smaller, bigger);
    }

     static int minProductHelper(int smaller, int bigger){
        if(smaller == 0){ // 0 x bigger = 0
            return 0;
        }else if(smaller == 1){
            return bigger;
        }

        /* Compute half. if univen, compute other half. If even ,double it. */
        int s = smaller >> 1; // Divide by 2
        int side1 = minProduct(s,bigger);
        int side2 = side1;
        if(smaller % 2 == 1){
            side2 = minProductHelper(smaller-s, bigger);
        }
        return side1 + side2;
    }

    /*
    Parens: Implement an algorithm to print all valid (e.g., properly opened and closed)
    combinations of n pairs of parentheses.
     */

    private static Set generateParens(int remaining){
        Set<String> set = new HashSet<>();
        if(remaining == 0){
            set.add("");
        }else{
            Set<String> prev = generateParens(remaining - 1);
            for (String str: prev){
                for (int i = 0; i < str.length(); i++){
                    if(str.charAt(i)=='('){
                        String s = insertInside(str, i);
                        /*
                        Add s to set if it's not already there. Node: Hashset
                        automatically checks for duplicates before adding, so an explicit
                        check is not necessary
                         */
                        set.add(s);
                    }
                }
                set.add("()" + str);
            }
        }
        return set;
    }

    static String insertInside(String str, int leftIndex){
        String left = str.substring(0,leftIndex + 1);
        String right = str.substring(leftIndex + 1, str.length());
        return left + "()" + right;
    }

    // Parens better
    static void addParen(List<String> list, int leftRem, int rightRem, char[] str, int index){

        if(leftRem < 0 || rightRem < leftRem){
                  return; 
        }
        if(leftRem == 0 && rightRem == 0){ /* Out of left and right parentheses */
            list.add(String.copyValueOf(str));
        }else{
            str[index] = '('; // Add left and recurse
            addParen(list,leftRem - 1,rightRem,str, index + 1);

            str[index] = ')'; // Add right and recurse
            addParen(list, leftRem,rightRem-1,str, index + 1);
        }
    }

   static List<String> generateParensBetter(int count){
        char [] str = new char[count * 2];
        List<String> list = new ArrayList<>();
        addParen(list,count,count,str,0);
        return list;
    }
}
