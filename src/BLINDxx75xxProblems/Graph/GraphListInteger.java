package BLINDxx75xxProblems.Graph;


import java.util.ArrayList;
import java.util.List;

public class GraphListInteger {
    private List<List<Integer>> adjacencyList;

    public GraphListInteger(int numNodes) {
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int node1, int node2) {
        if (node1 >= 0 && node1 < adjacencyList.size() && node2 >= 0 && node2 < adjacencyList.size()) {
            adjacencyList.get(node1).add(node2);
            adjacencyList.get(node2).add(node1);
        }
    }

    public void removeEdge(int node1, int node2) {
        if (node1 >= 0 && node1 < adjacencyList.size() && node2 >= 0 && node2 < adjacencyList.size()) {
            adjacencyList.get(node1).remove(Integer.valueOf(node2));
            adjacencyList.get(node2).remove(Integer.valueOf(node1));
        }
    }

    public List<Integer> getNeighbors(int node) {
        if (node >= 0 && node < adjacencyList.size()) {
            return adjacencyList.get(node);
        }
        return new ArrayList<>();
    }

    public List<Integer> getAllNodes() {
        List<Integer> nodes = new ArrayList<>();
        for (int i = 0; i < adjacencyList.size(); i++) {
            nodes.add(i);
        }
        return nodes;
    }

    public static void main(String[] args) {
        // Create a graph with 5 nodes
        GraphListInteger graph = new GraphListInteger(5);

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);

        // Get neighbors of a node
        List<Integer> neighbors = graph.getNeighbors(0);
        System.out.println(neighbors);  // Output: [1, 4]

        // Remove an edge
        graph.removeEdge(1, 2);

        // Get all nodes in the graph
        List<Integer> nodes = graph.getAllNodes();
        System.out.println(nodes);  // Output: [0, 1, 2, 3, 4]
    }
}
