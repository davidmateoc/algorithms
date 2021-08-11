package algorithms.trees;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:35 PM
 * Algorithm URL: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public BinarySearchNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public BinarySearchNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if(preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        BinarySearchNode root = new BinarySearchNode(preorder[preStart]);
        int inIndex = 0;
        for(int i = inStart; i <= inEnd; i++) {
            if(root.data == inorder[i]) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);

        return root;
    }
}
