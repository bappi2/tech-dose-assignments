package ArrayProblems.FaceBook;

import util.TreeNode;

/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LowestCommonAncestorOfBT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if the root is null or matches either p or q, return the root
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search for the lowest common ancestor in the left and right subtrees
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        // If both left and right subtrees return non-null values, then the current root is the LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // If only one subtree returns a non-null value, pass it up
        return (leftLCA != null) ? leftLCA : rightLCA;
    }
}
