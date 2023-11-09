package com.learning.codingpractice.graph;

public class Edge<S, D> {
    S source;
    D destination;

    public Edge(S s, D d) {
        this.source = s;
        this.destination = d;
    }

    public D getDestination() {
        return destination;
    }

    public void setDestination(D destination) {
        this.destination = destination;
    }

    public S getSource() {
        return source;
    }

    public void setSource(S source) {
        this.source = source;
    }
}
