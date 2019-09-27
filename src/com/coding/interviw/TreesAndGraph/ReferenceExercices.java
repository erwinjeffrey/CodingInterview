package com.coding.interviw.TreesAndGraph;

import java.util.*;

public class ReferenceExercices {

    public static void main(String[] args) {
        System.out.println("maximumSumSubArr: " + maximumSumSubArr(new int[]{-2,-5,6,-2,-3,1,5,-6}));

    }
    public static int  getMaxHeight(NodeWithParent node){
        if(node == null){
            return 0;
        }
        int left = getMaxHeight(node.left);
        int right = getMaxHeight(node.right);
        int h = 0;
        if(left > right){
             h = left + 1;
        }else{
             h = right + 1;
        }
        return h;
    }


    // breath first search
    // print level by level example :
    /* a
    *  bc
    *  defg
    *  */

    public static void bfsLevelByLevel(NodeWithParent root){
        if(root == null){
            return;
        }
        Queue<NodeWithParent> queue = new LinkedList<>();
        NodeWithParent temp = null;

        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            temp = queue.poll();
            if(temp != null){
                System.out.print(temp.key + " ");
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }else{
                // if there two consecutive null it's over
                if(queue.peek() == null){
                    queue.poll();
                }else {
                    // change level
                    System.out.print("\n");
                    queue.add(null);
                }

            }
        }
    }

    public static String  printOrder(NodeWithParent root){

        StringBuilder result = new StringBuilder();
        Map<Integer, List<Integer>> verticalOrders = verticalOrder(root);
        List<Integer> keys = new ArrayList<>(verticalOrders.keySet());
        Collections.sort(keys);

        for(int key: keys){
            List<Integer> values = verticalOrders.get(key);
            for (int value: values){
                result.append(value + " ");
            }
        }

       return result.toString();
    }
    public static  Map<Integer, List<Integer>> verticalOrder(NodeWithParent root){
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        Queue<NodeWithParent> queue = new LinkedList<>();
        queue.add(root);

        add(0,root.key,hashMap);

        while(!queue.isEmpty()){
            NodeWithParent  temp = queue.poll();

            if(temp.left != null){
                temp.left.index =  temp.index - 1;
                add(temp.left.index,temp.left.key,hashMap);
                queue.add(temp.left);
            }

            if(temp.right != null){
                temp.right.index = temp.index +1;
                add(temp.right.index ,temp.right.key,hashMap);
                queue.add(temp.right);
            }
        }
        return  hashMap;
    }

    private static void add(int key, int value, Map<Integer,List<Integer>> multiMap){
        List<Integer> list;
        if(multiMap.containsKey(key)){
            list = multiMap.get(key);
            list.add(value);
        }else{
            list = new ArrayList<>();
            list.add(value);
            multiMap.put(key,list);
        }
    }

    private static int maximumSumSubArr(int [] arr){
        int max_so_far = arr[0];
        int max_ending_here = 0;

        for (int i = 0; i < arr.length; i++) {
            max_ending_here = max_ending_here + arr[i];

            if(max_so_far < max_ending_here){
                max_so_far = max_ending_here;
            }
            if(max_ending_here < 0){
                max_ending_here = 0;
            }
        }
        return max_so_far;
    }



   }
