package algorithms.arrays;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:32 PM
 * Algorithm URL: https://leetcode.com/problems/max-consecutive-ones/
 */

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int accumulated = 0;
        for(int num : nums) {
            if(num == 1) {
                accumulated++;
                max = Math.max(max, accumulated);
            } else {
                accumulated = 0;
            }
        }
        return max;
    }

    @Test
    public void findMaxConsecutiveOnesTest() {
        assertThat(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}), is(equalTo(3)));
    }
}
