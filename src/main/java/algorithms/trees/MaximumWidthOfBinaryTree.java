package algorithms.trees;

import java.util.HashMap;

public class MaximumWidthOfBinaryTree {

    int maxWidth;
    HashMap<Integer, Integer> leftmostPositions;
    public int widthOfBinaryTree(BinarySearchNode root) {
        maxWidth = 0;
        leftmostPositions = new HashMap();
        getWidth(root, 0, 0);
        return  maxWidth;
    }

    public void getWidth(BinarySearchNode root, int depth, int position) {
        if(root == null) {
            return;
        }
        leftmostPositions.computeIfAbsent(depth, x->position);
        maxWidth = Math.max(maxWidth, position - leftmostPositions.get(depth) + 1);
        getWidth(root.left, depth + 1, position * 2);
        getWidth(root.right, depth + 1, position*2+1);
    }
}
