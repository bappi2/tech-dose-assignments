
### Iterate through array
```agsl
for (int i = 0; i < array.length; i++) {
    // Process array[i]
}
```
### End Condition Binary Search
```agsl
    // template 1
    public int search(int[] nums, int target) {
         if (nums == null || nums.length == 0)  return -1;
         int start = 0, end = nums.length - 1;
         while (start <= end) {
             int mid = start + (end - start) / 2;
             if (nums[mid] == target)   return mid;
             else if (nums[mid] < target)   start = mid + 1;
             else   end = mid - 1;
         }
         // End Condition left > right
         return -1;
    }

    // template 2
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)  return -1;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) start = mid + 1;
            else    end = mid;
        }
        // End Condition: left == right
        if (nums[start] == target)   return start;
        return -1;
    }

    // template 3
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)  return -1;
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) start = mid;
            else    end = mid;
        }
        // Post-processing:
        // End Condition: left + 1 == right
        if (nums[start] == target)  return start;
        if (nums[end] == target)    return end;
        return -1;
    }
```

## Two-pointer technique (useful for sorted arrays, sometimes not sorted, linked lists, etc.)
```agsl
public int fn(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    int ans = 0;

    while (left < right) {
        // do some logic here with left and right
        if (CONDITION) {
            left++;
        } else {
            right--;
        }
    }

    return ans;
}
```

## Two pointers: two inputs, exhaust BOTH

```agsl
public int fn(int[] arr1, int[] arr2) {
    int i = 0; int j = 0; int result = 0;
    
    while ( i < arr1.length && j < arr2.length) {
        // some logic with i and j
        if ( some condition ){
            i++;
        }else{
            j++;
        }
    }
    while ( i < arr1.length ){
        // some logic to go through rest of arr1 if any elem present
        i++;
    }
    
    while ( j < arr2.length ){
        // some logic to go through rest of arr2 if any elem present
        j++;
    }
    
    return ans;
}
```
### Using a HashSet for quick lookup:
```agsl
HashSet<Integer> set = new HashSet<>();
for (int num : arr) {
    if (set.contains(num)) {
        // Some logic when num is a duplicate
    } else {
        set.add(num);
    }
}
```

### Using a HashMap for counting frequencies:
```agsl
HashMap<Integer, Integer> map = new HashMap<>();
for (int num : arr) {
    map.put(num, map.getOrDefault(num, 0) + 1);
}
```

### Using recursion for backtracking problems:
```agsl
public void backtrack(int[] arr, int start, List<Integer> current, List<List<Integer>> result) {
    result.add(new ArrayList<>(current));
    for (int i = start; i < arr.length; i++) {
        current.add(arr[i]);
        backtrack(arr, i + 1, current, result);
        current.remove(current.size() - 1);
    }
}
```

### Depth-First Search (DFS) on a graph represented as a matrix:
```agsl
public void dfs(int[][] matrix, int row, int col, boolean[][] visited) {
    if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || visited[row][col]) {
        return;
    }
    visited[row][col] = true;
    dfs(matrix, row - 1, col, visited);
    dfs(matrix, row + 1, col, visited);
    dfs(matrix, row, col - 1, visited);
    dfs(matrix, row, col + 1, visited);
}
```

### Using Dynamic Programming for optimization problems:
```agsl
public int dp(int[] arr) {
    int[] dp = new int[arr.length + 1];
    // initial condition, e.g., dp[0] = 0;
    for (int i = 1; i <= arr.length; i++) {
        for (int j = 1; j <= i; j++) {
            // transition function, e.g.,
            dp[i] = Math.max(dp[i], dp[i - j] + arr[j - 1]);
        }
    }
    return dp[arr.length];
}
```
## Sliding Window
* Fixed Window: Check PermutationSubstring
* Variable Window: Check LongestSubstringWithoutRepeatingCharacters
  Window elements always satisfy the core business logic. As long as that is not satisfied, move the window.
```agsl
publid fn(int[] arr){
    
    int left = 0;
    int current = 0;
    int result = 0;
    
    for(int right = 0; right < arr.length; right++){
        // some logic to add arr[right] to current
        
        while( AS LONG AS WINDOW CONDITION IS BROKEN ){
            // REMOVE arr[left] from current
            left++;
        }
        
        // update result
    }
    return result;
}
```
### Using a Deque for sliding window maximum/minimum:
Monotonic queue!
```agsl
Deque<Integer> deque = new ArrayDeque<>();
for (int i = 0; i < arr.length; i++) {
    while (!deque.isEmpty() && arr[i] > arr[deque.peekLast()]) {
        deque.pollLast();
    }
    deque.offerLast(i);
    if (i - deque.peekFirst() >= k) {
        deque.pollFirst();
    }
    if (i >= k - 1) {
        // arr[deque.peekFirst()] is the maximum of the window
    }
}
```

