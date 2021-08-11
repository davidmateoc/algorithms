package algorithms.spotify;

import org.junit.Test;

import java.util.HashMap;

/**
 * Create by davidmateo
 * Date: 7/7/21
 * Time: 4:50 AM
 * Algorithm URL: https://leetcode.com/problems/two-sum/
 */

public class TwoSum {

    public int[] twoSumBruteForce(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No solution found");
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(myMap.containsKey(nums[i])) {
                return new int[]{myMap.get(nums[i]), i};
            } else {
                myMap.put(target - nums[i], i);
            }
        }
        throw new IllegalArgumentException("No solution found");
    }

    @Test
    public void TwoSumTest() {

    }
}

