package BLINDxx75xxProblems.TreeProblems;

public class BinaryTreeMaximumPathSum {
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0 ;
        }
        maxPathSumUtil (root);
        return result;
    }
    int maxPathSumUtil(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxPathSumUtil(root.left);
        int right = maxPathSumUtil(root.right);

        // case 1
        // either current node in the path or start ot max path
        int case1 = Math.max(Math.max(left, right) + root.val, root.val);
        // case 2
        // current node is the root of max path
        int case2  = Math.max(left + right + root.val, case1);

        // case 3 cuuent node is not the path of maxsum

        result = Math.max(result, case2);

        return case1;


    }
}
