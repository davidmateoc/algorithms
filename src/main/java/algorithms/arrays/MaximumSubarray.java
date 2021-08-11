package algorithms.arrays;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 8/2/21
 * Time: 2:33 AM
 * Algorithm URL: https://leetcode.com/problems/maximum-subarray/
 */

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = Integer.MIN_VALUE;

        for(int num : nums) {
            if(num > currentSum && currentSum < 0) {
                currentSum = num;
            } else {
                currentSum += num;
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public int maxSubArrayOptimized(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    @Test
    public void MaximumSubarrayTest() {
        Assert.assertThat(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}), Is.is(IsEqual.equalTo(6)));
    }

    @Test
    public void MaximumSubarrayOptimizedTest() {
        Assert.assertThat(maxSubArrayOptimized(new int[]{-2,1,-3,4,-1,2,1,-5,4}), Is.is(IsEqual.equalTo(6)));
    }

}

