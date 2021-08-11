package algorithms.arrays;

import org.hamcrest.core.AnyOf;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:36 PM
 * Algorithm URL: https://leetcode.com/problems/sort-array-by-parity-ii/
 */

public class SortArrayByParityII {

    //Time Complexity is O(N) where N is the length of nums
    //Space Complexity is O(N)
    public int[] sortArrayByParityII(int[] nums) {
        int[] res = new int[nums.length];
        int even = 0;
        int odd = 1;

        for(int num : nums) {
            if(num % 2 == 0) {
                res[even] = num;
                even+=2;
            } else {
                res[odd] = num;
                odd+=2;
            }
        }
        return res;
    }

    //Time Complexity is O(N) where N is the length of nums
    //Space Complexity is O(1)
    public int[] sortArrayByParityIIOptimal(int[] nums) {
        int evenPointer = 0;
        int oddPointer = 1;

        while(evenPointer < nums.length && oddPointer < nums.length) {
            while(evenPointer < nums.length && nums[evenPointer] % 2 == 0) {
                evenPointer += 2;
            }

            while(oddPointer < nums.length && nums[oddPointer] % 2 == 1) {
                oddPointer += 2;
            }

            if(evenPointer < nums.length && oddPointer < nums.length) {
                int temp = nums[evenPointer];
                nums[evenPointer] = nums[oddPointer];
                nums[oddPointer] = temp;
            }
        }
        return nums;
    }

    @Test
    public void sortArrayByParityIITest() {
        Assert.assertThat(sortArrayByParityII(new int[]{4, 2, 5, 7}), AnyOf.anyOf(
            is(equalTo(new int[]{4, 5, 2, 7})),
            is(equalTo(new int[]{4, 7, 2, 5})),
            is(equalTo(new int[]{2, 5, 4, 7})),
            is(equalTo(new int[]{2, 7, 4, 5}))
        ));
    }

    @Test
    public void sortArrayByParityIIOptimalTest() {
        Assert.assertThat(sortArrayByParityIIOptimal(new int[]{4, 2, 5, 7}), AnyOf.anyOf(
            is(equalTo(new int[]{4, 5, 2, 7})),
            is(equalTo(new int[]{4, 7, 2, 5})),
            is(equalTo(new int[]{2, 5, 4, 7})),
            is(equalTo(new int[]{2, 7, 4, 5}))
        ));
    }
}
