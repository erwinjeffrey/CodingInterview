package com.coding.interviw.TreesAndGraph;

public class NodeWithParent {

   public int key;
   public NodeWithParent left;
    public NodeWithParent right;
   public NodeWithParent parent;
   public int index =0 ;
    boolean isVisited;

    public NodeWithParent(int item) {
        key = item;
        left = null;
        right = null;
        parent = null;
        isVisited = false;
        index = 0;
    }
}
