package ArrayProblems.FaceBook;

import java.util.List;

// This is the interface provided by LeetCode for NestedInteger
interface NestedInteger2 {
    // Returns true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // Returns the single integer that this NestedInteger holds, if it holds a single integer.
    // Returns null if this NestedInteger holds a nested list.
    public Integer getInteger();

    // Returns the nested list that this NestedInteger holds, if it holds a nested list.
    // Returns null if this NestedInteger holds a single integer.
    public List<NestedInteger2> getList();
}

public class NestedInteger {
    public int depthSum(List<NestedInteger2> nestedList) {
        return depthSumHelper(nestedList, 1);
    }

    private int depthSumHelper(List<NestedInteger2> nestedList, int depth) {
        int sum = 0;

        for (NestedInteger2 ni : nestedList) {
            if (ni.isInteger()) {
                sum += ni.getInteger() * depth;
            } else {
                sum += depthSumHelper(ni.getList(), depth + 1);
            }
        }

        return sum;
    }
}
