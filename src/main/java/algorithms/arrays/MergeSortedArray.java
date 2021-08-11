package algorithms.arrays;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Create by davidmateo
 * Date: 8/2/21
 * Time: 2:45 AM
 * Algorithm URL: https://leetcode.com/problems/merge-sorted-array/
 */

public class MergeSortedArray {

    //Not the best approach because you dont use the fact that the arrays are already sorted
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public void mergeOptimal(int[] nums1, int m, int[] nums2, int n) {
        int aPointer = m - 1;
        int bPointer = n - 1;
        int cPointer = m + n - 1;

        while(aPointer >= 0 && bPointer >= 0) {
            if(nums1[aPointer] > nums2[bPointer]) {
                nums1[cPointer] = nums1[aPointer];
                aPointer--;
            } else {
                nums1[cPointer] = nums2[bPointer];
                bPointer--;
            }
            cPointer--;
        }

        if(aPointer < 0) {
            while(bPointer >= 0) {
                nums1[cPointer] = nums2[bPointer];
                bPointer--;
                cPointer--;
            }
        } else {
            while(aPointer >= 0) {
                nums1[cPointer] = nums1[aPointer];
                aPointer--;
                cPointer--;
            }
        }
    }

    public void mergeOptimalLessCode(int[] nums1, int m, int[] nums2, int n) {
        // Set p1 and p2 to point to the end of their respective arrays.
        int aPointer = m - 1;
        int bPointer = n - 1;

        // And move p backwards through the array, each time writing
        // the smallest value pointed at by p1 or p2.
        for (int p = m + n - 1; p >= 0; p--) {
            if (bPointer < 0) {
                break;
            }
            if (aPointer >= 0 && nums1[aPointer] > nums2[bPointer]) {
                nums1[p] = nums1[aPointer--];
            } else {
                nums1[p] = nums2[bPointer--];
            }
        }
    }

    //Solo en caso de que pueda devolver un array y no almacenarlo en el nums1 tal y como dice el enunciado
    public int[] mergeReturningANewArray(int[] nums1, int m, int[] nums2, int n) {

         if(nums1.length == 0) {
             return nums2;
         }
         if(nums2.length == 0) {
             return nums1;
         }

        int[] mergedArray = new int[m + n];
        int aPointer = 0;
        int bPointer = 0;
        int cPointer = 0;

        while(aPointer < nums1.length && bPointer < nums2.length) {
            if(nums1[aPointer] < nums2[bPointer]) {
                mergedArray[cPointer] = nums1[aPointer];
                aPointer++;
            } else {
                mergedArray[cPointer] = nums2[bPointer];
                bPointer++;
            }
            cPointer++;
        }

        if(aPointer == nums1.length) {
            while(bPointer < nums2.length) {
                mergedArray[cPointer] = nums2[bPointer];
                bPointer++;
                cPointer++;
            }
        } else {
            while(aPointer < nums1.length) {
                mergedArray[cPointer] = nums1[aPointer];
                aPointer++;
                cPointer++;
            }
        }
        return mergedArray;
    }

    @Test
    public void MergeReturningANewArray() {
        Assert.assertThat(mergeReturningANewArray(new int[]{1, 2, 3}, 3, new int[]{2, 5, 6}, 3), Is.is(IsEqual.equalTo(new int[]{1, 2, 2, 3, 5, 6})));
    }

    @Test
    public void MergeOptimalTest() {
        mergeReturningANewArray(new int[]{1, 2, 3}, 3, new int[]{2, 5, 6}, 3);
    }
}

