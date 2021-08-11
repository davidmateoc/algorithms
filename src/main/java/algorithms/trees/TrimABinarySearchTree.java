package algorithms.trees;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 8/7/21
 * Time: 2:56 PM
 * Algorithm URL: https://leetcode.com/problems/trim-a-binary-search-tree/
 */

public class TrimABinarySearchTree {

    public BinarySearchNode trimBST(BinarySearchNode root, int low, int high) {
        if(root == null) return null;

        if(root.data < low) return trimBST(root.right, low, high);
        if(root.data > high) return trimBST(root.left, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    @Test
    public void TrimABinarySearchTreeTest() {

    }
}

