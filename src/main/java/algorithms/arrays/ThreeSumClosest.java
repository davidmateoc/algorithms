package algorithms.arrays;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:37 PM
 * Algorithm URL: https://leetcode.com/problems/3sum-closest/
 */

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {
            int aPointer = i + 1;
            int bPointer = nums.length - 1;

            while(aPointer < bPointer) {
                int currentSum = nums[i] + nums[aPointer] + nums[bPointer];
                if(currentSum > target) {
                    bPointer--;
                } else {
                    aPointer++;
                }

                if(Math.abs(currentSum - target) < Math.abs(result - target)) {
                    result = currentSum;
                }
            }
        }
        return result;
    }

    @Test
    public void threeSumClosestTest() {
        assertThat(threeSumClosest(new int[]{-1, 2, 1, -4}, 1), is(equalTo(2)));
    }
}
