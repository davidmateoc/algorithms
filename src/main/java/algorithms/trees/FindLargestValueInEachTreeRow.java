package algorithms.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 1:36 PM
 * Algorithm URL: https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 */

public class FindLargestValueInEachTreeRow {

    public List<Integer> largestValues(BinarySearchNode root) {
        List<Integer> largestValues = new ArrayList();

        helperMethod(root, largestValues, 0);

        return largestValues;
    }

    public void helperMethod(BinarySearchNode root, List<Integer> largestValues, int level) {
        if(root == null) {
            return;
        }

        if(level == largestValues.size()) {
            largestValues.add(root.data);
        } else {
            largestValues.set(level, Math.max(largestValues.get(level), root.data));
        }

        helperMethod(root.left, largestValues, level + 1);
        helperMethod(root.right, largestValues, level + 1);
    }
}
