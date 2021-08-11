package algorithms.arrays;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:27 PM
 * Algorithm URL: https://leetcode.com/problems/container-with-most-water/
 */

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = 0;
        int aPointer = 0;
        int bPointer = height.length - 1;

        while(aPointer < bPointer) {
            //If case the aPointer height is lower than bPointer, then we move the shorter end in
            //the hope of increasing the height of the rectangle, because increasing the height of
            // the rectangle is the only way to get a larger area
            if(height[aPointer] < height[bPointer]) {
                maxArea = Math.max(maxArea, height[aPointer] * (bPointer - aPointer));
                aPointer++;
            } else {
                maxArea = Math.max(maxArea, height[bPointer] * (bPointer - aPointer));
                bPointer--;
            }
        }

        return maxArea;
    }

    @Test
    public void maxAreaTest() {
        assertThat(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}), is(equalTo(49)));
    }
}