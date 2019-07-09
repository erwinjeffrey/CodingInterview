package com.coding.interviw.TreesAndGraph;

public class GraphNode {
    public String name;
    public GraphNode[] children;

    public GraphNode(int vertex){
        this.children = new GraphNode[vertex];
    }
}
