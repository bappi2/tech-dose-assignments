package BLINDxx75xxProblems.BinarySearchProblems;

public class FindFirstandLastPositionSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int [] result = {-1 , -1};
        for (int i=0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (result[0] == -1) {
                    result[0] = i;
                }
                result[1] = i;
            }
        }
        return result;
    }


    // lo, hi, mid = lo + (hi - lo) / 2
    // findFirst() nums[mid] < target
    // findLast() nums[mid] > target
    public int[] searchRange2(int[] nums, int target) {
        int n = nums.length;
        int left = findFirst(nums, target, n);
        int right = findLast(nums, target, n);
        return new int[]{left, right};
    }

    private int findFirst(int[] nums, int target, int n) {
        int lo = 0, hi = n - 1;
        int index = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1; // if found nums[mid] < target is false; force to go left
            }

            if (nums[mid] == target) {
                index = mid;
            }
        }

        return index;
    }

    private int findLast(int[] nums, int target, int n) {
        int lo = 0, hi = n - 1;
        int index = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1; // if found nums[mid] > target is false; force to go right
            }

            if (nums[mid] == target) {
                index = mid;
            }
        }

        return index;
    }


    //
    //   ======
    public int[] searchRange3(int[] nums, int target) {

        int firstOccurrence = this.findBound(nums, target, true);

        if (firstOccurrence == -1) {
            return new int[]{-1, -1};
        }

        int lastOccurrence = this.findBound(nums, target, false);

        return new int[]{firstOccurrence, lastOccurrence};
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int N = nums.length;
        int begin = 0, end = N - 1;

        while (begin <= end) {

            int mid = (begin + end) / 2;

            if (nums[mid] == target) {

                if (isFirst) {

                    // This means we found our lower bound.
                    if (mid == begin || nums[mid - 1] != target) {
                        return mid;
                    }

                    // Search on the left side for the bound.
                    end = mid - 1;

                } else {

                    // This means we found our upper bound.
                    if (mid == end || nums[mid + 1] != target) {
                        return mid;
                    }

                    // Search on the right side for the bound.
                    begin = mid + 1;
                }

            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }

        return -1;
    }
}
