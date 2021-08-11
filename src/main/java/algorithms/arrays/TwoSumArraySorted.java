package algorithms.arrays;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:38 PM
 * Algorithm URL: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */

public class TwoSumArraySorted {

    public int[] twoSum(int[] numbers, int target) {
        int aPointer = 0;
        int bPointer = numbers.length - 1;

        while(aPointer <= bPointer) {
            int sum = numbers[aPointer] + numbers[bPointer];

            if(sum > target) {
                bPointer--;
            } else if(sum < target) {
               aPointer++;
            } else {
                return new int[]{aPointer + 1 , bPointer + 1};
            }
        }

        return new int[]{};
    }

    @Test
    public void twoSumTest() {
        Assert.assertThat(twoSum(new int[]{2, 7, 11, 15}, 9), Is.is(IsEqual.equalTo(new int[]{1, 2})));
    }

}
