package ArrayProblems;

public class TrappingRainwaterProblem {
    // Approach 1: Brute force

    // Approach 2: Dynamic Programming
    /*
    Algorithm

Find maximum height of bar from the left end upto an index i in the array \text{left\_max}left_max.
Find maximum height of bar from the right end upto an index i in the array \text{right\_max}right_max.
Iterate over the \text{height}height array and update ans:
Add min(left_max[i],right_max[i])−height[i] to ans
     */
/*
    int trap(vector<int>& height)
    {
        if(height.empty())
            return 0;
        int ans = 0;
        int size = height.size();
        vector<int> left_max(size), right_max(size);
        left_max[0] = height[0];
        for (int i = 1; i < size; i++) {
            left_max[i] = max(height[i], left_max[i - 1]);
        }
        right_max[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            right_max[i] = max(height[i], right_max[i + 1]);
        }
        for (int i = 1; i < size - 1; i++) {
            ans += min(left_max[i], right_max[i]) - height[i];
        }
        return ans;
    }
*/
    // Approach 3: Using stacks

    // Approach 4: Using 2 pointers
}
