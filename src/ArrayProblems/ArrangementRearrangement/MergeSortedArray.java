package ArrayProblems.ArrangementRearrangement;

import java.util.Arrays;

public class MergeSortedArray {
    // Approach 1 : Merge and sort
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    // Approach 2 : Three Pointers (Start From the Beginning)

    /*
    The algorithm is similar to before, except this time we set p1 to
    point at index m - 1 of nums1, p2 to point at index n - 1 of nums2,
    and p to point at index m + n - 1 of nums1. This way, it is guaranteed
    that once we start overwriting the first m values in nums1, we will
    have already written each into its new position. In this way, we can
     eliminate the additional space.
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        // Set p1 and p2 to point to the end of their respective arrays.
        int p1 = m - 1;
        int p2 = n - 1;

        // And move p backwards through the array, each time writing
        // the smallest value pointed at by p1 or p2.
        for (int p = m + n - 1; p >= 0; p--) {
            if (p2 < 0) {
                break;
            }
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1--];
            } else {
                nums1[p] = nums2[p2--];
            }
        }
    }

}
