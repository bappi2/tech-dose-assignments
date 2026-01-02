### Binary Tree Preorder Traversal Iterative
```agsl
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(); 
        if (root == null) return result; 
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop(); 
            result.add(current.val);
            if (current.right != null) stack.push(current.right); 
            if (current.left!= null) stack.push(current.left); 
            
        }
        return result;
    }
```
### Binary Tree Preorder Traversal Recursive
```agsl
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(); 
        preOrderDFS(root, result); 
        return result;
    }
    void preOrderDFS(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val); 
            preOrderDFS(root.left, result); 
            preOrderDFS(root.right, result); 
        }
    }
```

### Binary Tree Inorder Traversal Recursive
```agsl
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(); 
        inOrderDFS(root, result); 
        return result;
    }


    void inOrderDFS(TreeNode root, List<Integer> result) {
        if (root != null) {     
            inOrderDFS(root.left, result); 
            result.add(root.val); 
            inOrderDFS(root.right, result); 
        }
    }
```

### Binary Tree Inorder Traversal Iterative
```agsl
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(); 
        if (root == null) return result; 
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode current = root; 
        while (current != null || !stack.isEmpty()) {
           while (current != null) {
            stack.push(current);
            current = current.left;
           }
           
            current = stack.pop(); 
            result.add(current.val);

            current = current.right;
        }
        return result;
    }
```
### Binary Tree PostOrder Traversal Recursive
```agsl
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(); 
        postOrderDFS(root, result); 
        return result;
    }

    void postOrderDFS(TreeNode root, List<Integer> result) {
        if (root != null) {
            postOrderDFS(root.left, result); 
            postOrderDFS(root.right, result); 
            result.add(root.val); 
        }
    }
```
### Binary Tree PostOrder Traversal Iterative
```agsl
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(); 
        if (root == null) return result; 
        Deque<TreeNode> stack1 = new ArrayDeque<>(); 
        Deque<TreeNode> stack2 = new ArrayDeque<>(); 

        stack1.push(root); 
        while (!stack1.isEmpty()) {
            TreeNode current = stack1.pop(); 
            stack2.push(current);
            if (current.left != null) stack1.push(current.left);
            if (current.right != null) stack1.push(current.right);
        }

        while (!stack2.isEmpty()) {
            TreeNode current = stack2.pop(); 
            result.add(current.val); 
        }
        return result; 
    }
```
```agsl
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>(); 
        if (root == null) return result; 
        Deque<TreeNode> stack = new ArrayDeque<>(); 
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop(); 

            result.addFirst(current.val);
            if (current.left != null) stack.push(current.left);
            if (current.right != null) stack.push(current.right);
        }
        return result; 
    }
```
### N-ary Tree Postorder Traversal
```agsl
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>(); 
        dfs(root, result);
        return result; 
    }
    void dfs(Node root, List<Integer> result) {
        if (root == null)  return; 
        for (Node child : root.children) {
            dfs(child, result);
        }
        result.add(root.val); 
    }
```
```agsl
    public List<Integer> postorder(Node root) {
        List<Integer> result = new LinkedList<>(); 
        if (root == null) return result; 

        Deque<Node> stack = new ArrayDeque<>(); 
        stack.push(root); 
        while (!stack.isEmpty()) {
            Node curr = stack.pop(); 
            result.addFirst(curr.val);
            for (Node child : curr.children) {
                stack.push(child);
            }
        }
        return result;
    }
```
### 429. N-ary Tree Level Order Traversal
```agsl
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>(); 
        if (root == null) return result; 
        Deque<Node> queue = new ArrayDeque<>(); 
        queue.offer(root); 

        while (!queue.isEmpty()) {
            int size = queue.size(); 
            List<Integer> level = new ArrayList<>(); 
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll(); 
                level.add(curr.val); 
                for (Node child : curr.children) {
                    queue.offer(child);
                }
            }
            result.add(level);
        }
        return result; 
    }
```
### 98. Validate Binary Search Tree
```agsl
     public boolean isValidBST(TreeNode root) {
        if (root == null) return true; 
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true; 
        else if (root.val <= min || root.val >= max) return false;
        else return isValidBST(root.left, min, root.val) 
            && isValidBST(root.right, root.val, max);
    }
```
### 226. Invert Binary Tree
```agsl
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null; 
        else {
            TreeNode left = invertTree(root.left); 
            TreeNode right = invertTree(root.right);

            root.left = right; 
            root.right = left; 
            return root;
        }
    }
```
### 104. Maximum Depth of Binary Tree
```agsl
  public int maxDepth(TreeNode root) {
      if (root == null) return 0; 
      else return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
```
### 543. Diameter of Binary Tree
```agsl
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int [] max = new int[1]; 
        maxDepth(root, max); 
        return max[0];
    }

    int maxDepth(TreeNode node, int[] max) {
        if (node == null) return 0;
        int left = maxDepth(node.left, max); 
        int right = maxDepth(node.right, max); 
        max[0] = Math.max(max[0], left + right);
        return 1 + Math.max(left, right);
    }
```
### 100. Same Tree
``` agsl
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) return q == null; 
        else if (q == null || p.val != q.val) return false; 
        else return isSameTree(p.left, q.left) && isSameTree(p.right, q.right); 
    }
```
### 235. Lowest Common Ancestor of a Binary Search Tree
```agsl
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (Math.max(p.val, q.val) < root.val) return lowestCommonAncestor(root.left, p, q);
        else if (Math.min(p.val, q.val) > root.val) return lowestCommonAncestor(root.right, p, q);
        elsen return root;
    }
```
### 112. Path Sum
```agsl 
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false; 
        else if (root.val == targetSum && root.left == null && root.right == null) return true; 
        else return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
```
### 113. Path Sum II
```agsl 
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result= new ArrayList<>(); 
        List<Integer> path = new ArrayList<>(); 
        backTrack(root, targetSum, path, result); 
        return result; 
    }
    void backTrack(TreeNode root, int targetSum, List<Integer> path , List<List<Integer>> result) {
        if (root == null) return; 
        path.add(root.val); 
        if (root.val == targetSum && root.left == null && root.right == null) {
            result.add(new ArrayList<>(path)); 
        }
        else {
             backTrack(root.left, targetSum - root.val, path, result); 
             backTrack(root.right, targetSum - root.val, path, result); 
        }
        path.remove(path.size() - 1);

    }
```