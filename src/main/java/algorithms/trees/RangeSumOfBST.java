package algorithms.trees;

import java.util.Stack;

/**
 * Create by davidmateo
 * Date: 7/6/21
 * Time: 3:26 AM
 * Algorithm URL: https://leetcode.com/problems/range-sum-of-bst/
 */

public class RangeSumOfBST {

    int total = 0;

    public int rangeSumBST(BinarySearchNode root, int low, int high) {
        if(root.left != null) {
            rangeSumBST(root.left, low, high);
        }
        if(root.data <= high && root.data >= low) {
            total += root.data;
        }
        if(root.right != null) {
            rangeSumBST(root.right, low, high);
        }
        return total;
    }

    public int rangeSumBSTIterative(BinarySearchNode root, int low, int high) {
        int rangeSum = 0;
        Stack<BinarySearchNode> stack = new Stack();
        stack.push(root);

        while(!stack.isEmpty()) {
            BinarySearchNode node = stack.pop();
            if(node != null) {
                if(node.data >= low && node.data <= high) {
                    rangeSum += node.data;
                }
                if(node.data > low) {
                    stack.add(node.left);
                }
                if(node.data < high) {
                    stack.add(node.right);
                }
            }
        }
        return rangeSum;
    }
}
