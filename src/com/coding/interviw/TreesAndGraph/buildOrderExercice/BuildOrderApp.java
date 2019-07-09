package com.coding.interviw.TreesAndGraph.buildOrderExercice;

import java.util.Stack;

public class BuildOrderApp {
    public static void main(String...args){
        Graph graph = new Graph();
        String [] project = {"a","b","c","d","e","f"};
        String [][] dependencies = {{"a","d"},{"f","b"},{"b","d"},{"f","a"},{"d","c"}};

        // Without DFS
       // Project[] projects = graph.findBuildOrder(project,dependencies);

        // WITH DFS
        Stack<Project> projects = graph.findBuildOrder2(project,dependencies);
        for(Project project1: projects){
            System.out.println(project1.getName());
        }
    }
}
