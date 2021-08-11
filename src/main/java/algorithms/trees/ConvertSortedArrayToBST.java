package algorithms.trees;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 10:34 PM
 * Algorithm URL: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */

public class ConvertSortedArrayToBST {

    public static Node sortedArrayToBST(int[] nums) {
        if(nums.length == 0) {
            return null;
        }

        return constructTreeFromArray(nums, 0, nums.length - 1);
    }

    private static Node constructTreeFromArray(int[] nums, int left, int right) {
        if(left > right) return null;

        int middle = left + (right - left)/2;
        Node node = new Node(nums[middle]);
        node.left = constructTreeFromArray(nums, left, middle - 1);
        node.left = constructTreeFromArray(nums, middle + 1, right);

        return node;
    }


    public static void main(String[] args) {
        int[] nums = {-10, -5, -3, 0, 5, 8, 9};
        sortedArrayToBST(nums);
    }

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
