package PrampProblems;

public class ArrayIndexAndElementEquality {
    /*
    Given a sorted array arr of distinct integers, write a
    function indexEqualsValueSearch that returns the lowest index
    i for which arr[i] == i. Return -1 if there is no such index.
    Analyze the time and space complexities of your solution and
    explain its correctness.

Examples:

input: arr = [-8,0,2,5]
output: 2 // since arr[2] == 2

input: arr = [-1,0,3,6]
output: -1 // since no index in arr satisfies arr[i] == i.
Constraints:

[time limit] 5000ms
[input] array.integer arr
1 ≤ arr.length ≤ 100
     */

    static int indexEqualsValueSearch(int[] arr) {
        int start = 0, end = arr.length - 1;
        int res = -1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < mid) {
                // Go right
                start = mid + 1;
            } else {
                // Go left
                if (arr[mid] == mid)
                    res = mid;
                end = mid - 1;
            }
        }
        if (start == end && arr[start] == start) return start;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(indexEqualsValueSearch(new int[]{-8, 0, 2, 5}));
        System.out.println(indexEqualsValueSearch(new int[]{-5, 0, 2, 3, 4, 5}));
    }
}
