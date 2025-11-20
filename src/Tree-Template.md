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