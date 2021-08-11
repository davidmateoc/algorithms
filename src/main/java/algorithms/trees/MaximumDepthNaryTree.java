package algorithms.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 10:44 PM
 * Algorithm URL: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */

public class MaximumDepthNaryTree {

    class Node {
        private int val;
        private List<Node> children;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    public int maxDepth(Node root) {
        if(root == null ){
            return 0;
        }

        int depth = 0;

        Queue<Node> queue = new LinkedList();
        queue.offer(root);

        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();

            for(Node child : currentNode.children) {
                queue.offer(child);
            }

            depth++;
        }

        return depth;
    }

    public static void main(String[] args) {

    }
}
