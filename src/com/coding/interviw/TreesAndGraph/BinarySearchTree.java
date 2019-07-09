package com.coding.interviw.TreesAndGraph;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    // Root of BST
    Node root;

    public BinarySearchTree(){
        root = null;
    }

    public void insert(int key){

        root = insertRec(root,key);
    }

    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, int key){

        // If the tree is empty, return a new node
        if(root == null){
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if(key <= root.key){
            root.left = insertRec(root.left, key);
        }else if(key > root.key){
            root.right = insertRec(root.right, key);
        }

        // return the (unchanged) node pointer
        return root;
    }

    // This method mainly calls InorderRec()
    void inorder(){
        inorderRec(root);
    }

    // This method mainly call preorderRec
    void preorder(){
        preorderRec(root);
    }

    // This method mainly calls Postorder
    void postorder(){
        postorderRec(root);
    }

    void searchNodeValue(){
        System.out.println(search(root,100));
    }

    // DFS INORDER

    void inorderRec(Node root){
          if(root == null){
            return;
        }
        inorderRec(root.left);
        System.out.println(root.key);
        inorderRec(root.right);
    }

    // DFS PREORDER
    void preorderRec(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.key);
        preorderRec(root.left);
        preorderRec(root.right);
    }

    // DFS Postorder
    void postorderRec(Node root){
        if(root == null){
            return;
        }
        postorderRec(root.left);
        postorderRec(root.right);
        System.out.println(root.key);
    }

    void bfsRec(){
        bfs(root);
    }

    // breath first search
    // print in one line for example : a b c d e f
    void bfs(Node root){
        Node temp = null;
        Queue<Node> queue = new LinkedList<>();
        if(root == null){
            return;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            temp = queue.poll();
            System.out.println(temp.key);

            if(temp.left != null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }
        }
    }

    private static int search(Node node, int value){
        if(node == null){
            return -1;
        }
        if(node.key == value){
            return 1;
        }
        if(node.key < value){
            return search(node.right, value);
        }else{
            return search(node.left, value);
        }
    }
}
