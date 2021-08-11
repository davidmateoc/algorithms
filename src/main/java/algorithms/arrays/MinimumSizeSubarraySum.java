package algorithms.arrays;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:32 PM
 * Algorithm URL: https://leetcode.com/problems/minimum-size-subarray-sum/
 */

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int aPointer = 0;

        int minLength = Integer.MAX_VALUE;
        int accumulated = 0;

        while(aPointer < nums.length) {
            int bPointer = aPointer;
            while(accumulated < target && bPointer < nums.length) {
                accumulated += nums[bPointer];
                bPointer++;
            }
            if(accumulated >= target) {
                minLength = Math.min(minLength, (bPointer - aPointer));
            }
            accumulated = 0;
            aPointer++;
        }
        return minLength != Integer.MAX_VALUE? minLength : 0;
    }

    public int minSubArrayLenOptimal(int target, int[] nums) {
        int aPointer = 0;
        int accumulated = 0;
        int minLength = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++) {
            accumulated += nums[i];

            while(accumulated >= target) {
                minLength = Math.min(minLength, (i + 1 - aPointer));
                accumulated -= nums[aPointer];
                aPointer++;
            }
        }
        return minLength != Integer.MAX_VALUE? minLength : 0;
    }

    @Test
    public void minSubArrayLenTest() {
        assertThat(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}), is(equalTo(2)));
        assertThat(minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}), is(equalTo(0)));
    }

    @Test
    public void minSubArrayLenOptimalTest() {
        assertThat(minSubArrayLenOptimal(7, new int[]{2, 3, 1, 2, 4, 3}), is(equalTo(2)));
        assertThat(minSubArrayLenOptimal(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}), is(equalTo(0)));
    }
}
