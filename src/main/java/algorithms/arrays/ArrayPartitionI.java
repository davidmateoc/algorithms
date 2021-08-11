package algorithms.arrays;

import org.junit.Test;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:24 PM
 * Algorithm URL: https://leetcode.com/problems/array-partition-i/
 */

public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int total = 0;

        for(int i = 0; i < nums.length - 1; i+=2) {
            //Its not needed to do the Math.min, because since its sorted the minimum will be always the first one
            //total += Math.min(nums[i], nums[i + 1]);
            total += nums[i];
        }
        return total;
    }

    @Test
    public void arrayPairSumTest() {
        assertThat(arrayPairSum(new int[]{6, 2, 6, 5, 1, 2}), is(equalTo(9)));
    }
}
