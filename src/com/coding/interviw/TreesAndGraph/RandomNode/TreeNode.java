package com.coding.interviw.TreesAndGraph.RandomNode;

import java.util.Random;

public class TreeNode {
    private int data;
    public TreeNode left;
    public TreeNode right;
    private int size = 0;

    public TreeNode(int d){
        data = d;
        size = 1;
    }

    public TreeNode getIthnode(int i) {
       int leftSize = left ==null ? 0 : left.size();
       if(i < leftSize){
           return left.getIthnode(i);
       }else if( i == leftSize){
           return this;
       }else{
           /* Skipping over leftSize + 1 nodes, so subtract them */
           return right.getIthnode(i - (leftSize + 1));
       }
    }

    public void insertInOrder(int d){
        if(d <= data){
            if(left == null){
               left = new TreeNode(d) ;
            }else{
                left.insertInOrder(d);
            }
        }else{
            if(right == null){
                right = new TreeNode(d);
            }else{
                right.insertInOrder(d);
            }
        }
        size++;
    }

    public int size(){
        return size;
    }
    public int data(){
        return data;
    }

    public TreeNode find(int d){
        if(d == data){
            return this;
        }else if(d <= data){
            return left != null ? left.find(d) : null;
        }else if(d > data){
            return right != null ? right.find(d) : null;
        }
        return null;

    }
}
