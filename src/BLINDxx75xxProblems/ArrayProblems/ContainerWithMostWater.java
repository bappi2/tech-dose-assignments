package BLINDxx75xxProblems.ArrayProblems;

public class ContainerWithMostWater {
    /*
    Example 2:

Input: height = [1,1]
Output: 1


Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104
     */

    public int maxArea(int[] height) {
        int maxarea = 0;
        for (int left = 0; left < height.length; left++) {
            for (int right = left + 1; right < height.length; right++) {
                int width = right - left;
                maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * width);
            }
        }
        return maxarea;
    }

    public int maxArea2(int[] height) {
        int maxarea = 0;
        int left = 0;
        int right = height.length - 1;
        // end condition left == right
        while (left < right) {
            int width = right - left;
            maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * width);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxarea;
    }
}
