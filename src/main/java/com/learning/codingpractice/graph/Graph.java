package com.learning.codingpractice.graph;

import java.util.List;

public interface Graph<V> {
    void addEdge(Edge<V, V> edge);

    void build(List<Edge<V, V>> edges);

    int verticesCount();

    List<V> getAdjacentNodes(Integer vertex);
}
