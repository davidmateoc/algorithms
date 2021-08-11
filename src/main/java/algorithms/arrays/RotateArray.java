package algorithms.arrays;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 8/4/21
 * Time: 7:07 PM
 * Algorithm URL: https://leetcode.com/problems/rotate-array/
 */

public class RotateArray {

    public void rotate(int[] nums, int k) {
        int[] rotatedNums = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            rotatedNums[(i + k)%nums.length] = nums[i];
        }

        for(int i = 0; i < nums.length; i++) {
            nums[i] = rotatedNums[i];
        }
    }

    public void rotateInPlace(int[] nums, int k) {
        int count = 0;

        for(int start = 0; count < nums.length; start++) {
            int currentPos = start;
            int prevVal = nums[start];
            do {
                int nextPos = (currentPos + k % nums.length) % nums.length;
                int tempVal = nums[nextPos];
                nums[nextPos] = prevVal;
                prevVal = tempVal;
                currentPos = nextPos;
                count++;
            } while (start != currentPos);
        }
    }

    public void rotateWithReverseTrick(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0 ,nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int startVal = nums[start];
            nums[start] = nums[end];
            nums[end] = startVal;
            start++;
            end--;
        }
    }

    @Test
    public void RotateArrayTest() {
//        rotateInPlace(new int[]{1,2,3,4,5,6,7}, 3);
        rotateInPlace(new int[]{-1,-100,3,99}, 2);
    }
}

