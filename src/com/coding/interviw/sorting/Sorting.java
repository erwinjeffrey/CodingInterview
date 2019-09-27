package com.coding.interviw.sorting;

import java.util.*;
import java.util.stream.Collectors;

/*
https://stackabuse.com/sorting-algorithms-in-java/
 */
public class Sorting {

    static RankNode root = null;

    public static void main(String[] args) {

        Sorting sorting = new Sorting();
         mergesort(new  int []{38,27,43,3,9,82,10});
        //bubbleSort(new int[]{5,4,3,2,1});
        //insertionSort(new int[]{5,4,3,2,1});
        // selectionSort(new int[]{5,4,3,2,1});
        // heapSort(new int[]{8,5,6,3,1,2,4});

        quickSort(new int []{10,80,30,90,40,50,70},0,6);
        // sortedMerged(new int[]{1,2,3,0,0,0}, new int[]{4,5,6});
        //  merge(new int[]{4,5,6,0,0,0}, new int[]{1,2,3},3,3);

        String[] words = new String[]{"evil", "vile", "pat"};
        /*String[] wordsResult = sorting.groupAnagrams(words);
        for(String w : wordsResult){
            System.out.println(w);
        }*/

        //  sort(words);

        //System.out.println(searchInRotatedArray(new int[]{15,16,19,20,25,1,3,4,5,7,10,14},0,11,5));
        //System.out.println(searchInRotatedArray(new int[]{10,15,20,0,5},0,4,5));
        // System.out.println(searchInRotatedArray(new int[]{50,5,20,30,40},0,4,5));

        //Sorted Search, No Size
        Listy listy = new Listy(6);
        listy.add(1);
        listy.add(2);
        listy.add(3);
        listy.add(4);
        listy.add(5);
        listy.add(6);

       // System.out.println(findIndex(listy, 6));

        //Sparse Search
       /*System.out.println(sparseSearch(
                new String[]{"at","","","","ball","","","bally","car","","","dad","",""},
                "dad",0,13));       */

        /*System.out.println(search(new String[]{"at","","","","ball","","","bally","car","","","dad","",""},
                "dad",0,13));*/

        checkDuplicates(new int[]{1,5,1,10,12,10});

        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
        int[][] matrix2 = {{15,20,70,85},{20,35,80,95},{30,55,95,105},{40,80,100,120}};
       // System.out.println("sortedMatrixSearch: " + sortedMatrixSearch(matrix,15));
       // findElement(matrix,6);

        findEl(matrix2,95);

        /*track(5);
        track(1);
        track(4);
        track(4);
        track(5);
        track(9);
        track(7);
        track(13);
        track(3);
        System.out.println("getRankOfNumber2: " + getRankOfNumber2(7));*/

        track(13);
        track(25);
        track(23);
        track(24);
        track(20);
        track(15);
        track(10);
        track(5);

        System.out.println("getRankOfNumber2: " + getRankOfNumber2(24));

        //sortByPeakAndValley(new int[]{5,3,1,2,3});
        // sortByPeakAndValley(new int[]{8,5,6,2,6,3,4});
        sortValleyPeak(new int[]{9,1,4,7,8,0});
    }

    /*
      Bubble sort: Bubble sort works by swapping adjacent elements if they're
      not in the desired order. This process repeats from the beginning of the
      array until all elements are in order.

      4 2 1 5 3: The first two elements are in the wrong order, so we swap them.

      2 4 1 5 3: The second two elements are in the wrong order too, so we swap.
     */

