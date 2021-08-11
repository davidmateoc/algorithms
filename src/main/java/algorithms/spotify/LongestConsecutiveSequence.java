package algorithms.spotify;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Create by davidmateo
 * Date: 7/7/21
 * Time: 3:36 AM
 * Algorithm URL: https://leetcode.com/problems/longest-consecutive-sequence/
 */

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int currentConsecutive = 0;
        int totalConsecutive = 0;

        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1] - 1) {
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
    public void LongestConsecutiveSequenceTest() {
        int[] nums = new int[]{100,4,200,1,3,2};
        Assert.assertThat(longestConsecutive(nums), Is.is(IsEqual.equalTo(4)));

    }
}

