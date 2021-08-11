package algorithms.trees;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 8/8/21
 * Time: 11:16 PM
 * Algorithm URL: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */

public class LowestCommonAncestor {

    public static BinarySearchNode lcaIfValuesAreInTree(BinarySearchNode root, int v1, int v2) {
        if(!root.contains(v1) || !root.contains(v2)) {
            System.err.println("Nodes not found in tree");
            return null;
        }
        if(v1 < root.data && v2 < root.data) {
            return lcaIfValuesAreInTree(root.left, v1, v2);
        }
        if(v1 > root.data && v2 > root.data) {
            return lcaIfValuesAreInTree(root.right, v1, v2);
        }
        return root;
    }

    public static BinarySearchNode lca(BinarySearchNode root, int v1, int v2) {
        if(root == null) {
            return null;
        }
        if(root.data == v1 || root.data == v2) {
            return root;
        }

        BinarySearchNode leftSearchResult = lca(root.left, v1, v2);
        BinarySearchNode rightSearchResult = lca(root.right, v1, v2);

        if(leftSearchResult == null) return rightSearchResult;
        if(rightSearchResult == null) return leftSearchResult;

        return root;
    }

    @Test
    public void LowestCommonAncestorTest() {

    }
}

