package algorithms.trees;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:34 PM
 * Algorithm URL: https://leetcode.com/problems/binary-tree-pruning/
 */

public class BinaryTreePruning {
    public BinarySearchNode pruneTree(BinarySearchNode root) {
        if(root == null) {
            return null;
        }
        if(!containsOne(root)) {
            return null;
        }
        return root;
    }

    public boolean containsOne(BinarySearchNode node) {
        if(node == null) {
            return false;
        }
        boolean leftContains = containsOne(node.left);
        boolean rightContains = containsOne(node.right);

        if(!leftContains) {
            node.left = null;
        }
        if(!rightContains) {
            node.right = null;
        }
        return node.data == 1 || leftContains || rightContains;
    }
}
