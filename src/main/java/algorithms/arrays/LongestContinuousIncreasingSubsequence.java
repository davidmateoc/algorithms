package algorithms.arrays;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 8/7/21
 * Time: 3:55 PM
 * Algorithm URL: https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 */

public class LongestContinuousIncreasingSubsequence {

    public static int findLengthOfLCIS(int[] nums) {
        int longest = 0;
        int curLongest = 0;
        int prev = Integer.MIN_VALUE;

        for(int num : nums) {
            if(num > prev) {
                curLongest++;
            } else {
                longest = Math.max(longest, curLongest);
                curLongest = 1;
            }
            prev = num;
        }
        return Math.max(longest, curLongest);
    }

    public static int findLengthOfLCISWithSlidingWindow(int[] nums) {
        int longest = 0;
        int anchor = 0;

        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i - 1] >= nums[i]) {
                anchor = i;
            }

            longest = Math.max(longest, i - anchor + 1);
        }

        return longest;
    }

    @Test
    public void LongestContinuousIncreasingSubsequenceTestFirst() {
        int[] numsA = {1, 3, 5, 4, 7};
        int[] numsB = {2, 2, 2, 2, 2};
        int[] numsC = {2, 1, 3};

        System.out.println(findLengthOfLCIS(numsA));
        System.out.println(findLengthOfLCIS(numsB));
        System.out.println(findLengthOfLCIS(numsC));
    }

    @Test
    public void LongestContinuousIncreasingSubsequenceTestSecond() {
        int[] numsA = {1, 3, 5, 4, 7};
        int[] numsB = {2, 2, 2, 2, 2};
        int[] numsC = {2, 1, 3};

        System.out.println(findLengthOfLCISWithSlidingWindow(numsA));
        System.out.println(findLengthOfLCISWithSlidingWindow(numsB));
        System.out.println(findLengthOfLCISWithSlidingWindow(numsC));
    }
}

