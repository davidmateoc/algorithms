package algorithms.trees;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 8/8/21
 * Time: 11:19 PM
 * Algorithm URL:
 */

public class SumValues {

    public int sumValues(BinarySearchNode root) {
        if (root == null) {
            return 0;
        }
        return root.data + sumValues(root.left) + sumValues(root.right);
    }

    @Test
    public void SumValuesTest() {

    }
}

