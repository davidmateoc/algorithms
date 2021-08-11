package algorithms.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:35 PM
 * Algorithm URL: https://leetcode.com/problems/deepest-leaves-sum/
 */

public class DeepestLeavesSum {
    public int deepestLeavesSum(BinarySearchNode root) {
        if(root == null) {
            return 0;
        }

        int levelSum = 0;
        Queue<BinarySearchNode> queue = new LinkedList();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            levelSum = 0;
            for(int i = 0; i < size; i++) {
                BinarySearchNode node = queue.poll();
                levelSum += node.data;

                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return levelSum;
    }
}
