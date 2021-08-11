package algorithms.trees;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/6/21
 * Time: 1:37 AM
 * Algorithm URL: https://leetcode.com/problems/invert-binary-tree/
 */

public class InvertBinaryTree {

    public BinarySearchNode invertTree(BinarySearchNode root) {
        if(root == null) {
            return root;
        }

        BinarySearchNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    @Test
    public void InvertBinaryTreeTest() {
        BinarySearchNode root = new BinarySearchNode(3);
        root.insert(1);
        root.insert(2);

        root.printInOrder();
        System.out.println("%%%%%%%");
        invertTree(root);
        root.printInOrder();
    }
}
