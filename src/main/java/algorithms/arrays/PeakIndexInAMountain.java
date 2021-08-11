package algorithms.arrays;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 8/8/21
 * Time: 8:29 PM
 * Algorithm URL: https://leetcode.com/problems/peak-index-in-a-mountain-array/
 */

public class PeakIndexInAMountain {

    public int peakIndexInMountainArray(int[] arr) {
        for(int i = 0; i < arr.length - 2; i++) {
            if((arr[i] < arr[i + 1]) && (arr[i + 1] > arr[i + 2])) {
                return i + 1;
            }
        }
        return 0;
    }

    public int peakIndexInMountainArrayOptimal(int[] arr) {
        int aPointer = 0;
        int bPointer = arr.length - 1;

        while(aPointer < bPointer) {
            int midPoint = aPointer + (bPointer - aPointer)/2;

            if(arr[midPoint] < arr[midPoint + 1]) {
                aPointer = midPoint + 1;
            } else {
                bPointer = midPoint;
            }
        }

        return aPointer;
    }

    @Test
    public void peakIndexInMountainArrayTest() {
        assertThat(peakIndexInMountainArray(new int[]{0, 1, 0}), is(equalTo(1)));
    }

    @Test
    public void peakIndexInMountainArrayOptimalTest() {
        assertThat(peakIndexInMountainArrayOptimal(new int[]{24,69,100,99,79,78,67,36,26,19}), is(equalTo(2)));
    }
}
