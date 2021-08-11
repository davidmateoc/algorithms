package algorithms.trees;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/6/21
 * Time: 2:07 AM
 * Algorithm URL: https://leetcode.com/problems/univalued-binary-tree/
 */

public class UnivaluedBinaryTree {

    public boolean isUnivalTree(BinarySearchNode root) {
        boolean leftUnivals = root.left == null || (root.left.data == root.data) && isUnivalTree(root.left);
        boolean rightUnivals = root.right == null || (root.right.data == root.data) && isUnivalTree(root.right);

        return leftUnivals && rightUnivals;
    }

    @Test
    public void UnivaluedBinaryTreeTest() {
        BinarySearchNode root = new BinarySearchNode(1);
        root.left = new BinarySearchNode(1);
        root.right = new BinarySearchNode(1);
        root.right.right = new BinarySearchNode(0);
        System.out.println(isUnivalTree(root));
    }
}
