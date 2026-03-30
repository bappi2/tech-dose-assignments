### 125. Valid Palindrome
```agsl
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(); 
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }

```
### 167. Two Sum II - Input Array Is Sorted
```agsl
    public int[] twoSum(int[] numbers, int target) {
        for (int i =0; i < numbers.length -1; i++) {
            int other = target - numbers[i]; 
            int lo = i + 1; 
            int hi = numbers.length -1; 
            while (lo <= hi) {
                int mid = lo + (hi -lo) / 2; 
                if (numbers[mid] == other) {
                    return new int[] { i + 1, mid + 1}; 
                }
                else if (numbers[mid] < other) {
                    lo = mid + 1; 
                }
                else {
                    hi = mid - 1;
                }
                
            }
        }
        return new int[] { -1, -1};
    }
```
### 15. 3Sum
```agsl
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();  
        Arrays.sort(nums); 

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i-1] < nums[i]) {
            int other = 0 - nums[i]; 
            int lo = i + 1; 
            int hi = nums.length -1; 

            while (lo < hi) {
                int sum = nums[lo] + nums[hi]; 
                if (sum == other ) {
                    List<Integer> current = new ArrayList<>(); 
                    current.add(nums[i]); 
                    current.add(nums[lo]); 
                    current.add(nums[hi]); 
                    result.add(current); 
                    lo++; 
                    hi--; 
                    while (lo < hi && nums[lo] == nums[lo-1]) lo++; 
                    while (lo < hi && nums[hi] == nums[hi + 1]) hi--; 
                }
                else if (sum < other) {
                    lo++;
                }
                else {
                    hi--;
                }
            }
            }
        }
        return result; 
    }
```
### 11. Container With Most Water
```agsl
    public int maxArea(int[] height) {
        int max = 0; 
        /*for (int i =0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i); 
                max = Math.max(max, area);
            }
        }*/ 

        int lo = 0; 
        int hi = height.length - 1; 
        while (lo < hi) {
            max = Math.max(max, Math.min(height[lo], height[hi]) * (hi - lo));
            if (height[lo] <= height[hi]) {
                lo++;
            }
            else {
            hi--;
        }
        }
        
        return max; 
    }
```