package BLINDxx75xxProblems.Graph.TopologicalSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseScheduleII {
    //Graph coloring: 0->not visited...1->visited...2->visited & processed

    private boolean detectCycleUtil(List<List<Integer>> adj, int[] visited, int v) {
        if (visited[v] == 1) {
            return true;
        }
        if (visited[v] == 2) {
            return false;
        }

        visited[v] = 1; //Mark current node as visited
        for (int i = 0; i < adj.get(v).size(); ++i) {
            if (detectCycleUtil(adj, visited, adj.get(v).get(i))) {
                return true;
            }
        }

        visited[v] = 2; //Mark current node as processed
        return false;
    }

    //Cycle detection
    public boolean detectCycle(List<List<Integer>> adj, int n) {
        int[] visited = new int[n];
        for (int i = 0; i < n; ++i) {
            if (visited[i] == 0) {
                if (detectCycleUtil(adj, visited, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    //Topological sort
    private void dfs(List<List<Integer>> adj, int v, boolean[] visited, Stack<Integer> mystack) {
        visited[v] = true;
        for (int i = 0; i < adj.get(v).size(); ++i) {
            if (!visited[adj.get(v).get(i)]) {
                dfs(adj, adj.get(v).get(i), visited, mystack);
            }
        }
        mystack.push(v);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            adj.add(new ArrayList<>());
        }

        //Make adjacency list
        for (int i = 0; i < n; ++i) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        //Detect cycle...If present then return empty array
        int[] ans = new int[numCourses];
        if (detectCycle(adj, numCourses)) {
            return new int[0];
        }

        //Find Topological sort and store it in stack
        Stack<Integer> mystack = new Stack<>();
        boolean[] visited = new boolean[numCourses];

        //Apply DFS and find topological sort
        for (int i = 0; i < numCourses; ++i) {
            if (!visited[i]) {
                dfs(adj, i, visited, mystack);
            }
        }

        int i = 0;
        while (!mystack.empty()) {
            ans[i] = mystack.pop();
            i++;
        }
        return ans;
    }

}
