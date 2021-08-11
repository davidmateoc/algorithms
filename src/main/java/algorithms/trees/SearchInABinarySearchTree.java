package algorithms.trees;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/6/21
 * Time: 1:59 AM
 * Algorithm URL: https://leetcode.com/problems/search-in-a-binary-search-tree/
 */

public class SearchInABinarySearchTree {

    public BinarySearchNode searchBST(BinarySearchNode root, int val) {
        if(root == null || root.data == val) {
            return root;
        }
        if(root.data <= val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }

    @Test
    public void SearchInABinarySearchTreeTest() {
        BinarySearchNode root = new BinarySearchNode(3);
        root.left = new BinarySearchNode(1);
        root.right = new BinarySearchNode(4);

        searchBST(root, 3).printInOrder();
        System.out.println("%%%%%%%");
        searchBST(root, 4).printInOrder();
        System.out.println("%%%%%%%");
        searchBST(root, 9);
        System.out.println("%%%%%%%");
    }
}
