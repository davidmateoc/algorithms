package algorithms.trees;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/6/21
 * Time: 1:44 AM
 * Algorithm URL: https://leetcode.com/problems/symmetric-tree/
 */

public class IsSymmetric {
    public boolean isSymmetric(BinarySearchNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(BinarySearchNode t1, BinarySearchNode t2) {
        if(t1 == null && t2 == null) {
            return true;
        }
        if(t1 == null || t2 == null) {
            return false;
        }

        return (t1.data == t2.data) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    @Test
    public void isSymmetricTest() {
        BinarySearchNode root = new BinarySearchNode(1);
        BinarySearchNode leftNode2 = new BinarySearchNode(2);
        BinarySearchNode leftNode3 = new BinarySearchNode(3);
        BinarySearchNode leftNode4 = new BinarySearchNode(4);

        BinarySearchNode rightNode2 = new BinarySearchNode(2);
        BinarySearchNode rightNode3 = new BinarySearchNode(3);
        BinarySearchNode rightNode4 = new BinarySearchNode(4);

        root.left = leftNode2;
        root.right = rightNode2;

        leftNode2.left = leftNode3;
        leftNode2.right = leftNode4;

        rightNode2.left = rightNode4;
        rightNode2.right = rightNode3;

        System.out.println(isSymmetric(root));
    }
}
