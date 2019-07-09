package com.coding.interviw.TreesAndGraph.buildOrderExercice;

import java.util.*;

public class Project{
    private List<Project> children = new ArrayList<>();
    private Map<String, Project> map = new HashMap<>();
    private String name;
    private int dependencies = 0;

    public Project(String name){
        this.name = name;
    }

    public void addNeighbor(Project node){
        if(!map.containsKey(node.getName())){
            children.add(node);
            map.put(node.getName(), node);
            node.incrementDependencies();
        }
    }

    public void incrementDependencies(){
        dependencies++;
    }

    public void  decrementDependencies(){
        dependencies--;
    }

    public String getName(){
        return name;
    }

    public List<Project> getChildren(){
        return children;
    }
    public int getNumberDependencies(){
        return dependencies;
    }


    // For DFS: this part is only required to find the build the order using DFS

    public enum State{
        COMPLETE,
        PARTIAL,
        BLANK
    };

    private State state = State.BLANK;

    public State getState(){
        return state;
    }

    public void setState(State st){
        state = st;
    }
}