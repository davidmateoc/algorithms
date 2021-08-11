package algorithms.trees;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * Create by davidmateo
 * Date: 7/6/21
 * Time: 3:39 AM
 * Algorithm URL: https://leetcode.com/problems/sum-of-left-leaves/
 */

public class SumOfLeftLeafs {

    public int sumOfLeftLeaves(BinarySearchNode root) {
        if(root == null) {
            return 0;
        }

        int sum = 0;

        if(root.left != null) {
            if(root.left.left == null && root.left.right == null) {
                sum += root.left.data;
            } else {
                sum += sumOfLeftLeaves(root.left);
            }
        }

        if(root.right != null) {
            if(root.right.left != null || root.right.right != null) {
                sum += sumOfLeftLeaves(root.right);
            }
        }
        return sum;
    }

    public int sumOfLeftLeavesIterative(BinarySearchNode root) {
        if(root == null) {
            return 0;
        }

        int sum = 0;
        Stack<BinarySearchNode> stack = new Stack();
        stack.add(root);
        while(!stack.isEmpty()) {
            BinarySearchNode current = stack.pop();
            if(current.left != null) {
                if(current.left.left == null && current.left.right == null) {
                    sum += current.left.data;
                } else {
                    stack.add(current.left);
                }
            }

            if(current.right != null) {
                if(current.right.left != null || current.right.right != null) {
                    stack.add(current.right);
                }
            }
        }
        return sum;
    }

    @Test
    public void SumOfLeftLeafsTest() {
        BinarySearchNode root = new BinarySearchNode(4);
        BinarySearchNode root_left = new BinarySearchNode(3);
        BinarySearchNode root_right = new BinarySearchNode(8);
        BinarySearchNode root_right_left = new BinarySearchNode(5);

        root.left = root_left;
        root.right = root_right;
        root_right.left = root_right_left;

        Assert.assertThat(sumOfLeftLeaves(root), Is.is(IsEqual.equalTo(8)));
    }
}
