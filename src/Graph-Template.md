### 200. Number of Islands
```agsl
class Solution {
    int[][] dirs =  {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        int m = grid.length; 
        int n = grid[0].length; 

        boolean[][] visited = new boolean[m][n]; 
        int count = 0; 
        for (int i =0; i < m; i++) {
            for (int j =0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, m, n, visited);
                    count++;
                }
            }
        }
        return count;
    }
    void dfs(char[][] grid, int i, int j, int m, int n, boolean[][] visited) {
        visited[i][j] = true; 
        for (int[] dir : dirs) {
            int newI = i + dir[0]; 
            int newJ = j + dir[1]; 
            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[newI][newJ] == '1' && !visited[newI][newJ]) {
                dfs(grid, newI, newJ, m, n, visited);
            }
        }

    }
}
```
### 695. Max Area of Island
```agsl
class Solution {
    int[][] dirs =  {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length; 
        boolean[][] visited = new boolean[m][n]; 
        int max = 0; 
        int count = 0; 

         for (int i =0; i < m; i++) {
            for (int j =0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    
                    count = dfs(grid, i, j, m, n, visited);
                    max = Math.max(max, count); 
                }
            }
        }
        return max;
        
    }

    int dfs(int[][] grid, int i, int j, int m, int n, boolean[][] visited) {
        visited[i][j] = true; 
        int count = 0;
        for (int[] dir : dirs) {
            int newI = i + dir[0]; 
            int newJ = j + dir[1]; 
            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[newI][newJ] == 1 && !visited[newI][newJ]) {
                count += dfs(grid, newI, newJ, m, n, visited);
            }
        }
        return count + 1; 
    }
}
```
### 286. Walls and Gates
```agsl
class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length; 
        int n = rooms[0].length; 
        boolean[][] visited = new boolean[m][n]; 
        Queue<Node> queue = new LinkedList<>();

        for(int i=0; i < m; i++) {
            for (int j =0; j < n; j++) {
                if (rooms[i][j] == 0 && !visited[i][j]) {
                    queue.offer(new Node(i, j, 0)); 
                    visited[i][j] = true; 
                }
            }
        }

        while (!queue.isEmpty()) { 
            Node current = queue.poll(); 
            for (int[] dir : dirs) {
                int newI = current.i + dir[0]; 
                int newJ = current.j + dir[1]; 

                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n 
                && rooms[newI][newJ] == Integer.MAX_VALUE && !visited[newI][newJ]) {
                    queue.offer(new Node(newI, newJ, current.step + 1)); 
                    visited[newI][newJ] = true; 
                    rooms[newI][newJ] = current.step + 1; 
                }
            }
            
        }

    }

    class Node {
        int i; 
        int j; 
        int step; 
        Node(int i, int j, int step) {
            this.i = i; 
            this.j = j; 
            this.step = step; 
        }
    }
}
```
### 994. Rotting Oranges
```agsl
class Solution {

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 

        
    public int orangesRotting(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length; 
        boolean[][] visited = new boolean[m][n]; 
        Queue<Node> queue = new LinkedList<>(); 

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2 && !visited[i][j])  {
                    queue.offer(new Node(i, j, 0));
                    visited[i][j] = true; 
                }
            }
        }
        int result = 0; 
        while (!queue.isEmpty()) {
            Node current = queue.poll(); 
            for (int[] dir : dirs) {
                int newI = current.i + dir[0]; 
                int newJ = current.j + dir[1]; 

                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[newI][newJ] == 1 && !visited[newI][newJ]) {
                    queue.offer(new Node(newI, newJ, current.step + 1)); 
                    visited[newI][newJ] = true; 
                    result = Math.max(result, current.step + 1);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j])  {
                    return -1;
                }
            }
        }
        return result;
    }
    class Node {
        int i; 
        int j; 
        int step; 
        Node(int i, int j, int step) {
            this.i = i; 
            this.j = j; 
            this.step = step; 
        }
    } 
}
```
### 133. Clone Graph
```agsl
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null; 
        }
        Map<Node, Node> seen = new HashMap<>(); 
        Node newNode = new Node(node.val); 
        seen.put(node, newNode); 
        Queue<Node> queue = new LinkedList<>(); 
        queue.offer(node); 
        while (!queue.isEmpty()) {
            Node current = queue.poll(); 
            for (Node neighbor: current.neighbors ) {
                if (seen.containsKey(neighbor)) {
                    seen.get(current).neighbors.add(seen.get(neighbor));
                }
                else {
                    Node copyNeighbor = new Node(neighbor.val); 
                    queue.offer(neighbor); 
                    seen.put(neighbor, copyNeighbor); 
                    seen.get(current).neighbors.add(copyNeighbor);
                }
            }

        }
        return newNode;
     }
}
```
### 207. Course Schedule
```agsl 
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>(numCourses); 
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        int[] in = new int[numCourses];
        for (int[] preReq : prerequisites) {
            adjList.get(preReq[1]).add(preReq[0]);
            in[preReq[0]]++;
        }
        Deque<Integer> queue = new ArrayDeque<>(); 
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) queue.offer(i);
        }
        int taken = 0; 
        while (!queue.isEmpty()) {
            int course = queue.poll(); 
            taken++; 
            for (int neighbor : adjList.get(course)) {
                in[neighbor]--; 
                if (in[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return taken == numCourses;
    }
```
### 210. Course Schedule II
```agsl
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>(); 
        for (int i =0; i < numCourses; i++) {
            adjList.add(new ArrayList<>()); 
        }
        int[] indegree = new int[numCourses]; 
        int[] result = new int[numCourses]; 
        for (int[] preReq : prerequisites) {
            adjList.get(preReq[1]).add(preReq[0]);
            indegree[preReq[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>(); 
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0; 
        while (!queue.isEmpty()) {
            int current = queue.poll(); 
            for (int neighbor : adjList.get(current)) {
                indegree[neighbor]--; 
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
            result[count++] = current;
        }
        if (count != numCourses) {
            return new int[0];
        }
        else {
            return result;
        }
    }
```