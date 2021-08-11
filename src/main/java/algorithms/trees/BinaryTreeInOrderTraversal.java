package algorithms.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Create by davidmateo
 * Date: 7/6/21
 * Time: 2:43 AM
 * Algorithm URL: https://leetcode.com/problems/binary-tree-inorder-traversal/
 */

public class BinaryTreeInOrderTraversal {

    List<Integer> inOrderTraversalList = new ArrayList();

    public List<Integer> inorderTraversal(BinarySearchNode root) {
        if(root == null) {
            return inOrderTraversalList;
        }

        BinarySearchNode left = root.left;
        BinarySearchNode right = root.right;
        if(left != null) {
            inorderTraversal(left);
        }
        inOrderTraversalList.add(root.data);
        if(right != null) {
            inorderTraversal(right);
        }
        return inOrderTraversalList;
    }

    public List<Integer> inorderTraversalIterative(BinarySearchNode root) {
        Stack<BinarySearchNode> stack = new Stack();
        List<Integer> output = new ArrayList();

        if(root == null) {
            return output;
        }

        BinarySearchNode current = root;
        while(current !=  null || !stack.isEmpty()) {
            while(current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            output.add(current.data);
            current = current.right;
        }
        return output;
    }
}
