package algorithms.trees;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:36 PM
 * Algorithm URL: https://leetcode.com/problems/find-bottom-left-tree-value/
 */

public class FindBottomLeftTreeValue {

    public int findBottomLeftValue(BinarySearchNode root) {
        Queue<BinarySearchNode> queue = new LinkedList();
        queue.offer(root);

        while(!queue.isEmpty()) {
            root = queue.poll();
            if(root.right != null) {
                queue.offer(root.right);
            }
            if(root.left != null) {
                queue.offer(root.left);
            }
        }
        return root.data;
    }


    @Test
    public void findBottomLeftValueTEst() {
        BinarySearchNode one = new BinarySearchNode(1);
        BinarySearchNode two = new BinarySearchNode(2);
        BinarySearchNode three = new BinarySearchNode(3);
        BinarySearchNode four = new BinarySearchNode(4);
        BinarySearchNode five = new BinarySearchNode(5);
        BinarySearchNode six = new BinarySearchNode(6);
        BinarySearchNode seven = new BinarySearchNode(7);
        BinarySearchNode eight = new BinarySearchNode(8);
        BinarySearchNode nine = new BinarySearchNode(9);

        one.left = two;
        one.right = three;
        two.left = four;
        three.left = five;
        three.right = six;
        five.left = seven;
        six.right = eight;
        eight.right = nine;

        System.out.println(findBottomLeftValue(one));
    }

}
