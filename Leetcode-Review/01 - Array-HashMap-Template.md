### 217. Contains Duplicate
```agsl
    public boolean containsDuplicate(int[] nums) {
        for (int i =0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    return true;

            }
        }
        return false; 
    }
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums); 
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == nums[i]) 
                return true;
        }
        return false; 
    }
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>(); 
        for (int num : nums) {
            if (!seen.add(num)) 
                return true; 
        }
        return false; 
    }
    public boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count() != nums.length;
    }
```

### 242. Valid Anagram
```agsl
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char [] sArray = s.toCharArray(); 
        char [] tArray = t.toCharArray(); 

        Arrays.sort(sArray);
        Arrays.sort(tArray); 
        return Arrays.equals(sArray, tArray);
    }
        public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) 
            return false;
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a'] ++; 
            freq[t.charAt(i)-'a']--; 
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) 
                return false;
        }
        return true;
    }
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> freq = new HashMap<>(); 
        for (int i = 0; i < s.length(); i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (!freq.containsKey(t.charAt(i))) {
                return false;
            }
            freq.put(t.charAt(i), freq.get(t.charAt(i))-1);
            if (freq.get(t.charAt(i)) < 0) {
                return false;
            }
        }
        return true;
    }
    
```
### 1. Two Sums
```agsl
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] { -1, -1};
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>(); 
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i]; 
            if (seen.containsKey(other)) {
                return new int[] {seen.get(other), i};
            }
            seen.put(nums[i], i);
        }
        return new int[] {-1, -1}; 
    }
```
### 49. Group Anagrams
```agsl
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(); 
        for (String str : strs) {
            String key = FindKey(str); 
            map.putIfAbsent(key, new ArrayList<>()); 
            map.get(key).add(str);      
        }
        return new ArrayList<>(map.values()); 

    }
    String FindKey(String str) {
        char[] sArray = str.toCharArray(); 
        Arrays.sort(sArray);
        return new String(sArray);
    }
    String FindKey2(String str) {
        int[] freq = new int[26]; 
        for (int i =0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++; 
        }
        ;
        return Arrays.toString(freq);
    }
```
### 347. Top K Frequent Elements
```agsl
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>(); 
        for (int i =0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b)-> freq.get(a) - freq.get(b));
        for (int key : freq.keySet()) {
            minHeap.offer(key); 
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        } 
        int [] result = new int[k]; 
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }
```
### 271. Encode and Decode Strings
```agsl
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder(); 
        for (String str : strs) {
            sb.append(str.length()).append("#").append(str); 
        }
        return sb.toString(); 
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>(); 
        int i = 0;
        int j = 0; 
        int len = s.length(); 
        while (i < len) {
            j = i; 
            while (s.charAt(i) != '#') {
                i++;
                
            }
            int segmentLength = Integer.valueOf(s.substring(j, i)); 
            String segment = s.substring(i+1, i+1+segmentLength);
            result.add(segment);
            i = i+1+segmentLength;
        }
        return result; 
    }
```
### 238. Product of Array Except Self
```agsl
public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length]; 

       /* int[] left = new int[nums.length]; 
        int[] right = new int[nums.length]; 

        left[0] = 1; 
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i-1] * nums[i-1]; 
        }

        right[nums.length-1] = 1; 
        for(int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1]; 
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = left[i] * right[i]; 
        } */

        result[0] = 1; 
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i-1] * nums[i-1]; 
        }
        int runningProduct = 1; 
        for (int i = nums.length-1; i >= 0; i--) {
            result[i] = result[i] * runningProduct; 
            runningProduct = runningProduct*nums[i]; 
        }
        return result; 
    }
```
### 128. Longest Consecutive Sequence
```agsl
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 1; 
        int count = 1; 
        Arrays.sort(nums); 
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] + 1 == nums[i]) {
                count++; 
                max = Math.max(max, count); 
            }
            else if (nums[i-1] == nums[i]) {
                continue;
            }
            else {
                count = 1;
            }
        }
        return max; 
    }
```
### 6. Zigzag Conversion
```agsl
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>(); 
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder()); 
        }
        int currRow = 0; 
        int step = 1; 

        for (char c : s.toCharArray()) {
            rows.get(currRow).append(c); 
            currRow += step; 
            if (currRow == 0 || currRow == numRows -1) {
                step = -step;
            }
        }
        StringBuilder result = new StringBuilder(); 
        for (int i = 0; i < numRows; i++) {
            result.append(rows.get(i));
        }
        return result.toString(); 
    }
```
### 281. Zigzag Iterator
Input: v1 = [1,2], v2 = [3,4,5,6]
Output: [1,3,2,4,5,6]
```agsl
public class ZigzagIterator {
    Queue<Integer> queue; 

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>(); 
        int m = v1.size(); 
        int n = v2.size(); 
        while (m != 0 && n != 0) {
            queue.add(v1.get(v1.size() -m)); 
            m--; 
            queue.add(v2.get(v2.size() -n)); 
            n--; 
        }
        while (m > 0) {
            queue.add(v1.get(v1.size() -m)); 
            m--; 
        }
        while (n > 0) {
            queue.add(v2.get(v2.size() -n)); 
            n--; 
        }
    }

    public int next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
```
### 1768. Merge Strings Alternately
```agsl
   public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder(); 
        int len1 = 0; 
        int len2 = 0; 
        while (len1 < word1.length() || len2 < word2.length()) {
            sb.append(len1 < word1.length() ? word1.charAt(len1++) : "");
            sb.append(len2 < word2.length() ? word2.charAt(len2++) : "");

        }
        return sb.toString();
        
    }
```
### 3. Longest Substring Without Repeating Characters
```agsl
    public int lengthOfLongestSubstring(String s) {
        int max = 0; 
        int left = 0; 
        Map<Character, Integer> seen = new HashMap<>(); 

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right); 
            // window broken? 
            if (seen.containsKey(current)) {
                left = Math.max(left, seen.get(current));
            }
            seen.put(current, right + 1);
            // update result 
            max = Math.max(max, right - left + 1);
        }
        return max; 
    }
```
### 8. String to Integer (atoi)
```agsl
    public int myAtoi(String s) {
        if (s == null) 
            return 0; 
        int left = 0; 
        int right = s.length();
        int sign = 1; 
        long ans = 0; 

        while (left < right && s.charAt(left) == ' ') {
            left++; 
        }
        if (left < right && s.charAt(left) == '+') {
            sign = 1; 
            left++;
        }
        else if (left < right && s.charAt(left) == '-'){
            sign = -1; 
            left++;
        }
        while (left < right && Character.isDigit(s.charAt(left))) {
            int digit = s.charAt(left) - '0'; 
            ans = ans * 10 + digit;
            left++; 
            if (ans > Integer.MAX_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return sign * (int) ans;

    }
```
### 36. Valid Sudoku
```agsl
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>(); 

        int row = board.length; 
        int col = board[0].length; 

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0'; 
                    if (!seen.add(i + " row " + num) || !seen.add(j + " col " + num) || 
                    !seen.add((i / 3) * 3 + j / 3 + " box " + num)) {
                        System.out.println(i + " " + j+ " num: " + num);
                        System.out.println(seen.toString());
                        return false;
                    }
                }
            }
        }
        return true;
    }

```