package algorithms.arrays;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:31 PM
 * Algorithm URL: https://leetcode.com/problems/longest-consecutive-sequence/solution/
 */

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int totalConsecutive = 0;
        int currentConsecutive = 0;

        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] + 1 == nums[i + 1]) {
                currentConsecutive++;
            } else if(nums[i] == nums[i + 1]) {
                continue;
            } else {
                totalConsecutive = Math.max(totalConsecutive, currentConsecutive);
                currentConsecutive = 0;
            }
        }
        return Math.max(totalConsecutive, currentConsecutive) + 1;
    }


    @Test
    public void longestConsecutiveSequenceTest() {
        int[] nums = {1,2,0,1};
        assertThat(longestConsecutive(nums), is(equalTo(3)));
    }
}
