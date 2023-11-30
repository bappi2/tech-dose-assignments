package ArrayProblems.FaceBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build the adjacency list representation of the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph.computeIfAbsent(course, k -> new ArrayList<>()).add(prerequisiteCourse);
        }

        // Initialize the status array (0: unvisited, 1: visiting, 2: visited)
        int[] status = new int[numCourses];

        // Perform DFS on each course
        for (int course = 0; course < numCourses; course++) {
            if (status[course] == 0 && !dfs(graph, status, course)) {
                return false; // Cycle detected, cannot finish all courses
            }
        }

        return true; // No cycle detected, can finish all courses
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int[] status, int course) {
        // Mark the current course as visiting
        status[course] = 1;

        // Explore prerequisites
        if (graph.containsKey(course)) {
            for (int prerequisite : graph.get(course)) {
                if (status[prerequisite] == 1) {
                    return false; // Cycle detected
                }

                if (status[prerequisite] == 0 && !dfs(graph, status, prerequisite)) {
                    return false; // Cycle detected in the subgraph
                }
            }
        }

        // Mark the current course as visited
        status[course] = 2;

        return true;
    }
}
