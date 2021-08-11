package algorithms.trees;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:35 PM
 * Algorithm URL: https://leetcode.com/problems/distribute-coins-in-binary-tree/
 */

public class DistributeCoinsInBinaryTree {

    int numberOfMoves;
    public int distributeCoins(BinarySearchNode root) {
        numberOfMoves = 0;
        giveCoins(root);
        return numberOfMoves;
    }

    public int giveCoins(BinarySearchNode node) {
        if(node == null) return 0;

        int left = giveCoins(node.left);
        int right = giveCoins(node.right);
        numberOfMoves += Math.abs(left) + Math.abs(right);
        return node.data + left + right - 1;
    }
}
