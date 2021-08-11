package algorithms.trees;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/6/21
 * Time: 2:15 AM
 * Algorithm URL: https://leetcode.com/problems/merge-two-binary-trees/
 */

public class MergeTwoBinaryTrees {

    public BinarySearchNode mergeTrees(BinarySearchNode root1, BinarySearchNode root2) {
        if(root1 == null) {
            return root2;
        }
        if(root2 == null) {
            return root1;
        }

        BinarySearchNode root3 = new BinarySearchNode(root1.data + root2.data);

        root3.left = mergeTrees(root1.left, root2.left);
        root3.right = mergeTrees(root1.right, root2.right);

        return root3;
    }

    public BinarySearchNode mergeTreesInSame(BinarySearchNode root1, BinarySearchNode root2) {
        if(root1 == null) return root2;
        if(root2 == null) return root1;

        root1.data += root2.data;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }

    @Test
    public void mergeTreesTest() {
        BinarySearchNode tree1node1 = new BinarySearchNode(1);
        BinarySearchNode tree1node3 = new BinarySearchNode(3);
        BinarySearchNode tree1node2 = new BinarySearchNode(2);
        BinarySearchNode tree1node5 = new BinarySearchNode(5);
        tree1node1.left = tree1node3;
        tree1node1.right = tree1node2;
        tree1node3.left = tree1node5;

        BinarySearchNode tree2node2 = new BinarySearchNode(2);
        BinarySearchNode tree2node1 = new BinarySearchNode(1);
        BinarySearchNode tree2node3 = new BinarySearchNode(3);
        BinarySearchNode tree2node4 = new BinarySearchNode(4);
        BinarySearchNode tree2node7 = new BinarySearchNode(7);
        tree2node2.left = tree2node1;
        tree2node2.right = tree2node3;
        tree2node1.right = tree2node4;
        tree2node3.right = tree2node7;

        mergeTrees(tree1node1, tree2node2);
    }
}
