package algorithms.trees;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/6/21
 * Time: 3:14 AM
 * Algorithm URL: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */

public class MaximumDepthOfABinaryTree {

    public int maxDepth(BinarySearchNode root) {
        if(root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    @Test
    public void MaximumDepthOfABinaryTreeTest() {
        BinarySearchNode root = new BinarySearchNode(4);
        BinarySearchNode root_left = new BinarySearchNode(3);
        BinarySearchNode root_right = new BinarySearchNode(8);
        BinarySearchNode root_right_left = new BinarySearchNode(5);

        root.left = root_left;
        root.right = root_right;
        root_right.left = root_right_left;

        System.out.println(maxDepth(root));
    }
}
