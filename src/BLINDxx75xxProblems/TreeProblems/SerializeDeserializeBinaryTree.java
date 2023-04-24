package BLINDxx75xxProblems.TreeProblems;

import util.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        builder(root, sb);
        return sb.toString();
    }
    private void builder(TreeNode node, StringBuilder sb ) {
        if (node == null) {
            sb.append("#").append(",");
        }
        else {
            sb.append(node.val).append(",");
            builder(node.left, sb);
            builder(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return buildTree(queue);
    }
    private TreeNode buildTree(Queue<String> queue) {
        String curr = queue.poll();
        if (curr.equals("#")) {
            return null;
        }
        else {
            TreeNode node = new TreeNode(Integer.valueOf(curr));
            node.left = buildTree(queue);
            node.right = buildTree(queue);
            return node;
        }
    }
}
