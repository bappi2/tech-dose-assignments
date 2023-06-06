package BLINDxx75xxProblems.Graph;



import java.util.ArrayList;
import java.util.List;

public class GraphEdgeList {
    private List<Edge> edges;

    public GraphEdgeList() {
        edges = new ArrayList<>();
    }

    public void addEdge(String source, String destination) {
        edges.add(new Edge(source, destination));
    }

    public void removeEdge(String source, String destination) {
        edges.removeIf(edge -> edge.source.equals(source) && edge.destination.equals(destination));
    }

    public List<String> getNeighbors(String node) {
        List<String> neighbors = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.source.equals(node)) {
                neighbors.add(edge.destination);
            }
        }
        return neighbors;
    }

    public List<String> getAllNodes() {
        List<String> nodes = new ArrayList<>();
        for (Edge edge : edges) {
            if (!nodes.contains(edge.source)) {
                nodes.add(edge.source);
            }
            if (!nodes.contains(edge.destination)) {
                nodes.add(edge.destination);
            }
        }
        return nodes;
    }

    private static class Edge {
        private String source;
        private String destination;

        public Edge(String source, String destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    public static void main(String[] args) {
        // Create a graph
        GraphEdgeList graph = new GraphEdgeList();

        // Add edges
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");
        graph.addEdge("D", "A");

        // Get neighbors of a node
        List<String> neighbors = graph.getNeighbors("A");
        System.out.println(neighbors);  // Output: [B]

        // Remove an edge
        graph.removeEdge("B", "C");

        // Get all nodes in the graph
        List<String> nodes = graph.getAllNodes();
        System.out.println(nodes);  // Output: [A, B, C, D]
    }
}
