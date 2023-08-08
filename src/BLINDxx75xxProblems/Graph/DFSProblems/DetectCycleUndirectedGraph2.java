package BLINDxx75xxProblems.Graph.DFSProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetectCycleUndirectedGraph2 {
    public boolean isCycle(int V, List<List<Integer>> adj) {
        int [] visited = new int[V];
        Arrays.fill(visited, 0);

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (dfsUtil(adj, visited, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsUtil(List<List<Integer>> adj, int[] visited, int node, int parent) {
        visited[node] = 1;
        for (int neighbor: adj.get(node)) {
            if (visited[neighbor] == 0) {
                if (dfsUtil(adj, visited, neighbor, node)) {
                    return true;
                }
            }
            // If an adjacent is visited and not parent of current
            // vertex, then there is a cycle.
            // we have reached another node which is not parent
            else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int numVertices = 4;
        List<List<Integer>> adjList = new ArrayList<>();

        // Initialize the adjacency list with empty lists for each vertex
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        // Adding edges to the graph
        addEdge(adjList, 0, 1);
        addEdge(adjList, 0, 3);
        addEdge(adjList, 1, 2);
        //addEdge(adjList, 2, 3);
        DetectCycleUndirectedGraph2 dg = new DetectCycleUndirectedGraph2();

        System.out.println(dg.isCycle(numVertices, adjList));
    }
    public static void addEdge(List<List<Integer>> adjList, int source, int destination) {
        // Add an edge between source and destination (undirected graph)
        adjList.get(source).add(destination);
        adjList.get(destination).add(source); // Adding the reverse edge as well
    }
}
