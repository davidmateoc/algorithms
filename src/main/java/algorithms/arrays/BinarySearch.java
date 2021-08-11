package algorithms.arrays;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:25 PM
 * Algorithm URL: https://leetcode.com/problems/binary-search/
 */

public class BinarySearch {

    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int midpoint = left + (right - left) / 2;

            if(nums[midpoint] == target) {
                return midpoint;
            } else if(nums[midpoint] < target) {
                left = midpoint + 1;
            } else {
                right = midpoint - 1;
            }
        }
        return -1;
    }

    @Test
    public void searchTest() {
        assertThat(search(new int[]{-1, 0, 3, 5, 9, 12}, 9), is(equalTo(4)));
        assertThat(search(new int[]{-1, 0, 3, 5, 9, 12}, 2), is(equalTo(-1)));
    }
}
