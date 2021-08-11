package algorithms.arrays;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:38 PM
 * Algorithm URL: https://leetcode.com/problems/two-sum/
 */

public class TwoSum {

    //Time Complexity is O(N^2) where N length of nums
    //Space Complexity is O(1)
    public int[] twoSum(int[] nums, int target) {
        int aPointer = 0;

        while(aPointer < nums.length - 1) {
            for(int i = aPointer + 1; i < nums.length; i++) {
                if(nums[aPointer] + nums[i] == target) {
                    return new int[]{aPointer, i};
                }
            }
            aPointer++;
        }
        return new int[]{};
    }

    //Time Complexity is O(N) where N length of nums
    //Space Complexity is O(1)
    public int[] twoSumOptimal(int[] nums, int target) {
        Map<Integer, Integer> myMap = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            if(!myMap.containsKey(nums[i])) {
                myMap.put(target - nums[i], i);
            } else {
                return new int[]{myMap.get(nums[i]), i};
            }
        }
        throw new IllegalArgumentException("not found");
    }

    @Test
    public void twoSumTest() {
        assertThat(twoSum(new int[]{3, 2, 4}, 6), is(equalTo(new int[]{1, 2})));
    }

    @Test
    public void twoSumOptimalTest() {
        assertThat(twoSumOptimal(new int[]{3, 2, 4}, 6), is(equalTo(new int[]{1, 2})));
    }

}
