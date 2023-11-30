package ArrayProblems.FaceBook;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BalanceABinarySearchTree {
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        inOrderTraversal(root, nodes); // Perform in-order traversal to get sorted nodes
        return buildBalancedBST(nodes, 0, nodes.size() - 1);
    }

    private void inOrderTraversal(TreeNode root, List<TreeNode> nodes) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, nodes);
        nodes.add(root);
        inOrderTraversal(root.right, nodes);
    }

    private TreeNode buildBalancedBST(List<TreeNode> nodes, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode midNode = nodes.get(mid);

        midNode.left = buildBalancedBST(nodes, start, mid - 1);
        midNode.right = buildBalancedBST(nodes, mid + 1, end);

        return midNode;
    }
}
