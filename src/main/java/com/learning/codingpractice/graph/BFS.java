package com.learning.codingpractice.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BFS {
    boolean[] visited;
    Queue<Integer> queue = new ArrayDeque<>();

    public BFS(int size) {
        this.visited = new boolean[size];
    }

    public List<Integer> traverse(Graph graph, int source) {
        init();

        List<Integer> traversedPath = new ArrayList<>();
        queue.add(source);
        visited[source] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            traversedPath.add(node);

            List<Integer> adjNodes = graph.getAdjacentNodes(node);
            for (int aNode: adjNodes) {
                if(!visited[aNode]){
                    visited[aNode] = true;
                    queue.add(aNode);
                }
            }
        }

        return traversedPath;
    }

    private void init() {
        for (int i = 0; i < this.visited.length; i++) {
            this.visited[i] = false;
        }
    }
}
