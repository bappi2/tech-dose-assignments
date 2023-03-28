package BLINDxx75xxProblems.TreeProblems;

public class ConstructBTFromPreOrderInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder== null
                || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        return treeBuilder(preorder, 0, inorder, 0, inorder.length -1);
    }

    private TreeNode treeBuilder(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd){
        // base case
        if (inStart < 0 || inStart >= preorder.length || inEnd < 0 || inEnd >= preorder.length
                || preStart < 0 || preStart >= inorder.length || inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preStart]);

        // find node in inorder
        int rIndex = -1;
        for (int i=inStart; i <= inEnd; i++) {
            if (inorder[i] == node.val) {
                rIndex = i;
                break;
            }
        }
        int distance = rIndex - inStart + 1;
        node.left = treeBuilder(preorder, preStart+1, inorder, inStart, rIndex -1);
        node.right = treeBuilder(preorder, preStart+distance, inorder, rIndex+1, inEnd);
        return node;
    }
}
