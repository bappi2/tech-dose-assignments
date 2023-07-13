package BLINDxx75xxProblems.Graph;
import java.util.*;

public class  JuggedArray {



        public List<Integer>[] adj;

        public JuggedArray(int numVertices) {
            adj = new ArrayList[numVertices];

            for (int i = 0; i < numVertices; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        public void addEdge(int source, int destination) {
            adj[source].add(destination);
            adj[destination].add(source);
        }

        public void bfs(int startVertex) {
            boolean[] visited = new boolean[adj.length];
            Queue<Integer> queue = new LinkedList<>();

            visited[startVertex] = true;
            queue.offer(startVertex);

            while (!queue.isEmpty()) {
                int currentVertex = queue.poll();
                System.out.print(currentVertex + " ");

                for (int neighbor : adj[currentVertex]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }
        }

        public static void main(String[] args) {
            int numVertices = 6;
            JuggedArray graph = new JuggedArray(numVertices);

            graph.addEdge(0, 1);
            graph.addEdge(0, 2);
            graph.addEdge(1, 3);
            graph.addEdge(1, 4);
            graph.addEdge(2, 4);
            graph.addEdge(3, 4);
            graph.addEdge(3, 5);
            graph.addEdge(4, 5);

            int startVertex = 0;
            System.out.println("BFS traversal starting from vertex " + startVertex + ":");
            graph.bfs(startVertex);
        }

    public static void jugged(String[] args) {
        int[][] graph = new int[4][];

        graph[0] = new int[3];
        graph[1] = new int[0];
        graph[2] = new int[1];
        graph[3] = new int[2];

        graph[0][0] = 1;
        graph[0][1] = 2;
        graph[0][2] = 3;

        graph[2][0] = 1;

        graph[3][0] = 0;
        graph[3][1] = 2;

        // Arrays.toString(array) only prints 1D array. toDeepString prints the whole contents. Check.
        System.out.println(Arrays.toString(graph));
        System.out.println(Arrays.deepToString(graph));
    }

}
