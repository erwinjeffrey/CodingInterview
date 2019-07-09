package com.coding.interviw.TreesAndGraph.RandomNode;

import com.coding.interviw.TreesAndGraph.Node;
import com.coding.interviw.TreesAndGraph.NodeWithParent;

import java.util.List;
import java.util.Random;

public class BinaryTree {

    public static Node insert(Node root,int key){

        if(root == null){
            root = new Node(key);
            return root;
        }
        if(key <= root.key){
            root.left = insert(root.left,key);
        }else if(key > root.key){
            root.right = insert(root.right, key);
        }
        return root;
    }

    public static  int find(Node root, int key){

        if(root == null){
            return -1;
        }
        if(root.key == key){
            return 1;
        }
        if(key <= root.key){
           return find(root.left, key);
        }else{
           return  find(root.right, key);
        }

    }

    public static NodeWithParent deleteNode(NodeWithParent root, int data){
        if(root == null){
            return null;
        }

        if(data < root.key){
            root.left = deleteNode(root.left, data);
        }else if(data > root.key){
            root.right = deleteNode(root.right,data);
        }else{
            //has at least one child o none
            if(root.left == null || root.right == null){
                NodeWithParent temp = null;
                temp = root.left == null ? root.right: root.left;

                return temp;
            }else{
                // have both left and right children
                NodeWithParent sucessor = getSuccesor(root);
               root.key = sucessor.key;
               root.right = deleteNode(root.right, sucessor.key);
               return root;
            }
        }
        return root;
    }

    private static  NodeWithParent getSuccesor(NodeWithParent node){
        if(node == null){
            return null;
        }
        NodeWithParent temp = node.right;

        while(temp.left != null){
            temp = temp.left;
        }
        return temp;
    }

    public static NodeWithParent randomNode(NodeWithParent root, List<NodeWithParent> listNode){
        addNode(root,listNode);
        int size = listNode.size()-1;
        Random r = new Random();
        int randomIndex =  r.nextInt(size);
        return listNode.get(randomIndex);
    }
    public static void addNode(NodeWithParent node, List<NodeWithParent> listNode){
        if(node == null){
            return;
        }
        addNode(node.left, listNode);
        listNode.add(node);
        addNode(node.right, listNode);
    }

}
