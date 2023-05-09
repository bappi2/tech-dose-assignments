package BLINDxx75xxProblems.Graph.DFSProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        buildAdjList(edges, adjList);
        boolean[] visted = new boolean[adjList.size()];
        int [] edge = new int[]{-1, -1};
        for (int u : adjList.keySet()) {
            if (!visted[u]) {
                if (dfs(u, -1, adjList, visted, edge)) {
                    return edge;
                }
            }
        }
        return edge;
    }

    private boolean dfs(int u, int parent, Map<Integer,
            List<Integer>> adjList, boolean[] visted, int[] edge)
    {
        visted[u] = true;
        for(int neighbor: adjList.get(u)) {
            if (!visted[neighbor]) {
                if (dfs(neighbor, u, adjList, visted, edge) ) {
                    return true;
                }
            }
            else if (neighbor != parent) {
                edge[0] = neighbor;
                edge[1] = parent;
                return true;
            }
        }
        return false;
    }

    private void buildAdjList(int [][] edges, Map<Integer, List<Integer>> adjList) {
        for (int [] edge: edges) {
            adjList.putIfAbsent(edge[0], new ArrayList<>());
            adjList.putIfAbsent(edge[1], new ArrayList<>());
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3}, {2, 3}};
        RedundantConnection rc = new RedundantConnection();
        System.out.println(rc.findRedundantConnection(edges));;
    }
}
