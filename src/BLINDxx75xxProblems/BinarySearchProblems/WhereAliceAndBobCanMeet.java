package BLINDxx75xxProblems.BinarySearchProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WhereAliceAndBobCanMeet {

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int len = queries.length, n = heights.length;
        int[] result = new int[len];
        List<int[]> qList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int left = Math.min(queries[i][0], queries[i][1]);
            int right = Math.max(queries[i][0], queries[i][1]);
            if (left == right || heights[left] < heights[right]) {
                result[i] = right;
            } else {
                qList.add(new int[]{left, right, i});
            }
        }
        Collections.sort(qList, (a, b) -> Integer.compare(b[1], a[1]));
        int qid = 0;
        int[] stack = new int[n];
        int idx = -1;
        for (int i = n - 1; i >= 0; i--) {
            while (qid < qList.size() && qList.get(qid)[1] == i) {
                //binarySearch
                int sidx = binarySearch(heights, stack, 0, idx, heights[qList.get(qid)[0]]);
                result[qList.get(qid)[2]] = sidx == -1 ? -1 : stack[sidx];
                qid++;
            }
            while (idx >= 0 && heights[stack[idx]] <= heights[i]) {
                idx--;
            }
            stack[++idx] = i;
        }
        return result;
    }

    private int binarySearch(int[] heights, int[] stack, int start, int end, int target) {
        if (end == -1)
        {
            return -1;
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (heights[stack[mid]] < target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (heights[stack[end]] > target) {
            return end;
        }
        if (heights[stack[start]] > target) {
            return start;
        }
        return -1;
    }

    public static void main(String[] args) {

            WhereAliceAndBobCanMeet solution = new WhereAliceAndBobCanMeet();

            int[] heights = {6,4,8,5,2,7};
            int[][] queries = {{0, 1}, {0, 3}, {2, 4}, {3, 4}, {2, 2}};
            System.out.println(Arrays.toString(solution.leftmostBuildingQueries(heights, queries)));

    }
}