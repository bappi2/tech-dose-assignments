Two super-common interval conventions:

Closed interval [lo, hi] (both ends included)

Half-open [lo, hi) (lo included, hi excluded)
0) exact index of target (closed interval)

Use when you want “find target, else -1”.
```agsl
int binarySearch(int[] a, int target) {
    int lo = 0, hi = a.length - 1;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2; // avoid overflow
        if (a[mid] == target) return mid;
        else if (a[mid] < target) lo = mid + 1;
        else hi = mid - 1;
    }
    return -1;
}
```
1) lower_bound = first index >= target (half-open)

This is the “search insert position” pattern. Works great with duplicates.
```agsl
int lowerBound(int[] a, int target) {
    int lo = 0, hi = a.length;           // [lo, hi)
    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        if (a[mid] < target) lo = mid + 1;
        else                 hi = mid;   // a[mid] >= target
    }
    return lo; // may be a.length if all < target
}
```
### 704. Binary Search
```agsl
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1; 
        int hi = piles[0]; 

        for (int i = 1; i < piles.length; i++) {
            hi = Math.max(hi, piles[i]); 
        }

        while (lo < hi) {
            int hour = 0; 
            int mid = lo + (hi -lo) / 2; 
            for (int i = 0; i < piles.length; i++) {
                hour += Math.ceil(piles[i] * 1.0 / mid);
                if (hour > h) 
                    break;
            }
            if (hour > h) {
                lo = mid + 1;
            }
            else {
                hi = mid; 
            }
        }
        return lo; 
    }
```
### 74. Search a 2D Matrix
```agsl
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length; 
        int cols = matrix[0].length; 

        int lo = 0; 
        int hi = rows * cols -1; 

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; 
            if (matrix[mid / cols][mid % cols] == target ) {
                return true;
            }
            else if (matrix[mid / cols][mid % cols] < target ) {
                lo = mid + 1;
            }
            else {
                hi = mid -1;
            }
        }
        return false; 
    }
```
### 875. Koko Eating Bananas
```agsl
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1; 
        int hi = piles[0]; 

        for (int i = 1; i < piles.length; i++) {
            hi = Math.max(hi, piles[i]); 
        }

        while (lo < hi) {
            int hour = 0; 
            int mid = lo + (hi -lo) / 2; 
            for (int i = 0; i < piles.length; i++) {
                hour += Math.ceil(piles[i] * 1.0 / mid);
                if (hour > h) 
                    break;
            }
            if (hour > h) {
                lo = mid + 1;
            }
            else {
                hi = mid; 
            }
        }
        return lo; 
    }
}
```
### 153. Find Minimum in Rotated Sorted Array
```agsl
    public int findMin(int[] nums) {
        int lo = 0; 
        int hi = nums.length -1; 

        while (lo <= hi ) {
            int mid = lo + (hi - lo) / 2; 

            if (nums[lo] <= nums[mid] && nums[mid] <= nums[hi]) {
                return nums[lo]; 
            }
            else if (nums[lo] <= nums[mid] && nums[mid] >= nums[hi]) {
                lo = mid + 1; 
            }
            else {
                hi = mid;
            }
        }
        // lo == hi + 1
        return nums[lo];
    }
```
### 33. Search in Rotated Sorted Array
```agsl
    public int search(int[] nums, int target) {
        int lo = 0; 
        int hi = nums.length - 1; 

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; 
            if (nums[mid] == target) {
                return mid; 
            }
            else if (nums[lo] <= nums[mid]) {
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                }
                else {
                    lo = mid + 1; 
                }
            }
            else {
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                }
                else {
                    hi = mid - 1; 
                }
            }

        }
        return -1; 
    }
```

### 981. Time Based Key-Value Store
```agsl
class TimeMap {
    Map<String, TreeMap<Integer, String>> map; 
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<Integer, String>(Collections.reverseOrder()));
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
    
        for (int timeKey: map.get(key).keySet()) {
            if ( timeKey <= timestamp) {
                return map.get(key).get(timeKey);
            }
        }
        return "";
    }
}

```
### 34. Find First and Last Position of Element in Sorted Array
```agsl
    public int[] searchRange(int[] nums, int target) {
        int left = searchRangeHelper(nums, target, true); 
        int right = searchRangeHelper(nums, target, false); 

        return new int[] {left, right}; 
    }

    int searchRangeHelper(int []nums, int target, boolean isFirst) {
        int lo = 0; 
        int hi = nums.length -1; 

        while (lo <= hi) {
            int mid = lo + (hi - lo) /2; 

            if (nums[mid] == target) {
                if (isFirst == true) {
                    if (mid == lo || nums[mid -1] != target) {
                    return mid; 
                }
                hi = mid - 1;
                }
                else {
                    if (mid == hi || nums[mid+1] != target) {
                        return mid;
                    }
                    lo = mid + 1; 
                }
            }
            else if (nums[mid] < target) 
            {
                lo = mid + 1; 
            }
            else {
                hi = mid -1; 
            }
        }
        return -1; 
    }
```
### 50. Pow(x, n)
```agsl
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0; 
        }
        else if (n == 1) {
            return x;
        }
        else if (n < 0) {
            x = 1 / x;
            return n % 2 == 0 ? myPow(x * x, -(n/2)) : x * myPow(x * x, -(n/2)); 

        }
        else {
            return n % 2 == 0 ? myPow(x * x, n/2) : x *  myPow(x * x, n/2); 
        }
    }
```
### 35 Search Insert Position
```agsl
    public int searchInsert(int[] nums, int target) {
        int lo = 0; 
        int hi = nums.length; 

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2; 
            if (nums[mid] < target) {
                lo = mid + 1; 
            }
            else {
                hi = mid;
            }
        }
        return lo; 
        
    }
```
### 278. First Bad Version
```agsl
    public int firstBadVersion(int n) {
        int lo = 1; 
        int hi = n; 

        while (lo < hi) {
            int mid = lo +(hi -lo) / 2; 
            if (isBadVersion(mid) == false) {
                lo = mid + 1;
            }
            else {
                hi = mid; 
            }
        } 
        return lo; 
    }
```
### 4. Median of Two Sorted Arrays
```agsl
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int [] merged = new int[len];
        for (int i = 0; i < nums1.length; i++) {
            merged[i] = nums1[i]; 
        }
        for (int i = 0; i < nums2.length; i++) {
            merged[nums1.length + i] = nums2[i]; 
        }
        Arrays.sort(merged);
        
        return len % 2 != 0 ? merged[len / 2] : (merged[len / 2] + merged[len/2 - 1])/ 2f;
    }
```