## Build a prefix sum (sum of all elements until current. arr[arr.length-1] will have sum or all element)
```agsl
public int[] fn(int[] arr){
    int[] prefix = new int[arr.length];
    prefix[0] = arr[0];
    
    for( int i = 1; i < arr.length; i++){
        prefix[i] = prefix[i-1] + arr[i];
    }
    return prefix;
}
```
## Find number of subarrays that fit an exact criteria
```agsl
public int fn(int[] arr, int k) {
    Map<Integer, Integer> counts = new HashMap<>();
    counts.put(0, 1);
    int ans = 0, curr = 0;

    for (int num: arr) {
        // do logic to change curr
        ans += counts.getOrDefault(curr - k, 0);
        counts.put(curr, counts.getOrDefault(curr, 0) + 1);
    }

    return ans;
}
```
## How to skip duplicates in an array
Examples: #15 (3Sum),Subsets with duplicates (backtracking)
```agsl
    public List<List<Integer>> threeSum(int[] nums) {
        // logic...
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
           // Skip Duplicate means DO process "original" FIRST AND THEN 
           // skip the rest of duplicates. Here nums[0] is the original.
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            // more logic without duplicates
        }
    }
```
## Efficient string building
```agsl
public String fn(char[] arr) {
    StringBuilder sb = new StringBuilder();
    for (char c: arr) {
        sb.append(c);
    }

    return sb.toString();
}
```

## Linked list: fast and slow pointer  (,...Compute mid of linkedlist)

```agsl
public int fn(ListNode head) {
    ListNode slow = head, fast = head;
    int answer = 0;
    
    while (fast != null && fast.next != null){
        // Some logic
        slow = slow.next;
        fast = fast.next.next;
    }
    return answer;
}
```

## Reversing LinkedList
```agsl
public ListNode fn(ListNode head) {

    ListNode prev = null, current = head;
    while ( current != null){
        ListNode nextNode = current.next;
        current.next = prev;
        prev = current;
        current = nextNode;
    }
    return prev;
}
```

## Monotonic Increasing Stack (same for Monotonic Queue)
```agsl
public int fn(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    
    for(int i = 0; i < arr.length; i++){
    
        while( !stack.isEmpty() && arr[i] < arr[stack.peek()]){
        // x can be anything, could also be an array. result[x] = arr[i]
        // many times you push the index i rather than nums[i]
        // mono dec stack means what I have in hand must be less than top elem for me to add to stack, until that happens, keep popping.
        // mono incr stack means what I have in hand must be greater than top elem for me to add to stack, until that happens, keep popping.
            int x = stack.pop(); 
        }
        
        stack.push(i) OR stack.push(arr[i])
    }
}
```
## Binary tree: DFS (recursive)
```agsl
public int dfs(TreeNode root){
    if( root == null){
        return 0;
    }
    int result = 0;
        // business logic
    dfs(root.left);
    dfs(root.right);
    
    return result;
}
```

## Binary tree: DFS (recursive)
```agsl
public int dfs(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    
    int result = 0;
    
    while(!stack.isEmpty()){
        TreeNode node = stack.pop();
        
       // Process node for result
       
       if(node.left != null){
            stack.push(node.left);
       }
       if(node.right != null){
            stack.push(node.right);
       }
    }
    return result;
}
```

## Binary tree: BFS  (level by level)
```agsl
public int fn(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int ans = 0;
    
    while(!queue.isEmpty()){
    
    int levelSize = queue.size();
    for( int i = 0; i < levelSize; i++){
        TreeNode node = queue.poll();
        // BUSINESS LOGIC
        
        if(node.left != null){
            queue.offer(root.left);
        }
        if(node.right != null){
            queue.offer(root.right);
        }
    }
    return answer;
}
```
## Graph: DFS (recursive)  Assuming nodes are 0 to n-1. Input is Adjacency list. Jagged Array.
### ArrayIndex is node# and arr[node] are the neighbors of node.
Always dfs is done only on visited nodes. If unvisited, visit it and then recurse.
```agsl

Set<Integer> visited = new HashSet<>();

public int fn(int[][] graph) {
    set.visited(START_NODE) // START_NODE could be the input
    return dfs(graph, START_NODE);
}

public int dfs(int[][] graph, int node){
    int answer = 0;
    
     // DO SOMETHING FOR CURRENT NODE.
     
    for(int neighbor: graph[node]){
        if( !visited.contains(neighbor) ){
            visited.add(neighbor);
             answer += dfs(graph, neighbor)
        }
    }
    return answer;
}
```

## DFS Graph Iterative
```agsl
public int fn(int[][] graph) {
    Set<Integer> visited = new HashSet<>();
    int answer = 0;
    visited.add(START_NODE)
    
    Stack<Integer> stack = new Stack<>();
    stack.push(START_NODE)
    while(!stack.isEmpty()){
        int node = stack.pop();
    
        // DO LOGIC for current node - answer
        for( int neighbor : graph[neighbor]){
            visited.add(neighbor);
            stack.push(neigbor);
        }
    }
    return answer;
}
```

## Graph: BFS
```agsl
public int fn(int[][] graph) {
    Set<Integer> visited = new HashSet<>();
    int ans = 0;
    
    Queue<Integer> q = new ArrayDeque<>();
    q.offer(START_NODE);
    visited.set(START_NODE);
    while(!q.isEmpty()){
        Integer node = q.poll();
        for(int neighbor: graph[node]){
            if(!visited.contains(neighbor)){
                visited.add(neighbor);
                q.offer(neighbor);
            }    
        }
    }
    return ans;
}
```
## Graph: Grid representation. Validation
### Always FIRST validate the row and col first for edge cases in grid representation!
```agsl
    private void dfs(char[][] grid, int row, int col){
        if(!(row >= 0 && col >= 0 && row < grid.length && col < grid[0].length)){
            return;
        }
    }
```

## Find top k elements with heap
```agsl
public int[] fn(int[] arr, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(CRITERIA);
    for(int num: arr){
        pq.offer(num);
        if(pq.size() > k){
            pq.poll();
        }
    }
    int[] ans = new int[k];
    for(int i = 0; i < k; i++){
        ans[i] = pq.poll();
    }
    return ans;
}
```
