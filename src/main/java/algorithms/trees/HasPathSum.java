package algorithms.trees;

import java.util.Stack;

/**
 * Create by davidmateo
 * Date: 7/6/21
 * Time: 2:28 AM
 * Algorithm URL: https://leetcode.com/problems/path-sum/
 */

public class HasPathSum {
    public boolean hasPathSum(BinarySearchNode root, int targetSum) {
        if(root == null) {
            return false;
        }

        if(root.data == targetSum && root.left == null && root.right == null) {
            return true;
        }

        targetSum -= root.data;

        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

    public boolean hasPathSumIterative(BinarySearchNode root, int targetSum) {
        if(root == null) {
            return false;
        }

        Stack<BinarySearchNode> nodeStack = new Stack();
        Stack<Integer> sumStack = new Stack();

        nodeStack.add(root);
        sumStack.add(targetSum - root.data);

        while(!nodeStack.isEmpty()) {
            BinarySearchNode currentNode = nodeStack.pop();
            int currentSum = sumStack.pop();

            if(currentNode.left == null && currentNode.right == null && currentSum == 0) {
                return true;
            }
            if(currentNode.left != null) {
                nodeStack.add(currentNode.left);
                sumStack.add(currentSum - currentNode.left.data);
            }
            if(currentNode.right != null) {
                nodeStack.add(currentNode.right);
                sumStack.add(currentSum - currentNode.right.data);
            }
        }
        return false;
    }

}
