package com.coding.interviw.TreesAndGraph.buildOrderExercice;

import java.util.*;

public class Graph {
    private List<Project> nodes = new ArrayList<>();
    private Map<String,Project> map = new HashMap<>();

    public Project getOrCreateNode(String name){
        if(!map.containsKey(name)){
            Project node = new Project(name);
            nodes.add(node);
            map.put(name, node);
        }
        return map.get(name);
    }

    public void addEdge(String startName, String endName){
        Project start = getOrCreateNode(startName);
        Project end = getOrCreateNode(endName);
        start.addNeighbor(end);
    }

    public List<Project> getNodes(){
        return nodes;
    }

    /* find a correct build order*/

    Project[] findBuildOrder(String[] projects, String[][]dependencies){
        Graph graph = buildGrahp(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    /* find a correct build order For problem implemented with DFS*/
    Stack<Project> findBuildOrder2(String[] projects, String[][]dependencies){
        Graph graph = buildGrahp(projects, dependencies);
        return orderProjects2(graph.getNodes());
    }
    /*
    Build the graph, adding the edge (a,b) if b is dependent on a. Assumes a pair is listed in "build order".
    the pair(a,b) is dependencies indicates that b depends on a and must be built before b
     */
    public Graph buildGrahp(String [] projects, String [][] dependencies){
        Graph graph = new Graph();
       for(String project : projects){
           graph.getOrCreateNode(project);
       }

       for(String [] dependency: dependencies){
           String first = dependency[0];
           String second = dependency[1];
           graph.addEdge(first,second);
       }
       return graph;
    }

    /* Return a list of the projects a correct build order */
    Project [] orderProjects(List<Project> projects){
        Project[] order = new Project[projects.size()];

        // Add root to the build order first
       int endOfList = addNonDependent(order, projects,0);

       int tobeProcessed = 0;
       while(tobeProcessed < order.length){
           Project current = order[tobeProcessed];

           /* We have a circular dependency since there are no remaining
           projects with zero dependencies */
           if(current == null){
               return null;
           }

           /* Remove myself as a dependency*/
           List<Project> children = current.getChildren();
           for(Project child: children){
               child.decrementDependencies();
           }

           /* Add children that have no one depending on them*/
           endOfList = addNonDependent(order, children, endOfList);
           tobeProcessed++;
       }
       return order;
    }

    /* A helper function to insert projects with zero dependencies
    into the order array, starting at index offset */
    int addNonDependent(Project[] order, List<Project> projects, int offset){
        for(Project project: projects){
            if(project.getNumberDependencies() == 0){
                order[offset] = project;
                offset++;
            }
        }
        return offset;
    }

    /* The same implementation but with DFS

     */

    Stack<Project> orderProjects2(List<Project> projects){
        Stack<Project> stack = new Stack<>();
        for(Project project: projects){
            if(project.getState() == Project.State.BLANK){
                if(!doDFS(project,stack)){
                    return null;
                }
            }
        }
        return stack;
    }

    boolean doDFS(Project project, Stack<Project> stack){
        if(project.getState() == Project.State.PARTIAL){
            return false; // Cycle
        }

        if(project.getState() == Project.State.BLANK){
            project.setState(Project.State.PARTIAL);
            List<Project> children = project.getChildren();
            for(Project child: children){
              if(!doDFS(child, stack)){
                 return false;
              }
            }
            project.setState(Project.State.COMPLETE);
            stack.push(project);
        }
       return true;
    }
}
