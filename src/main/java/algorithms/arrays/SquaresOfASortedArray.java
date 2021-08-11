package algorithms.arrays;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:36 PM
 * Algorithm URL: https://leetcode.com/problems/squares-of-a-sorted-array/
 */

public class SquaresOfASortedArray {

    public int[] sortedSquares(int[] nums) {
        int[] myArray = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            myArray[i] = nums[i] * nums[i];
        }

        Arrays.sort(myArray);
        return myArray;
    }

    public int[] sortedSquaresOptimal(int[] nums) {
        int N = nums.length;
        int positivePointer = 0;

        //We do this loop to find the pointer of the first positive element
        while(positivePointer < N && nums[positivePointer] < 0) {
            positivePointer++;
        }

        //Therefore the first negative element will be the previous of the positive pointer
        int negativePointer = positivePointer - 1;
        int[] sortedSquares = new int[N];
        int counter = 0;

        //We loop through it decreasing the negative pointer (since after doing the square they will be greater)
        //and increasing the positive pointer. Also increasing always the counter because we want to store the values
        //in order
        while(negativePointer >= 0 && positivePointer < N) {
            if(-nums[negativePointer] < nums[positivePointer]) {
                sortedSquares[counter] = nums[negativePointer] * nums[negativePointer];
                negativePointer--;
            } else {
                sortedSquares[counter] = nums[positivePointer] * nums[positivePointer];
                positivePointer++;
            }
            counter++;
        }

        //In case that we have reached the last positive element but there's still negative numbers in the array,
        // we just add them all
        while(negativePointer >= 0) {
            sortedSquares[counter] = nums[negativePointer] * nums[negativePointer];
            negativePointer--;
            counter++;
        }

        //In case that we have reached the last negative element but there's still positive numbers in the array,
        // we just add them all
        while(positivePointer < N) {
            sortedSquares[counter] = nums[positivePointer] * nums[positivePointer];
            positivePointer++;
            counter++;
        }

        return sortedSquares;
    }

    @Test
    public void sortedSquaresTest() {
        assertThat(sortedSquares(new int[]{-4, -1, 0, 3, 10}), is(equalTo(new int[]{0, 1, 9, 16, 100})));
    }

    @Test
    public void sortedSquaresOptimalTest() {
        assertThat(sortedSquaresOptimal(new int[]{-4, -1, 0, 3, 10}), is(equalTo(new int[]{0, 1, 9, 16, 100})));
    }
}