    private static void bubbleSort(int[] array) {
        boolean sorted = false;
        int temp;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
            }
        }
    }

    /*
     Upon expanding, we place the new element into its proper place within
     the sorted subarray. We do this by shifting all of the elements to the right
     until we encounter the first element we don't have to shift.
     */
    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && current < array[j]) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = current;
        }
    }

    /*
    Finding the minimum is O(n) for the length of array because we have
    to check all of the elements. We have to find the minimum for each element
    of the array, making the whole process bounded by O(n^2)
     */
    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minId = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minId = j;
                }
            }

            // swapping
            int temp = array[i];
            array[i] = min;
            array[minId] = temp;
        }
    }

    static void mergesort(int[] array) {
        int[] helper = new int[array.length];
        mergesort(array, helper, 0, array.length - 1);
    }

    static void mergesort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
          int middle = (low + high) / 2;
            mergesort(array, helper, low, middle); // Sort left half
            mergesort(array, helper, middle + 1, high); // Sort right half
            merge(array, helper, low, middle, high); // merge them
        }
    }

    static void merge(int[] array, int[] helper, int low, int middle, int high) {
        /*
        Copy both halves into a helper array
         */
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        /*
        Iterate through helper array. Compare the left and right half, copying back
        the smaller element from the two halves into the original array
         */

        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else { // if right element  is smaller than left element
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        /* copy the rest of the left side of the array into the target array */
        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        }
    }

    static void heapify(int[] array, int length, int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int largest = i;

        // if the left child is larger than parent
        if (leftChild < length && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        // if the right child is larger than parent
        if (rightChild < length && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        //if a swap needs to occur
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, length, largest);
        }
    }

    public static void heapSort(int[] array) {
        if (array.length == 0) return;

        // Building the heap
        int length = array.length;

        // we're going from the first non-leaf to the root
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }

        for (int i = length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    static int partition(int[] array, int begin, int end) {
        int pivot = end;

        int counter = begin;
        for (int i = begin; i <= end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;

        return counter;
    }

    /*
    https://www.geeksforgeeks.org/quick-sort-vs-merge-sort/
     */
    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) {
            return;
        }

        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    /*
    You are given two sorted arrays, A and B, where A has a large buffer at the end to hold B.
    Write a method to merge B  into A in sorted order.
     */
    private static int[] sortedMerged(int[] A, int[] B) {
        int index = (A.length - 1) - (B.length - 1);

        for (int i = 0; i < B.length; i++) {
            A[index] = B[i];
            index++;
        }

        return A;
    }

    private static void merge(int[] a, int[] b, int lastA, int lastB) {
        int indexA = lastA - 1; // Index of last element in array a
        int indexB = lastB - 1; // Index of last element in array b
        int indexMerged = lastB + lastA - 1; // end of merged array

        /* Merge a and b, starting from the last element in each  */
        while (indexB >= 0) {
            // end of a is > than end of b
            if (indexA >= 0 && a[indexA] > b[indexB]) {
                a[indexMerged] = a[indexA];
                indexA--;
            } else {
                a[indexMerged] = b[indexB]; // copy element
                indexB--;
            }

            indexMerged--; // move indices
        }
    }

    /*
     Group Anagrams: Write a method to sort an array of Strings so that all the anagrams are next
     to each other.
     */

    class AnagramComparator implements Comparator<String> {

        public String sortChars(String s) {
            char[] content = s.toCharArray();
            Arrays.sort(content);
            return new String(content);
        }

        @Override
        public int compare(String s1, String s2) {
            return sortChars(s1).compareTo(s2);
        }
    }

    private String[] groupAnagrams(String[] strings) {
        Arrays.sort(strings, new AnagramComparator());
        return strings;
    }

    static void sort(String[] array) {
        Map<String, ArrayList<String>> mapList = new HashMap<>();

        // Group words by anagram
        for (String s : array) {
            String key = sortChars(s);
            if (!mapList.containsKey(key)) {
                mapList.put(key, new ArrayList<String>());
            }
            mapList.get(key).add(s);
        }

        // convert hash table to array
        int index = 0;
        for (String key : mapList.keySet()) {
            ArrayList<String> list = mapList.get(key);
            for (String t : list) {
                array[index] = t;
                index++;
            }
        }
    }

    public static String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    //search in rotated array
    private static int searchInRotatedArray(int[] array, int left, int right, int x) {

        int mid = (left + right) / 2;
        if (x == array[mid]) { // Found element
            return mid;
        }
        if (right < left) {
            return -1;
        }

       /*
         Either the left or right half must be normally ordered. Find out which side
         is normally ordered, and then use the normally ordered half to figure out
         which side to search to find x.
        */

        if (array[left] < array[mid]) { // left is normally ordered
            if (x >= array[left] && x < array[mid]) {
                return searchInRotatedArray(array, left, mid - 1, x); // search left
            } else {
                return searchInRotatedArray(array, mid + 1, right, x); // search right
            }
        } else if (array[mid] < array[left]) { // Right is normally ordered
            if (x > array[mid] && x <= array[right]) {
                return searchInRotatedArray(array, mid + 1, right, x); //search right
            } else {
                return searchInRotatedArray(array, left, mid - 1, x); // search left
            }
        } else if (array[left] == array[mid]) { // left or right half is all repeats
            if (array[mid] != array[right]) { // if right is different, search it
                return searchInRotatedArray(array, mid + 1, right, x); // search right
            } else { // Else, we have to search both values
                int result = searchInRotatedArray(array, left, mid - 1, x); // search left
                if (result == -1) {
                    return searchInRotatedArray(array, mid + 1, right, x);
                } else {
                    return result;
                }
            }
        }
        return -1;
    }

    /*
      Sorted Search, No Size
      You are given an array-like dat structure Listy which lacks a size method.
     */

    private static int findIndex(Listy listy, int value) {
        // int length = findLength(listy);
        //return findIndexBinarySearch(listy,value,0,length);

        // finding the length of the array  more optimize
        int index = 1;
        while (listy.elementAt(index) != -1 && listy.elementAt(index) < value) {
            index *= 2;
        }
        return findIndexBinarySearch(listy, value, index / 2, index);
    }

    private static int findIndexBinarySearch(Listy listy, int value, int start, int length) {
        if (start > length) {
            return -1;
        }
        int mid = (start + length) / 2;
        if (listy.elementAt(mid) == value) {
            return mid;
        } else if (value < listy.elementAt(mid)) {
            return findIndexBinarySearch(listy, value, start, mid - 1);
        } else {
            return findIndexBinarySearch(listy, value, mid + 1, length);
        }

    }

    private static int findLength(Listy listy) {
        int index = 1;

        while (listy.elementAt(index) != -1) {
            index += 2;
        }
        if (listy.elementAt(index - 1) == -1) {
            return index - 2;
        }
        return index - 1;
    }

    /*
    Book Implementation
     */
    private static int search(Listy list, int value) {
        int index = 1;
        while (list.elementAt(index) != -1 && list.elementAt(index) < value) {
            index *= 2;
        }
        return binarySearch(list, value, index / 2, index);
    }

    static int binarySearch(Listy list, int value, int low, int high) {
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            int middle = list.elementAt(mid);
            if (middle > value || middle == -1) {
                high = mid - 1;
            } else if (middle < value) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /*
       Sparse Search: Given a  sorted array of strings that is  interspersed
       with empty strings, write a method to find the location of a given string.
     */

    private static int sparseSearch(String[] input, String searchValue, int start, int high) {

        if (start > high) {
            return -1;
        }

        int mid = (start + high) / 2;

        if (!input[mid].isEmpty() && input[mid].equals(searchValue)) {
            return mid;
        } else if ((!input[mid].isEmpty() )
                && input[mid].compareTo(searchValue) < 0) {
            return sparseSearch(input, searchValue, mid + 1, high);
        }else {
            int search = sparseSearch(input, searchValue, start, mid-1);
            if(search == -1){
                return sparseSearch(input, searchValue, mid+1, high);
            }
            return search;
        }

    }

    /*
      Book Implementation
     */

    static int search(String [] strings, String str){
        if(strings == null || str== null || str == ""){
            return -1;
        }
        return search(strings, str, 0, strings.length -1);
    }
    private static int search (String[] strings, String str, int first, int last){
        if(first > last){
            return -1;
        }

        /* Move mid to the middle  */
        int mid = (last + first) /2;

        /* If mid is empty, find closest non-empty string. */
        if(strings[mid].isEmpty()){
            int left = mid - 1;
            int right = mid + 1;
            while(true){
                if(left < first && right > last){
                   return -1;
                }else if(right <= last && !strings[right].isEmpty()){
                    mid = right;
                    break;
                }else if(left >= first && !strings[left].isEmpty()){
                    mid = left;
                    break;
                }
                right++;
                left--;
            }
        }

        /* Check for string, and recurse if necessary */
        if(str.equals(strings[mid])){ // Found it
            return mid;
        }else if(strings[mid].compareTo(str) < 0){ // search right
            return search(strings,str,mid +1,last);
        }else{ // Search  left
           return search(strings,str,first,mid -1);
        }
    }

    /*
    Sort Big File: Imagine you have a 20 GB file with one string per line.
      Explain how you would sort the file.
     */

    /*
    Find Duplicates: You have an array with all the numbers from 1 to N, where N is at most 32,000.
     The array may have duplicate entries and you do not know what N is. With only 4 kilobytes of
     memory available, how would you print all duplicate elements in the array?
     */

    static void checkDuplicates(int [] array){
        BitSet bs = new BitSet(32000);
        for (int i = 0; i < array.length ; i++) {
            int num = array[i];
            int num0 = num -1; // bitset starts at 0, numbers start at 1
            if(bs.get(num0)){
                System.out.println(num);
            }else{
                bs.set(num0);
            }
        }
    }

    /*
    Sorted Matrix Search: Given an M  x  N matrix in which each
    row and each column is sorted in ascending order, write a method to find an element.
     */

    private static int sortedMatrixSearch(int [][] inputs, int element){

        for (int i = 0; i <inputs.length ; i++) {
            int search = rowBinarySearch(inputs[i],element,0,inputs[0].length-1);
            if(search != -1){
                return 1;
            }
        }
        return -1;
    }
    private static int rowBinarySearch(int [] inputs, int element, int start,int last){

        if(start > last){
            return -1;
        }
        if(inputs[last] < element){
            return -1;
        }

        int mid = (start + last) / 2;

        if(inputs[mid]==element){
            return 1;
        }else if(inputs[mid]< element){
          return rowBinarySearch(inputs,element,mid+1,last);
        }else{
            return rowBinarySearch(inputs,element,start, mid-1);

        }
    }

   /*
      book implementation
    */

   private static boolean findElement(int[][] matrix, int element){
       int row = 0;
       int col = matrix[0].length - 1;
       while(row < matrix.length && col >= 0){
           if(matrix[row][col] == element){
               return true;
           }else if(matrix[row][col] > element){
               col--;
           }else{
               row++;
           }
       }
       return false;
   }

   /*
    second book implementation
    */

    private static Coordinate findEl(int[][] matrix, int x){
        Coordinate origin = new Coordinate(0,0);
        Coordinate dest = new Coordinate(matrix.length -1, matrix[0].length -1);
        return findEl(matrix, origin, dest, x);
    }

    private static Coordinate findEl(int[][] matrix, Coordinate origin, Coordinate dest, int x){
        if(!origin.inbounds(matrix) || !dest.inbounds(matrix)){
            return null;
        }
        if(matrix[origin.row][origin.column] == x){
            return origin;
        }else if(!origin.isBefore(dest)){
            return null;
        }

       /* Set start to start of diagonal and end to end of the diagonal. Since the
          grid may not be square, the end of the diagonal may not equal dest
        */
        Coordinate start = (Coordinate) origin.clone();
        int diagDist = Math.min(dest.row - origin.row, dest.column - origin.column);
        Coordinate end = new Coordinate(start.row + diagDist, start.column + diagDist);
        Coordinate p = new Coordinate(0,0);

       /* Do binary search on the diagonal, looking for the first element > x */
        while (start.isBefore(end)){
            p.setToAverage(start, end);
            if(x > matrix[p.row][p.column]){
                start.row = p.row +1;
                start.column = p.column +1;
            }else{
                end.row = p.row -1;
                end.column = p.column -1;
            }
        }

       /* Split the grid into quadrants. Search the bottom left and the top right */
        return partitionAndSearch(matrix, origin, dest, start, x);
    }

   private static Coordinate partitionAndSearch(int[][]matrix, Coordinate origin, Coordinate dest,
                                         Coordinate pivot, int x){

       Coordinate lowerLeftOrigin = new Coordinate(pivot.row, origin.column);
       Coordinate lowerLeftDest = new Coordinate(dest.row, pivot.column);
       Coordinate upperRightOrigin = new Coordinate(origin.row, pivot.column);
       Coordinate upperRightDest = new Coordinate(pivot.row -1, dest.column);

       Coordinate lowerLeft = findEl(matrix,lowerLeftOrigin, lowerLeftDest, x);
       if(lowerLeft == null){
           return findEl(matrix, upperRightOrigin,upperRightDest, x);
       }
       return lowerLeft;
   }

   /*
   Rank from Stream: Imagine you  are reading in a  stream of  integers.
   Periodically, you  wish to be able to look up the rank of a
   number x (the number of values less than or  equal to x).
   Implement the data structures and algorithms to support these operations.
   That is, implement the method track(int x),
   which is called when each number is generated, and the method getRankOfNumber(int x),
   which returns the number of values less than or equal to x (not including x itself).
    */

   private static int  getRankOfNumber(int item){
       Rank rank = new Rank(8);
       rank.add(5);
       rank.add(1);
       rank.add(4);
       rank.add(4);
       rank.add(5);
       rank.add(9);
       rank.add(7);
       rank.add(13);
       rank.add(3);

       return rank.getRankOfNumber(item);
   }

   /*
     Book Implementation
    */

   static void track(int number){
       if(root == null){
           root = new RankNode(number);
       }else{
           root.insert(number);
       }
   }
   private static int getRankOfNumber2(int number){
       return root.getRank(number);
   }

   /*
   Peaks and Valleys: In an array of integers, a "peak" is an element which
   is greater than or equal to the adjacent integers and a "valley" is an element
   which is less than or equal to the adjacent integers. For example,
   in the array {5, 8, 6, 2, 3, 4, 6}, {8, 6} are peaks and {5, 2} are valleys.
   Given an array of integers, sort the array into an alternating sequence of peaks and valleys.
    */

   // Suboptimal Solution
   private static void sortByPeakAndValley(int [] arr){

       Arrays.sort(arr);

       for (int i = 1; i < arr.length; i+=2) {
          swap(arr, i-1, i);
       }
   }

   private static void swap(int[] array, int left, int right){
       int temp = array[left];
       array[left] = array[right];
       array[right] = temp;
   }

   // Optimal
    static void sortValleyPeak(int [] array){
        for (int i = 1; i < array.length; i+=2) {
            int biggestIndex = maxIndex(array, i-1, i, i +1);
            if(i != biggestIndex){
                swap(array,i, biggestIndex);
            }
        }
    }

    static int maxIndex(int[] array, int a, int b, int c){
       int len = array.length;
       int aValue = a >= 0 && a < len ? array[a] : Integer.MIN_VALUE;
       int bValue = b >= 0 && b < len ? array[b] : Integer.MIN_VALUE;
       int cValue = c >= 0 && c < len ? array[c] : Integer.MIN_VALUE;

       int max = Math.max(aValue, Math.max(bValue, cValue));
       if(aValue == max) return a;
       else if(bValue == max) return b;
       else return c;
    }
}
