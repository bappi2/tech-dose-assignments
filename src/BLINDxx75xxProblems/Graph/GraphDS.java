package BLINDxx75xxProblems.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphDS {
    private Map<String, List<String>> adjacencyList;

    public GraphDS() {
        adjacencyList = new HashMap<>();
    }

    public void addNode(String node) {
        if (!adjacencyList.containsKey(node)) {
            adjacencyList.put(node, new ArrayList<>());
        }
    }

    public void deleteNode(String node) {
        if (adjacencyList.containsKey(node)) {
            // Delete all edges connected to the node
            for (String neighbor : adjacencyList.get(node)) {
                adjacencyList.get(neighbor).remove(node);
            }
            adjacencyList.remove(node);
        }
    }

    public void addEdge(String node1, String node2) {
        if (adjacencyList.containsKey(node1) && adjacencyList.containsKey(node2)) {
            adjacencyList.get(node1).add(node2);
            adjacencyList.get(node2).add(node1);
        }
    }

    public void deleteEdge(String node1, String node2) {
        if (adjacencyList.containsKey(node1) && adjacencyList.containsKey(node2)) {
            adjacencyList.get(node1).remove(node2);
            adjacencyList.get(node2).remove(node1);
        }
    }

    public List<String> getNeighbors(String node) {
        if (adjacencyList.containsKey(node)) {
            return adjacencyList.get(node);
        }
        return new ArrayList<>();
    }

    public List<String> getAllNodes() {
        return new ArrayList<>(adjacencyList.keySet());
    }

    public static void main(String[] args) {
        // Create a graph
        GraphDS graph = new GraphDS();

        // Add nodes
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        // Add edges
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");
        graph.addEdge("D", "A");

        // Get neighbors of a node
        List<String> neighbors = graph.getNeighbors("A");
        System.out.println(neighbors);  // Output: [B, D]

        // Delete an edge
        graph.deleteEdge("A", "B");

        // Delete a node
        graph.deleteNode("C");

        // Get all nodes in the graph
        List<String> nodes = graph.getAllNodes();
        System.out.println(nodes);  // Output: [A, B, D]
    }
}
