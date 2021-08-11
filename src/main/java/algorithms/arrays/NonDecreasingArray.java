package algorithms.arrays;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 8/7/21
 * Time: 12:54 PM
 * Algorithm URL: https://leetcode.com/problems/non-decreasing-array/
 */

public class NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {
        int changed = 0;

        for(int i = 1; i < nums.length; i++) {

            if(nums[i - 1] > nums[i]) {
                if(changed == 1) {
                    return false;
                }
                changed++;

                //This applies when we are in the first iteration so we only 2 numbers so far.
                // Or when we have more than 2 numbers, we need to check the previous of the two we are evaluating
                // For example: 0, 2, 1 --> since 0 < 1, we will need to change 2 to 1 --> 0, 1, 1
                // On the other hand: 2, 2, 1 --> since 2 > 1, we will need to change 1 to 2 --> 2, 2, 2
                if(i < 2 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }
        return true;
    }

    @Test
    public void NonDecreasingArrayTest() {
//        Assert.assertThat(checkPossibility(new int[]{}), Is.is(IsEqual.equalTo(true)));
        Assert.assertThat(checkPossibility(new int[]{2, 1}), Is.is(IsEqual.equalTo(true)));
//        Assert.assertThat(checkPossibility(new int[]{1, 2}), Is.is(IsEqual.equalTo(true)));
//        Assert.assertThat(checkPossibility(new int[]{2}), Is.is(IsEqual.equalTo(true)));
//        Assert.assertThat(checkPossibility(new int[]{4, 2, 3}), Is.is(IsEqual.equalTo(true)));
//        Assert.assertThat(checkPossibility(new int[]{4, 2, 1}), Is.is(IsEqual.equalTo(false)));
//        Assert.assertThat(checkPossibility(new int[]{3, 4, 2, 3}), Is.is(IsEqual.equalTo(false)));
    }
}

