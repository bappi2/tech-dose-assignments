package BLINDxx75xxProblems.Graph;

import java.util.*;

public class AdjMatrixDS {
    private int numVertices;
    private int[][] adjMatrix;

    public AdjMatrixDS(int numVertices) {
        this.numVertices = numVertices;
        this.adjMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int v1, int v2) {
        if (v1 >= 0 && v1 < numVertices && v2 >= 0 && v2 < numVertices) {
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;  // Assuming an undirected graph
        }
    }

    public void removeEdge(int v1, int v2) {
        if (v1 >= 0 && v1 < numVertices && v2 >= 0 && v2 < numVertices) {
            adjMatrix[v1][v2] = 0;
            adjMatrix[v2][v1] = 0;
        }
    }

    public boolean isEdge(int v1, int v2) {
        if (v1 >= 0 && v1 < numVertices && v2 >= 0 && v2 < numVertices) {
            return adjMatrix[v1][v2] == 1;
        }
        return false;
    }

    public void dfsTraversal(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        Stack<Integer> stack = new Stack<>();

        visited[startVertex] = true;
        stack.push(startVertex);

        System.out.println("DFS Traversal:");
        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            System.out.print(currentVertex + " ");

            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[currentVertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }
        System.out.println();
    }

    public void bfsTraversal(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        System.out.println("BFS Traversal:");
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[currentVertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        System.out.println();
    }

    public boolean hasPath(int source, int destination) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[source] = true;
        queue.add(source);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            if (currentVertex == destination) {
                return true;
            }

            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[currentVertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

        return false;
    }

    public List<List<Integer>> findAllPaths(int source, int destination) {
        boolean[] visited = new boolean[numVertices];
        List<List<Integer>> paths = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(source);
        visited[source] = true;

        findAllPathsUtil(source, destination, visited, stack, paths);

        return paths;
    }

    private void findAllPathsUtil(int currentVertex, int destination, boolean[] visited, Stack<Integer> stack,
                                  List<List<Integer>> paths) {
        visited[currentVertex] = true;

        if (currentVertex == destination) {
            paths.add(new ArrayList<>(stack));
        } else {
            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[currentVertex][i] == 1 && !visited[i]) {
                    stack.push(i);
                    findAllPathsUtil(i, destination, visited, stack, paths);
                    stack.pop();
                }
            }
        }
        visited[currentVertex] = false;
    }

    public boolean hasCycle() {
        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i] && hasCycleUtil(i, visited, -1)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycleDirected() {
        int[] visited = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            if (visited[i] == 0 && hasCycleUtilDirected(i, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycleUtilDirected(int currentVertex, int[] visited) {
        if (visited[currentVertex] == 1) {
            return true;
        }
        else if (visited[currentVertex] == 2) {
            return false;
        }
        else {
            visited[currentVertex] = 1;

            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[currentVertex][i] == 1 && visited[i] == 0) {
                    if (hasCycleUtilDirected(i, visited)) {
                        return true;
                    }
                }
            }
            visited[currentVertex] = 2;
        }
        return false;
    }

    private boolean hasCycleUtil(int currentVertex, boolean[] visited, int parent) {
        visited[currentVertex] = true;

        for (int i = 0; i < numVertices; i++) {
            if (adjMatrix[currentVertex][i] == 1 && !visited[i]) {
                if (hasCycleUtil(i, visited, currentVertex)) {
                    return true;
                }
            } else if (adjMatrix[currentVertex][i] == 1 && visited[i] && i != parent) {
                return true;
            }
        }

        return false;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                sb.append(adjMatrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // Example usage
    public static void main(String[] args) {
        AdjMatrixDS graph = new AdjMatrixDS(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println(graph);
        int source = 0;
        int destination = 3;

        System.out.println("Does a path exist between " + source + " and " + destination + "? " +
                graph.hasPath(source, destination));

        List<List<Integer>> paths = graph.findAllPaths(source, destination);
        System.out.println("All paths between " + source + " and " + destination + ":");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }

        boolean hasCycle = graph.hasCycle();
        System.out.println("Does the graph have a cycle? " + hasCycle);

        graph.dfsTraversal(0);
        graph.bfsTraversal(0);
    }
}
