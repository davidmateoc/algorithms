package algorithms.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:36 PM
 * Algorithm URL: https://leetcode.com/problems/find-mode-in-binary-search-tree/
 */

public class FindModeInBinarySearchTree {

    Integer prev = null;
    int count = 1;
    int max = 0;
    public int[] findMode(BinarySearchNode root) {
        List<Integer> modes = new ArrayList();

        traverse(root, modes);

        int[] result = new int[modes.size()];
        for(int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    public void traverse(BinarySearchNode node, List<Integer> modes) {
        if(node == null) {
            return;
        }

        traverse(node.left, modes);
        if(prev != null) {
            if(prev == node.data) {
                count++;
            } else {
                count = 1;
            }
        }

        if(count > max) {
            max = count;
            modes.clear();
            modes.add(node.data);
        } else if (count == max) {
            modes.add(node.data);
        }
        prev = node.data;

        traverse(node.right, modes);

    }
}
