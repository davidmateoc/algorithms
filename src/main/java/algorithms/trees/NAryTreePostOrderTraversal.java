package algorithms.trees;


import java.util.LinkedList;
import java.util.List;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:38 PM
 * Algorithm URL: https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 */

public class NAryTreePostOrderTraversal {

    public List<Integer> postorder(NAryTreeNode root) {
        LinkedList<NAryTreeNode> stack = new LinkedList();
        LinkedList<Integer> output = new LinkedList();

        if(root == null) {
            return output;
        }
        stack.add(root);

        while(!stack.isEmpty()) {
             NAryTreeNode node = stack.pollLast();
             output.addFirst(node.val);

             for(NAryTreeNode child : node.children) {
                 stack.add(child);
             }
        }
        return output;
    }
}
