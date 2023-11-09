package com.learning.codingpractice.graph;

import java.util.List;
import java.util.Scanner;

public class AdjacencyMatrix<V> implements Graph<V> {
    int[][] adjMat;

    AdjacencyMatrix(){
        adjMat = new int[1][1];
    }

    public int[][] create(int n, int m) {
        Scanner sc = new Scanner(System.in);

        // n is the number of vertices
        // m is the number of edges
//        int n = sc.nextInt();
//        int m = sc.nextInt();
        adjMat = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjMat[u][v] = 1;
            adjMat[v][u] = 1;
            // for a directed graph with an edge pointing from u to v,we just assign
            // adjMat[u][v] as 1
        }
        return adjMat;
    }

    @Override
    public void addEdge(Edge edge) {

    }

    @Override
    public int verticesCount() {
        return 0;
    }

    @Override
    public List getAdjacentNodes(Integer vertex) {
        return null;
    }

    @Override
    public void build(List list) {

    }
}
