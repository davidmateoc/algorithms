package algorithms.trees;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:14 PM
 * Algorithm URL: https://leetcode.com/problems/binary-tree-paths/
 */

public class BinaryTreePaths {
    public List<String> binaryTreePaths(BinarySearchNode root) {
        List<String> result = new ArrayList();

        if(root == null) {
            return result;
        }

        String currentPath = Integer.toString(root.data);
        if(root.left == null && root.right == null) {
            result.add(currentPath);
        }
        if(root.left != null) {
            dfs(root.left, currentPath, result);
        }
        if(root.right != null) {
            dfs(root.right, currentPath, result);
        }

        return result;
    }

    public void dfs(BinarySearchNode node, String currentPath, List<String> result) {
        currentPath += "->" + node.data;
        if(node.left == null && node.right == null) {
            result.add(currentPath);
            return;
        }

        if(node.left != null) {
            dfs(node.left, currentPath, result);
        }
        if(node.right != null) {
            dfs(node.right, currentPath, result);
        }
    }

    @Test
    public void binaryTreePathsListOfIntegersTest() {
        BinarySearchNode one = new BinarySearchNode(1);
        BinarySearchNode two = new BinarySearchNode(2);
        BinarySearchNode three = new BinarySearchNode(3);
        BinarySearchNode five = new BinarySearchNode(5);

        one.left = two;
        one.right = three;
        two.right = five;

        List<String> result = binaryTreePaths(one);
        System.out.println(result);
    }
}
