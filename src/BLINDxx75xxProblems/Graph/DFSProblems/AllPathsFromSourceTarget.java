package BLINDxx75xxProblems.Graph.DFSProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSourceTarget {
    // https://leetcode.com/problems/all-paths-from-source-to-target/description/
    private int target;
    private int[][] graph;
    private List<List<Integer>> results;

    protected void backtrack(int currNode, LinkedList<Integer> path) {
        if (currNode == this.target) {
            // Note: one should make a deep copy of the path
            this.results.add(new ArrayList<Integer>(path));
            return;
        }
        // explore the neighbor nodes one after another.
        for (int nextNode : this.graph[currNode]) {
            // mark the choice, before backtracking.
            path.addLast(nextNode);
            this.backtrack(nextNode, path);
            // remove the previous choice, to try the next choice
            path.removeLast();
        }
    }

    public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();

        currPath.add(0);
        dfs(graph, result, currPath, 0);
        return result;
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        this.target = graph.length - 1;
        this.graph = graph;
        this.results = new ArrayList<List<Integer>>();
        // adopt the LinkedList for fast access to the tail element.
        LinkedList<Integer> path = new LinkedList<Integer>();
        path.addLast(0);
        // kick of the backtracking, starting from the source (node 0)
        this.backtrack(0, path);
        return this.results;
    }

    void dfs(int[][] graph, List<List<Integer>> result, List<Integer> currPath, int currNode) {
        if (currNode == graph.length -1) {

            result.add(new ArrayList<>(currPath));
            return;
        }
        for (int neighbor: graph[currNode]) {
            currPath.add(neighbor);
            dfs(graph, result, currPath, neighbor);
            currPath.remove(currPath.size()-1);
        }
    }

    public List<List<Integer>> allPathsSourceTarget3(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();

        boolean [] seen = new boolean[graph.length];
        Arrays.fill(seen, false);

        currPath.add(0);
        seen[0] = true;
        dfs_undirected(graph, result, seen, currPath, 0);
        return result;
    }

    private void dfs_undirected(int[][] graph, List<List<Integer>> result,
                                boolean[] seen, List<Integer> currPath, int currNode) {
        if (currNode == graph.length -1) {
            result.add(new ArrayList<>(currPath));
            return;
        }
        for (int neighbor: graph[currNode]) {
            if (seen[currNode] != true) {
                currPath.add(neighbor);
                seen[neighbor] = true;
                dfs_undirected(graph, result, seen, currPath, neighbor);
                seen[neighbor] = false;
                currPath.remove(currPath.size() -1);
            }
        }
    }
}
