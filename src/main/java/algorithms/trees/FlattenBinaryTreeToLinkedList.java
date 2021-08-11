package algorithms.trees;

import org.junit.Test;

import java.util.Stack;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:36 PM
 * Algorithm URL: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */

public class FlattenBinaryTreeToLinkedList {

    public void flatten(BinarySearchNode root) {

        if(root == null) {
            return;
        }

        Stack<BinarySearchNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()) {
            BinarySearchNode current = stack.pop();

            if(current.right != null) {
                stack.push(current.right);
            }

            if(current.left != null) {
                stack.push(current.left);
            }

            if(!stack.isEmpty()) {
                current.right = stack.peek();
            }
            current.left = null;
        }
    }


    @Test
    public void flattenTest() {
        BinarySearchNode one = new BinarySearchNode(1);
        BinarySearchNode two = new BinarySearchNode(2);
        BinarySearchNode three = new BinarySearchNode(3);
        BinarySearchNode four = new BinarySearchNode(4);
        BinarySearchNode five = new BinarySearchNode(5);
        BinarySearchNode six = new BinarySearchNode(6);

        one.left = two;
        one.right = five;

        two.left = three;
        two.right = four;

        five.right = six;

        flatten(one);
        System.out.println("test");
    }

}
