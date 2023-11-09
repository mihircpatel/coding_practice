package com.learning.codingpractice.graph;

import java.util.Arrays;
import java.util.List;

public class Traversal {

    public static void main(String[] args) {
        Graph graph1 = new AdjacencyList<>(8);

        List<Edge<Integer, Integer>> edges = Arrays.asList(new Edge<>(0, 1), new Edge<>(0, 2),
                new Edge<>(1, 3), new Edge<>(1, 4),
                new Edge<>(2, 5), new Edge<>(2, 6),
                new Edge<>(3, 7),
                new Edge<>(4, 7),
                new Edge<>(5, 7),
                new Edge<>(6, 7));//,
                //new Edge<>(7, 0));

        graph1.build(edges);

        System.out.println("===== BFS Traversal =====");
        BFS bfs = new BFS(graph1.verticesCount());
        System.out.println("Traversed Path: " + bfs.traverse(graph1, 0));
        System.out.println("Traversed Path: " + bfs.traverse(graph1, 2));

        System.out.println("===== DFS Traversal =====");
        DFS dfs = new DFS(8);
        System.out.println("Traversed Path: " + dfs.traverse(graph1, 0));
        System.out.println("Traversed Path: " + dfs.traverse(graph1, 2));
    }
}
