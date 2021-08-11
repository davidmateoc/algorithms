package algorithms.trees;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 8/6/21
 * Time: 3:40 AM
 * Algorithm URL: https://leetcode.com/problems/subtree-of-another-tree/
 */

public class SubtreeOfAnotherTree {

    public boolean isSubtree(BinarySearchNode root, BinarySearchNode subRoot) {
        if(root == null) {
            return false;
        } else if(isSameTree(root, subRoot)) {
            return true;
        } else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }

    private boolean isSameTree(BinarySearchNode s, BinarySearchNode t) {
        if(s == null || t == null) {
            return s == null && t == null;
        } else if(s.data == t.data) {
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        } else {
            return false;
        }
    }

    @Test
    public void SubtreeOfAnotherTreeTest() {

    }
}

