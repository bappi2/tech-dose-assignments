package BinarySearch;

public class FirstBadVersion {
    //The straight forward way is to brute force it by doing a linear scan.
    public int firstBadVersion(int n) {
        for (int i = 1; i < n; i++) {
            if (isBadVersion(i)) {
                return i;
            }
        }
        return n;
    }

    private boolean isBadVersion(int i) {
        return false;
    }

    /*Complexity analysis
    Time complexity : O(n)O(n). Assume that isBadVersion(version)isBadVersion(version)
    takes constant time to check if a version is bad. It takes at most n - 1n−1 checks,
    therefore the overall time complexity is O(n)O(n).
    Space complexity : O(1)O(1).
    */

    public int firstBadVersion2(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
