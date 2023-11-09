package com.learning.codingpractice.graph;

import java.util.LinkedList;
import java.util.List;

public class AdjacencyList<V> implements Graph<V> {
    int noOfVertices;
    List<V> adj[];

    public AdjacencyList(int v) {
        this.noOfVertices = v;
        this.adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    @Override
    public void addEdge(Edge<V, V> edge) {
        this.adj[Integer.parseInt(edge.getSource().toString())].add(edge.getDestination());
    }

    public void build(List<Edge<V, V>> edges) {
        edges.stream().forEach( edge -> addEdge(edge));
    }

    @Override
    public int verticesCount() {
        return this.noOfVertices;
    }

    @Override
    public List<V> getAdjacentNodes(Integer vertex) {
        return this.adj[vertex];
    }

}
