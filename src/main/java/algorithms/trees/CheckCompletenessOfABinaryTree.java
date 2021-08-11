package algorithms.trees;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:35 PM
 * Algorithm URL: https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 */

public class CheckCompletenessOfABinaryTree {

    public boolean isCompleteTree(BinarySearchNode root) {
        boolean end = false;
        Queue<BinarySearchNode> queue = new LinkedList();
        queue.offer(root);

        while(!queue.isEmpty()) {
            BinarySearchNode current = queue.poll();
            if(current == null) {
                end = true;
            } else {
                if(end) {
                    return false;
                }
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }
        return true;
    }
}
