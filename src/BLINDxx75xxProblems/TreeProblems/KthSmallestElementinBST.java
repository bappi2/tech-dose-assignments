package BLINDxx75xxProblems.TreeProblems;

public class KthSmallestElementinBST {
    class Count {
        int c;
        int v;
        public Count() {
            c=0;
            v=0;
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        Count c = new Count();
        helper(root, k, c);
        return c.v;
    }
    private void helper(TreeNode node, int k, Count c) {
        if (node != null) {
            helper(node.left, k, c);
            c.c++;
            if (c.c == k) {
                c.v = node.val;
                return;
            }
            helper(node.right, k, c);
        }
    }
    // ===
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result.get(k-1);

    }
    void inOrderTraversal(TreeNode root, List<Integer> result ) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
    }
}
