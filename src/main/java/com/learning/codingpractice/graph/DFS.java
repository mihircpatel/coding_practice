package com.learning.codingpractice.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DFS {
    boolean[] visited;

    public DFS(int size) {
        this.visited = new boolean[size];
    }

    List<Integer> traverse(Graph graph, int source){
        init();
        List<Integer> traversedPath = new ArrayList<>();

        traverse(graph, source, traversedPath);

        return traversedPath;
    }

    private void traverse(Graph graph, int nodeToVisit, List<Integer> path) {
        this.visited[nodeToVisit] = true;
        path.add(nodeToVisit);

        Iterator<Integer> itr = graph.getAdjacentNodes(nodeToVisit).listIterator();
        while(itr.hasNext()) {
            int nextNode = itr.next();
            if(!visited[nextNode]) {
                traverse(graph, nextNode, path);
            }
        }
    }

    private void init() {
        for (int i = 0; i < this.visited.length; i++) {
            this.visited[i] = false;
        }
    }
}
