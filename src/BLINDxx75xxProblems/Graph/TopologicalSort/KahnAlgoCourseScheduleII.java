package BLINDxx75xxProblems.Graph.TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnAlgoCourseScheduleII {
    public boolean kahnsAlgo(List<List<Integer>> adj, int n, int[] indegree, List<Integer> ans) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int a : adj.get(curr)) {
                indegree[a]--;
                if (indegree[a] == 0) {
                    q.add(a);
                }
            }
            ans.add(curr);
            count++;
        }
        if (count != n) {
            return false;
        }
        return true;
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];

        for (int i = 0; i < n; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        List<Integer> ans = new ArrayList<>();
        if (kahnsAlgo(adj, numCourses, indegree, ans)) {
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                res[i] = ans.get(i);
            }
            return res;
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = { {1, 0} };
        int[] order = findOrder(numCourses, prerequisites);
        for (int i = 0; i < order.length; i++) {
            System.out.print(order[i] + "->");
        }
        System.out.println();
    }
}
