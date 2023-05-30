package BLINDxx75xxProblems.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            int [] prereq = prerequisites[i];
            adjList.get(prereq[1]).add(prereq[0]);
        }

        int [] visited = new int[numCourses];
        Arrays.fill(visited, 0);

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (detectCycle(adjList, i, visited)) {
                    return false;
                }
            }
        }
        return true;

    }
    boolean detectCycle(List<List<Integer>> adjList, int index, int [] visited) {
        if (visited[index] == 1) {
            return true;
        }
        else if (visited[index] == 2) {
            return false;
        }
        else {
            visited[index] = 1;
            for (int neighbor : adjList.get(index)) {
                if (detectCycle(adjList, neighbor, visited)) {
                    return true;
                }
            }
            visited[index] = 2;
            return false;
        }
    }
}
