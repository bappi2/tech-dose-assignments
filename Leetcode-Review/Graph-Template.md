### 1971. Find if Path Exists in Graph
```agsl
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // BFS QUEUE 
        List<List<Integer>> adjList = new ArrayList<>(); 
        for (int i = 0; i < n; i++) {
            adjList.add (new ArrayList<>()); 
        }
        for (int [] edge : edges) {
            adjList.get(edge[0]).add(edge[1]); 
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n]; 
        Arrays.fill(visited, false); 

        Queue<Integer> queue = new LinkedList<>(); 
        queue.offer(source); 
        visited[source] = true; 

        while(!queue.isEmpty()) {
            int curr = queue.poll(); 

            if (curr == destination) {
                return true; 
            }

            for (int neighbor : adjList.get(curr)) {
                if (visited[neighbor] != true) {
                    visited[neighbor] = true; 
                    queue.offer(neighbor);
                }
            }
        }
        return false; 
    }
}
```

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
![Graph example](../src/images/grid.jpg)
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
### 130. Surrounded Regions
```agsl
class Solution {
    public void solve(char[][] board) {
        int rows = board.length; 
        int cols = board[0].length; 

        boolean[][] visited = new boolean[rows][cols]; 
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < rows; i++) {
            for (int j =0; j < cols; j++) {
                if (i == 0 || i == rows - 1 || j ==0 || j == cols -1) {
                    if (board[i][j] == 'O' && !visited[i][j]) {
                        dfs(board, i, j, visited, dirs);
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j =0; j < cols; j++) {
                
                    if (board[i][j] == 'O' && !visited[i][j]) {
                        board[i][j] = 'X';
                    }
                
            }
        }
    }
    void dfs(char[][] board, int r, int c, boolean[][] visited, int[][] dirs) {
        visited[r][c] = true; 
        for (int[] dir : dirs) {
            int nr = r + dir[0]; 
            int nc = c + dir[1]; 
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length 
            && board[nr][nc] == 'O' && !visited[nr][nc]) {
                dfs(board, nr, nc, visited, dirs);
            }
        }
    }
}
```
### 542. 01 Matrix
```agsl
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length; 
        int cols = mat[0].length; 

        boolean[][] visited = new boolean[rows][cols]; 
        Queue<Node> queue = new LinkedList<>(); 
        for (int i=0; i< rows; i++) {
            for (int j =0; j < cols; j++) {
                if (mat[i][j] == 0 && !visited[i][j]) {
                queue.offer(new Node(i, j, 0)); 
                visited[i][j] = true;
            }
            }
        }
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 
        while (!queue.isEmpty()) {
            Node current = queue.poll(); 
            for (int[] dir : dirs) {
                int r = current.row + dir[0]; 
                int c = current.col + dir[1]; 

                if (r >= 0 && r < rows
                && c >= 0 && c < cols &&
                mat[r][c] == 1 && !visited[r][c]) {
                    queue.offer(new Node (r, c, current.step + 1));
                    visited[r][c] = true; 
                    mat[r][c] = current.step + 1;
                }

            }
        }
        return mat;
    }
}
class Node {
    int row; 
    int col;
    int step; 
    Node (int row, int col, int step) {
        this.row = row;
        this.col = col;
        this.step = step;
    }
}
```
### 733. Flood Fill
```agsl
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // there is no visited 
        //if (image[sr][sc] == color) {
        //    return image;
        //}
        boolean[][] visited = new boolean[image.length][image[0].length];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 
        dfs (image, sr, sc, color, image[sr][sc], dirs, visited); 
        return image; 
    }
    void dfs(int[][] image, int r, int c, int color, int initColor, int[][] dirs, boolean[][] visited) {
        visited[r][c] = true;
        image[r][c] = color; 
        for (int[] dir : dirs ) {
            int newR = r + dir[0]; 
            int newC = c + dir[1]; 

            if (newR >= 0 && newR < image.length && newC >= 0 && newC < image[0].length
            && image[newR][newC] == initColor && !visited[newR][newC]) {
                dfs(image, newR, newC, color, initColor, dirs, visited);
            }
        }
    }
}
```
### 582. Kill Process
```agsl
class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> result = new 
        
    }
        public List<Integer> killProcess2(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            adjMap.putIfAbsent(ppid.get(i), new ArrayList<>());
            adjMap.get(ppid.get(i)).add(pid.get(i));
        }

        List<Integer> result = new ArrayList<>(); 
        Stack<Integer> stack = new Stack<>();
        stack.push(kill); 
        while (!stack.isEmpty()) {
            int current = stack.pop(); 
            result.add(current); 
            for (int child : adjMap.getOrDefault(current, new ArrayList<>())) {
                stack.push(child);
            }
            
        }
        return result;
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
### 323. Number of Connected Components in an Undirected Graph
```agsl
Union Find
class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n); 
        int numOfComponent = n; 
        for (int[] edge: edges){
            if (!uf.unionbyRank(edge[0], edge[1])) {
                numOfComponent--;
            }
        }
        return numOfComponent;
    }

    class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    int find(int x) {
        if (parent[x] == x) {
            return parent[x];
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    boolean unionbyRank(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return true;
        }
        if (rank[rootY] > rank[rootX]) {
            parent[rootX] = rootY;
        } else if (rank[rootY] < rank[rootX]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        return false;
    }
}
}
```
```agsl
DFS
```
### 261. Graph Valid Tree
```agsl
Union Find
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1){
            return false;
        }

        UnionFind uf = new UnionFind(n); 
        for (int[] edge: edges) {
            if (!uf.unionbyRank(edge[0], edge[1])) {
                return false;
            }
        }
        return true;
    }

    class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    int find(int x) {
        if (parent[x] == x) {
            return parent[x];
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    boolean unionbyRank(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return false;
        }
        if (rank[rootY] > rank[rootX]) {
            parent[rootX] = rootY;
        } else if (rank[rootY] < rank[rootX]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        // no cycle
        return true;
    }
}
}
```

### 127. Word Ladder
```agsl
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        set.addAll(wordList);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(beginWord, 1));

        while (!queue.isEmpty()) {

            Node curr = queue.poll();
            if (curr.word.equals(endWord)) {
                return curr.step;
            }

            for (int i = 0; i < curr.word.length(); i++) {
                char[] wordArray = curr.word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    wordArray[i] = j;
                    String newWord = String.valueOf(wordArray);
                    if (set.contains(newWord)) {
                        queue.offer(new Node(newWord, curr.step + 1));
                        set.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }

    class Node {
        String word;
        int step;

        public Node(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }
}
```
### 332. Reconstruct Itinerary
```agsl
class Solution {

    //Eulerian path (is a trail in a finite graph that visits every edge exactly once (allowing for revisiting vertices).)
    //Fleury's algorithm 
    //Since the problem asks for lexical order smallest solution, we can put the neighbors in a min-heap. In this way, we always visit the smallest possible neighbor first in our trip.

    HashMap<String, PriorityQueue<String>> map;
    LinkedList<String> itinerary;

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<String, PriorityQueue<String>>();
        itinerary = new LinkedList<String>();
        for (List<String> ticket : tickets) {
            if (map.containsKey(ticket.get(0))) {
                PriorityQueue<String> pq = map.get(ticket.get(0));
                pq.add(ticket.get(1));
            } else {
                PriorityQueue<String> pq = new PriorityQueue<String>();
                pq.add(ticket.get(1));
                map.put(ticket.get(0), pq);
            }
        }
        findHelper("JFK");
        return itinerary;
    }

    public void findHelper(String current) {
        PriorityQueue<String> pq = map.get(current);
        while (pq != null && !pq.isEmpty()) {
            findHelper(pq.poll());
        }
        itinerary.addFirst(current);
    }
}
```
### 269. Alien Dictionary
```agsl

```
### 787. Cheapest Flights Within K Stops
```agsl
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] i : flights)
            adj.computeIfAbsent(i[0], value -> new ArrayList<>()).add(new int[] { i[1], i[2] });

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { src, 0 });
        int stops = 0;

        while (stops <= k && !q.isEmpty()) {
            int sz = q.size();
            // Iterate on current level.
            while (sz-- > 0) {
                int[] temp = q.poll();
                int node = temp[0];
                int distance = temp[1];

                if (!adj.containsKey(node))
                    continue;
                // Loop over neighbors of popped node.
                for (int[] e : adj.get(node)) {
                    int neighbour = e[0];
                    int price = e[1];
                    if (price + distance >= dist[neighbour])
                        continue;
                    dist[neighbour] = price + distance;
                    q.offer(new int[] { neighbour, dist[neighbour] });
                }
            }
            stops++;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
```
### 785. Is Graph Bipartite?
```agsl

```

### 841. Keys and Rooms
```agsl
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        Stack<Integer> stack = new Stack();
        stack.push(0);

        //At the beginning, we have a todo list "stack" of keys to use.
        //'seen' represents at some point we have entered this room.
        while (!stack.isEmpty()) { // While we have keys...
            int node = stack.pop(); // Get the next key 'node'
            for (int nei: rooms.get(node)) // For every key in room # 'node'...
                if (!seen[nei]) { // ...that hasn't been used yet
                    seen[nei] = true; // mark that we've entered the room
                    stack.push(nei); // add the key to the todo list
                }
        }

        for (boolean v: seen)  // if any room hasn't been visited, return false
            if (!v) return false;
        return true;
    }
}
```

### 277. Find the Celebrity
```agsl

```
### 329. Longest Increasing Path in a Matrix
```agsl

```
### 631. Design Excel Sum Formula
```agsl

```