package algorithms.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:34 PM
 * Algorithm URL: https://leetcode.com/problems/binary-tree-right-side-view/
 */

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(BinarySearchNode root) {
        List<Integer> result = new ArrayList();
        Queue<BinarySearchNode> queue = new LinkedList();

        if(root == null) {
            return result;
        }
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
             for(int i = 0; i < size; i++) {
                 BinarySearchNode current = queue.poll();
                 if(i == 0) {
                     result.add(current.data);
                 }
                 if(current.right != null) {
                     queue.offer(current.right);
                 }
                 if(current.left != null) {
                     queue.offer(current.left);
                 }
             }
        }
        return result;
    }
}
