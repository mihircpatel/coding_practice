package com.learning.codingpractice.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class G4GGraph {
        private int V; // No. of vertices

        // Array of lists for
        // Adjacency List Representation
        private LinkedList<Integer> adj[];

        // Constructor
        @SuppressWarnings("unchecked") G4GGraph(int v)
        {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        // Function to add an edge into the graph
        void addEdge(int v, int w)
        {
            adj[v].add(w); // Add w to v's list.
        }

        // A function used by DFS
        void DFSUtil(int v, boolean visited[])
        {
            // Mark the current node as visited and print it
            visited[v] = true;
            System.out.print(v + " ");

            // Recur for all the vertices adjacent to this
            // vertex
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n])
                    DFSUtil(n, visited);
            }
        }

        // The function to do DFS traversal.
        // It uses recursive
        // DFSUtil()
        void DFS(int v)
        {
            // Mark all the vertices as
            // not visited(set as
            // false by default in java)
            boolean visited[] = new boolean[V];

            // Call the recursive helper
            // function to print DFS
            // traversal
            DFSUtil(v, visited);
        }

        // Driver's Code
        public static void main(String args[])
        {
            G4GGraph g = new G4GGraph(8);

            g.addEdge(0, 1);
            g.addEdge(0, 2);
            g.addEdge(1, 3);
            g.addEdge(1, 4);
            g.addEdge(2, 5);
            g.addEdge(2, 6);
            g.addEdge(3, 7);
            g.addEdge(4, 7);
            g.addEdge(5, 7);
            g.addEdge(6, 7);
            //g.addEdge(7, 0);


            System.out.println(
                    "Following is Depth First Traversal "
                            + "(starting from vertex 2)");

            // Function call
            g.DFS(0);
        }
}
